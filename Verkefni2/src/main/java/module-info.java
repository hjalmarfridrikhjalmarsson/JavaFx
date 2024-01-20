/**
 * Skilgreining á módul fyrir verkefni 2
 */

module vidmot.verkefni2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens vidmot to javafx.fxml;
    exports vidmot;
}