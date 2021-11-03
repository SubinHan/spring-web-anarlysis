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
	
	public CsvAnalyzer(String path, Boolean header){	
		String line = "";
	 
		try {
			
			// change 1
//			InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
//		    Reader reader =
//		            new InputStreamReader(inputStream, Charset.forName("UTF-8"));
//		    
		    // origin
			//BufferedReader br = new BufferedReader(new FileReader(path));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			// ���� ���� ���ؼ� ����
			line = br.readLine();
			String[] values = line.split(",");
			numCol = values.length;
			
			// �迭 �Ҵ�
			col = new Attribute[numCol];
			for(int i=0; i<numCol; i++) {
				col[i] = new Attribute();
			}
			
			// ��� ����
			if(header==true) {
				values = line.split(",");
				for(int i=0; i<numCol; i++) {
					col[i].setName(values[i]);
					System.out.println(values[i]); // 확인
				}
			}
			else {
				for(int i=0; i<numCol; i++) {
					col[i].setName("column" + (i+1));
					col[i].addData(values[i]);
				}
			}
			
			// ������ ����
			while((line=br.readLine()) != null) {
				values = line.split(",");				
				for(int i=0; i<numCol; i++) {
					col[i].addData(values[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ������ ���� Ȯ��
//		col[1].setNum();
//		rownum = col[1].getNum();
//		for(int i=0; i<rownum; i++) {
//			for(int j=0; j<colnum; j++) {
//				System.out.println(col[j].getData(i));
//			}
//		}
	}
	
	// NA ����
//	public void setNa() {
//		for(int )
//	}
	
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
		for(int i = 0; i < numCol; i++) {
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

	private void assertNotEquals(String beforeEncoding, String string) {
		// TODO Auto-generated method stub
		
	}
	
//	public void getCol(int[] idx, int rownum) {
//		for(int i=0; i<idx.length; i++) {
//			System.out.print(col[idx[i]].getName()+" ");
//		}
//		System.out.println();
//		
//		for(int j=0; j<rownum; j++) {
//			for(int i=0; i<idx.length; i++) {
//				System.out.print(col[idx[i]].getData(j)+ " ");
//			}
//			System.out.println();
//		}
//	}
//	
//	public void getRow(int[] idx) {
//		for (int j=0; j<idx.length; j++) {
//			for(int i=0; i<numCol; i++) {
//				System.out.print(col[i].getData(idx[j])+" ");
//			}
//			System.out.println();
//		}
//	}
	
//	public void head() {
//		for(int i=0; i<numCol; i++) {
//			System.out.print(col[i].getName()+" ");
//		}
//		System.out.println();
//		for(int j=0; j<6 ; j++) {
//			for(int i=0; i<numCol; i++) {
//				System.out.print(col[i].getData(j)+ " ");
//			}
//			System.out.println();
//		}
//	}
}
