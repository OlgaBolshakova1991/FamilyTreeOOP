package SaveAndLoad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Person.Service;

public class FileHandler implements Writable {

    @Override
    public void saveFamilyTreeToFile(String filename, Service service) throws IOException {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOut.writeObject(service);
        }
    }

    @Override
    public Service loadFamilyTreeFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filename))) {
            return (Service) objectIn.readObject();
        }
    }
}