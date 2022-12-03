package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.Model.Person;
import co.edu.cue.finalproyect.service.CarService;
import co.edu.cue.finalproyect.service.LoginService;
import co.edu.cue.finalproyect.service.PersonService;

import java.util.ArrayList;

public class RentCarServiceImpl {
    private final CarService carService;
    private final LoginService loginService;
    private final PersonService personService;



    public RentCarServiceImpl() {

        this.carService = new CarServiceImpl();
        this.loginService = (LoginService) new LoginServiceImpl();
        this.personService = new PersonServiceImpl();
    }

    public PersonService getPersonService() {
        return personService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public CarService getCarService() {
        return carService;
    }

}
