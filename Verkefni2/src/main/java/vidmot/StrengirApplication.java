package vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/******************************************************************************
 * Lýsing: Application klasi fyrir verkefni 2 sem les inn viðmótslýsingu
 * úr .fxml skrá, býr til senu og birtir glugga
 *
 * @author Hjálmar Friðrik Hjálmarsson, hfh17@hi.is
 * @version 1.0.0, 2024-01-19
 *****************************************************************************/

public class StrengirApplication extends javafx.application.Application {

    /**
     * Aðferðin start sem les inn viðmótslýingu úr fxml skrá, býr til senu og birtir glugga
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StrengirApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Strengir");
        stage.setScene(scene);
        stage.show();
        stage.getScene().getRoot().requestFocus();
    }
    /**
     * Aðferðin main sem kallað er á þegar forritið er ræst
     * @param args skipanalínu viðfang
     */
    public static void main(String[] args) {
        launch();
    }
}