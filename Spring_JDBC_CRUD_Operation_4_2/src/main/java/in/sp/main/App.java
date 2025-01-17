package in.sp.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import in.sp.beans.Student;
import in.sp.mapper.StudentRowMapper;
import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        
//        Insert OPERATION      
//        String name = "efg";
//    	int rollno = 103;
//    	float marks = 87f;
//        String insert_sql_query = "insert into student values(?,?,?)";
//        int count = jdbcTemplate.update(insert_sql_query, name, rollno, marks);
//        if(count > 0) {
//        	System.out.println("Insert Successful");
//        }
//        else {
//        	System.out.println("Insert Fail!");
//        }
        
//        UPDATE OPERATION
//        float marks = 67;
//        int rollno = 78;
//        String update_sql_query = "update student set marks=? where rollno=?";
//        int count = jdbcTemplate.update(update_sql_query, marks, rollno);
//        if(count > 0) {
//        	System.out.println("Update Successful");
//        }
//        else {
//        	System.out.println("Update Fail");
//        }
        
//        DELETE OPERATION
//        int rollno = 34;
//        String delete_sql_query = "delete from student where rollno=?";
//        int count = jdbcTemplate.update(delete_sql_query, rollno);
//        if(count > 0) {
//        	System.out.println("Delete Successful");
//        }
//        else {
//        	System.out.println("delete Fail");
//        }
        
//        SELECT OPERATION
        String select_sql_query = "select * from student";
        List<Student> std_list = jdbcTemplate.query(select_sql_query, new StudentRowMapper());
        for(Student std : std_list) {
        	System.out.println("Name :"+std.getName());
        	System.out.println("Roll No :"+std.getRollno());
        	System.out.println("Marks :"+std.getMarks());
        	System.out.println("");
        }
    }
}
