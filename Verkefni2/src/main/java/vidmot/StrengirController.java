package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vinnsla.Strengir;

/******************************************************************************
 * Lýsing: Controller klasi fyrir verkefni 2 sem les inn viðmótslýsingu
 * úr .fxml skrá, býr til senu og birtir glugga
 *
 * @author Hjálmar Friðrik Hjálmarsson, hfh17@hi.is
 * @version 1.0.0, 2024-01-19
 *****************************************************************************/

public class StrengirController {

    // Viðmótsbreytur fyrir viðmótshluti
    @FXML private Label telja;
    @FXML private Label leita;
    @FXML private Button buttonvista;
    @FXML private Button buttonleita;
    @FXML private Button buttontelja;
    @FXML private TextArea texti;
    @FXML private TextField leitarstrengur;

    // Strengjahlutur gerður til að nota vinnslu
    private Strengir strengir;

    /**
     * initialize aðferð sem frumstillir stýriklasann
     */
    public void initialize (){
        strengir = new Strengir();
    }


    /* Hjálparaðferð fyrir handlera sem athugar hvort það
    sé villa(texti eða leitarstrengur sé tómur). Skilar true ef
    það var villa og breytir prompt texta fyrir viðeigandi viðmótshlut til
    að benda notenda á villuna.
    */

    /**
     * Handler fyrir talningarhnapp sem kallar á telja aðferð
     * í vinnsluklasa og uppfærir notendaviðmótið með því að
     * breyta texta á telja label í gildið úr vinnslu. Einnig er
     * notenda bent á að ýtt hafi verið á hnappin með því að setja
     * grænan border á hnappinn eftir að ýtt er á hann
     * Villuaðferð notuð til þess að athuga fyrst hvort einhver villa var fundinn
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void teljaHandler(ActionEvent actionEvent) {
        if(strengir.isEmpty()) {
            texti.setPromptText("Vantar Texta!");
        }
        else {
            int talning = strengir.telja();
            telja.setText(String.valueOf(talning));
            buttontelja.setStyle("-fx-border-width: 5px");
            buttontelja.setStyle("-fx-border-color: green");
        }
    }

    /**
     * Handler fyrir vistunarhnapp sem kallar á vista aðferð í
     * vinnsluklasa sem vistar texta. Villuaðferð notuð til þess
     * að athuga hvort einhver villa var fundinn.  Einnig er
     * notenda bent á að ýtt hafi verið á hnappin með því að setja
     * grænan border á hnappinn eftir að ýtt er á hann
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void vistaHandler(ActionEvent actionEvent) {
        if(texti.getText().isEmpty()) {
            texti.setStyle("-fx-prompt-text-fill: red;");
            texti.setPromptText("Vantar Texta!");
        }
        else {
            strengir.vista(texti);
            buttonvista.setStyle("-fx-border-size: 50px");
            buttonvista.setStyle("-fx-border-color: green");
        }
        }

    /**
     * Handler fyrir leitunarhnapp sem kallar á leita aðferð
     * í vinnsluklasa og uppfærir notendaviðmótið með því að
     * breyta texta á leita label í gildið úr vinnslu ef
     * leitarstrengur var fundinn, annars er texta breytt
     * í "Ekki fundinn". Villuaðferð notuð til þess
     * að athuga fyrst hvort einhver villa var fundinn.
     * Einnig er notenda bent á að ýtt hafi verið á hnappin með því að setja
     * grænan border á hnappinn eftir að ýtt er á hann
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void leitaHandler(ActionEvent actionEvent) {
        if(texti.getText().isEmpty()) {
            texti.setStyle("-fx-prompt-text-fill: red;");
            texti.setPromptText("Vantar Texta!");
        }

        else if(strengir.isEmpty()) {

        }

        if(leitarstrengur.getText().isEmpty()) {
            leitarstrengur.setStyle("-fx-prompt-text-fill: red;");
            leitarstrengur.setPromptText("Vantar leitarstreng!");
        }
        else {
            buttonleita.setStyle("-fx-border-width: 50px");
            buttonleita.setStyle("-fx-border-color: green");
            strengir.leita(leitarstrengur);
            int leitun = strengir.leita(leitarstrengur);
            if (leitun != -1) {
                leita.setText(String.valueOf(leitun));
            } else {
                leita.setText("Ekki fundinn");
            }
        }
    }
}