package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */
@AllArgsConstructor
@Data
public class Maillon<T> {


    private final T value;
    private Maillon<T> previous;

    @Override
    public String toString() {
        return value.toString();
    }
}
