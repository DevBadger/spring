package model
import org.pojomatic.Pojomatic

/**
 * Created by Badger on 1/2/18.
 */
abstract class Model {
    @Override
    String toString() { Pojomatic.toString(this)}

    @Override
    int hashCode() { Pojomatic.hashCode(this)}

    @Override
    boolean equals(Object other) { Pojomatic.equals(this, other)}
}
