package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.service.CarService;

public class RentCarServiceImpl {
    private CarService carService;

    public RentCarServiceImpl() {
        this.carService = new CarServiceImpl();
    }

    public CarService getCarService() {
        return carService;
    }

}
