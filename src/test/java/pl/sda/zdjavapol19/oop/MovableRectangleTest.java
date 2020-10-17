package pl.sda.zdjavapol19.oop;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

//TAD - Test Assisted Development - pomaga w implementacji klasy
//TDD - pomaga w DESIGNIE klasy
public class MovableRectangleTest {

    @Test
    public void is_valid_rectangle() {
        //given
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(3, 0);
        Point2D c = new Point2D(3, -3);
        Point2D d = new Point2D(0, -3);

        //when
        MovableRectangle mr = new MovableRectangle(a, b, c, d);

        //then
        assertThat(mr.points[0]).isEqualTo(a);
        assertThat(mr.points[1]).isEqualTo(b);
        assertThat(mr.points[2]).isEqualTo(c);
        assertThat(mr.points[3]).isEqualTo(d);
    }

    @Test
    public void is_not_valid_rectangle() {
        //given
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(3, 0);
        Point2D c = new Point2D(3, -3);
        Point2D d = new Point2D(0, 6);

        //when
        Exception ex = assertThrows(
                MovableRectangle.RectangleConstructionException.class,
                () -> new MovableRectangle(a, b, c, d)
        );

        //then
        assertEquals("Cannot construct rectangle out of given points", ex.getMessage());
    }

    @Test
    public void rect_moves_right_with_speed() {
        //given
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(3, 0);
        Point2D c = new Point2D(3, -3);
        Point2D d = new Point2D(0, -3);

        MovableRectangle mr = new MovableRectangle(a, b, c, d, 5, 10);

        //when
        mr.moveRight();

        //then
        assertThat(mr.points[0].x).isEqualTo(5);
        assertThat(mr.points[1].x).isEqualTo(8);
        assertThat(mr.points[2].x).isEqualTo(8);
        assertThat(mr.points[3].x).isEqualTo(5);
    }

    @Test
    public void cannot_manipulate_rect_points_positions() {
        //given
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(3, 0);
        Point2D c = new Point2D(3, -3);
        Point2D d = new Point2D(0, -3);

        MovableRectangle mr = new MovableRectangle(a, b, c, d, 5, 10);

        assertThat(mr.points[0]).isEqualTo(a);
        assertThat(mr.points[1]).isEqualTo(b);
        assertThat(mr.points[2]).isEqualTo(c);
        assertThat(mr.points[3]).isEqualTo(d);

        //when
        a.setXY(5, 5);  //zakladamy, ze to nie powinno zmodyfikowac wsp pkt tworzacego prostokat

        //then
        assertThat(mr.isValid(mr.points[0], mr.points[1], mr.points[2], mr.points[3]))
            .isTrue();
    }

}
