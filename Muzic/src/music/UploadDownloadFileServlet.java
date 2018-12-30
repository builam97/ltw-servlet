package music;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mvc.dao.myMusicDao;
import com.mvc.model.myMusic;

@WebServlet("/UploadDownloadFileServlet")
@MultipartConfig
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
	public UploadDownloadFileServlet() {
		super();
	}
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		if(fileName == null || fileName.equals("")){
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		ServletOutputStream os  = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read=0;
		while((read = fis.read(bufferData))!= -1){
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("File downloaded at client successfully");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		System.out.println("content"+content);
		String songName = request.getParameter("songName");
		System.out.println(songName);
		String quality = request.getParameter("quality");
		String extendFile = request.getParameter("extendFile");
		 response.setContentType("text/html;charset=UTF-8");

		    // Create path components to save the file
		    final Part filePart = request.getPart("fileName");
		    final String fileName = getFileName(filePart);

		    OutputStream out = null;
		    InputStream filecontent = null;
		    final PrintWriter writer = response.getWriter();

		    try {
		        out = new FileOutputStream(new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator
		                + fileName));
		        filecontent = filePart.getInputStream();
		        System.out.println(request.getServletContext().getAttribute("FILES_DIR") + File.separator
		                + fileName);
		        String path =request.getServletContext().getAttribute("FILES_DIR") + File.separator
		                + fileName;
		        // save database
		        myMusic music = new myMusic(0,fileName,"Unknow",path,content,extendFile,1);
		        myMusicDao musicdao = new myMusicDao();
		        musicdao.addMusic(music);
		        int read = 0;
		        final byte[] bytes = new byte[1024];

		        while ((read = filecontent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		    } catch (FileNotFoundException fne) {
		    } finally {
		        if (out != null) {
		            out.close();
		        }
		        if (filecontent != null) {
		            filecontent.close();
		        }
		        if (writer != null) {
		            writer.close();
		        }
		    }
	}
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
