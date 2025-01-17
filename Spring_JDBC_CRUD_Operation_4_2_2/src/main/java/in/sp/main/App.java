package in.sp.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        NamedParameterJdbcTemplate myJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key_name", "harsh");
        map.put("key_rollno", 94);
        map.put("key_marks", 88.8f);
        
        String insert_query = "insert into student values(:key_name, :key_rollno, :key_marks)";
        int count = myJdbcTemplate.update(insert_query, map);
        if(count > 0) {
        	System.out.println("insert Successful");
        }
        else {
        	System.out.println("Insert Fail");
        }
    }
}
