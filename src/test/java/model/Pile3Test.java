package model;

import exception.ContentIsEmpty;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 31/05/2022.
 *
 * @author Laurent Lamiral
 */
class Pile3Test {

    @Test
    void test_add() {

        Pile3<String> pile3 = new Pile3<>();


        final String expectedResult = "fifi, riri";


        pile3.add("riri");

        assertThat(pile3.getCurrentMaillon().getValue()).isEqualTo("riri");

        pile3.add("fifi");

        assertThat(pile3.getCurrentMaillon().getValue()).isEqualTo("fifi");
        assertThat(pile3.getCurrentMaillon().getPrevious().getValue()).isEqualTo("riri");
        assertThat(pile3.getCurrentMaillon().getValue()).isEqualTo("fifi");

        assertThat(pile3).hasToString(expectedResult);

    }

    @Test
    void test_remove() {

        Pile3<Integer> pile3 = new Pile3<>();
        final String expectedResult = "-127, -127, 256";

        pile3.add(256);
        pile3.add(-127);
        pile3.add(-127);
        pile3.add(24);

        pile3.remove();

        assertThat(pile3.getCurrentMaillon().getValue()).isEqualTo(-127);
        assertThat(pile3.getCurrentMaillon().getPrevious().getNext()).isEqualTo(pile3.getCurrentMaillon());
        assertThat(pile3.getCurrentMaillon().getNext()).isNull();
        assertThat(pile3).hasToString(expectedResult);

    }

    @Test
    void test_remove_but_no_maillon() {

        Pile3<Integer> pile3 = new Pile3<>();

        pile3.add(256);
        pile3.remove();

        assertThatThrownBy(pile3::remove).isInstanceOf(ContentIsEmpty.class)
                .hasMessage("Empty!!");


    }


    @Test
    void test_clear() {

        Pile3<JButton> pile3 = new Pile3<>();

        pile3.add(new JButton());
        pile3.add(new JButton());
        pile3.add(new JButton());
        pile3.add(new JButton());
        pile3.clear();


        assertThat(pile3.getCurrentMaillon()).isNull();


    }

    @Test
    void test_clear_but_empty() {

        Pile3<JButton> pile3 = new Pile3<>();

        pile3.clear();


        assertThat(pile3.getCurrentMaillon()).isNull();


    }

    @Test
    void reverse_to_string() {

        Pile3<String> pile3 = new Pile3<>();

        final String expectedResult = "riri, fifi, loulou";

        pile3.add("riri");
        pile3.add("fifi");
        pile3.add("loulou");


        assertThat(pile3.reversetoString()).isEqualTo(expectedResult);


    }


}