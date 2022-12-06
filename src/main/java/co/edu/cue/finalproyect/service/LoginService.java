package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Person;

import java.util.ArrayList;

public interface LoginService {
    Boolean login(String userRegis, String passwordRegis, ArrayList<Person> arrayList);
    Boolean comprobationPassword(String pass, String pass2);
    Boolean comprobationAdmi(ArrayList<Person> arrayList);

}
