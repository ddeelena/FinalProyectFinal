package co.edu.cue.finalproyect.execeptions;

public class Validations {
    public   void isNumInteger(String name) throws Excepcions {
        try
        {
            Integer.parseInt(name);

        }
        catch (NumberFormatException nfe)
        {
            throw  new Excepcions("Debe ingresar caracteres solamente");
        }
    }
    public boolean isString(Integer num){
        try {
            Integer.parseInt(String.valueOf(num));
            return false;
        }catch (NumberFormatException err){
            return true;
        }
    }
    public void searchFull(){

    }
}
