package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
	ArrayList<Remark> remarks;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
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
		ArrayList<Remark> tmp_remarks;
		tmp_report = (BuildingReport) session.getAttribute("building.report");
		tmp_roomReport = (RoomReport) session.getAttribute("room.report");
		tmp_remarks = (ArrayList<Remark>) session.getAttribute("remarks"); 
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
		if(tmp_remarks!=null){
			remarks=tmp_remarks;
		}else{
			remarks = new ArrayList<>();
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
					roomReport.setBuilding_report_id(report.getBuilding_id());
					response.getWriter().append(roomReport.getBuilding_report_id()+" "+roomReport.getRoom_name());
					if(isConsistentRoomReport(roomReport)){
						
						fac.createRoomReport(roomReport);
						response.getWriter().append(remarks.get(0).getDescription());
						for (Remark r : remarks) {
							fac.createRemark(r);
						}
					}
				}else{
					response.getWriter().append("<html><body><h2>Not consistent report</h2></body></html>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("add_room_name")!=null){
			roomReport.setRoom_name(request.getParameter("room_name"));
			session.setAttribute("room.report", roomReport);
		}else if(request.getParameter("damage_check")!=null){
			roomReport.setDamage_reperation(request.getParameter("damage"));
			session.setAttribute("room.report", roomReport);
		}else if(request.getParameter("save_notes")!=null){
			String wall_comment,ceiling_comment,floor_comment,WD_comment;
			wall_comment=request.getParameter("wall_comment");
			ceiling_comment=request.getParameter("ceiling_comment");
			floor_comment=request.getParameter("floor_comment");
			WD_comment=request.getParameter("WD_comment");

			try {
				if(!wall_comment.equalsIgnoreCase("")){
					remarks.add(new Remark(0, report.getReport_id(), wall_comment, "WALL"));
				}
				if(!ceiling_comment.equalsIgnoreCase("")){
					remarks.add(new Remark(0, report.getReport_id(), ceiling_comment, "CEILING"));
				}
				if(!floor_comment.equalsIgnoreCase("")){
					remarks.add(new Remark(0, report.getReport_id(), floor_comment, "FLOOR"));
				}
				if(!WD_comment.equalsIgnoreCase("")){
					remarks.add(new Remark(0, report.getReport_id(), WD_comment, "WINDOW/DOOR"));
				}
				session.setAttribute("remarks", remarks);
			} catch (Exception e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"An internal error happende contact admin.\" ); </script>");
			}
		}else if(request.getParameter("save_notes_m")!=null){
			roomReport.setMoisture_scan(request.getParameter("Moisture_comment"));
			session.setAttribute("room.report", roomReport);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public boolean isConsistent(BuildingReport report){
		if(report.getBuilding_id()!=0 && report.getTech_id()!=0 && report.getBuildingCondition()!=null){
			return true;
		}
		return false;
	}

	public boolean isConsistentRoomReport(RoomReport report){
		if(report.getBuilding_report_id()!=0 && report.getRoom_name()!=null){
			return true;
		}
		return false;
	}

}
