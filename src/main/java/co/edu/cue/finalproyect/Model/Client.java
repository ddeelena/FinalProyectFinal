package co.edu.cue.finalproyect.Model;

public class Client extends Person {
    private  String direction;
    private String location;

    public Client(String name, String id, String cellphone, String gender, String user, String password, String direction, String location) {
        super(name, id, cellphone, gender, user, password);
        this.direction = direction;
        this.location = location;
    }
}
