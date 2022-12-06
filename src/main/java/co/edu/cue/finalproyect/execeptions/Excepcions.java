package co.edu.cue.finalproyect.execeptions;

public class Excepcions {
    public void exception(Boolean correct) throws Exception {
        if(correct){
            throw new Exception("Debes ingresar caracteres");
        }
    }
    public void exceptionError(){

    }
}
