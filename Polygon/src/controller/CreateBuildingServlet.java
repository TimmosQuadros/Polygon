package controller;

import java.io.IOException;
import java.sql.SQLException;

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
import data.User;


@WebServlet("/CreateBuilding")
public class CreateBuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade facade;

	public CreateBuildingServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		facade = new Facade();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		if(user!=null){
			try {
				String building_name = request.getParameter("building_name");
				String street_address = request.getParameter("street_address");
				int zip = Integer.parseInt(request.getParameter("zipcode"));	
				int build_year = Integer.parseInt(request.getParameter("build_year"));
				int floor_area = Integer.parseInt(request.getParameter("floor_area"));
				facade.createBuilding(new Building(building_name, street_address, zip, build_year, floor_area),user.getOrganisations_id());
				facade.createFloorplan(facade.getMaxImageId(), facade.getMaxBuildingId());
			} catch (SQLException e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"An error occurred either: yoou tried to add a building with a name that already exists.\" ); </script>");
				forward(request, response, "/addBuilding.jsp");
			}catch (NumberFormatException e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"You have enterede wrong format in some of the fields.\" ); </script>");
				forward(request, response, "/addBuilding.jsp");
			}catch (NullPointerException e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"An internal null pointer error happend try to login again.\" ); </script>");
				forward(request, response, "/addBuilding.jsp");
			}catch (Exception e) {
				response.getWriter().append("<script language=\"javascript\"> "
						+ "alert( \"An internal error happende contact admin.\" ); </script>");
				forward(request, response, "/addBuilding.jsp");
			}
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
	}

}
