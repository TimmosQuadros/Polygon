package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		boolean done = false;
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
		}else if(request.getParameter("owc")!=null){
			report.setOuter_wall_remark(request.getParameter("outerWalls_comment"));
		}else if(request.getParameter("conditionLevel")!=null){
			report.setBuildingCondition(BuildingReport.BuildingCondition.valueOf(request.getParameter("conditionLevel")));
			try {
				User user = (User) session.getAttribute("user");
				report.setTech_id(user.getUser_id());
				report.setBuilding_id(((Building)session.getAttribute("building")).getBuilding_id());
				report.setReport_id(getMaxBuildingReportID()+1);
				if(isConsistent(report)){
					fac.createReport(report);
					roomReport.setBuilding_report_id(report.getReport_id());
					//if(isConsistentRoomReport(roomReport)){
					int roomReportID = getMaxRoomReportID()+1;
					roomReport.setRoom_report_id(roomReportID);
					fac.createRoomReport(roomReport);
					for (Remark r : remarks) {
						r.setRoomReportId(roomReportID);
						fac.createRemark(r);
					}
					//}
				}else{
					response.getWriter().append("<html><body><h2>Not consistent report</h2></body></html>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			done = true;
			forward(request, response, "/techPage.jsp");
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

			try {
				if(!wall_comment.equalsIgnoreCase("") && wall_comment!=null){
					remarks.add(new Remark(0, 0, wall_comment, "WALL"));
				}
				if(!ceiling_comment.equalsIgnoreCase("") && ceiling_comment!=null){
					remarks.add(new Remark(0, 0, ceiling_comment, "CEILING"));
				}
				if(!floor_comment.equalsIgnoreCase("") && floor_comment!=null){
					remarks.add(new Remark(0, 0, floor_comment, "FLOOR"));
				}
				if(!WD_comment.equalsIgnoreCase("") && WD_comment!=null){
					remarks.add(new Remark(0, 0, WD_comment, "WINDOW/DOOR"));
				}
			} catch (Exception e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"An internal error happende contact admin.\" ); </script>");
			}
		}else if(request.getParameter("save_notes_m")!=null){
			roomReport.setMoisture_scan(request.getParameter("Moisture_comment"));
		}
		session.setAttribute("remarks", remarks);
		session.setAttribute("room.report", roomReport);
		session.setAttribute("building.report", report);
		if(!done){
			forward(request, response, "/buildingReport.jsp");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
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

	public int getMaxBuildingReportID() throws SQLException{
		ArrayList<BuildingReport> buildingReports = fac.getBuildingReports();
		if(!buildingReports.isEmpty()){
			return buildingReports.get(buildingReports.size()-1).getReport_id();
		}
		return 0;
	}

	public int getMaxRoomReportID() throws SQLException{
		ArrayList<RoomReport> roomreports = fac.getRoomReports();
		if(!roomreports.isEmpty()){
			return roomreports.get(roomreports.size()-1).getRoom_report_id();
		}
		return 0;
	}
}
