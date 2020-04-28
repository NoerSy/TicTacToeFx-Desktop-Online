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
}

