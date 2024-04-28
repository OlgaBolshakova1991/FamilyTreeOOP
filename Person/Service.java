package Person;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable{
    private int idPerson;
    FamilyTree<Person> family;

    public Service() {
        family = new FamilyTree<>();
    }

    public void addPerson(String name, LocalDate dob, LocalDate dod, Gender gender){
        Person person = new Person(idPerson++, name, dob, dod, gender);
        family.addPerson(person);
    }

    public String getPersonInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");

        for (Person person: family){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        family.sortByName();
    }

    public void sortByAge(){
        family.sortByAge();
    }
    public Person findFamilyMemberByName(String name) {
        for (Person person : family.personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}