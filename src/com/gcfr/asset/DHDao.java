package com.gcfr.asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gcfr.dh.DBUtil;
import com.gcfr.dh.DHModel;

public class DHDao {
	public void del(String guid) {
		
	}
	public void insert(DHModel dm) {
		
	}
	public void edit(DHModel dm) {
		
	}
	public List<DHModel> query() throws SQLException {
		String sql = "select * from gcfr_t_assetclass where type = ? order by code desc;";
		List<DHModel> dh = new ArrayList<DHModel>();
		DHModel d = null;
		Integer type = null ;
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, type);//type=1,0
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			d = new DHModel();
			d.setGuid(rs.getString("guid"));
			d.setCode(rs.getInt("code"));
			d.setName(rs.getString("name"));
			d.setType(rs.getInt("type"));
			dh.add(d);
		}
		return dh;
	}
}
