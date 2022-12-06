package co.edu.cue.finalproyect.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Proveedor {
   HashMap<String, Car> carHashMap;

    public HashMap<String, Car> getCarHashMap() {
        return carHashMap;
    }

    public void setCarHashMap(HashMap<String, Car> carHashMap) {
        this.carHashMap = carHashMap;
    }
}
