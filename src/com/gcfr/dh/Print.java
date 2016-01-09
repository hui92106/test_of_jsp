package com.gcfr.dh;

import java.util.ArrayList;
import java.util.List;

public class Print {
	public void UpdatePrint(DHModel dh) {
		System.out.println("你要更新的数据："+dh.toString());
	}
	public void DelPrint(String guid) {
		List<DHModel> dm = new ArrayList<DHModel>();
		setOne(dm, "1", 1, "老大", 1);
		setOne(dm, "2", 2, "老二", 2);
		setOne(dm, "3", 3, "老大", 3);
		setOne(dm, "4", 4, "老二", 4);
		
		for (DHModel dhModel : dm) {
			if(dhModel.getGuid().equals(guid)){
				dm.remove(dhModel);
			}
			else {
				System.out.println("guid为"+guid+"的单据不存在");
			}
			print(dm);
		}
	}
	public List<DHModel> QueryPrint() {
		List<DHModel> dm = new ArrayList<DHModel>();
		setOne(dm, "1", 1, "老大", 1);
		setOne(dm, "2", 2, "老二", 2);
		setOne(dm, "3", 3, "老大", 3);
		setOne(dm, "4", 4, "老二", 4);
		for (DHModel dhModel : dm) {
			System.out.println(dhModel.toString());
		}
		return dm;
	}
	public void InsertPrint(DHModel dh) {
		System.out.println("你要添加的数据："+dh.toString());
	}
	
	
	private static List<DHModel> setOne(List<DHModel> dm,String guid,Integer code,String name,Integer type) {
		DHModel d = new DHModel();
		d.setGuid(guid);
		d.setCode(code);
		d.setName(name);
		d.setType(type);
		dm.add(d);
		return dm;
	}
	
	public List<DHModel> get(){
		List<DHModel> dm = new ArrayList<DHModel>();
		setOne(dm, "1", 1, "老大", 1);
		setOne(dm, "2", 4, "老二", 2);
		setOne(dm, "3", 35, "老三", 3);
		setOne(dm, "4", 99, "老四", 4);
		return dm;
	}
	
	public boolean context(DHModel dh){
		List<DHModel> dl = get();
		for (DHModel dp : dl) {
			if(dp.getGuid().equals(dh.getGuid())){
				return false;
			}
		}
		return true;
	}
	
	public boolean codeP(Integer code) {
		List<DHModel> dl = get();
		for (DHModel dhModel : dl) {
			if(dhModel.getCode().equals(code)){
				return false;
			}
		}
		return true;
	}
	
	public boolean nameP(String name) {
		List<DHModel> dl = get();
		for (DHModel dhModel : dl) {
			if(dhModel.getName().equals(name)){
				return false;
			}
		}
		return true;
	}
	
	private static void print(List<DHModel> dm) {
		System.out.println("GUID "+"CODE "+ "NAME "+"TYPE");
		for (DHModel dhModel : dm) {
//			System.out.println(dhModel.getGuid()+"    "+dhModel.getCode()
//					+"    "+dhModel.getName()+"     "+dhModel.getType());
			System.out.print(dhModel.getGuid()+"    ");
			if (dhModel.getCode()<10) {
				System.out.println(dhModel.getCode()
						+"   0"+dhModel.getName()+"     "+dhModel.getType());
			}else {
				System.out.println(dhModel.getCode()
						+"    "+dhModel.getName()+"     "+dhModel.getType());
			}
		}
	}
}
