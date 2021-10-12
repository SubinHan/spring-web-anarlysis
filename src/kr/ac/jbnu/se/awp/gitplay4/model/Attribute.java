package kr.ac.jbnu.se.awp.gitplay4.model;
import java.util.ArrayList;
import java.util.HashSet;

public class Attribute {
	
	private ArrayList<String> data;
	private String name;
	private HashSet<Integer> na_array;
	private int num;
	
	public Attribute() {
		data = new ArrayList<String>();
		na_array = new HashSet<Integer>();
	}
	
	public void setData(String data) {
		this.data.add(data);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setName(int i) {
		name = "column" + i;
	}
	
	public void setNa_array(int na) {
		na_array.add(na);
	}
	
	public void setNum() {
		num = data.size();
	} 
	
	public String getData(int i) {
		return data.get(i);
	}	
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}

//	public Integer getNa_array(String ) {
//		� ������ ��ȯ���� .. 
// 		�˻��ϴ� ��쵵 ����
// 		������ ��ȯ�� �� ��� �ؾ�����..
//	} 
	
}
