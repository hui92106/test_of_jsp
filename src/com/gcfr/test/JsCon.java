package com.gcfr.test;

import java.util.List;
import java.util.Scanner;

import com.gcfr.dh.DHModel;
import com.gcfr.dh.Print;

public class JsCon {
	static Print p= new Print();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DHModel dm = new DHModel();
		
		System.out.println("操作：1.保存	2.删除");
		switch (Integer.parseInt(scan.next())) {
		case 1:
			System.out.println("输入数据 ");
			System.out.println("guid: ");
			dm.setGuid(scan.next());
			System.out.println("code: ");
			dm.setCode(Integer.parseInt(scan.next()));
			System.out.println("name: ");
			dm.setName(scan.next());
			System.out.println("type: ");
			dm.setType(Integer.parseInt(scan.next()));
			System.out.println(p.get().toString());
			if(check(dm)){
				if(!p.context(dm)){
					System.out.println("数据已存在：你要修改的数据是："+dm.toString());
				}else {
					System.out.println("新增的数据："+dm.toString());
				}
			}
			break;
		case 2:
			print(p.get());
			System.out.println("输入要删除的guid");
			p.DelPrint(scan.next());
			break;
		default:
			System.out.println("输入有误，重启吧");
			break;
		}
	}
	

	private static boolean check(DHModel dm) {
		if(dm.getCode()<0){
			System.out.println("code不能为负数");
			return false;
		}else if(dm.getCode()>99){
			System.out.println("code只能为2位数");
			return false;
		}else if(!p.codeP(dm.getCode())){
			System.out.println("code已存在");
			return false;
		}else if(!p.nameP(dm.getName())){
			System.out.println("name已存在");
			return false;
		}else{
			return true;
		}
	}


	private static void print(List<DHModel> dm) {
		System.out.println("GUID "+"CODE "+ "NAME "+"TYPE");
		for (DHModel dhModel : dm) {
			System.out.println(dhModel.getGuid()+"    "+dhModel.getCode()
					+"    "+dhModel.getName()+"     "+dhModel.getType());
		}
	}

}
