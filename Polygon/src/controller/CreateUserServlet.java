package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Facade;
import data.User;
import data.User.User_type;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
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

		String organisation_name = request.getParameter("organisation");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user_email = request.getParameter("email");
		String usertype = request.getParameter("usertype");
		
		ArrayList<User> users = null;
		try {
			users = facade.getUsers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (User u : users){
			if (u.getUsername().equals(username)) {
				forward(request, response, "/login.jsp");

				return;
			}
		}
 		
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

		forward(request,response,"/adminPage.jsp");
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

	private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
	}
	
}
