package main;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.cars_dao;
import helper.dbhelper;
import pojo.cars;


public class main {
	
	public static void main(String[] args) throws SQLException {
//
		ArrayList<cars> cars = cars_dao.getAll();
		for (cars s : cars) {
			System.out.println(s.getName() + " " + s.getPrice());
		}
		
		cars s1 = cars_dao.getById(1);
		
		if(s1 != null) {
			System.out.println("masina cu id = 4 are numele " + s1.getName());
		}else {
			System.out.println("NU exista masina cu id 4.");
		}
		
		s1.setName("Tesla");
		boolean actualizat = cars_dao.update(s1);
		if (actualizat == true) {
			System.out.println("masina a fost actualizata");
		}else {
			System.out.println("masina nu a fost gasita");
		}
		String deleted = cars_dao.delete("Tesla");

		System.out.println(deleted);
		
		
		
		
		cars Tesla = new cars (1, "Tesla", 4000, null);
		cars_dao.create(Tesla);
		dbhelper.closeConnection();
	} 


}