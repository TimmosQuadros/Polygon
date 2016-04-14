package controller;

import java.io.IOException;
import java.sql.SQLException;

import data.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Facade fac;
	BuildingReport report;
	HttpSession session;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		fac = new Facade();
		super.init();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		BuildingReport tmp_report;
		tmp_report = (BuildingReport) session.getAttribute("building.report");
		if(tmp_report!=null){
			report=tmp_report;
		}else{
			report = new BuildingReport();
		}
		if(request.getParameter("rc")!=null){
			report.setRoof_remark(request.getParameter("rc"));
			session.setAttribute("building.report", report);
		}else if(request.getParameter("owc")!=null){
			report.setOuter_wall_remark(request.getParameter("owc"));
			session.setAttribute("building.report", report);
		}else if(request.getParameter("conditionLevel")!=null){
			
			report.setBuildingCondition(BuildingReport.BuildingCondition.valueOf(request.getParameter("cLevel")));
			session.setAttribute("building.report", report);
			try {
				User user = (User) session.getAttribute("user");
				report.setTech_id(user.getUser_id());
				report.setBuilding_id((int)session.getAttribute("building.id"));
				if(isConsistent(report)){
					fac.createReport(report);
				}else{
					response.getWriter().append("<html><body><h2>Not consistent report</h2></body></html>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public boolean isConsistent(BuildingReport report){
		if(report.getBuilding_id()!=0 && report.getTech_id()!=0 && report.getRoof_remark()!=null && report.getOuter_wall_remark()!=null && report.getBuildingCondition()!=null){
			return true;
		}
		return false;
	}

}
