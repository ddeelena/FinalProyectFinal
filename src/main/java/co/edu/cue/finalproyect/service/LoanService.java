package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public interface LoanService {
    ArrayList<LoanDTO> genereDTO();
    void createLoan(Client debtorName, Car car, boolean chair, boolean porta, String placeCollected, String plateDelivery,String typeCount, String countNumber);
}