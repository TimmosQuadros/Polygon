package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILogin login;
	
    public LoginServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	login = new data.LoginController();
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user;
		
		if((user = login.correctPassword(username, password))!=null){
			session.setAttribute("user", user);
			
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
