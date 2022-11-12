package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.service.Impl.RentCarServiceImpl;
import co.edu.cue.finalproyect.service.ModelFactoryControllerService;


public class ModelFactoryController implements ModelFactoryControllerService {
        RentCarServiceImpl rentCarService;
        private static class SingletonHolder {
            // El constructor de Singleton puede ser llamado desde aquí al ser protected
            private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
        }

        // Método para obtener la instancia de nuestra clase
        public static ModelFactoryController getInstance() {
            return SingletonHolder.eINSTANCE;
        }

        public ModelFactoryController() {
            System.out.println("invocación clase singleton");
            rentCarService = new RentCarServiceImpl();
        }

}
