package pl.sda.zdjavapol19.enums;

import java.util.Scanner;

/*
2. Przebieg rozgrywki:
	a. Wyswietl wiadomosc przywitalna "Papier - Kamien - Nozyce"
	b. Wybor gestu przez gracza
	c. Losowanie gestu przez komputer
	d. Porownanie gestow
	e. Wyswietlenie wyniku

3. Scanner sc = new Scanner(System.in);
	sout("Wybierz swoj gest: 0 - papier; 1 - kamien; 2 - nozyce")
	int noin = sc.nextInt();
	Gesture userGesture = map(noin);

4. Mapowanie int -> Gesture
	public Gesture map(int no) {
		return Gesture.values[no];
	}

	Function<Integer, Gesture>
	(no) -> return Gesture.values[no]

5. Losowanie przez komputer:
	Gesture pcGesture = map((int)(Math.random() * 3)); //Math.random => <0, 1)

6. GameResult gr = userGesture.play(pcGesture);
 */
public class PaperRockScissorsGame {

    public static void main(String[] args) {
        System.out.println("Witaj w grze Papier - Kamien - Nozyce !!!");
        boolean nextTurn = false;
        do {
            System.out.println("Wybierz gest:\n0 - kamien\n1 - nozyce\n2 - papier");

            Scanner sc = new Scanner(System.in);
            int noin = sc.nextInt();

            Gesture userGesture = map(noin);

            Gesture pcGesture = map((int)(Math.random() * 3));
            System.out.printf("Twoj gest: %s; gest komputera: %s\n",
                    userGesture.name(), pcGesture.name());

            GameResult gr = userGesture.play(pcGesture);
            System.out.println("Twoj wynik: " + gr.name());

            System.out.println("Czy grasz jeszcze raz? Wprowadz 'y' aby grac dalej lub inny znak aby zakonczyc.");
            sc.nextLine();
            nextTurn = sc.nextLine().charAt(0) == 'y';
        }
        while(nextTurn);
    }

    private static Gesture map(int input) {
        return Gesture.values()[input];
    }

}
