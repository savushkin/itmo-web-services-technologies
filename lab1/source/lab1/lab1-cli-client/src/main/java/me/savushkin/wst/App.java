package me.savushkin.wst;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static void print(List<MusicAlbum> musicAlbums) {
        musicAlbums.forEach(musicAlbum -> System.out.printf(
                "ID: %d,%n" +
                        "Альбом: %s,%n" +
                        "Исполнитель: %s,%n" +
                        "Год выпуска: %d,%n" +
                        "Жанр: %s,%n" +
                        "Количество записей: %d.%n%n",
                musicAlbum.getId(),
                musicAlbum.getTitle(),
                musicAlbum.getArtist(),
                musicAlbum.getReleaseYear(),
                musicAlbum.getGenre(),
                musicAlbum.getTrackCount()));
        System.out.printf("Всего: %d.%n---------------------------%n%n", musicAlbums.size());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://0.0.0.0:8080/music-album-service?wsdl");
            MusicAlbumService musicAlbumService = new MusicAlbumService(url);
            System.out.printf("Все альбомы:%n%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());
            System.out.printf("Поиск без параметров:%n%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    null,
                    null,
                    null));
            System.out.printf("Поиск по жанру \"Blues\":%n%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    null,
                    "Blues",
                    null));
            System.out.printf("Поиск по году \"1969\":%n%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    1969L,
                    null,
                    null));
            System.out.printf("Поиск по году \"1969\" и жанру \"Blues\":%n%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    1969L,
                    "Blues",
                    null));

        } catch (MalformedURLException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
