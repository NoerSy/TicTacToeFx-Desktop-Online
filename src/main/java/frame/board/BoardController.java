
package frame.board;

import java.net.URL;
import java.util.ResourceBundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import frame.start.Common;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.application.Platform.runLater;

public class BoardController implements Initializable {

    private Stage stage;
    private Common ServerService;
    private String tampG;
    private String tempG;
    private int poin = 0;
    private int poinL = 0;
    private String playerSatu;
    private String noRoom;
    private final Moved moved = new Moved();
    private final String Player = "X";
    private final String PLawan = "O";
    private Timeline Timer;
    private Integer timeSeconds;

    @FXML private Pane mainFxmlClass;
    @FXML private Label Np1;
    @FXML private Label Np2;
    @FXML private Label ScP1;
    @FXML private Label ScP2;
    @FXML private Label Reset;
    @FXML private Label TimerLabel;
    @FXML private StackPane PaneButton;
    @FXML private HBox Restart;
    @FXML private HBox TimerPane;
    @FXML private VBox Body;
    @FXML private VBox Pnotice;
    @FXML private Label notice;

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
    private void ActionClose() {
        if(!notice.getText().equalsIgnoreCase(" Lost Connected!"))
            ServerService.mSMovePlayer("Close", noRoom, playerSatu);
        GameStop();
        Stage stage = (Stage) mainFxmlClass.getScene().getWindow();
        stage.close();
        this.stage.show();
    }
    @FXML
    private void ActionBoardReset(){
        Reset.setText("Reset");
        ServerService.mSMovePlayer("Reset", noRoom, playerSatu);
        Pnotice.setVisible(false);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        Reset();
    }

    //Board Event Start[
    @FXML
    private void ActionBoardXY11() {
        xy11.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy11.setStyle("-fx-background-color: #000033");
        Lxy11.setText(Player);
        ServerService.mSMovePlayer("Lxy11", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY12() {
        xy12.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy12.setStyle("-fx-background-color: #000033");
        Lxy12.setText(Player);
        ServerService.mSMovePlayer("Lxy12", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY13() {
        xy13.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy13.setStyle("-fx-background-color: #000033");
        Lxy13.setText(Player);
        ServerService.mSMovePlayer("Lxy13", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY21() {
        xy21.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy21.setStyle("-fx-background-color: #000033");
        Lxy21.setText(Player);
        ServerService.mSMovePlayer("Lxy21", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY22() {
        xy22.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy22.setStyle("-fx-background-color: #000033");
        Lxy22.setText(Player);
        ServerService.mSMovePlayer("Lxy22", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY23() {
        xy23.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy23.setStyle("-fx-background-color: #000033");
        Lxy23.setText(Player);
        ServerService.mSMovePlayer("Lxy23", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY31() {
        xy31.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy31.setStyle("-fx-background-color: #000033");
        Lxy31.setText(Player);
        ServerService.mSMovePlayer("Lxy31", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY32() {
        xy32.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy32.setStyle("-fx-background-color: #000033");
        Lxy32.setText(Player);
        ServerService.mSMovePlayer("Lxy32", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }
    @FXML
    private void ActionBoardXY33() {
        xy33.disableProperty().set(true);
        Body.disableProperty().set(true);
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        xy33.setStyle("-fx-background-color: #000033");
        Lxy33.setText(Player);
        ServerService.mSMovePlayer("Lxy33", noRoom, playerSatu);
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        cekMenang();
    }

    //Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PaneButton.setOnMouseEntered((MouseEvent) -> {
            TimerPane.setVisible(false);
            Restart.setVisible(true);
            PaneButton.setStyle("-fx-background-color : #330000;");
        });
        PaneButton.setOnMouseExited((MouseEvent) -> {
            TimerPane.setVisible(true);
            Restart.setVisible(false);
            PaneButton.setStyle("-fx-background-color : #100c0c;");
        });
    }

    //Costume Setup
    public void setNama(String nama) {
        Np1.setText(nama);
    }
    public void setNamaL(String nama) {
        runLater(() -> Np2.setText(nama));
    }
    public void setPlayer(String playerSatu, String lawan) {
        this.playerSatu = playerSatu;
        mGetMovePlayer(noRoom, lawan);
    }
    public void setnoRoom(String noRoom){
        this.noRoom = noRoom;
    }
    public void setServerService(Common ServerService){
        this.ServerService = ServerService;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    //BoardID
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

        if(moved.cekTie(Lxy11, Lxy12, Lxy13,
                Lxy21, Lxy22, Lxy23,
                Lxy31, Lxy32, Lxy33))  gameSeri();

        PaneButton.setOnMouseEntered((MouseEvent) -> {
            TimerPane.setVisible(false);
            Restart.setVisible(true);
            PaneButton.setStyle("-fx-background-color : #330000;");
        });
        PaneButton.setOnMouseExited((MouseEvent) -> {
            TimerPane.setVisible(false);
            Restart.setVisible(true);
            PaneButton.setStyle("-fx-background-color : #100c0c;");
        });
    }
    private void xMenang(){
        notice.setText("Kamu Menang!");
        Pnotice.setVisible(true);
        Body.disableProperty().set(true);
        Reset.setText("Restart");
        poin++;
        ScP1.setText("["+poin+"]");
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(noRoom)
                .child(playerSatu)
                .child("Score")
                .setValue(ScP1.getText(), null);
    }
    private void oMenang(){
        notice.setText("Kamu Kalah!");
        Pnotice.setVisible(true);
        Body.disableProperty().set(true);
        Reset.setText("Restart");
        poinL++;
        ScP2.setText("["+poinL+"]");
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        TimerPane.setVisible(false);
        Restart.setVisible(true);
    }
    private void gameSeri(){
        notice.setText("Game Seri!");
        Pnotice.setVisible(true);
        Body.disableProperty().set(true);
        Reset.setText("Restart");
        Timer.stop();
        Timer.setCycleCount(15);
        TimerLabel.setText("15");
        TimerPane.setVisible(false);
        Restart.setVisible(true);
    }
    private void Reset() {
        Pnotice.setVisible(false);
        Reset.setText("Reset");
        Lxy11.setText(" ");
        Lxy12.setText(" ");
        Lxy13.setText(" ");
        Lxy21.setText(" ");
        Lxy22.setText(" ");
        Lxy23.setText(" ");
        Lxy31.setText(" ");
        Lxy32.setText(" ");
        Lxy33.setText(" ");

        xy11.disableProperty().set(false);
        xy11.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy12.disableProperty().set(false);
        xy12.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy13.disableProperty().set(false);
        xy13.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy21.disableProperty().set(false);
        xy21.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy22.disableProperty().set(false);
        xy22.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy23.disableProperty().set(false);
        xy23.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy31.disableProperty().set(false);
        xy31.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy32.disableProperty().set(false);
        xy32.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        xy33.disableProperty().set(false);
        xy33.setStyle(
                "{-fx-background-color: white}"
                        + ":hover{-fx-background-color:#0066ff;}");
        Body.disableProperty().set(false);
    }
    private void ambilGlawan(String in){
        if(in.equalsIgnoreCase("Close")) {
            runLater(() -> {
                System.out.println(in);
                notice.setText(" Lost Connected!");
                Pnotice.setVisible(true);
                Body.disableProperty().set(true);
                GameStop();
            });
        }else if(in.equalsIgnoreCase("Reset")) {
            runLater(() -> {
                System.out.println(in);
                Reset.setText("Reset");
                Timer.stop();
                Timer.setCycleCount(15);
                TimerLabel.setText("15");
                Reset();
            });
        }else if(in.equalsIgnoreCase("Skip")) {
            runLater(() -> {
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                Body.disableProperty().set(false);
                playTimer();
            });
        }else if(in.equalsIgnoreCase("Lxy11")) {
            runLater(() -> {
                System.out.println(in);
                xy11.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy11.setStyle("-fx-background-color: #660000");
                Lxy11.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy12")){
            runLater(() -> {
                System.out.println(in);
                xy12.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy12.setStyle("-fx-background-color: #660000");
                Lxy12.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy13")){
            runLater(() -> {
                System.out.println(in);
                xy13.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy13.setStyle("-fx-background-color: #660000");
                Lxy13.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy21")){
            runLater(() -> {
                System.out.println(in);
                xy21.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy21.setStyle("-fx-background-color: #660000");
                Lxy21.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy22")){
            runLater(() -> {
                System.out.println(in);
                xy22.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy22.setStyle("-fx-background-color: #660000");
                Lxy22.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy23")){
            runLater(() -> {
                System.out.println(in);
                xy23.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy23.setStyle("-fx-background-color: #660000");
                Lxy23.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy31")){
            runLater(() -> {
                System.out.println(in);
                xy31.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy31.setStyle("-fx-background-color: #660000");
                Lxy31.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy32")){
            runLater(() -> {
                System.out.println(in);
                xy32.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy32.setStyle("-fx-background-color: #660000");
                Lxy32.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }else if(in.equalsIgnoreCase("Lxy33")){
            runLater(() -> {
                System.out.println(in);
                xy33.disableProperty().set(true);
                Body.disableProperty().set(false);
                TimerPane.setVisible(true);
                Restart.setVisible(false);
                xy33.setStyle("-fx-background-color: #660000");
                Lxy33.setText(PLawan);
                playTimer();
                cekMenang();
            });
        }
    }
    private void mGetMovePlayer(String noRoom, String lawan) {
        ValueEventListener mSPalyerDua = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    tampG = dataSnapshot
                            .child("Room")
                            .child(noRoom)
                            .child(lawan)
                            .child("Bxy")
                            .getValue(String.class);
                if(!tampG.equalsIgnoreCase(tempG)){
                    tempG = tampG;
                    ambilGlawan(tampG);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseDatabase.getInstance().getReference().addValueEventListener(mSPalyerDua);
    }
    private void playTimer(){
        timeSeconds = 15;
        Timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeSeconds--;
            TimerPane.setVisible(true);
            Restart.setVisible(false);
            TimerLabel.setText(timeSeconds.toString());
            if (timeSeconds <= 0) {
                ServerService.mSMovePlayer("Skip", noRoom, playerSatu);
                Body.disableProperty().set(true);
                Timer.stop();
                TimerPane.setVisible(false);
                Restart.setVisible(true);
                PaneButton.setOnMouseEntered((MouseEvent) -> {
                    TimerPane.setVisible(false);
                    Restart.setVisible(true);
                    PaneButton.setStyle("-fx-background-color : #330000;");
                });
                PaneButton.setOnMouseExited((MouseEvent) -> {
                    TimerPane.setVisible(false);
                    Restart.setVisible(true);
                    PaneButton.setStyle("-fx-background-color : #100c0c;");
                });
            }
        }));
        Timer.setCycleCount(15);
        Timer.playFromStart();
        PaneButton.setOnMouseEntered((MouseEvent) -> {
            TimerPane.setVisible(false);
            Restart.setVisible(true);
            PaneButton.setStyle("-fx-background-color : #330000;");
        });
        PaneButton.setOnMouseExited((MouseEvent) -> {
            TimerPane.setVisible(true);
            Restart.setVisible(false);
            PaneButton.setStyle("-fx-background-color : #100c0c;");
        });
    }
    private void stopTimer(){
        try{
            if(Timer == null) throw new NullPointerException();
            Timer.stop();
            Timer.setCycleCount(15);
            TimerLabel.setText("15");
        }catch (NullPointerException ignored){

        }
    }
    private void GameStop(){
        FirebaseDatabase m = ServerService.getDatabase();
        m.getReference().child("Room").child(noRoom).child("ID Room").removeValue(null);
        m.getReference().child("Room").child(noRoom).child(playerSatu)
                .child("Nama")
                .removeValue(null);
        m.getReference().child("Room").child(noRoom).child(playerSatu)
                .child("Bxy")
                .removeValue(null);
        m.getReference().child("Room").child(noRoom).child(playerSatu)
                .child("Score")
                .removeValue(null);
        stopTimer();
        TimerPane.setVisible(false);
        Restart.setVisible(true);
        Reset.setText("");
    }
}
