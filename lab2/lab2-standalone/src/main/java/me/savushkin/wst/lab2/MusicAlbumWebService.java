package me.savushkin.wst.lab2;

import me.savushkin.wst.common.MusicAlbum;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "music-album-service")
public class MusicAlbumWebService extends me.savushkin.wst.lab1.MusicAlbumWebService {
    @WebMethod(operationName = "create-album")
    public String createAlbum(
            @WebParam(name = "title") String title,
            @WebParam(name = "artist") String artist,
            @WebParam(name = "releaseYear") Long releaseYear,
            @WebParam(name = "genre") String genre,
            @WebParam(name = "trackCount") Long trackCount
    ) {
        try {
            return String.valueOf(sqldao.createMusicAlbum(new MusicAlbum(
                    null,
                    title,
                    artist,
                    releaseYear,
                    genre,
                    trackCount
            )));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod(operationName = "update-album")
    public String updateAlbum(
            @WebParam(name = "id") Long id,
            @WebParam(name = "title") String title,
            @WebParam(name = "artist") String artist,
            @WebParam(name = "releaseYear") Long releaseYear,
            @WebParam(name = "genre") String genre,
            @WebParam(name = "trackCount") Long trackCount
    ) {
        try {
            return String.valueOf(sqldao.updateMusicAlbum(new MusicAlbum(
                    id,
                    title,
                    artist,
                    releaseYear,
                    genre,
                    trackCount
            )));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod(operationName = "delete-album")
    public String deleteAlbum(
            @WebParam(name = "id") Long id
    ) {
        try {
            return String.valueOf(sqldao.deleteMusicAlbum(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
