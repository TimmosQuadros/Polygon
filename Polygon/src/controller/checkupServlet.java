package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Facade;

/**
 * Servlet implementation class checkupServlet
 */
@WebServlet("/checkupServlet")
public class checkupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Facade fac;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		fac = new Facade();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int building_id, customer_id, tech_id;
		String dateIssued;
		
		//dateIssued = request.getParameter("organisation");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
