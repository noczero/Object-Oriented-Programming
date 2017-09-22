package com.hmkcode;

import com.hmkcode.dao.JDBCPersonDAO;
import com.hmkcode.vo.Person;

public class Main {

	public static void main(String args[]){
		
		Person person = new Person();
		person.setName("HMK");
		
		JDBCPersonDAO jdbcPersonDAO = new JDBCPersonDAO();
		jdbcPersonDAO.getConnection();
		jdbcPersonDAO.insert(person);
		
		person.setName("Another Name");

		jdbcPersonDAO.insert(person);
		
		jdbcPersonDAO.select();
		jdbcPersonDAO.closeConnection();


		
	}
}
