package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Facade;
import data.User;
import data.UserMapper;
import data.User.User_type;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUser() {
		super();
	}

	@Override
	public void init() throws ServletException {

		super.init();
		facade = new Facade();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String organisation_name = request.getParameter("organization");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user_email = request.getParameter("email");
		String usertype = request.getParameter("usertype");
		
		User.User_type user_type = null;

		if (usertype.equalsIgnoreCase("ADMIN")) {
			user_type = User_type.valueOf("ADMIN");
		}
		if (usertype.equalsIgnoreCase("TECH")) {
			user_type = User_type.valueOf("TECH");
		}
		if (usertype.equalsIgnoreCase("CUST")) {
			user_type = User_type.valueOf("CUST");
		} else {
			// execption her? fejlmeddelelse eller termination?
		}

		try {
			facade.createUser(new User(user_type, username, password, user_email),organisation_name);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
