package pl.sda.zdjavapol19.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class VisitTest {

    @Test
    public void cannot_calc_total_expense() {
        //given
        Customer c = new Customer("PW", MemberType.PREMIUM);
        Visit v = new Visit(c, LocalDateTime.now());

        //when
        Assertions.assertThrows(Visit.TotalExpenseCalcEx.class,
                () -> v.calcTotalExpense());
    }

    @Test
    public void calcs_total_expense_with_membership() {
        //given
        Customer c = new Customer("PW", MemberType.PREMIUM);
        Visit v = new Visit(c, LocalDateTime.now());

        //when
        v.setServiceExpense(100);
        double totalExpense = v.calcTotalExpense();

        //then
        org.assertj.core.api.Assertions.assertThat(totalExpense).isEqualTo(80);
    }

}
