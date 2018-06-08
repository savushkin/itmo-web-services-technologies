package me.savushkin.wst.lab5;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import me.savushkin.wst.common.MusicAlbum;

import javax.ws.rs.core.MediaType;
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
        GenericType<List<MusicAlbum>> type = new GenericType<List<MusicAlbum>>() {
        };

        MusicAlbum album = new MusicAlbum();
        album.setTitle("Title-1");
        album.setArtist("Artist-1");
        album.setReleaseYear(1942L);
        album.setGenre("Folk");
        album.setTrackCount(42L);

        String url = "http://localhost:8080/rest/music-albums";
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response;

        System.out.printf("Все альбомы:%n");
        response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));

        Long id = -1L;
        try {
            response = webResource
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, album);
            id = Long.parseLong(response.getEntity(String.class));
            album.setId(id);
            System.out.printf("Запись номер %d создана%n", id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Все альбомы:%n");
        response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));

        try {
            album.setTitle("Title-2");
            album.setArtist("Artist-2");
            album.setReleaseYear(1943L);
            album.setGenre("Rock");
            album.setTrackCount(44L);
            response = webResource
                    .accept(MediaType.APPLICATION_JSON)
                    .put(ClientResponse.class, album);
            System.out.printf("%d запись обновлена%n",
                    Long.parseLong(response.getEntity(String.class)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Все альбомы:%n");
        response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));

        try {
            response = webResource
                    .path("/" + id)
                    .accept(MediaType.APPLICATION_JSON)
                    .delete(ClientResponse.class);
            System.out.printf("%d запись удалена%n",
                    Long.parseLong(response.getEntity(String.class)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Все альбомы:%n");
        response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));
    }
}
