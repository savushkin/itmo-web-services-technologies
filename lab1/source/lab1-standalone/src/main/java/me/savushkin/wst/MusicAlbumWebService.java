package me.savushkin.wst;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "music-album-service")
public class MusicAlbumWebService {
    @WebMethod(operationName = "get-album")
    public List<MusicAlbum> getAlbum() {
        SQLDAO sqldao = new SQLDAO();

        List<MusicAlbum> musicAlbums = sqldao.getMusicAlbums();
        return musicAlbums;
    }
}
