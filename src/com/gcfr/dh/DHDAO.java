package com.gcfr.dh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DHDAO {
	/**
	 * 查询功能
	 * @return List<DHModel>
	 * @throws SQLException
	 */
	public List<DHModel> query() throws SQLException {
		String sql = "select * from gcfr_t_assetclass where order by code desc;";
		Connection conn=DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<DHModel> dh = new ArrayList<DHModel>();
		DHModel d = null;
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
	/**
	 * 删除功能
	 * @param guid
	 * @throws SQLException
	 */
	public void del(String guid) throws SQLException{
		String sql ="delete from gcfr_t_assetclass where guid = '?';";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, guid);
		ptmt.execute(sql);
	}
	/**
	 * 添加功能
	 * @param dh
	 * @throws SQLException
	 */
	public void insert(DHModel dh) throws SQLException {
		String sql = "insert into gcfr_t_assetclass values('?',?,'?',?);";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, dh.getGuid());
		ptmt.setInt(2, dh.getCode());
		ptmt.setString(3, dh.getName());
		ptmt.setInt(4, dh.getType());
		ptmt.execute(sql);
	}
	/**
	 * 修改
	 * @param dh
	 * @throws SQLException
	 */
	public void update(DHModel dh) throws SQLException {
		String sql = "UPDATE gcfr_t_assetclass SET guid='?', code=?,name='?',type=?;";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, dh.getGuid());
		ptmt.setInt(2, dh.getCode());
		ptmt.setString(3, dh.getName());
		ptmt.setInt(4, dh.getType());
		ptmt.execute();
	}
	
	/**
	 * 批量新增
	 * @param dm
	 * @throws SQLException
	 */
	public void insertList(List<DHModel> dm) throws SQLException {
		String sql = "insert into gcfr_t_assetclass values('?',?,'?',?);";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		for (DHModel dhModel : dm) {
			ptmt.setString(1, dhModel.getGuid());
			ptmt.setInt(2, dhModel.getCode());
			ptmt.setString(3, dhModel.getName());
			ptmt.setInt(4, dhModel.getType());
			ptmt.execute(sql);
		}

	}
}
