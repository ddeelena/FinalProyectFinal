package co.edu.cue.finalproyect.persistencia;

import co.edu.cue.finalproyect.model.Person;

import static co.edu.cue.finalproyect.persistencia.ArchivoUtil.salvarRecursoSerializadoXML;

public class PeristencePerson {
    public static final String RUTA_ARCHIVO_TIENDA = "src/main/resources/user.xml";

    public static Person cargarRecursoTiendaXML() {
        Person person = null;
        try {
            person = (Person) ArchiveUsefulPerson.cargarRecursoSerializadoXML(RUTA_ARCHIVO_TIENDA);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return person;
    }



    public static void guardarRecursoBancoXML(Person tienda) {
        try {
            System.out.println("++++++++++"+tienda.getName()+"+++++++++");
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_TIENDA, tienda);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
