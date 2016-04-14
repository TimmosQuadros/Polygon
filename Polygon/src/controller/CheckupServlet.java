package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Building;
import data.Checkup;
import data.Facade;
import data.User;

/**
 * Servlet implementation class checkupServlet
 */
@WebServlet("/CheckupServlet")
public class CheckupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade fac;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		fac = new Facade();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		User checkupUser = (User) session.getAttribute("user");

		DateFormat df = new SimpleDateFormat("YYYY/DD/MM");
		Date today = Calendar.getInstance().getTime();
		ArrayList<Building> buildingList = new ArrayList<>();
		
		//df.format(today)

		try {

			buildingList = fac.getAllBuildings();
			for (Building b : buildingList) {
				if (request.getParameter(String.valueOf(b.getBuilding_id())) != null) {
					fac.createCheckup(new Checkup(b.getBuilding_id(), checkupUser.getUser_id(), "1234"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		forward(request, response, "/viewBuildings.jsp");

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

	private void forward(HttpServletRequest req, HttpServletResponse res, String path)
			throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
	}

}
