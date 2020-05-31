package frame.board;

import javafx.scene.control.Label;

public class Moved {
    
    public boolean getBoolx(Label satu, Label dua, Label tiga){
        return satu.getText().equalsIgnoreCase("X") && 
                dua.getText().equalsIgnoreCase("X") &&
                tiga.getText().equalsIgnoreCase("X");
    }
    public boolean getBoolo(Label satu, Label dua, Label tiga){
        return satu.getText().equalsIgnoreCase("O") && 
                dua.getText().equalsIgnoreCase("O") &&
                tiga.getText().equalsIgnoreCase("O");
    }

    public boolean cekTie(Label satu,
                          Label dua,
                          Label tiga,
                          Label empat,
                          Label lima,
                          Label enam,
                          Label tujuh,
                          Label delapan,
                          Label sembilan){
        return !satu.getText().equalsIgnoreCase(" ") &&
                !dua.getText().equalsIgnoreCase(" ") &&
                !tiga.getText().equalsIgnoreCase(" ") &&
                !empat.getText().equalsIgnoreCase(" ") &&
                !lima.getText().equalsIgnoreCase(" ") &&
                !enam.getText().equalsIgnoreCase(" ") &&
                !tujuh.getText().equalsIgnoreCase(" ") &&
                !delapan.getText().equalsIgnoreCase(" ") &&
                !sembilan.getText().equalsIgnoreCase(" ");
    }
}

