package com.gcfr.test;

import java.util.Scanner;

import com.gcfr.dh.DHBO;
import com.gcfr.dh.DHModel;

public class Console {
	public static void main(String[] args) throws Exception {
		DHBO db = new DHBO();
		System.out.println("输入你的操作：1.查询，2.增加，3.删除，4.修改");
		Scanner scanner=new Scanner(System.in);//控制台输入对象
		System.out.println("请操作:");
		int a = Integer.parseInt(scanner.next());//从控制台输入第一个数
		switch (a) {
		case 1:
			System.out.println("db.query();");
			db.query();
			break;
		case 2:
			DHModel dm = new DHModel();
			System.out.println("db.insert(dh);");
			System.out.println("请输入guid：");
			dm.setGuid(scanner.next().toString());
			System.out.println("请输入code：");
			dm.setCode(Integer.parseInt(scanner.next()));
			System.out.println("请输入name：");
			dm.setName(scanner.next().toString());
			System.out.println("请输入type：");
			dm.setType(Integer.parseInt(scanner.next()));
			db.insert(dm);
			break;
		case 3:
			System.out.println("请输入删除的guid：");
			System.out.println("db.del(guid);");
			String guid = scanner.next();
			db.del(guid);
			break;
		case 4:
			System.out.println("db.update(dh);");
			DHModel dm1 = new DHModel();
			System.out.println("请输入guid：");
			dm1.setGuid(scanner.next().toString());
			System.out.println("请输入code：");
			dm1.setCode(Integer.parseInt(scanner.next()));
			System.out.println("请输入name：");
			dm1.setName(scanner.next().toString());
			System.out.println("请输入type：");
			dm1.setType(Integer.parseInt(scanner.next()));
			db.update(dm1);
			break;
		default:
			System.out.println("请重新输入");
		}
	}
}
