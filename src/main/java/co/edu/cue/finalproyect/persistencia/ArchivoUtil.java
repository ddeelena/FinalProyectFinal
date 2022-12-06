package co.edu.cue.finalproyect.persistencia;

import co.edu.cue.finalproyect.model.Car;
import java.beans.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class ArchivoUtil {
    public ArchivoUtil() {
    }
    //------------------------------------SERIALIZACION  y XML

    public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

        System.out.println("arichivo util cargar");

        XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

        System.out.println("arichivo util salvar");


        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }
}
