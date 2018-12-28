package music;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.Attachment;
import com.mvc.util.DBConnection;
@WebServlet("/downloadAttachment")
public class DownloadAttachmentServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		 Connection conn = null;
		   try {
			   conn = DBConnection.createConnection();
				 Long id = null;
				   try {
		               id = Long.parseLong(request.getParameter("id"));
		           } catch (Exception e) {
		           }
			Attachment attachment = getAttachmentFromDB(conn,id);
			   if (attachment == null) {
	               // Không có dữ file.
	               response.getWriter().write("No data found");
	               return;
	           }
			   String fileName = attachment.getFileName();
			   System.out.println("File Name: " + fileName);
			   String contentType = this.getServletContext().getMimeType(fileName);
	           System.out.println("Content Type: " + contentType);
	 
	           response.setHeader("Content-Type", contentType);
	 
	           response.setHeader("Content-Length", String.valueOf(attachment.getFileData().length()));
	 
	           response.setHeader("Content-Disposition", "inline; filename=\"" + attachment.getFileName() + "\"");
	 
	    
	           // Với các file attachment dung lượng lớn
	           // nên đọc và ghi lần lượt
	           Blob fileData = attachment.getFileData();
	           InputStream is = fileData.getBinaryStream();
	 
	           byte[] bytes = new byte[1024];
	           int bytesRead;
	 
	           while ((bytesRead = is.read(bytes)) != -1) {
	               // Ghi dữ liệu ảnh vào Response.
	               response.getOutputStream().write(bytes, 0, bytesRead);
	           }
	           is.close();
	 
	       } catch (Exception e) {
	           throw new ServletException(e);
	       } finally {
	           this.closeQuietly(conn);
	       }
	 }
	   private Attachment getAttachmentFromDB(Connection conn, Long id) throws SQLException {
	       String sql = "Select a.Id,a.File_Name,a.File_Data,a.Description "//
	               + " from Attachment a where a.id = ?";
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       pstm.setLong(1, id);
	       ResultSet rs = pstm.executeQuery();
	       if (rs.next()) {
	           String fileName = rs.getString("File_Name");
	           Blob fileData = rs.getBlob("File_Data");
	           String description = rs.getString("Description");
	           return new Attachment(id, fileName, fileData, description);
	       }
	       return null;
	   }
	 
	   private void closeQuietly(Connection conn) {
	       try {
	           if (conn != null) {
	               conn.close();
	           }
	       } catch (Exception e) {
	       }
	   }
}
