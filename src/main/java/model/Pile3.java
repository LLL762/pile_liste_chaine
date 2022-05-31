package model;

import exception.ContentIsEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 31/05/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@EqualsAndHashCode
public class Pile3<T> {

    private Maillon3<T> currentMaillon;
    private Maillon3<T> firstMaillon;


    public void add(final T object) {

        final Maillon3<T> newMaillon = new Maillon3<>(object, currentMaillon, null);

        if (firstMaillon == null) {

            firstMaillon = newMaillon;

        } else {

            currentMaillon.setNext(newMaillon);
        }

        currentMaillon = newMaillon;

    }


    public void remove() {

        if (currentMaillon == null) {
            throw new ContentIsEmpty("Empty!!");
        }


        currentMaillon = currentMaillon.getPrevious();

        if (currentMaillon != null) {
            currentMaillon.setNext(null);
        }

    }

    public void clear() {


        while (currentMaillon != null) {

            currentMaillon = currentMaillon.getPrevious();

        }

    }


    public String reversetoString() {

        final StringBuilder output = new StringBuilder();
        Maillon3<T> maillon = firstMaillon;

        while (maillon != null) {
            output.append(maillon.getValue().toString()).append(", ");
            maillon = maillon.getNext();
        }

        return output.substring(0, output.length() - 2);


    }


    @Override
    public String toString() {

        final StringBuilder output = new StringBuilder();
        Maillon3<T> maillon = currentMaillon;

        while (maillon != null) {
            output.append(maillon.getValue().toString()).append(", ");
            maillon = maillon.getPrevious();
        }

        return output.substring(0, output.length() - 2);

    }
}
