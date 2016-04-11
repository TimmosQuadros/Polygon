package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
		
		out.append("ja tak!");
		
//		// TODO Auto-generated method stub
//		File file;
//		int maxFileSize = 5000 * 1024;
//		int maxMemSize = 5000 * 1024;
//
//		ServletContext context = request.getServletContext();
//		String filePath = context.getInitParameter("file-upload");
//
//		// Verify the content type
//		String contentType = request.getContentType();
//		if((contentType.indexOf("multipart/form-data")>=0)){
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			// maximum size that will be stored in memory
//			factory.setSizeThreshold(maxMemSize);
//			// Location to save data that is larger than maxMemSize.
//			factory.setRepository(new File("c:\\temp"));
//			// Create a new file upload handler
//			ServletFileUpload upload = new ServletFileUpload(factory);
//			// maximum file size to be uploaded.
//			upload.setSizeMax(maxFileSize);
//			
//			try{ 
//		         // Parse the request to get file items.
//		         List fileItems = upload.parseRequest((RequestContext) request);
//
//		         // Process the uploaded file items
//		         Iterator i = fileItems.iterator();
//
//		         out.println("<html>");
//		         out.println("<head>");
//		         out.println("<title>JSP File upload</title>");  
//		         out.println("</head>");
//		         out.println("<body>");
//		         while ( i.hasNext () ) 
//		         {
//		            FileItem fi = (FileItem)i.next();
//		            if ( !fi.isFormField () )	
//		            {
//		            // Get the uploaded file parameters
//		            String fieldName = fi.getFieldName();
//		            String fileName = fi.getName();
//		            boolean isInMemory = fi.isInMemory();
//		            long sizeInBytes = fi.getSize();
//		            // Write the file
//		            if( fileName.lastIndexOf("\\") >= 0 ){
//		            file = new File( filePath + 
//		            fileName.substring( fileName.lastIndexOf("\\"))) ;
//		            }else{
//		            file = new File( filePath + 
//		            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//		            }
//		            fi.write( file ) ;
//		            out.println("Uploaded Filename: " + filePath + 
//		            fileName + "<br>");
//		            }
//		         }
//		         out.println("</body>");
//		         out.println("</html>");
//		      }catch(Exception ex) {
//		         System.out.println(ex);
//		      }
//		   }
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
