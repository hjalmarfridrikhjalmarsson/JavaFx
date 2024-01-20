package vidmot;
//a. Javadoc Lysing Nafn höfundar og tölvupóstur (@author)
//b. Fyrir hvern klasa sem þið skrifið skuluð þið skrifa stutta lýsingu á hlutverki klasans
//c. Fyrir hvert fall/aðferð sem þið skrifið skuluð þið skrifa lýsingu á hvað fallið gerir ásamt
//því að skjala viðfangsbreytur (@param) og skilagildi (@return)
//d. Lýsing á hlutverki tilviksbreyta klasa með kommenti eftir skilgreiningu á breytunni //
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Verkefni 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}