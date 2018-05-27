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

    private void setStringFilterFiledValue(PreparedStatement statement, int index, String value) throws SQLException {
        if (value == null)
            statement.setNull(index, Types.VARCHAR);
        else
            statement.setString(index, value);
    }

    private void setLongFilterFiledValue(PreparedStatement statement, int index, Long value) throws SQLException {
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

            setStringFilterFiledValue(preparedStatement, 1, musicAlbumFilter.getTitle());
            setStringFilterFiledValue(preparedStatement, 2, musicAlbumFilter.getArtist());
            setLongFilterFiledValue(preparedStatement, 3, musicAlbumFilter.getReleaseYear());
            setStringFilterFiledValue(preparedStatement, 4, musicAlbumFilter.getGenre());
            setLongFilterFiledValue(preparedStatement, 5, musicAlbumFilter.getTrackCount());
            return returnResultSetAsList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return new ArrayList<>();
    }
}
