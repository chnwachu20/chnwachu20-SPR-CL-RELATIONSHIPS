package Lab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * This is an ORM entity for an Album. This entity has a many-to-one relationship with artists (many albums may be
 * created by one artist) and a one-to-many relationship with songs (one album may have many songs).
 */
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    // The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;

    private String title;

    /**
     * Many albums can be created by one artist.
     * This is a many-to-one relationship.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private Artist artist;

    /**
     * One album can have many songs.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
    }

    /**
     * A custom toString() is provided that avoids recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                '}';
    }
}




















