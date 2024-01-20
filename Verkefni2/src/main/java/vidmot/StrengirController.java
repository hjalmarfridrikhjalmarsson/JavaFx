package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
     * breyta texta á telja label í gildið úr vinnslu. Villuaðferð
     * notuð til þess að athuga fyrst hvort einhver villa var fundinn
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void teljaHandler(ActionEvent actionEvent) {
        int talning = strengir.telja();
        telja.setText(String.valueOf(talning));
    }

    /**
     * Handler fyrir vistunarhnapp sem kallar á vista aðferð í
     * vinnsluklasa sem vistar texta. Villuaðferð notuð til þess
     * að athuga hvort einhver villa var fundinn
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void vistaHandler(ActionEvent actionEvent) {
            strengir.vista(texti);
        }

    /**
     * Handler fyrir leitunarhnapp sem kallar á leita aðferð
     * í vinnsluklasa og uppfærir notendaviðmótið með því að
     * breyta texta á leita label í gildið úr vinnslu ef
     * leitarstrengur var fundinn, annars er texta breytt
     * í "Ekki fundinn". Villuaðferð notuð til þess
     * að athuga fyrst hvort einhver villa var fundinn
     * @param actionEvent atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    public void leitaHandler(ActionEvent actionEvent) {
        strengir.leita(leitarstrengur);
        int leitun = strengir.leita(leitarstrengur);
        if (leitun != -1) {
            leita.setText(String.valueOf(leitun));
        } else {
            leita.setText("Ekki fundið");
        }
    }
}