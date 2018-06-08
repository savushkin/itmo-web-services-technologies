package me.savushkin.wst.lab6;

import me.savushkin.wst.common.ConnectionUtil;
import me.savushkin.wst.common.MusicAlbum;
import me.savushkin.wst.common.MusicAlbumFilter;
import me.savushkin.wst.common.SQLDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("/music-albums")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MusicAlbumResource {
    protected Connection connection;
    protected SQLDAO sqldao;

    {
        try {
            connection = ConnectionUtil.getConnection();
            sqldao = new SQLDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MusicAlbum> getAllFighters() throws WSTException {
        try {
            return sqldao.getMusicAlbums();
        } catch (Exception e) {
            throw new WSTException(e.getMessage());
        }
    }

    @POST
    @Path("/finder")
    public List<MusicAlbum> getFighterByFilter(MusicAlbumFilter filter) throws WSTException {
        try {
            return sqldao.findMusicAlbums(filter);
        } catch (Exception e) {
            throw new WSTException(e.getMessage());
        }
    }

    @POST
    public String createMusicAlbum(MusicAlbum musicAlbum) throws WSTException {
        try {
            return String.valueOf(sqldao.createMusicAlbum(musicAlbum));
        } catch (Exception e) {
            throw new WSTException(e.getMessage());
        }
    }

    @PUT
    public String updateMusicAlbum(MusicAlbum musicAlbum) throws WSTException {
        try {
            return String.valueOf(sqldao.updateMusicAlbum(musicAlbum));
        } catch (Exception e) {
            throw new WSTException(e.getMessage());
        }
    }

    @DELETE
    @Path("/{id}")
    public String deleteMusicAlbum(@PathParam("id") Long id) throws WSTException {
        try {
            return String.valueOf(sqldao.deleteMusicAlbum(id));
        } catch (Exception e) {
            throw new WSTException(e.getMessage());
        }
    }
}
