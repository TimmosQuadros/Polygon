package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserMapper;
import data.BuildingMapper;
import data.OrganisationMapper;

/**
 * Servlet implementation class adminPage
 */
@WebServlet("/adminPage")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		forward(request, response,"/viewOrders.jsp");
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse res, String path)
			throws IOException, ServletException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(path);
		rd.forward(req, res);
	}
	
	

}
