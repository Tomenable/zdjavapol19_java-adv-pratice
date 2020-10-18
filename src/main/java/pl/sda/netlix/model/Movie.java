package pl.sda.netlix.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Movie {

    private final String title;
    private final Genre genre;
    private final LocalDate releaseDate;
    private final String desc;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", releaseDate=" + releaseDate +
                ", desc='" + desc + '\'' +
                '}';
    }
}
