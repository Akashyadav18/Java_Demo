import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet{
	//dopost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String myName = req.getParameter("name1");
		String myEmail = req.getParameter("email1");
		String myPassword = req.getParameter("Password1");
		String myGender = req.getParameter("gender1");
		String myCity = req.getParameter("city1");
		
		try {
			//Browser -> mysql 8 connection jar download
			//Build Path -> configure Build Path > Libraries > CalssPath -> Add External Jar > Select Jar File -> Apply
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_Reg_DB", "root", "root"); //DB Name -> servlet_Reg_DB
			//Create table register and schema
			PreparedStatement ps = conn.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1, myName);
			ps.setString(2, myEmail);
			ps.setString(3, myPassword);
			ps.setString(4, myGender);
			ps.setString(5, myCity);
			
			int count = ps.executeUpdate();
			if(count > 0) {
				resp.setContentType("text/html");
				out.println("<h3 style='color: green'>User Register SuccessFully!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				out.println("<h3 style='color: red'>User Not Register!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.println("<h3 style='color: red'> Exception Occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
	}
	
}
