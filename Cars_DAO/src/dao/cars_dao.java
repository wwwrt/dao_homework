package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import helper.dbhelper;
import pojo.cars;

public class cars_dao {
	public static ArrayList<cars> getAll() throws SQLException {
		ArrayList<cars> result = new ArrayList<cars>();

		Connection conn = dbhelper.getConnection();
		Statement stmt = conn.createStatement();

		String query = "select * from cars";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			cars s = new cars(0, query, 0, null);
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setPrice(rs.getInt("price"));
			s.setManufactured(null);
			result.add(s);
		}
		return result;
	}
	
	public static cars getById(int id) throws SQLException {
		cars result = null;
		Connection conn = dbhelper.getConnection();
		
		String query = "select * from cars where id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			result = new cars(id, query, id, null);
			result.setId(rs.getInt("id"));
			result.setName(rs.getString("name"));
			result.setPrice(rs.getInt("price"));
			result.setManufactured(null);
		}
		return result;
	}
	
	public static String delete (String name) throws SQLException {
		Connection c = dbhelper.getConnection();
		String DeleteQuerry = "delete cars where id = ?";
		PreparedStatement ps=c.prepareStatement(DeleteQuerry);
		ps.setString(1, name);
		int deletedRecords = ps.executeUpdate();
		if (deletedRecords == 0) {
		return "nu au fost strse inregistrari";
		}else 
			return "s-au sters "  +deletedRecords+  " inregistrari";
	}
	
	public static boolean update(cars s) throws SQLException {
		
		Connection c = dbhelper.getConnection();
		String query = "update cars set name = ?, price = ?, manufactured = ? where id = ? ";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setInt(2, (int) s.getPrice());
		ps.setDate(3, null);
		ps.setInt(4, s.getId());

		
		int ar = ps.executeUpdate();
		
		
		//terndary operation
		return ar == 0 ? false : true;
	}
	
	public static void create (cars s) throws SQLException {
		Connection c = dbhelper.getConnection();
		String query = "insert into cars (name, price, manufactured) values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setInt(2, (int) s.getPrice());
		ps.setDate(3, null);
ps.executeUpdate();
System.out.println("S-a inserat cu succes " +s.getName());
	}
}
