package co.edu.cue.finalproyect.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class ArchiveUsefulPerson {

/*    public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

       XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }*/


        //ESTE METODO GUARDA EN UNA VARIABLE EL CONTENIDO ORDENADO DE EL ARCHIVO .TXT
        //TENIENDO ESTA INFORMACION EN UNA CADENA DE STRINGS SERA MAS FACIL REESTRUCTURAR LA INFORMACION
        public static ArrayList<String> leerArchivo(String ruta) throws IOException {

            ArrayList<String> contenido = new ArrayList<String>();
            FileReader fr = new FileReader(ruta);
            BufferedReader bfr = new BufferedReader(fr);
            String linea = "";
            while((linea = bfr.readLine())!= null) {
                contenido.add(linea);
            }
            bfr.close();
            fr.close();
            return contenido;
        }

        //EDITA Y GUARDA NUESTRO CONTENIDO
        public static void guardarArchivo(String ruta, String contenido, boolean b) throws IOException {
            FileWriter fw = new FileWriter(ruta, b);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write(contenido);
            bfw.close();
            fw.close();

        }

}
