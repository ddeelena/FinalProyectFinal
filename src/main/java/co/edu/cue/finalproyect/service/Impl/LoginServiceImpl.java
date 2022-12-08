package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.Person;
import co.edu.cue.finalproyect.service.LoginService;

import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {
    ArrayList<Person> arrayList = new ArrayList<>();

    // @Override
    public Boolean login(String userRegis, String passwordRegis, ArrayList<Person> arrayList){
        this.arrayList = arrayList;
        boolean pass = validatePass(passwordRegis);
        boolean us = validateUser(userRegis);
        System.out.println(pass +"///"+ us);
        return (pass == true && us == true) ? true : false;
    }
    public Boolean validatePass(String passwordRegis){
        for (Person person:arrayList) {
            System.out.println(person.getPassword());
            return person.getPassword().equals(passwordRegis) ? true: false;
        }
        return false;
    }
    public Boolean validateUser(String userRegis){
        for (Person person:arrayList) {
            System.out.println(person.getUser());
            return  person.getUser().equals(userRegis) ? true : false;
        }
        return false;
    }

    public Boolean comprobationPassword(String pass, String pass2){
        return pass.equals(pass2) ? true : false;
    }
    public Boolean comprobationAdmi(ArrayList<Person> arrayList){
        for (Person per: arrayList){
            return per instanceof Client ? true : false;
        }
        return null;
    }

}
