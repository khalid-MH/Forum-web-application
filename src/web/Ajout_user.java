package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajout_user
 */
@WebServlet("/Ajout_user")
public class Ajout_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_user() {
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
		String vpwd=request.getParameter("pwd");
		String ve=request.getParameter("email");
		
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/forum";
		String req = "insert into users values(?,?,?,?)";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		
		st.setString(1, vl);
		st.setString(2, vpwd);
		st.setString(3, "user");
		st.setString(4, ve);
		st.executeUpdate();
		response.sendRedirect("pages/consultation_user.jsp");
				
		
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
	}

	}


