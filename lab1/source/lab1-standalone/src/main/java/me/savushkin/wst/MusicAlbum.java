package me.savushkin.wst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicAlbum {
    private Long id;

    private String title;
    private String artist;
    private Long releaseYear;
    private String genre;
    private Long trackCount;
}
