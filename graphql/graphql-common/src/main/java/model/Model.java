package model;

import org.pojomatic.Pojomatic;

/**
 * Created by Badger on 1/2/18.
 */
public abstract class Model {
    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }

    @Override
    public int hashCode() {
        return Pojomatic.hashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return Pojomatic.equals(this, other);
    }

}
