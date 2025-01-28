package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertUser(User user) {
		try {
			String sql_query = "insert into user values(?,?,?,?)";
			int count = jdbcTemplate.update(sql_query, user.getName(), user.getEmail(), user.getGender(), user.getCity());
			if(count > 0 ) {
				System.out.println("Insert Successful");
			}
			else {
				System.out.println("Insert Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		try {
			String sql_query = "update user set name=?, gender=?, city=? where email=?";
			int count = jdbcTemplate.update(sql_query, user.getName(), user.getGender(), user.getCity(), user.getEmail());
			if(count > 0) {
				System.out.println("User Updated Successfully");
			}
			else {
				System.out.println("User Update Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUserByEmail(String email) {
		try {
			String sql_query = "delete from user where email=?";
			int count = jdbcTemplate.update(sql_query, email);
			if(count > 0) {
				System.out.println("User Deleted Successfully");
			}
			else {
				System.out.println("User Deleted Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByEmail(String email) {
		String sql_query = "select * from user where email=?";
		return jdbcTemplate.queryForObject(sql_query, new UserRowMapper(), email);
	}
	
	public List<User> getAllUser(){
		String sql_query = "select * from user";
		return jdbcTemplate.query(sql_query, new UserRowMapper());
	}
	
	//Agar tume lagta h ki RowMapper class ki Kisi or jahag jarurat nahi h to isme create kardo warna bhahar create karo
	public static final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			
			return user;
		}
		
	}
	
}
