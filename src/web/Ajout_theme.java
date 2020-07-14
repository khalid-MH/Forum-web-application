package web;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ajout_theme
 */
@WebServlet("/Ajout_theme")
public class Ajout_theme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_theme() {
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
		Scanner sc=new Scanner(System.in);
		
		String vlab=request.getParameter("lab");
		String vd=request.getParameter("desc");
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/forum";
		String req = "insert into themes(label, description) values(?,?)";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		st.setString(1, vlab);
		st.setString(2, vd);
		st.executeUpdate();
		response.sendRedirect("pages/consultation_theme.jsp");
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
	}

}
}