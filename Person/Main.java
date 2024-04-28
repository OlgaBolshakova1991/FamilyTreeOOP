package Person;

import java.io.IOException;
import java.time.LocalDate;

import SaveAndLoad.FileHandler;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.addPerson("Иван", LocalDate.of(2005, 3, 15), null, Gender.Male);
        service.addPerson("Петр", LocalDate.of(1975, 8, 20), null, Gender.Male);
        service.addPerson("Анна",  LocalDate.of(1980, 10, 10), null, Gender.Female);
        service.addPerson("Елизавета", LocalDate.of(1952, 11, 10), LocalDate.of(2020, 4,4), Gender.Female);
        service.addPerson("Игорь", LocalDate.of(1947, 8, 28), LocalDate.of(2020, 1,11), Gender.Male);

        System.out.println(service.getPersonInfo());
        service.sortByName();
        System.out.println(service.getPersonInfo());
        service.sortByAge();
        System.out.println(service.getPersonInfo());
    

        Person foundPerson = service.findFamilyMemberByName("");
        if (foundPerson != null) {
            System.out.println("Найден: " + foundPerson.getName());
            System.out.println("Дата рождения: " + foundPerson.getDob()); 
            System.out.println("Дата смерти: " + foundPerson.getDod());
            System.out.println("Возраст: " + foundPerson.getAge());
            System.out.println("Пол: " + foundPerson.getGender());
        } 
        else {
            System.out.println("Такого члена семьи нет");
        }

        // Сохранение семейного дерева в файл
        FileHandler fileHandler = new FileHandler();
        String filename = "person.txt";
        try {
            fileHandler.saveFamilyTreeToFile(filename, service);
            System.out.println("Семейное дерево успешно сохранено в файл " + filename);
        } 
        catch (IOException e) {
            System.out.println("Ошибка при сохранении семейного дерева в файл: " + e.getMessage());
        }

        // Загрузка семейного дерева из файла
        Service loadedService = null;
        try {
            loadedService = fileHandler.loadFamilyTreeFromFile(filename);
            System.out.println("Семейное дерево успешно загружено из файла " + filename);

            System.out.println("Загруженное семейное дерево содержит " +  loadedService.family.personList.size()+ " членов семьи.");
        } 
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке семейного дерева из файла: " + e.getMessage());
        }        
    }    
}
