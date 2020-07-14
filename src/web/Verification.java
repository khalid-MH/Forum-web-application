package web;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vl=request.getParameter("login");
		String vp=request.getParameter("pwd");
		
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/forum";
		String req = "select * from users where login=? and password=?";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		st.setString(1, vl);
		st.setString(2, vp);
		ResultSet res=st.executeQuery();
			if(res.next()) {    // si il a trouvé une valeur
				HttpSession session=request.getSession();
				session.setAttribute("login", vl);
				String vprofile=res.getString("profile");
				if(vprofile.equals("admin"))
				response.sendRedirect("pages/menu_admin.jsp");
				else
				
					response.sendRedirect("pages/menu_user.jsp");
			}
			else{
				response.sendRedirect("pages/index.jsp");
			}
			
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
	}
	}

	}


