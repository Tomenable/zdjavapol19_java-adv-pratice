package pl.sda.zdjavapol19.throwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordValidatorRunner {

    public static void main(String[] args) {
        List<Validator> validators = new ArrayList<>();
        validators.add(new LengthValidator(8));
        validators.add(new ContainsDigitsValidator());
        validators.add(new ContainsLargeLettersValidator());

        System.out.println("Podaj haslo, pamietajac o nastepujacych warunkach: ");
        //wypisac warunki - dostarczne przez validator
        validators.stream()
                .forEach(v -> System.out.println(v.getReq()));

        boolean isPswdValid = true;
        Scanner sc = new Scanner(System.in);
        String pswd = sc.nextLine();

        do {
            //uruchamiamy kolejne walidatory
            try {
                for(Validator v : validators)
                    v.isValid(pswd);
                isPswdValid = true; //jesli przeszly wszystkie validatory, ustawiam ze haslo jest poprawne
            }
            catch(ValidationException vex) {
                isPswdValid = false;
                System.out.println(vex.getMessage());
                System.out.println("Podaj nowe haslo.");
                pswd = sc.nextLine();
            }
        }
        while(!isPswdValid);

        System.out.println("Twoje nowe haslo to: " + pswd);

    }

}
