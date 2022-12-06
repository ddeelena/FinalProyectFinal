package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Detail;

import java.util.ArrayList;

public interface LoanService {
    void carSelect(Car car);
    void createLoan(String debtorName, String dateLoan, String deliveryLoan, String car, ArrayList<Detail> listDetail);
}
