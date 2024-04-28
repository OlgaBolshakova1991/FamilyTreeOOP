package Person;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.List;

public interface FamilyItem<E> extends Serializable{
    String getName();
    int getAge();
    LocalDate getDob();
    LocalDate getDod();
    Gender getGender();

}