package model;

import exception.ContentIsEmpty;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */
class PileTest {


    @Test
    void pile_should_be_immutable() {

        final Pile<String> pile = new Pile<>();

        pile.getContent().add("toto");


        assertThat(pile.getContent()).isEmpty();

    }


    @Test
    void pile_should_maintain_order() {

        final Pile<JButton> pile = new Pile<>();

        final JButton[] expectedResult = {
                new JButton("riri"),
                new JButton("fifi"),
                new JButton("loulou")};

        for (JButton button : expectedResult) {
            pile.add(button);
        }

        assertThat(pile.getContent()).containsExactly(expectedResult);

    }

    @Test
    void pile_remove_should_remove_last_element() {

        final Pile<Double> pile = new Pile<>();
        final Double[] doubles = {1.0, -99.5, 37.0, 145d};
        final Double[] expectedResult = {1.0, -99.5, 37.0};

        pile.addAll(Arrays.stream(doubles).toList());
        pile.remove();

        assertThat(pile.getContent()).containsExactly(expectedResult);

    }


    @Test
    void pile_remove_but_content_is_empty() {

        final Pile<Object> pile = new Pile<>();

        assertThatThrownBy(pile::remove).isInstanceOf(ContentIsEmpty.class)
                .hasMessage("!!!!!!");


    }

    @Test
    void pile_clear() {

        final Pile<RuntimeException> pile = new Pile<>();

        pile.addAll(List.of(new ContentIsEmpty(), new RuntimeException()));
        pile.clear();


        assertThat(pile.getContent()).isEmpty();


    }


}