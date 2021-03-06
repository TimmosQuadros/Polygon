package presentation;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import logic.ILogin;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILogin login;
	
    public LoginServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	login = new logic.LoginController();
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		
		try {
			user = login.correctPassword(username, password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
			session.setAttribute("user", user);
		if (user != null) {
			switch (user.getUser_type()) {
			case ADMIN:
				session.setAttribute("user.password", "Logged in as admin");
				forward(request, response, "/adminPage.jsp" );
				break;
			case TECH:
				session.setAttribute("user.password", "Logged in as technician");
				forward(request, response, "/techPage.jsp");
				break;
			case CUST:
				session.setAttribute("user.password", "Logged in as customer");
				forward(request, response, "/customerPage.jsp");
				break;
			default:
				break;
			} 
		}else{
			session.setAttribute("user.password", "Wrong passsword or username.");
			forward(request, response, "/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
	}
}
