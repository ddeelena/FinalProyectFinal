package co.edu.cue.finalproyect.execeptions;

public class Validations {
    private static boolean isNumInteger(String name) {
        try
        {
            Integer.parseInt(name);
            return true;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
    }

}
