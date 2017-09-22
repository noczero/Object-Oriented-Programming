package net.codejava.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * This console application demonstrates how to do CRUD operations using JDBC
 * with Spring framework.
 * @author www.codejava.net
 *
 */
public class SpringJDBCTemplateExample {

	public static void main(String[] args) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("P@ssw0rd");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlInsert = "INSERT INTO contact (name, email, address, telephone)"
				+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsert, "Tom", "tomea@mail.com", "USA", "12345");
		
		String sqlUpdate = "UPDATE contact set email=? where name=?";
		jdbcTemplate.update(sqlUpdate, "tomee@mail.com", "Tom");
		
		String sqlSelect = "SELECT * FROM contact";
		List<Contact> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
				Contact contact = new Contact();
				contact.setName(result.getString("name"));
				contact.setEmail(result.getString("email"));
				contact.setAddress(result.getString("address"));
				contact.setPhone(result.getString("telephone"));
				
				return contact;
			}
			
		});
		
		for (Contact aContact : listContact) {
			System.out.println(aContact);
		}
		
		String sqlDelete = "DELETE FROM contact1 where name=?";
		jdbcTemplate.update(sqlDelete, "Tom");
	}

}
