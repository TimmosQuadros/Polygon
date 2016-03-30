package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Building;
import data.BuildingMapper;


@WebServlet("/CreateBuilding")
public class CreateBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BuildingMapper buildingMapper;

    public CreateBuilding() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	
    	super.init();
    	buildingMapper = new BuildingMapper();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String building_name = request.getParameter("building_name");
		String street_address = request.getParameter("street_address");
		int zip = Integer.parseInt(request.getParameter("zipcode"));
		int build_year = Integer.parseInt(request.getParameter("build_year"));
		int floor_area = Integer.parseInt(request.getParameter("floor_area"));
		
		try {
			buildingMapper.createBuilding(new Building(building_name, street_address, zip, build_year, floor_area));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
