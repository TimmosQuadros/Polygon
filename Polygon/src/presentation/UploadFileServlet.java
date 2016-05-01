package presentation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import data.Facade;




/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
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
				
				Facade fc = new Facade();
				
				fc.createImage(new File(ServerPath+"\\"+file.getName()), "Abe");
				
				forward(request, response, "/addBuilding.jsp");
				
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
