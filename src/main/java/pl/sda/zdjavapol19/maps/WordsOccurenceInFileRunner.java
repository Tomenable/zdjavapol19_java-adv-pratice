package pl.sda.zdjavapol19.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/*
1. Utworzyc plik .txt - umiescic go w folderze 'resources'
2. Otworz plik uzywajac klasy Scanner i czytac linia po linii.

3. Oczyscic tekst z niechcianych znakow (np. interpunkcyjne). Dzieki temu 'kot,' nie bedzie liczone jako slowo.
String#replace(',', '');
Przeprowadzic dla znakow: " , .
4. Kazda linie tekstu podzielic na slowa - String#split(" ")
5. Umiescic slowo w mapie:
	a. Jesli slowo-klucz nie istnieje w mapie, dodac klucz (slowo) wraz z wartoscia - liczba wystapien: 1
	b. Jesli slowo-klucz istnieje w mapie, zaktualizowac liczbe wystapien slowa - liczba wystapien +1
6. Wyswietlic mape.

Cel: utworzyc mape slowo - liczba wystapien w tekscie
 */
public class WordsOccurenceInFileRunner {

    public static void main(String[] args) {
        InputStream is = WordsOccurenceInFileRunner.class.getClassLoader().getResourceAsStream("news.txt");
        Map<String, Integer> wordsOccurenceMap = new HashMap<>();

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = removeInterpunctionChars(line);
                for(String word : line.split(" ")) {
                    if(wordsOccurenceMap.containsKey(word)) {
                        wordsOccurenceMap.put(word, wordsOccurenceMap.get(word) + 1);
                    }
                    else {
                        wordsOccurenceMap.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(wordsOccurenceMap);
    }

    private static String removeInterpunctionChars(String input) {
        input = input.replace(",", "");
        input = input.replace(".", "");
        input = input.replace("\"", "");
        return input.toLowerCase();
    }

}
