package me.savushkin.wst.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class MusicAlbum {
    private Long id;

    private String title;
    private String artist;
    private Long releaseYear;
    private String genre;
    private Long trackCount;
}
