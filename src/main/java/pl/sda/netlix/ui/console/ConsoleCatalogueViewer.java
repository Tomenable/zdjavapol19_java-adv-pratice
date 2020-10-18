package pl.sda.netlix.ui.console;

import de.vandermeer.asciitable.AsciiTable;
import pl.sda.netlix.model.Movie;
import pl.sda.netlix.repository.InMemoryMoviesRepository;
import pl.sda.netlix.repository.MoviesRepository;

import java.time.format.DateTimeFormatter;

public enum ConsoleCatalogueViewer {

    INSTANCE(new InMemoryMoviesRepository());

    private final MoviesRepository moviesRepo;
    private final DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    ConsoleCatalogueViewer(MoviesRepository moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    public void printCatalogue() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Title", "Genre", "Release date", "Description");
        for(Movie m : moviesRepo.findAll()) {
            at.addRule();
            at.addRow(m.getTitle(), m.getGenre().name(), m.getReleaseDate().format(europeanDateFormatter), m.getDesc());
        }
        at.addRule();
        System.out.println(at.render());
    }

}
