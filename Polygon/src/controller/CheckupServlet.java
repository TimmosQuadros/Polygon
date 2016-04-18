package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

		ArrayList<Building> buildingList = new ArrayList<>();

		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int date = now.get(Calendar.DAY_OF_MONTH);
		int month = now.get(Calendar.MONTH) + 1;
		String tmpdate = "", tmpmonth = "", tmpyear = "";
		if (month < 10) {
			tmpmonth = "0" + month;
		} else {
			tmpmonth = String.valueOf(month);
		}
		if (date < 10) {
			tmpdate = "0" + date;
		} else {
			tmpdate = String.valueOf(date);
		}

		tmpyear = String.valueOf(year);

		String formattedDate = tmpyear + "/" + tmpdate + "/" + tmpmonth;

		try {

			buildingList = fac.getAllBuildings();
			for (Building b : buildingList) {
				if (request.getParameter(String.valueOf(b.getBuilding_id())) != null) {
					fac.createCheckup(new Checkup(b.getBuilding_id(), checkupUser.getUser_id(), formattedDate));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		forward(request, response, "/viewOrders.jsp");

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
