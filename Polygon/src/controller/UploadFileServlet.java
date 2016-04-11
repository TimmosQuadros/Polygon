package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
				File uploadDir = new File("c:\\UploadedFiles");
				File file = File.createTempFile("img", ".png",uploadDir);
				fileItem.write(file);
				
				out.println("File Saved Sucesfully");
				
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

}
