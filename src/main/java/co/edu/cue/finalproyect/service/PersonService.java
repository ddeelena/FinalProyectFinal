package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.Person;

import java.util.ArrayList;

public interface PersonService {
    ArrayList<Person> getArrayList();
    void init ();
    void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location);
    void editClient(String name, String gender,String cellphone, String email, String password);
    Client getClient();
    void setClient(Client client);
    void identi(String pass);
}
