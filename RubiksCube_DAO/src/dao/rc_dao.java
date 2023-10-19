package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import helper.dbhelper;
import pojo.rc;

public class rc_dao {
	public static ArrayList<rc> getAll() throws SQLException {
		ArrayList<rc> result = new ArrayList<rc>();

		Connection conn = dbhelper.getConnection();
		Statement stmt = conn.createStatement();

		String query = "select * from rubikscube";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			rc s = new rc(query, 0, 0, null);
			s.setBrand(rs.getString("brand"));
			s.setWeight(rs.getDouble("weight"));
			s.setSides(rs.getInt("sides"));
			s.setManufactured(rs.getDate("manufactured"));
			result.add(s);
		}
		return result;
	}
	
	public static rc getById(int id) throws SQLException {
		rc result = null;
		Connection conn = dbhelper.getConnection();
		
		String query = "select * from rubikscube where id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			result = new rc(query, id, id, null);
			result.setBrand(rs.getString("brand"));
			result.setWeight(rs.getDouble("weight"));
			result.setSides(rs.getInt("sides"));
			result.setManufactured(rs.getDate("manufactured"));
		}
		return result;
	}
	
	public static String delete (String name) throws SQLException {
		Connection c = dbhelper.getConnection();
		String DeleteQuerry = "delete from rubikscube where id = ?";
		PreparedStatement ps=c.prepareStatement(DeleteQuerry);
		ps.setString(1, name);
		int deletedRecords = ps.executeUpdate();
		if (deletedRecords == 0) {
		return "nu au fost strse inregistrari";
		}else 
			return "s-au sters "  +deletedRecords+  " inregistrari";
	}
	
	public static boolean update(rc s) throws SQLException {
		
		Connection c = dbhelper.getConnection();
		String query = "update rubikscube set brand = ?, weight = ?, sides = ? where brand = ? ";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getBrand());
		ps.setDouble(2, s.getWeight());
		ps.setInt(3, s.getSides());

		
		int ar = ps.executeUpdate();
		
		
		//terndary operation
		return ar == 0 ? false : true;
	}
	
	public static void create (rc s) throws SQLException {
		Connection c = dbhelper.getConnection();
		String query = "insert into rubikscube (brand, weight, sides) values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getBrand());
		ps.setDouble(2, s.getWeight());
		ps.setInt(3, s.getSides());
ps.executeUpdate();
System.out.println("S-a inserat cu succes " +s.getBrand());
	}
}
