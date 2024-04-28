package Person;

import java.time.LocalDate;

public class Person implements Comparable<Person>, FamilyItem<Person>{
    private int id;
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;

    public Person(int id, String name, LocalDate dob,LocalDate dod,Gender gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Член семьи: " +
                "id= " + id +
                ", имя = " + name +
                ", возраст = " + getAge() +
                ", дата рождения = " + dob + 
                ", дата смерти  = " + dod +
                ", пол = " + gender;
    }


    @Override
    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }
    public LocalDate getDod() {
        return dod;
    }
    public Gender getGender() {
        return gender;
    }
    @Override
    public int getAge() {
        if (dod == null) {
            return getPeriod(dob, LocalDate.now());
        } else {
            return getPeriod(dob, dod);
        }
    }

    public int getPeriod(LocalDate dob, LocalDate dod) {
        return dob.until(dod).getYears();
    }


    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}