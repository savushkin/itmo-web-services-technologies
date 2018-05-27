package me.savushkin.wst.lab1;

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
        String separator = "---------------------------------------------------------------------------------------------------------------------------";
        System.out.println(separator);
        System.out.printf("| %5s | %30s | %30s | %11s | %10s | %18s |%n",
                "ID",
                "Альбом",
                "Исполнитель",
                "Год выпуска",
                "Жанр",
                "Количество записей");
        System.out.println(separator);
        musicAlbums.forEach(musicAlbum -> System.out.printf("| %5d | %30s | %30s | %11d | %10s | %18d |%n",
                musicAlbum.getId(),
                musicAlbum.getTitle(),
                musicAlbum.getArtist(),
                musicAlbum.getReleaseYear(),
                musicAlbum.getGenre(),
                musicAlbum.getTrackCount()));
        System.out.println(separator);
        System.out.printf("Всего: %d.%n%n", musicAlbums.size());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://0.0.0.0:8080/music-album-service?wsdl");
            MusicAlbumService musicAlbumService = new MusicAlbumService(url);
            System.out.printf("Все альбомы:%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());
            System.out.printf("Поиск по жанру \"Blues\":%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    null,
                    "Blues",
                    null));
            System.out.printf("Поиск по году \"1969\":%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().findAlbums(
                    null,
                    null,
                    1969L,
                    null,
                    null));
            System.out.printf("Поиск по году \"1969\" или жанру \"Blues\":%n");
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
