package pl.sda.netlix.repository;

import com.google.common.base.Preconditions;
import pl.sda.netlix.exception.MovieNotFoundEx;
import pl.sda.netlix.model.Genre;
import pl.sda.netlix.model.Movie;
import pl.sda.zdjavapol19.maps.WordsOccurenceInFileRunner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileMoviesRepository implements MoviesRepository {

    private final List<Movie> movies;
    private final String catalogueFileName;

    public FileMoviesRepository(String catalogueFileName) {
        this.catalogueFileName = catalogueFileName;
        this.movies = load();
    }

    @Override
    public List<Movie> findAll() {
        return movies;
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

    private List<Movie> load() {
        List<Movie> movies = new ArrayList<>();

        InputStream is = FileMoviesRepository.class.getClassLoader().getResourceAsStream(catalogueFileName);

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                movies.add(mapToMovie(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private Movie mapToMovie(String line) {
        String[] splitted = line.split("\\|");
        return Movie.builder()
                .title(splitted[0])
                .genre(Genre.valueOf(splitted[1]))
                .releaseDate(mapToLD(splitted[2]))
                .desc(splitted[3])
                .build();
    }

    private LocalDate mapToLD(String entry) {
        List<Integer> values = Arrays.stream(entry.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return LocalDate.of(values.get(0), values.get(1), values.get(2));
    }

    @Override
    public void persistCatalogue() {
        StringBuilder strb = new StringBuilder();
        for(Movie m : movies)
            strb.append(mapToString(m));

        try {
            PrintWriter writer = new PrintWriter(new File(FileMoviesRepository.class.getClassLoader().getResource(catalogueFileName).getPath()));
            writer.write(strb.toString());
        }
        catch(FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    private String mapToString(Movie movie) {
        StringBuilder strb = new StringBuilder();
        strb.append(movie.getTitle());
        strb.append("|");
        strb.append(movie.getGenre().name());
        strb.append("|");
        strb.append(mapLDToString(movie.getReleaseDate()));
        strb.append("|");
        strb.append(movie.getDesc());
        strb.append("\n");
        return strb.toString();
    }

    private String mapLDToString(LocalDate ld) {
        StringBuilder strb = new StringBuilder();
        strb.append(ld.getYear());
        strb.append(",");
        strb.append(ld.getMonth());
        strb.append(",");
        strb.append(ld.getDayOfMonth());
        return strb.toString();
    }

    @Override
    public void add(Movie m) {
        movies.add(m);
        System.out.println("Add new movie to catalogue: " + m);
    }
}
