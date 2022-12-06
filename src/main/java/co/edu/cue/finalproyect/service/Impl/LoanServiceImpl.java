package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Detail;
import co.edu.cue.finalproyect.model.Loan;
import co.edu.cue.finalproyect.service.LoanService;

import java.util.ArrayList;

public class LoanServiceImpl implements LoanService {
    ArrayList<Loan> loanList = new ArrayList<>();

    Car car = new Car();

    public void carSelect(Car car) {
        this.car = car;
    }

    public  void createLoan(String debtorName, String dateLoan, String deliveryLoan, String car, ArrayList<Detail> listDetail){
        Loan loan = new Loan(debtorName, dateLoan, deliveryLoan, car, listDetail);
        loanList.add(loan);
    }

}
