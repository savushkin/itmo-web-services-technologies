package me.savushkin.wst.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicAlbumFilter {
    private String title;
    private String artist;
    private Long releaseYear;
    private String genre;
    private Long trackCount;
}
