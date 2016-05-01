package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Checkup;
import data.CheckupMapper;
import data.Facade;
import data.ImageMapper;
import data.User;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AddTechServlet
 */
@WebServlet("/AddTechServlet")
public class AddTechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTechServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		User user = (User)session.getAttribute("user");

		String usertype = user.getUser_type().name();

		Facade facade = new Facade();
		CheckupMapper chum = new CheckupMapper();

		switch (usertype) {
		case "ADMIN":

			break;
		case "TECH":
			try {
				Checkup checkup = getCheckup(facade.getCheckups(),request);
				if(checkup!=null){
					chum.addTech(checkup, user.getUser_id());	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "CUSTOMER":

			break;

		default:
			break;
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	public Checkup getCheckup(ArrayList<Checkup> checkups,HttpServletRequest request){
		for (Checkup checkup : checkups) {
			if(request.getParameter(String.valueOf(checkup.getCheckupID()))!=null){
				return checkup;
			}
		}
		return null;
	}

}
