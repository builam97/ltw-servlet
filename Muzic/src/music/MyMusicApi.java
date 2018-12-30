package music;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mvc.model.FavoriteMusic;
import com.mvc.model.myMusic;
import com.mvc.service.FavoriteMusicService;
import com.mvc.service.MyMusicService;

@Path("/mymusic")
public class MyMusicApi {
	MyMusicService service= new MyMusicService();
@GET
@Path("/{username}")
@Produces(MediaType.APPLICATION_JSON)
public List<myMusic> getAllMyMusic(@PathParam("username") String usernames) {
	System.out.println("getall");
	return service.getAllMyMusic(usernames);
}

@DELETE
@Path("/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public Object getUser(@PathParam("userId") String userId) {
	return null;
}
}