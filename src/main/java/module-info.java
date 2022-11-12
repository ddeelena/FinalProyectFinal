module co.edu.cue.finalproyect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens co.edu.cue.finalproyect to javafx.fxml;
    exports co.edu.cue.finalproyect;
}