package me.savushkin.wst.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDAO {
    private Connection connection;

    public SQLDAO(Connection connection) {
        this.connection = connection;
    }

    private List<MusicAlbum> returnResultSetAsList(ResultSet resultSet) {
        List<MusicAlbum> musicAlbums = new ArrayList<>();
        try {
            while (resultSet.next())
                musicAlbums.add(new MusicAlbum(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("artist"),
                        resultSet.getLong("release_year"),
                        resultSet.getString("genre"),
                        resultSet.getLong("track_count")));
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return musicAlbums;
    }

    private void setStringValue(PreparedStatement statement, int index, String value) throws SQLException {
        if (value == null)
            statement.setNull(index, Types.VARCHAR);
        else
            statement.setString(index, value);
    }

    private void setLongValue(PreparedStatement statement, int index, Long value) throws SQLException {
        if (value == null)
            statement.setNull(index, Types.INTEGER);
        else
            statement.setLong(index, value);
    }

    public List<MusicAlbum> getMusicAlbums() {
        try {
            Statement statement = connection.createStatement();
            return returnResultSetAsList(statement.executeQuery("SELECT * FROM music_album"));
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return new ArrayList<>();
    }

    public List<MusicAlbum> findMusicAlbums(MusicAlbumFilter musicAlbumFilter) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM music_album WHERE title LIKE ? OR artist LIKE ? OR release_year = ? OR genre LIKE ? OR track_count = ?");

            setStringValue(preparedStatement, 1, musicAlbumFilter.getTitle());
            setStringValue(preparedStatement, 2, musicAlbumFilter.getArtist());
            setLongValue(preparedStatement, 3, musicAlbumFilter.getReleaseYear());
            setStringValue(preparedStatement, 4, musicAlbumFilter.getGenre());
            setLongValue(preparedStatement, 5, musicAlbumFilter.getTrackCount());
            return returnResultSetAsList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return new ArrayList<>();
    }

    public Long createMusicAlbum(MusicAlbum musicAlbum) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO music_album (title, artist, release_year, genre, track_count) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        setStringValue(preparedStatement, 1, musicAlbum.getTitle());
        setStringValue(preparedStatement, 2, musicAlbum.getArtist());
        setLongValue(preparedStatement, 3, musicAlbum.getReleaseYear());
        setStringValue(preparedStatement, 4, musicAlbum.getGenre());
        setLongValue(preparedStatement, 5, musicAlbum.getTrackCount());

        Long id = -1L;
        if (preparedStatement.executeUpdate() > 0) {
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
        }

        if (id != -1L) {
            return id;
        } else {
            throw new Exception("Ошибка при создании записи");
        }
    }

    public Integer updateMusicAlbum(MusicAlbum musicAlbum) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE music_album SET title = ?, artist = ?, release_year = ?, genre = ?, track_count = ? WHERE id = ?");

        setStringValue(preparedStatement, 1, musicAlbum.getTitle());
        setStringValue(preparedStatement, 2, musicAlbum.getArtist());
        setLongValue(preparedStatement, 3, musicAlbum.getReleaseYear());
        setStringValue(preparedStatement, 4, musicAlbum.getGenre());
        setLongValue(preparedStatement, 5, musicAlbum.getTrackCount());
        setLongValue(preparedStatement, 6, musicAlbum.getId());

        Integer count = preparedStatement.executeUpdate();
        if (count != 0) {
            return count;
        } else {
            throw new Exception("Ошибка при обновлении записи");
        }
    }

    public Integer deleteMusicAlbum(Long id) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM music_album WHERE id = ?");

        setLongValue(preparedStatement, 1, id);

        Integer count = preparedStatement.executeUpdate();
        if (count != 0) {
            return count;
        } else {
            throw new Exception("Ошибка при удалении записи");
        }
    }
}
