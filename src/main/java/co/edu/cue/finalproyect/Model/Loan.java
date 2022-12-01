package co.edu.cue.finalproyect.Model;

import java.util.ArrayList;

public class Loan {
     private String debtorName;
     private String dateLoan;
     private String deliveryLoan;
     private String car;
     ArrayList<Detail> listDetail;

     public String getDebtorName() {
          return debtorName;
     }

     public void setDebtorName(String debtorName) {
          this.debtorName = debtorName;
     }

     public String getDateLoan() {
          return dateLoan;
     }

     public void setDateLoan(String dateLoan) {
          this.dateLoan = dateLoan;
     }

     public String getDeliveryLoan() {
          return deliveryLoan;
     }

     public void setDeliveryLoan(String deliveryLoan) {
          this.deliveryLoan = deliveryLoan;
     }

     public String getCar() {
          return car;
     }

     public void setCar(String car) {
          this.car = car;
     }

     public ArrayList<Detail> getListDetail() {
          return listDetail;
     }

     public void setListDetail(ArrayList<Detail> listDetail) {
          this.listDetail = listDetail;
     }

     public Loan(String debtorName, String dateLoan, String deliveryLoan, String car, ArrayList<Detail> listDetail) {
          this.debtorName = debtorName;
          this.dateLoan = dateLoan;
          this.deliveryLoan = deliveryLoan;
          this.car = car;
          this.listDetail = listDetail;
     }
}
