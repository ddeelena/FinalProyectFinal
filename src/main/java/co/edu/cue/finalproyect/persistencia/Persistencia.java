package co.edu.cue.finalproyect.persistencia;

import co.edu.cue.finalproyect.model.Car;


import co.edu.cue.finalproyect.persistencia.ArchivoUtil.*;

import java.io.Serializable;


public class Persistencia{
    public Persistencia() {
    }

    //------------------------------------SERIALIZACION  y XML

    public static final String RUTA_ARCHIVO_TIENDA = "src/main/resources/car.xml";

    public static Car cargarRecursoTiendaXML() {
        System.out.println("PERSISTENCIAS  cargar");

        Car carArrayList = null;
        try {
            carArrayList = (Car) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_TIENDA);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return carArrayList;
    }



    public static void guardarRecursoBancoXML(Car tienda) {
        System.out.println("PERSISTENCIAS  GIARDAR");

        try {
            System.out.println("++++++++++"+tienda.getName()+"+++++++++");

           ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_TIENDA, tienda);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
