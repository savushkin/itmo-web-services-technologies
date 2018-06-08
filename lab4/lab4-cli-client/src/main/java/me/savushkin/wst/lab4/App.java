package me.savushkin.wst.lab4;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import me.savushkin.wst.common.MusicAlbum;
import me.savushkin.wst.common.MusicAlbumFilter;

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

        System.out.printf("Поиск по жанру \"Blues\":%n");
        response = webResource
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, new MusicAlbumFilter(
                        null,
                        null,
                        null,
                        "Blues",
                        null
                ));
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));

        System.out.printf("Поиск по году \"1969\":%n");
        response = webResource
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, new MusicAlbumFilter(
                        null,
                        null,
                        1969L,
                        null,
                        null
                ));
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));

        System.out.printf("Поиск по году \"1969\" или жанру \"Blues\":%n");
        response = webResource
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, new MusicAlbumFilter(
                        null,
                        null,
                        1969L,
                        "Blues",
                        null
                ));
        System.out.printf("response code - %d%n", response.getStatus());
        print(response.getEntity(type));
    }
}
