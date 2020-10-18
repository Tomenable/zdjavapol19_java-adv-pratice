package pl.sda.netlix;

import pl.sda.netlix.model.Genre;
import pl.sda.netlix.model.Movie;
import pl.sda.netlix.ui.console.ConsoleUI;

import java.time.LocalDate;

public class NetlixRunner {

    public static void main(String[] args) {
        ConsoleUI.INSTANCE.printCatalogue();    //wyswietl ostatni zapisany catalogue
        //todo: refactor, only for test puropses
        Movie m3 = Movie.builder()
                .title("Instant family")
                .genre(Genre.DRAMA)
                .releaseDate(LocalDate.of(2018, 11, 16))
                .desc("Amerykański komediodramat familijny z 2018 roku, w którym występują Mark Wahlberg i Rose Byrne jako rodzice adoptujący troje małych dzieci.")
                .build();
        ConsoleUI.INSTANCE.addMovie(m3);    //zmodyfikuj catalogue dodajac nowa pozycje

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Shutdown hook fired.");
                ConsoleUI.INSTANCE.persistCatalogueOnExit();    //zapisz przy wylaczeniu programu
            }
        }, "Shutdown-thread"));
    }

}
