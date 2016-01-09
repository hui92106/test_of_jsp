package com.gcfr.dh;

import java.sql.SQLException;

public class DHBO {
	private DHDAO dhdao;
	public DHDAO getDhdao() {
		return dhdao;
	}
	public void setDhdao(DHDAO dhdao) {
		this.dhdao = dhdao;
	}
	public void query() throws SQLException {
		dhdao.query();
	}
	public void del(String guid) throws SQLException  {
		dhdao.del(guid);
	}
	public void insert(DHModel dh) throws SQLException {
		dhdao.insert(dh);
	}
	public void update(DHModel dh) throws SQLException {
		dhdao.update(dh);
	}
}
