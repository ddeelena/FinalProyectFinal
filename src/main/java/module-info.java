module co.edu.cue.finalproyect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    exports co.edu.cue.finalproyect;

    exports co.edu.cue.finalproyect.controller to javafx.fxml;
    exports co.edu.cue.finalproyect.Model to javafx.fxml;
    opens co.edu.cue.finalproyect.Model to javafx.base;
    opens co.edu.cue.finalproyect.controller to javafx.fxml;
    opens co.edu.cue.finalproyect to javafx.graphics;
}