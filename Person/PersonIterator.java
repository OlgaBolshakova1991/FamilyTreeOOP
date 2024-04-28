package Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
    public int index;
    public List<E> personList;

    public PersonIterator(List<E> personList) {
        this.personList = personList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public E next() {
        return personList.get(index++);
    }
    
}