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
 * Servlet implementation class Ajout_message
 */
@WebServlet("/Ajout_message")
public class Ajout_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated m
		

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vtitre=request.getParameter("titre");
		String vmessage=request.getParameter("message");
		String vtheme=request.getParameter("theme");
		System.out.println(vtitre+"  "+vmessage+"  "+vtheme);
		String driver = "com.mysql.jdbc.Driver";
		String con = "jdbc:mysql://localhost:3306/forum";
		String req = "insert into messages(titre,message,theme,statut,user) values(?,?,?,?,?)";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		PreparedStatement st=conn.prepareStatement(req);
		
		HttpSession session=request.getSession();
		String vl=session.getAttribute("login").toString();
		st.setString(1, vtitre);
		st.setString(2, vmessage);
		st.setString(3, vtheme);
		st.setString(4, "non");
		st.setString(5, vl);
		st.executeUpdate();
		response.sendRedirect("pages/consultation_message.jsp");
				
		
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());



		}
	}
}