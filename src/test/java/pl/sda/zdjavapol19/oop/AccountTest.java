package pl.sda.zdjavapol19.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    //notacja z Python; 300 linijek kodu w Java = 100 linijkom w Pythonie
    @Test
    public void credit_500_to_empty_account() {
        //given
        Account a1 = new Account("1", "a");
        //when
        a1.debit(500);
        //then
        Assertions.assertThat(a1.getBalance()).isEqualTo(500);
    }

    @Test   //+expected exception
    public void cannot_debit_from_empty_account() {

    }

}
