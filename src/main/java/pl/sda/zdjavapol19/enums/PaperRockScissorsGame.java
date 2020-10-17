package pl.sda.zdjavapol19.enums;

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

    }

}
