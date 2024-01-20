package vinnsla;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/******************************************************************************
 * Lýsing: Klasinn er vinnsluklasi fyrir verkefni 2.
 *
 * @author Hjálmar Friðrik Hjálmarsson, hfh17@hi.is
 * @version 1.0.0, 2024-01-19
 *****************************************************************************/
public class Strengir {

    // tilviksbreyta sem geymir strengi í fylki
    private String[] textafylki;

    /**
     * Aðferðin leita sem finnur fyrsta tilvik strengs í texta
     * @return int sem er vísitala fyrsta tilviks leitarstrengs í textafylki
     * @param leitarstrengur sem leitað er að í texta
     */
    public int leita(TextField leitarstrengur) {
        for (int i = 0; i < textafylki.length; i++) {
            String leit = snid(leitarstrengur.getText());
            if (snid(textafylki[i]).equals(leit)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Aðferðin telja sem telur fjölda tilvika strengs í texta
     * @return int sem er fjöldi tilvika orða í textanum
     */
    public int telja(){
        return textafylki.length;
    }

    /**
     * Aðferðin tekur inn textareit og vistar hann
     * @param textfield tekin inn sem er svo vistaður
     */
    public void vista(TextArea textfield) {
       String texti = textfield.getText();
       textafylki = texti.split("\\s+");
    }

    // Aðferðin tekur inn streng og breytir öllum stöfum í lágstafi og fjarlægir
    // alla stafi sem eru ekki bókstafir
    private String snid(String strengur) {
        strengur = strengur.toLowerCase().replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚýÝ]", "");
        return strengur;
    }

}