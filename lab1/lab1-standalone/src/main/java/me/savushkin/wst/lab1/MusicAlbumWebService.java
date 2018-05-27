package me.savushkin.wst.lab1;

import me.savushkin.wst.common.ConnectionUtil;
import me.savushkin.wst.common.MusicAlbum;
import me.savushkin.wst.common.MusicAlbumFilter;
import me.savushkin.wst.common.SQLDAO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebService(serviceName = "music-album-service")
public class MusicAlbumWebService {
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
    @WebMethod(operationName = "get-albums")
    public List<MusicAlbum> getAlbums() {
        return sqldao.getMusicAlbums();
    }

    @WebMethod(operationName = "find-albums")
    public List<MusicAlbum> findAlbums(
            @WebParam(name = "title") String title,
            @WebParam(name = "artist") String artist,
            @WebParam(name = "releaseYear") Long releaseYear,
            @WebParam(name = "genre") String genre,
            @WebParam(name = "trackCount") Long trackCount
    ) {
        return sqldao.findMusicAlbums(new MusicAlbumFilter(
                title,
                artist,
                releaseYear,
                genre,
                trackCount
        ));
    }
}
