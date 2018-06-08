package me.savushkin.wst.lab5;

import me.savushkin.wst.common.MusicAlbum;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/music-albums")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MusicAlbumResource extends me.savushkin.wst.lab4.MusicAlbumResource {

    @POST
    public String createMusicAlbum(MusicAlbum musicAlbum) {
        try {
            return String.valueOf(sqldao.createMusicAlbum(musicAlbum));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PUT
    public String updateMusicAlbum(MusicAlbum musicAlbum) {
        try {
            return String.valueOf(sqldao.updateMusicAlbum(musicAlbum));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DELETE
    @Path("/{id}")
    public String deleteMusicAlbum(@PathParam("id") Long id) {
        try {
            return String.valueOf(sqldao.deleteMusicAlbum(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
