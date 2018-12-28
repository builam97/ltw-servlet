package music;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mvc.model.LoginBean;
import com.mvc.service.UserService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("/users")
public class UserApi {
	UserService service= new UserService();
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<LoginBean> getAll() {
	System.out.println("abc");
	return service.getAllUser();
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Object addUser(LoginBean user) {
	return service.postUser(user);
}
@GET
@Path("/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public LoginBean getUser(@PathParam("userId") String userId) {
	return service.getUser(Integer.parseInt(userId));
}

}
