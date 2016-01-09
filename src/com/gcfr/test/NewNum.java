package com.gcfr.test;

import java.util.List;
import java.util.Scanner;

import com.gcfr.dh.DHModel;
import com.gcfr.dh.Print;

public class NewNum {
	public static void main(String[] args) {
		Print p = new Print();
		DHModel d = new DHModel();
		Scanner scan = new Scanner(System.in);
		List<DHModel> pp = p.get();
		Integer len = 1;
		
		print(pp);
		System.out.println("输入GUID");
		d.setGuid(scan.next());
		System.out.println("输入NAME");
		d.setName(scan.next());
		System.out.println("输入TYPE");
		d.setType(Integer.parseInt(scan.next()));
		for (DHModel dhModel : pp) {
//			len = len>dhModel.getCode()?len:dhModel.getCode();//返回最大数加1
			if(dhModel.getCode()==len){
				len++;
			}else{
				d.setCode(len);//从1开始，补齐
				break;
			}
		}
		pp.add(d);
		print(pp);
	}
	
	
	private static void print(List<DHModel> dm) {
		System.out.println("GUID "+"CODE "+ "NAME "+"TYPE");
		for (DHModel dhModel : dm) {
//			System.out.println(dhModel.getGuid()+"    "+dhModel.getCode()
//					+"    "+dhModel.getName()+"     "+dhModel.getType());
			System.out.print(dhModel.getGuid()+"   ");
			if (dhModel.getCode()<10) {
				System.out.println(" 0"+dhModel.getCode()
						+"    "+dhModel.getName()+"     "+dhModel.getType());
			}else {
				System.out.println(" "+dhModel.getCode()
						+"    "+dhModel.getName()+"     "+dhModel.getType());
			}
		}
	}

}
