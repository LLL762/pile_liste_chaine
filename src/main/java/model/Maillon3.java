package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 31/05/2022.
 *
 * @author Laurent Lamiral
 */


@AllArgsConstructor
@Data
public class Maillon3<T> {

    private final T value;
    private Maillon3<T> previous;
    private Maillon3<T> next;


    @Override
    public String toString() {
        return value.toString();
    }


}
