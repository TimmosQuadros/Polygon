package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Building;
import data.Facade;
import data.User;


@WebServlet("/CreateBuilding")
public class CreateBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade facade;

    public CreateBuilding() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	facade = new Facade();
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String building_name = request.getParameter("building_name");
		String street_address = request.getParameter("street_address");
		int zip = Integer.parseInt(request.getParameter("zipcode"));
		int build_year = Integer.parseInt(request.getParameter("build_year"));
		int floor_area = Integer.parseInt(request.getParameter("floor_area"));
		User user = (User)session.getAttribute("user");
		try {
			facade.createBuilding(new Building(building_name, street_address, zip, build_year, floor_area),user.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
