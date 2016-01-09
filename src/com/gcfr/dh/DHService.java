package com.gcfr.dh;

import java.sql.SQLException;
import java.util.List;

public class DHService {
	private DHBO dhbo;

	public DHBO getDhbo() {
		return dhbo;
	}

	public void setDhbo(DHBO dhbo) {
		this.dhbo = dhbo;
	}
	public void save(List<DHModel>dm) throws SQLException {
//		String d = dh.getGuid();
//		if(d.equals("")||d == null){
//			dhbo.insert(dh);
//		}else{
//			dhbo.update(dh);
//		}
		
		for (DHModel dhModel : dm) {
			String d = dhModel.getGuid();
			if(d.equals("")||d == null){
			dhbo.insert(dhModel);
		}else{
			dhbo.update(dhModel);
		}
		}
	}
	public void del(List<String>guid) throws SQLException{
//		dhbo.del(guid);
			for (String string : guid) {
				dhbo.del(string);
			}
	}
	public List<DHModel> query() throws SQLException {
		List<DHModel>dm = dhbo.query();
		return dm;
	}
}
