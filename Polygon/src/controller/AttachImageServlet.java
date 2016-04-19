package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.ant.SessionsTask;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import data.Facade;




/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/AttachImageServlet")
public class AttachImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttachImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		Facade facade = new Facade();
		HttpSession session = request.getSession(true);
		
		if(!ServletFileUpload.isMultipartContent(request)){
			out.println("Nothing to upload");
			return;
		}
		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem fileItem : items) {
				String contentType = fileItem.getContentType();
				if(!contentType.equals("image/png")){
					out.println("only png format image files supported");
					continue;
				}
				
				String path = this.getServletContext().getRealPath("/");
				
				String ServerPath = path+"Resources\\Images";
				
				File uploadDir = new File(ServerPath);
				
				File file = File.createTempFile("img", ".png",uploadDir);
				
				fileItem.write(file);
				
				
				facade.createImage(new File(ServerPath+"\\"+file.getName()), "Abe");
				
				try {
					//keep it in the session instead. 
					facade.createFloorplan(facade.getMaxImageId(),(int)session.getAttribute("building_id"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				forward(request, response, "/viewBuildings.jsp");
				
			}
			
		} catch (FileUploadException e) {
			
			out.println("Upload fail");
		} catch (Exception e) {
			
			out.println("Can't save");
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