import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String myEmail = req.getParameter("email1");
		String myPass = req.getParameter("password1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_reg_db", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, myEmail);
			ps.setString(2, myPass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//By using session we can get current user name
				HttpSession session = req.getSession();
				session.setAttribute("s_name", rs.getString("name"));
				
				RequestDispatcher rd  = req.getRequestDispatcher("/profile.jsp");
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
