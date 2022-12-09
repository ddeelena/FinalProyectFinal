package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.*;
import co.edu.cue.finalproyect.service.LoanService;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoanServiceImpl implements LoanService {
    Loan loanselect = new Loan();
    LoanDTO loanDtoSelect = new LoanDTO();
    ArrayList<Loan> loanList = new ArrayList<>();
    LocalDate dateLoan;
    LocalDate deliveryLoan;

    public Loan getLoanselect() {
        return loanselect;
    }

    public LoanDTO getLoanDtoSelect() {
        return loanDtoSelect;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }

    public LocalDate getDateLoan() {
        return dateLoan;
    }

    public LocalDate getDeliveryLoan() {
        return deliveryLoan;
    }

    public void setDateLoan(LocalDate dateLoan) {
        this.dateLoan = dateLoan;
    }

    public void setDeliveryLoan(LocalDate deliveryLoan) {
        this.deliveryLoan = deliveryLoan;
    }

    public  void createLoan(Client debtorName, Car car, boolean chair, boolean porta, String placeCollected,
                            String plateDelivery, String typeCount, String countNumber){
        Detail detail = new Detail(car.getPrice(), chair,porta,placeCollected,placeCollected,dateLoan,deliveryLoan, typeCount,countNumber);
        Loan loan = new Loan(debtorName, car, detail);
        loanList.add(loan);
    }
    public void select(TableView<LoanDTO> tblLoan){
       loanDtoSelect = tblLoan.getSelectionModel().getSelectedItem();
       searchLoan();
    }
    public void searchLoan(){
        for (Loan ln: loanList) {
            if(ln.getDebtorName().getName().equals(loanDtoSelect.getNameUser()) && ln.getCar().getName().equals(loanDtoSelect.getCarName())){
                loanselect = ln;
            }
        }
    }
    public void eliminateLoan(TableView<LoanDTO> tblLoan,ObservableList<LoanDTO> observableList){
        if(loanselect != (null)){
            loanList.remove(loanselect);
            observableList.remove(loanDtoSelect);
            tblLoan.refresh();
        }
    }
    public List<LoanDTO> genereDTO(){
      return  loanList.stream()
              .map(l -> new LoanDTO(l.getCar().getPrice(),l.getCar().getPlate(),l.getDetail().getDateLoan(), l.getDetail().getDeliveryLoan(), l.getDebtorName().getName(),l.getCar().getName()))
              .collect(Collectors.toList());
    }

}
