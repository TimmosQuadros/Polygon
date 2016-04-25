package controller;

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
 * Servlet implementation class InspectBuildingServlet
 */
@WebServlet("/Inspect")
public class InspectBuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Facade facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InspectBuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	facade = new Facade();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(true);
			ArrayList<Building> buildings = facade.getAllBuildings();
			for (Building building : buildings) {
				if(request.getParameter(String.valueOf(building.getBuilding_id()))!=null){
					session.setAttribute("building.inspect", building);
				}
			}
			forward(request, response, "/buildingReport1.jsp"/*change to buildingReport*/);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
