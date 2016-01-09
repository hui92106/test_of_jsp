package com.gcfr.dh;

import java.sql.SQLException;

public class DHService {
	private DHBO dhbo;

	public DHBO getDhbo() {
		return dhbo;
	}

	public void setDhbo(DHBO dhbo) {
		this.dhbo = dhbo;
	}
	public void save(DHModel dh) throws SQLException {
		String d = dh.getGuid();
		if(d.equals("")||d == null){
			dhbo.insert(dh);
		}else{
			dhbo.update(dh);
		}
	}
	public void del(String guid) throws SQLException{
		dhbo.del(guid);
	}
}
