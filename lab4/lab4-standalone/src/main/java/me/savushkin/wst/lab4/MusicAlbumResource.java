package me.savushkin.wst.lab4;

import me.savushkin.wst.common.MusicAlbum;
import me.savushkin.wst.common.MusicAlbumFilter;
import me.savushkin.wst.common.SQLDAO;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("/music-albums")
public class MusicAlbumResource {
    protected SQLDAO sqldao;

    @Resource(lookup = "jdbc/__default")
    private DataSource dataSource;

    private Connection connection;

    {
        try {
            connection = dataSource.getConnection();
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
