package me.savushkin.wst.lab1;

import me.savushkin.wst.common.MusicAlbum;
import me.savushkin.wst.common.MusicAlbumFilter;
import me.savushkin.wst.common.SQLDAO;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebService(serviceName = "music-album-service")
public class MusicAlbumWebService {
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

    @WebMethod(operationName = "get-albums")
    public List<MusicAlbum> getAlbums() {
        SQLDAO sqldao = new SQLDAO(connection);

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
        SQLDAO sqldao = new SQLDAO(connection);

        return sqldao.findMusicAlbums(new MusicAlbumFilter(
                title,
                artist,
                releaseYear,
                genre,
                trackCount
        ));
    }
}
