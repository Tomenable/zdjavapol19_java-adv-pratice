package pl.sda.zdjavapol19.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MovablePointTest {

    @Test
    public void mp_moves_up() {
        //given
        MovablePoint mp = new MovablePoint();
        //when
        mp.moveUp();
        //then
        assertThat(mp.x).isEqualTo(0);
        assertThat(mp.y).isEqualTo(1);
    }

    @Test
    public void mp_moves_left_speed_applied() {
        //given
        MovablePoint mp = new MovablePoint(0, 0, 5, 0);
        //when
        mp.moveLeft();
        //then
        assertThat(mp.x).isEqualTo(-5);
        assertThat(mp.y).isEqualTo(0);
    }

}
