package presentation;


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
import javax.servlet.http.HttpSession;

import data.Building;
import data.Facade;

/**
 * Servlet implementation class ButtonClickedServlet
 */
@WebServlet("/ButtonClickedServlet")
public class ButtonClickedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ButtonClickedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ArrayList<Building> buildings;
		ArrayList<String> paths;
				try {
					Facade f = new Facade();
					buildings = f.getAllBuildings();
					
					for (int i = 0; i < buildings.size(); i++) {
						if(request.getParameter(String.valueOf(buildings.get(i).getBuilding_id())) !=null){
							paths=f.getBuildingFloorplans(buildings.get(i).getBuilding_id(),this.getServletContext());
							session.setAttribute("paths.floorplans",paths);
							session.setAttribute("building_id", buildings.get(i).getBuilding_id());
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

		forward(request,response,"/showFloorplans.jsp");

		
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

	public void test(){

	}

}
