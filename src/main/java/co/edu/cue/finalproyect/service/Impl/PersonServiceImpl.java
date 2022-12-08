package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.ClientDTO;
import co.edu.cue.finalproyect.model.Person;
import co.edu.cue.finalproyect.persistencia.PeristencePerson;
import co.edu.cue.finalproyect.service.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    Client client = new Client();
    ArrayList<Person> arrayList = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void init () throws IOException {
        arrayList = PeristencePerson.cargarClientes();
        System.out.println(arrayList.get(0).getUser());
       // Person person = new Person("diana","90","3444","Femenino","dde","dd",false);
       // arrayList.add(person);
        Client cliente = new Client("der","123","1234","f","derly","plo","local","armenia",false);
        //System.out.println(cliente.getPassword() +"   "+person.getPassword());
        arrayList.add(cliente);
    }

    public ArrayList<Person> getArrayList() {
        return arrayList;
    }

    //hilos
    public void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location) throws IOException {
        Client client = new Client(name, id, cellphone, gender, user, password, direction, location,false);
        arrayList.add(client);
        CompletableFuture.runAsync(()-> {
            try {
                PeristencePerson.guardarClientes(arrayList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void editClient(String name, String gender,String cellphone, String email, String password){
        editArray(name, gender, cellphone, email, password);

            client.setName(name);
            client.setCellphone(cellphone);
            client.setGender(gender);
            client.setPassword(password);
            client.setUser(email);
            editArray(name, gender, cellphone, email, password);

    }
    public void editArray(String name, String gender,String cellphone, String email, String password){
        client.setName(name);
        client.setCellphone(cellphone);
        client.setGender(gender);
        client.setPassword(password);
        client.setUser(email);
    }

    public List<ClientDTO> genereListDTOs(){
        return  arrayList.stream()
                .map(c -> new ClientDTO(c.getName(),c.getId(),c.getCellphone()))
                .collect(Collectors.toList());
    }
    public void identi(String pass){
        for (Person cli: arrayList) {
            //cli.getPassword().equals(pass) ? client = (Client) cli : ;
            if(cli.getPassword().equals(pass)){
                client = (Client) cli;
                client.setCondition(true);
            }
        }
    }
}
