package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import kr.ac.jbnu.se.awp.gitplay4.model.Attribute;

public class CsvAnalyzer {

	private Attribute col[];
	private int colnum;
	private int rownum;
	
	public CsvAnalyzer(String path, Boolean header){	
		String line = "";
	 
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			// 열의 개수 구해서 저장
			line = br.readLine();
			String[] values = line.split(",");
			colnum = values.length;
			
			// 배열 할당
			col = new Attribute[colnum];
			for(int i=0; i<colnum; i++) {
				col[i] = new Attribute();
			}
			
			// 헤더 저장
			if(header==true) {
				values = line.split(",");
				for(int i=0; i<colnum; i++) {
					col[i].setName(values[i]);
				}
			}
			
			else {
				for(int i=0; i<colnum; i++) {
					col[i].setName(i+1);
					col[i].setData(values[i]);
				}
			}
			
			// 데이터 저장
			while((line=br.readLine()) != null) {
				values = line.split(",");				
				for(int i=0; i<colnum; i++) {
					col[i].setData(values[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 데이터 저장 확인
//		col[1].setNum();
//		rownum = col[1].getNum();
//		for(int i=0; i<rownum; i++) {
//			for(int j=0; j<colnum; j++) {
//				System.out.println(col[j].getData(i));
//			}
//		}
	}
	
	// NA 저장
//	public void setNa() {
//		for(int )
//	}
	
	public void getColnum() {
		System.out.println("열의 개수 : " + colnum);
	}
	
	public void getRownum() {
		System.out.println("행의 개수 : " + rownum);
	}
	
	public void getColname() {
		for(int i=0; i<colnum; i++)
			System.out.print(col[i].getName()+ " ");
	}
	
	public void getCol(int[] idx, int rownum) {
		for(int i=0; i<idx.length; i++) {
			System.out.print(col[idx[i]].getName()+" ");
		}
		System.out.println();
		
		for(int j=0; j<rownum; j++) {
			for(int i=0; i<idx.length; i++) {
				System.out.print(col[idx[i]].getData(j)+ " ");
			}
			System.out.println();
		}
	}
	
	public void getRow(int[] idx) {
		for (int j=0; j<idx.length; j++) {
			for(int i=0; i<colnum; i++) {
				System.out.print(col[i].getData(idx[j])+" ");
			}
			System.out.println();
		}
	}
	
	public void head() {
		for(int i=0; i<colnum; i++) {
			System.out.print(col[i].getName()+" ");
		}
		System.out.println();
		for(int j=0; j<6 ; j++) {
			for(int i=0; i<colnum; i++) {
				System.out.print(col[i].getData(j)+ " ");
			}
			System.out.println();
		}
	}
}
