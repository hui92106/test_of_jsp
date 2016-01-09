package com.test;

import java.util.ArrayList;
import java.util.List;

import com.gcfr.dh.DHBO;
import com.gcfr.dh.DHModel;

public class MainJsp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		set();
		DHBO db = new DHBO();
		db.del("1");
	}

	
	private static void print(List<DHModel> dm) {
		System.out.println("GUID "+"CODE "+ "NAME "+"TYPE");
		for (DHModel dhModel : dm) {
			System.out.println(dhModel.getGuid()+"    "+dhModel.getCode()
					+"    "+dhModel.getName()+"     "+dhModel.getType());
		}
	}
	
	@SuppressWarnings("unused")
	private static void set() {
		List<DHModel>dm = new ArrayList<DHModel>();
		setOne(dm,"1", 1, "老大", 1);
		setOne(dm,"2", 2, "老二", 2);
		print(dm);
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
