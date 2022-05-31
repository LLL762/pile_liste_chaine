package model;

import exception.ContentIsEmpty;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 30/05/2022.
 *
 * @author Laurent Lamiral
 */


public class Pile<T> {


    private final ArrayList<T> content = new ArrayList<>();


    public void add(T object) {
        content.add(object);
    }

    public void addAll(Collection<T> objects) {
        content.addAll(objects);
    }


    public void remove() {

        if (content.isEmpty()) {
            throw new ContentIsEmpty("!!!!!!");
        }
        content.remove(content.size() - 1);
    }

    public void clear() {
        content.clear();
    }

    public ArrayList<T> getContent() {

        return new ArrayList<>(content);

    }
}
