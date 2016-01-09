package com.gcfr.dh;

import java.sql.SQLException;
import java.util.List;

public class DHBO {
	private DHDAO dhdao;
	private Print print =new Print();
	public DHDAO getDhdao() {
		return dhdao;
	}
	public void setDhdao(DHDAO dhdao) {
		this.dhdao = dhdao;
	}
	
	public Print getPrint() {
		return print;
	}
	public void setPrint(Print print) {
		this.print = print;
	}
	
//	public void insertList(List<DHModel> dm) throws SQLException {
//		//dhdao.insertList(dm);
//		print.InsertPrint(dm);
//	}

	
	public List<DHModel> query() throws SQLException {
//		dhdao.query();
		return print.QueryPrint();
	}
	public void del(String guid) throws Exception  {
//		dhdao.del(guid);
		print.DelPrint(guid);
	}
	public void insert(DHModel dh) throws SQLException {
//		dhdao.insert(dh);
		print.InsertPrint(dh);
	}
	public void update(DHModel dh) throws SQLException {
//		dhdao.update(dh);
		print.UpdatePrint(dh);
	}

}
