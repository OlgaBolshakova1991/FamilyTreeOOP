package Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E> {
    public List<E> personList;

    public FamilyTree() {
        personList = new ArrayList<>();
    }

    public void addPerson(E person){
        personList.add(person);
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(personList);
    }

    public void sortByName(){
        personList.sort(new PersonComparatorByName<>());
    }

    public void sortByAge(){
        personList.sort(new PersonComparatorByAge<>());
    }
}