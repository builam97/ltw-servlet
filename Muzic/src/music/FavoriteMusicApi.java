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
import com.mvc.model.LoginBean;
import com.mvc.service.FavoriteMusicService;
import com.mvc.service.UserService;

@Path("/favorite")
public class FavoriteMusicApi {
	FavoriteMusicService service= new FavoriteMusicService();
@GET
@Path("/{username}")
@Produces(MediaType.APPLICATION_JSON)
public List<FavoriteMusic> getAll(@PathParam("username") String usernames) {
	System.out.println("getall");
	return service.getAllLoveMusic(usernames);
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Object addMusic(FavoriteMusic fmusic) {
	System.out.println("abc");
	return service.postFavoriteMusic(fmusic);
}
@DELETE
@Path("/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public Object getUser(@PathParam("userId") String userId) {
	return service.delFavoriteMusic(Integer.parseInt(userId));
}
}
