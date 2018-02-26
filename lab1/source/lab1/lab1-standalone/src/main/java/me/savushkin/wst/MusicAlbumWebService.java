package me.savushkin.wst;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "music-album-service")
public class MusicAlbumWebService {

    @WebMethod(operationName = "get-albums")
    public List<MusicAlbum> getAlbums() {
        SQLDAO sqldao = new SQLDAO();

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
        SQLDAO sqldao = new SQLDAO();

        return sqldao.findMusicAlbums(new MusicAlbumFilter(
                title,
                artist,
                releaseYear,
                genre,
                trackCount
        ));
    }
}
