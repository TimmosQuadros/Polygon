package controller;


import java.io.File;
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

import org.apache.tomcat.util.http.fileupload.FileUtils;

import data.Facade;
import data.User;

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
		ArrayList<User> users;
		try {
			Facade f = new Facade();
			users = f.getUsers();
			for (int i = 0; i < users.size(); i++) {
				if(request.getParameter(String.valueOf(users.get(i).getUser_id())) !=null){
					FileUtils.cleanDirectory(new File("WebContent/Resources/Images/Floorplans"));
					session.setAttribute("user.floorplans", users.get(i));
					f.getUserImages(users.get(i).getUser_id());
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

}
