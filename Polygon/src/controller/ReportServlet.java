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
	RoomReport roomReport;
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
		RoomReport tmp_roomReport;
		tmp_report = (BuildingReport) session.getAttribute("building.report");
		tmp_roomReport = (RoomReport) session.getAttribute("room.report");
		if(tmp_report!=null){
			report=tmp_report;
		}else{
			report = new BuildingReport();
		}
		if(tmp_roomReport!=null){
			roomReport=tmp_roomReport;
		}else{
			roomReport = new RoomReport();
		}

		if(request.getParameter("rc")!=null){
			report.setRoof_remark(request.getParameter("roof_comment"));
			session.setAttribute("building.report", report);
		}else if(request.getParameter("owc")!=null){
			report.setOuter_wall_remark(request.getParameter("outerWalls_comment"));
			session.setAttribute("building.report", report);
		}else if(request.getParameter("conditionLevel")!=null){

			report.setBuildingCondition(BuildingReport.BuildingCondition.valueOf(request.getParameter("conditionLevel")));
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
		}else if(request.getParameter("add_room_name")!=null){
			roomReport.setRoom_name(request.getParameter("room_name"));
		}else if(request.getParameter("damage_check")!=null){
			roomReport.setDamage_reperation(request.getParameter("damage"));
		}else if(request.getParameter("save_notes")!=null){
			String wall_comment,ceiling_comment,floor_comment,WD_comment;
			wall_comment=request.getParameter("wall_comment");
			ceiling_comment=request.getParameter("ceiling_comment");
			floor_comment=request.getParameter("floor_comment");
			WD_comment=request.getParameter("WD_comment");
			
			if(wall_comment!=null){

			}
			if(ceiling_comment!=null){

			}
			if(floor_comment!=null){

			}
			if(WD_comment!=null){

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
