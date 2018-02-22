package me.savushkin.wst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDAO {

    public List<MusicAlbum> getMusicAlbums() {
        List<MusicAlbum> musicAlbums = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from music_albums");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id"),
                        releaseYear = resultSet.getLong("releaseYear"),
                        trackCount = resultSet.getLong("trackCount");

                String title = resultSet.getString("title"),
                        artist = resultSet.getString("artist"),
                        genre = resultSet.getString("genre");

                musicAlbums.add(new MusicAlbum(id, title, artist, releaseYear, genre, trackCount));
            }
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return musicAlbums;
    }
}
