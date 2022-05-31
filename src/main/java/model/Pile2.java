package model;

import exception.ContentIsEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@EqualsAndHashCode
public class Pile2<T> {

    private Maillon<T> currentMaillon;


    public void add(T object) {


        currentMaillon = new Maillon<>(object, currentMaillon);

    }


    public void remove() {

        if (currentMaillon == null) {
            throw new ContentIsEmpty("Empty!!");
        }

        currentMaillon = currentMaillon.getPrevious();

    }

    public void clear() {


        while (currentMaillon != null) {

            currentMaillon = currentMaillon.getPrevious();

        }

    }


    @Override
    public String toString() {

        final StringBuilder output = new StringBuilder();
        Maillon<T> maillon = currentMaillon;

        while (maillon != null) {
            output.append(maillon.getValue().toString()).append(", ");
            maillon = maillon.getPrevious();
        }

        return output.substring(0, output.length() - 2);

    }
}
