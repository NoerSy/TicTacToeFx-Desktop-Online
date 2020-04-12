/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefx.frame.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class BoardController implements Initializable {

    private PrintWriter out;
    private BufferedReader in;
    private int poin = 0;
    private int poinL = 0;
    private final Moved moved = new Moved();
    private final String Player = "X";
    private final String PLawan = "O";

    @FXML private Label Np1;
    @FXML private Label Np2;
    @FXML private Label ScP1;
    @FXML private Label ScP2;
    @FXML private Label Reset;
    @FXML private VBox Body;

    @FXML private Pane xy11;
    @FXML private Pane xy12;
    @FXML private Pane xy13;
    @FXML private Pane xy21;
    @FXML private Pane xy22;
    @FXML private Pane xy23;
    @FXML private Pane xy31;
    @FXML private Pane xy32;
    @FXML private Pane xy33;

    @FXML private Label Lxy11;
    @FXML private Label Lxy12;
    @FXML private Label Lxy13;
    @FXML private Label Lxy21;
    @FXML private Label Lxy22;
    @FXML private Label Lxy23;
    @FXML private Label Lxy31;
    @FXML private Label Lxy32;
    @FXML private Label Lxy33;

    @FXML
    public void ActionClose(MouseEvent event) {
        System.exit(0);
    }

    public void ActionBoardReset(MouseEvent event){
        Reset.setText("Reset");
        out.println("Reset");
        Reset();
    }
    
    //Board Event Start[
    @FXML
    public void ActionBoardXY11(MouseEvent evnt) {
        xy11.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy11.setStyle("-fx-background-color: #000033");
        Lxy11.setText(Player);
        out.println("Lxy11");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY12(MouseEvent evnt) {
        xy12.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy12.setStyle("-fx-background-color: #000033");
        Lxy12.setText(Player);
        out.println("Lxy12");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY13(MouseEvent evnt) {
        xy13.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy13.setStyle("-fx-background-color: #000033");
        Lxy13.setText(Player);
        out.println("Lxy13");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY21(MouseEvent evnt) {
        xy21.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy21.setStyle("-fx-background-color: #000033");
        Lxy21.setText(Player);
        out.println("Lxy21");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY22(MouseEvent evnt) {
        xy22.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy22.setStyle("-fx-background-color: #000033");
        Lxy22.setText(Player);
        out.println("Lxy22");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY23(MouseEvent evnt) {
        xy23.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy23.setStyle("-fx-background-color: #000033");
        Lxy23.setText(Player);
        out.println("Lxy23");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY31(MouseEvent evnt) {
        xy31.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy31.setStyle("-fx-background-color: #000033");
        Lxy31.setText(Player);
        out.println("Lxy31");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY32(MouseEvent evnt) {
        xy32.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy32.setStyle("-fx-background-color: #000033");
        Lxy32.setText(Player);
        out.println("Lxy32");
        cekMenang();
    }

    @FXML
    public void ActionBoardXY33(MouseEvent evnt) {
        xy33.disableProperty().set(true);
        Body.disableProperty().set(true);
        xy33.setStyle("-fx-background-color: #000033");
        Lxy33.setText(Player);
        out.println("Lxy33");
        cekMenang();
    }

    
    //Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Costume Setup
    public void setNama(String nama) {
        Np1.setText(nama);
    }
    public void setNamaL(String nama) {
        Platform.runLater(() -> {
            Np2.setText(nama);
        });
    }
    public void getInput(BufferedReader in) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ambilGlawan(in.readLine());
                    } catch (IOException ex) {
                        
                    }
                }
            }
        }.start();
    }
    public void setOutput(PrintWriter out) {
        this.out = out;
    }
    
    
    //Game Logic
    // Lxy11, Lxy12, Lxy13
    // Lxy21, Lxy22, Lxy23
    // Lxy31, Lxy32, Lxy33
    private void cekMenang(){   
        // Player X
        if(      moved.getBoolx(Lxy11, Lxy12, Lxy13)){
            xMenang();
        }else if(moved.getBoolx(Lxy21, Lxy22, Lxy23)){
            xMenang();
        }else if(moved.getBoolx(Lxy31, Lxy32, Lxy33)){
            xMenang();
        }else if(moved.getBoolx(Lxy11, Lxy21, Lxy31)){
            xMenang();
        }else if(moved.getBoolx(Lxy12, Lxy22, Lxy32)){
            xMenang();
        }else if(moved.getBoolx(Lxy13, Lxy23, Lxy33)){
            xMenang();
        }else if(moved.getBoolx(Lxy11, Lxy22, Lxy33)){
            xMenang();
        }else if(moved.getBoolx(Lxy13, Lxy22, Lxy31)){
            xMenang();
        }
        
        // Player O
        if(      moved.getBoolo(Lxy11, Lxy12, Lxy13)){
            oMenang();
        }else if(moved.getBoolo(Lxy21, Lxy22, Lxy23)){
            oMenang();
        }else if(moved.getBoolo(Lxy31, Lxy32, Lxy33)){
            oMenang();
        }else if(moved.getBoolo(Lxy11, Lxy21, Lxy31)){
            oMenang();
        }else if(moved.getBoolo(Lxy12, Lxy22, Lxy32)){
            oMenang();
        }else if(moved.getBoolo(Lxy13, Lxy23, Lxy33)){
            oMenang();
        }else if(moved.getBoolo(Lxy11, Lxy22, Lxy33)){
            oMenang();
        }else if(moved.getBoolo(Lxy13, Lxy22, Lxy31)){
            oMenang();
        }
    }
    private void ambilGlawan(String in){
        if(in.equalsIgnoreCase("X")){
            Platform.runLater(() -> {
                System.out.println("Giliran : O");
                Body.disableProperty().set(true);
            }); 
        }else if(in.equalsIgnoreCase("Reset")){
            Platform.runLater(() -> {
                Reset();
            });
        }else if(in.equalsIgnoreCase("Lxy11")) {
            Platform.runLater(() -> {
                System.out.println(in);
                xy11.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy11.setStyle("-fx-background-color: #660000");
                Lxy11.setText(PLawan);
                cekMenang(); 
            });
        }else if(in.equalsIgnoreCase("Lxy12")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy12.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy12.setStyle("-fx-background-color: #660000");
                Lxy12.setText(PLawan);
                cekMenang(); 
            });
        }else if(in.equalsIgnoreCase("Lxy13")){
             Platform.runLater(() -> {
                System.out.println(in);
                xy13.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy13.setStyle("-fx-background-color: #660000");
                Lxy13.setText(PLawan);
                cekMenang(); 
            });         
        }else if(in.equalsIgnoreCase("Lxy21")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy21.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy21.setStyle("-fx-background-color: #660000");
                Lxy21.setText(PLawan);
                cekMenang(); 
            });          
        }else if(in.equalsIgnoreCase("Lxy22")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy22.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy22.setStyle("-fx-background-color: #660000");
                Lxy22.setText(PLawan);
                cekMenang(); 
            });          
        }else if(in.equalsIgnoreCase("Lxy23")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy23.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy23.setStyle("-fx-background-color: #660000");
                Lxy23.setText(PLawan);
                cekMenang(); 
            });       
        }else if(in.equalsIgnoreCase("Lxy31")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy31.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy31.setStyle("-fx-background-color: #660000");
                Lxy31.setText(PLawan);
                cekMenang();   
            });     
        }else if(in.equalsIgnoreCase("Lxy32")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy32.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy32.setStyle("-fx-background-color: #660000");
                Lxy32.setText(PLawan);
                cekMenang(); 
            });
                      
        }else if(in.equalsIgnoreCase("Lxy33")){
            Platform.runLater(() -> {
                System.out.println(in);
                xy33.disableProperty().set(true);
                Body.disableProperty().set(false);
                xy33.setStyle("-fx-background-color: #660000");
                Lxy33.setText(PLawan);
                cekMenang(); 
            });
        }
    }
    private void xMenang(){
        System.out.println("Kamu Menang!!");
        Body.disableProperty().set(true);
        Reset.setText("Restart");
        poin++;
        ScP1.setText("["+poin+"]");
    }
    private void oMenang(){
        System.out.println("Kamu Kalah!!");
        Body.disableProperty().set(true);
        Reset.setText("Restart");
        poinL++;
        ScP2.setText("["+poinL+"]");
    }
    private void Reset(){
    Reset.setText("Reset");
    Lxy11.setText("");
    Lxy12.setText("");
    Lxy13.setText("");
    Lxy21.setText("");
    Lxy22.setText("");
    Lxy23.setText("");
    Lxy31.setText("");
    Lxy32.setText("");
    Lxy33.setText("");
    xy11.disableProperty().set(false); xy11.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy12.disableProperty().set(false); xy12.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy13.disableProperty().set(false); xy13.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy21.disableProperty().set(false); xy21.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy22.disableProperty().set(false); xy22.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy23.disableProperty().set(false); xy23.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy31.disableProperty().set(false); xy31.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy32.disableProperty().set(false); xy32.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    xy33.disableProperty().set(false); xy33.setStyle(
            "{-fx-background-color: white}"
            + ":hover{-fx-background-color:#0066ff;}");
    Body.disableProperty().set(false);
    }
}
