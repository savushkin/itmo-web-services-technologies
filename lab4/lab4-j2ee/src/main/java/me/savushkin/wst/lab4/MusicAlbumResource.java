package me.savushkin.wst.lab4;

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
    public List<MusicAlbum> getAllFighters() {
        return sqldao.getMusicAlbums();
    }

    @POST
    @Path("/finder")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<MusicAlbum> getFighterByFilter(MusicAlbumFilter filter) {
        return sqldao.findMusicAlbums(filter);
    }
}
