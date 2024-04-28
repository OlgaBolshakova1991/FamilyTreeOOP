package SaveAndLoad;

import java.io.IOException;

import Person.*;

public interface Writable{
    void saveFamilyTreeToFile(String filename, Service service) throws IOException;
    Service loadFamilyTreeFromFile(String filename) throws IOException, ClassNotFoundException;
}