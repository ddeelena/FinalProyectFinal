package co.edu.cue.finalproyect.persistencia;

import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static co.edu.cue.finalproyect.persistencia.ArchivoUtil.salvarRecursoSerializadoXML;

public class PeristencePerson {
  //  public static final String RUTA_ARCHIVO_TIENDA = "src/main/resources/user.xml";

/*    public static Person cargarRecursoTiendaXML() {
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
    }*/


        public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/clientes.txt";

        public static void guardarClientes(ArrayList<Person> listaClientes) throws IOException {

            String contents = "";

            for(Person cliente: listaClientes) {
                contents+= cliente.getPassword()+"@"+cliente.getName()+"@"+ "@"+cliente.getCellphone()+"@"+
                        cliente.getGender()+"@"+cliente.isCondition()+"@"+cliente.getUser()+"@"+cliente.getId();
                if(cliente instanceof Client){
                    contents+=  "@"+((Client) cliente).getDirection()+
                            "@"+ ((Client) cliente).getLocation()+"@"+"\n";
                }
            }
            ArchiveUsefulPerson.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contents, false);
        }

        //METODO PARA CARGAR LOS CLIENTES A PARTIR DEL ARCHIVO
        public static ArrayList<Person> cargarClientes() throws FileNotFoundException, IOException {

            ArrayList<Person> clientes = new ArrayList<Person>();

            ArrayList<String> contenido = ArchiveUsefulPerson.leerArchivo(RUTA_ARCHIVO_CLIENTES);
            String linea = "";

            for (int i = 0;i<contenido.size(); i++) {
                Client miCliente = new Client();
                linea = contenido.get(i);

                miCliente.setPassword((linea.split("@")[0]));
                miCliente.setName(linea.split("@")[1]);
                miCliente.setDirection(linea.split("@")[2]);
                miCliente.setLocation(linea.split("@")[3]);
                miCliente.setCellphone(linea.split("@")[4]);
                miCliente.setGender(linea.split("@")[5]);
                miCliente.setCondition(Boolean.parseBoolean(linea.split("@")[6]));
                miCliente.setUser(linea.split("@")[7]);
                miCliente.setId(linea.split("@")[8]);

                clientes.add(miCliente);
            }

            return clientes;
        }

}
