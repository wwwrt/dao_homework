package main;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.rc_dao;
import helper.dbhelper;
import pojo.rc;


public class main {
	
	public static void main(String[] args) throws SQLException {
//
//		ArrayList<rc> rubikscube = rc_dao.getAll();
//		for (rc s : rubikscube) {
//			System.out.println(s.getBrand() + " " + s.getWeight());
//		}
//		
//		rc s1 = rc_dao.getById(1);
//		
//		if(s1 != null) {
//			System.out.println("cubul cu weight = 4.6 are brandul " + s1.getBrand());
//		}else {
//			System.out.println("NU exista cubul cu id 4.6.");
//		}
//		
//		s1.setBrand("rubik");
//		boolean actualizat = rc_dao.update(s1);
//		if (actualizat == true) {
//			System.out.println("cubul a fost actualizat");
//		}else {
//			System.out.println("cubul nu a fost gasit");
//		}
//		String deleted = rc_dao.delete("rubik");
//
//		System.out.println(deleted);
		
		
		
		
		rc rubik = new rc ("rubik", 4.5, 4, null);
		rc_dao.create(rubik);
		dbhelper.closeConnection();
	} 


}