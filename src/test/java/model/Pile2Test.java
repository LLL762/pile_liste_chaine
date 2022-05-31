package model;

import exception.ContentIsEmpty;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */
class Pile2Test {


    @Test
    void test_add() {


        Pile2<String> pile2 = new Pile2<>();


        final String expectedResult = "fifi, riri";


        pile2.add("riri");

        assertThat(pile2.getCurrentMaillon().getValue()).isEqualTo("riri");

        pile2.add("fifi");

        assertThat(pile2.getCurrentMaillon().getValue()).isEqualTo("fifi");

        assertThat(pile2).hasToString(expectedResult);

    }

    @Test
    void test_remove() {

        Pile2<Integer> pile2 = new Pile2<>();
        final String expectedResult = "-127, -127, 256";

        pile2.add(256);
        pile2.add(-127);
        pile2.add(-127);
        pile2.add(24);

        pile2.remove();

        assertThat(pile2.getCurrentMaillon().getValue()).isEqualTo(-127);
        assertThat(pile2).hasToString(expectedResult);

    }

    @Test
    void test_remove_but_no_maillon() {

        Pile2<Integer> pile2 = new Pile2<>();

        pile2.add(256);
        pile2.remove();

        assertThatThrownBy(pile2::remove).isInstanceOf(ContentIsEmpty.class)
                .hasMessage("Empty!!");


    }


    @Test
    void test_clear() {

        Pile2<JButton> pile2 = new Pile2<>();

        pile2.add(new JButton());
        pile2.add(new JButton());
        pile2.add(new JButton());
        pile2.add(new JButton());
        pile2.clear();


        assertThat(pile2.getCurrentMaillon()).isNull();


    }

    @Test
    void test_clear_but_empty() {

        Pile2<JButton> pile2 = new Pile2<>();

        pile2.clear();


        assertThat(pile2.getCurrentMaillon()).isNull();


    }


}