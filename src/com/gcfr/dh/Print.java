package com.gcfr.dh;

import java.util.ArrayList;
import java.util.List;

public class Print {
	public void UpdatePrint(DHModel dh) {
		System.out.println("你要更新的数据："+dh.toString());
	}
	public void DelPrint(String guid) {
		System.out.println("你要删除的是guid为"+guid+"的数据！");
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
}
