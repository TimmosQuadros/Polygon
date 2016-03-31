package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import data.UserMapper;
import data.User.User_type;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMapper userMapper;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUser() {
		super();
	}

	@Override
	public void init() throws ServletException {

		super.init();
		userMapper = new UserMapper();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String organisation_name = request.getParameter("organisation_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user_email = request.getParameter("user_email");
		User.User_type user_type = null;

		if (request.getParameter("user_type").equalsIgnoreCase("ADMIN")) {
			user_type = User_type.valueOf("ADMIN");
		}
		if (request.getParameter("user_type").equalsIgnoreCase("TECH")) {
			user_type = User_type.valueOf("TECH");
		}
		if (request.getParameter("user_type").equalsIgnoreCase("CUST")) {
			user_type = User_type.valueOf("CUST");
		} else {
			// execption her? fejlmeddelelse eller termination?
		}

		try {
			userMapper.createUser(new User(organisation_name, username, password, user_type, user_email));

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
