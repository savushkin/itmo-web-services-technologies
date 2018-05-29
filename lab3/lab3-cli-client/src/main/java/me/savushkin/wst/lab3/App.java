package me.savushkin.wst.lab3;

import java.net.URL;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void print(List<MusicAlbum> musicAlbums) {
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

            Long id = -1L;
            id = Long.parseLong(musicAlbumService.getMusicAlbumWebServicePort().createAlbum(
                    "Title-1", "Artist-1", 1942L, "Folk", 42L));
            System.out.printf("Запись номер %d создана%n", id);

            System.out.printf("Все альбомы:%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());

            Integer count = 0;
            count = Integer.parseInt(musicAlbumService.getMusicAlbumWebServicePort().updateAlbum(
                    id, "Title-2", "Artist-2", 1943L, "Rock", 44L));
            System.out.printf("%d запись обновлена%n", count);

            System.out.printf("Все альбомы:%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());

            count = Integer.parseInt(musicAlbumService.getMusicAlbumWebServicePort().deleteAlbum(id));
            System.out.printf("%d запись удалена%n", count);

            System.out.printf("Все альбомы:%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());

            String response = musicAlbumService.getMusicAlbumWebServicePort().deleteAlbum(-43L);
            count = Integer.parseInt(response);

            System.out.printf("Все альбомы:%n");
            print(musicAlbumService.getMusicAlbumWebServicePort().getAlbums());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
