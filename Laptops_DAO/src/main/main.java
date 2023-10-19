package main;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.laptops_dao;
import helper.dbhelper;
import pojo.laptops;


public class main {
	
	public static void main(String[] args) throws SQLException {
//
		ArrayList<laptops> laptops = laptops_dao.getAll();
		for (laptops s : laptops) {
			System.out.println(s.getBrand() + " " + s.getPrice());
		}
		
		laptops s1 = laptops_dao.getById(1);
		
		if(s1 != null) {
			System.out.println("laptopul cu id = 4 are brandul " + s1.getBrand());
		}else {
			System.out.println("NU exista laptopul cu id 4.");
		}
		
		s1.setBrand("lenovo");
		boolean actualizat = laptops_dao.update(s1);
		if (actualizat == true) {
			System.out.println("laptopul a fost actualizat");
		}else {
			System.out.println("laptopul nu a fost gasit");
		}
		String deleted = laptops_dao.delete("lenovo");

		System.out.println(deleted);
		
		
		
		
		laptops lenovo = new laptops (1, "lenovo", 4000, null);
		laptops_dao.create(lenovo);
		dbhelper.closeConnection();
	} 


}