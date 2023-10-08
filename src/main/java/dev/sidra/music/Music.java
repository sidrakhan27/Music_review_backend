package dev.sidra.music;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "music")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    private String musicId;  // Change the type to String
    private String title;
    private String releaseDate;
    private String artist;
    private String genre;
    private String musicLink;
    private String album;
    private String coverImage;
    private List<String> backdrops;
    private List<String> reviewIds;

    // Define a single constructor
    public Music(String title, String releaseDate, String artist, String genre, String musicLink, String album, String coverImage, List<String> backdrops, List<String> reviewIds) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.genre = genre;
        this.musicLink = musicLink;
        this.album = album;
        this.coverImage = coverImage;
        this.backdrops = backdrops;
        this.reviewIds = reviewIds;
    }
}


