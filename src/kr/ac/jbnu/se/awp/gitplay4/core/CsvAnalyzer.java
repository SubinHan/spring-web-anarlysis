package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import kr.ac.jbnu.se.awp.gitplay4.model.Attribute;

public class CsvAnalyzer {

	private Attribute col[];
	private int numCol;
	private int numRow;

	public CsvAnalyzer(String path, Boolean header) {
		String line = "";

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			// ���� ���� ���ؼ� ����
			line = br.readLine();
			String[] values = line.split(",");
			numCol = values.length;

			// �迭 �Ҵ�
			col = new Attribute[numCol];
			for (int i = 0; i < numCol; i++) {
				col[i] = new Attribute();
			}

			// ��� ����
			if (header == true) {
				values = line.split(",");
				for (int i = 0; i < numCol; i++) {
					col[i].setName(values[i]);
					System.out.println(values[i]); // 확인
				}
			} else {
				for (int i = 0; i < numCol; i++) {
					col[i].setName("column" + (i + 1));
					col[i].addData(values[i]);
				}
			}

			// ������ ����
			while ((line = br.readLine()) != null) {
				values = line.split(",");
				for (int i = 0; i < numCol; i++) {
					col[i].addData(values[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNumOfColumn() {
		return numCol;
	}

	public int getNumOfRow() {
		return numRow;
	}

	public String getColumnName(int index) {
		return col[index].getName();
	}

	public String[] getColumnNames() {
		String[] columnNames = new String[numCol];
		for (int i = 0; i < numCol; i++) {
			String beforeEncoding = col[i].getName();
//			ByteBuffer buffer = StandardCharsets.UTF_8.encode(beforeEncoding);
//			columnNames[i] = StandardCharsets.UTF_8.decode(buffer).toString();

//			byte[] bytes = beforeEncoding.getBytes();
//			columnNames[i] = new String(bytes, StandardCharsets.UTF_8);
//			assertNotEquals(columnNames[i],beforeEncoding);
			System.out.println(columnNames[i]);
			columnNames[i] = col[i].getName();

		}

		return columnNames;
	}
	
	public boolean isNumericColumn(int column) {
		for (int i = 0; i < this.col[column].getSize(); i++) {
			String data = this.col[column].getData(i);
			if (data == null)
				continue;
			if (!isNumeric(data)) {
				System.out.println(data);
				return false;
			}
		}
		return true;
	}

	public double getMinOf(int column) {
		double min = Double.MAX_VALUE;

		for (int i = 0; i < this.col[column].getSize(); i++) {
			String data = this.col[column].getData(i);
			if (data == null)
				continue;
			if (isNumeric(data)) {
				double num = Double.parseDouble(data);
				if (min > num)
					min = num;
			} else
				return Double.NaN;
		}

		return min;
	}

	public double getMaxOf(int column) {
		double max = Double.MIN_VALUE;

		for (int i = 0; i < this.col[column].getSize(); i++) {
			String data = this.col[column].getData(i);
			if (data == null)
				continue;
			if (isNumeric(data)) {
				double num = Double.parseDouble(data);
				if (max < num)
					max = num;
			} else
				return Double.NaN;
		}

		return max;
	}

	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void assertNotEquals(String beforeEncoding, String string) {
		// TODO Auto-generated method stub

	}
}
