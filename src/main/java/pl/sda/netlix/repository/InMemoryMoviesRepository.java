package pl.sda.netlix.repository;

import com.google.common.base.Preconditions;
import pl.sda.netlix.exception.MovieNotFoundEx;
import pl.sda.netlix.model.Genre;
import pl.sda.netlix.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryMoviesRepository implements MoviesRepository {

    private List<Movie> movies;

    public InMemoryMoviesRepository(List<Movie> movies) {
        this.movies = movies;
    }

    public InMemoryMoviesRepository() {
        this.movies = new ArrayList<>();

        Movie m1 = Movie.builder()
                .title("Ogniem i mieczem")
                .genre(Genre.HISTORICAL)
                .releaseDate(LocalDate.of(1999, 2, 8))
                .desc("Polski film historyczny z 1999 roku, w reżyserii Jerzego Hoffmana, na podstawie powieści Henryka Sienkiewicza pod tym samym tytułem.")
                .build();
        Movie m2 = Movie.builder()
                .title("Avatar")
                .genre(Genre.SCI_FI)
                .releaseDate(LocalDate.of(2009, 12, 25))
                .desc("Amerykański film science fiction z 2009, wyreżyserowany, napisany oraz wyprodukowany przez Jamesa Camerona. Produkcja została wykonana przy użyciu przełomowych technik filmowych.")
                .build();
        Movie m3 = Movie.builder()
                .title("Instant family")
                .genre(Genre.DRAMA)
                .releaseDate(LocalDate.of(2018, 11, 16))
                .desc("Amerykański komediodramat familijny z 2018 roku, w którym występują Mark Wahlberg i Rose Byrne jako rodzice adoptujący troje małych dzieci.")
                .build();

        this.movies.add(m1);
        this.movies.add(m2);
        this.movies.add(m3);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies); //aby zachowac enkapsulacje, zwracaj kopie zlozonych obiektow, np List
    }

    /**
     * This method searches persistence storage for movie with given title.
     * If not found, throws MovieNotFoundEx (RuntimeException).
     *
     *
     * @param title cannot be null (validated, throws InvalidArgumentException)
     * @return
     */
    @Override
    public Movie findByTitle(String title) {
        Preconditions.checkNotNull(title);  //jesli title == null metoda wyrzuci RuntimeException -> InvalidArgumentException
        Optional<Movie> movieOptional = movies.stream()
                                    .filter(m -> title.equals(m.getTitle()))
                                    .findFirst();
        if(movieOptional.isPresent()) {
            return movieOptional.get();
        }
        else {
            throw new MovieNotFoundEx(title);
        }
    }

    @Override
    public void persistCatalogue() {
        System.out.println("InMemory repo could not be persisted");
    }

    @Override
    public void add(Movie m) {
        System.err.println("Not implemented!");
    }
}
