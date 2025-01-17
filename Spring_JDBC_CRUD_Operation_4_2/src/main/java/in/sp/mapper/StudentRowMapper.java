package in.sp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sp.beans.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student std = new Student();
		std.setName(rs.getString("name"));
		std.setRollno(rs.getInt("rollno"));
		std.setMarks(rs.getFloat("marks"));
		return std;
	}

}
