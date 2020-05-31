
package frame.start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import stage.NewStage;

import static javafx.application.Platform.runLater;

public class StartController implements Initializable {

    @FXML private VBox Window;
    @FXML private BorderPane Body;
    @FXML private GridPane Form;
    @FXML private Button Start;
    @FXML private Button Join;
    @FXML private TextField Nama;
    @FXML private TextField Room;
    @FXML private Label Status;


    @FXML private Label roomId1;
    @FXML private Label roomId2;
    @FXML private Label roomId3;
    @FXML private Label roomId4;
    @FXML private Label roomId5;

    @FXML private Label namaPs1;
    @FXML private Label namaPs2;
    @FXML private Label namaPs3;
    @FXML private Label namaPs4;
    @FXML private Label namaPs5;

    @FXML private Label namaPd1;
    @FXML private Label namaPd2;
    @FXML private Label namaPd3;
    @FXML private Label namaPd4;
    @FXML private Label namaPd5;

    @FXML private Label scorePs1;
    @FXML private Label scorePs2;
    @FXML private Label scorePs3;
    @FXML private Label scorePs4;
    @FXML private Label scorePs5;

    @FXML private Label scorePd1;
    @FXML private Label scorePd2;
    @FXML private Label scorePd3;
    @FXML private Label scorePd4;
    @FXML private Label scorePd5;

    @FXML private HBox roomGet;
    @FXML private Label roomLabel;
    @FXML private Button Get;

    private String NamaL;
    private int timeSeconds;
    private Timeline Timer;
    private String idRoom = " ";

    private Common ServerService = new Common();
    private Parent root = new FXMLLoader(getClass().getResource("/Room.fxml")).load();
    private ValueEventListener listerWaitForJoin = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
             if (!dataSnapshot
                            .child("Room")
                            .child(idRoom)
                            .child("playerDua")
                            .child("Nama")
                            .getValue(String.class)
                            .equalsIgnoreCase("")) {
                 NamaL = dataSnapshot
                         .child("Room")
                         .child(idRoom)
                         .child("playerDua")
                         .child("Nama")
                         .getValue(String.class);
                 System.out.println("Lawan : " + NamaL);
                 timeSeconds = 0;
             }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Join.disableProperty().bind(new BooleanBinding() {
            {
                super.bind(Room.textProperty(),
                        Nama.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return (Nama.getText().isEmpty() ||
                        Room.getText().isEmpty());
            }
        });
        getRoom();
    }
    public StartController() throws IOException { }

    private void getRoom() {
        HBox hb1 = (HBox) root.lookup("#tabel1");
        roomId1 = (Label) hb1.lookup("#IdRoom");
        HBox hb2 = (HBox) root.lookup("#tabel2");
        roomId2 = (Label) hb2.lookup("#IdRoom");
        HBox hb3 = (HBox) root.lookup("#tabel3");
        roomId3 = (Label) hb3.lookup("#IdRoom");
        HBox hb4 = (HBox) root.lookup("#tabel4");
        roomId4 = (Label) hb4.lookup("#IdRoom");
        HBox hb5 = (HBox) root.lookup("#tabel5");
        roomId5 = (Label) hb5.lookup("#IdRoom");

        namaPs1 = (Label) hb1.lookup("#nPlayerSatu");
        namaPs2 = (Label) hb1.lookup("#nPlayerSatu");
        namaPs3 = (Label) hb1.lookup("#nPlayerSatu");
        namaPs4 = (Label) hb1.lookup("#nPlayerSatu");
        namaPs5 = (Label) hb1.lookup("#nPlayerSatu");

        namaPd1 = (Label) hb1.lookup("#nPlayerDua");
        namaPd2 = (Label) hb1.lookup("#nPlayerDua");
        namaPd3 = (Label) hb1.lookup("#nPlayerDua");
        namaPd4 = (Label) hb1.lookup("#nPlayerDua");
        namaPd5 = (Label) hb1.lookup("#nPlayerDua");

        scorePs1 = (Label) hb1.lookup("#sPlayerSatu");
        scorePs2 = (Label) hb1.lookup("#sPlayerSatu");
        scorePs3 = (Label) hb1.lookup("#sPlayerSatu");
        scorePs4 = (Label) hb1.lookup("#sPlayerSatu");
        scorePs5 = (Label) hb1.lookup("#sPlayerSatu");

        scorePd1 = (Label) hb1.lookup("#sPlayerDua");
        scorePd2 = (Label) hb1.lookup("#sPlayerDua");
        scorePd3 = (Label) hb1.lookup("#sPlayerDua");
        scorePd4 = (Label) hb1.lookup("#sPlayerDua");
        scorePd5 = (Label) hb1.lookup("#sPlayerDua");

        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 1;
                for (DataSnapshot snapshot : dataSnapshot.child("Room").getChildren()) {
                    switch (i){
                        case 1:
                            Platform.runLater(() -> {
                                roomId1.setText(snapshot.child("idRoom").getValue(String.class));
                                namaPs1.setText(snapshot.child("playerSatu").child("Nama").getValue(String.class));
                                namaPd1.setText(snapshot.child("playerDua").child("Nama").getValue(String.class));
                                scorePs1.setText(snapshot.child("playerSatu").child("Score").getValue(String.class));
                                scorePd1.setText(snapshot.child("playerDua").child("Score").getValue(String.class));
                            });
                            break;
                        case 2:
                            Platform.runLater(() -> {
                                roomId2.setText(snapshot.child("idRoom").getValue(String.class));
                                namaPs2.setText(snapshot.child("playerSatu").child("Nama").getValue(String.class));
                                namaPd2.setText(snapshot.child("playerDua").child("Nama").getValue(String.class));
                                scorePs2.setText(snapshot.child("playerSatu").child("Score").getValue(String.class));
                                scorePd2.setText(snapshot.child("playerDua").child("Score").getValue(String.class));
                            });
                            break;
                        case 3:
                            Platform.runLater(() -> {
                                roomId3.setText(snapshot.child("idRoom").getValue(String.class));
                                namaPs3.setText(snapshot.child("playerSatu").child("Nama").getValue(String.class));
                                namaPd3.setText(snapshot.child("playerDua").child("Nama").getValue(String.class));
                                scorePs3.setText(snapshot.child("playerSatu").child("Score").getValue(String.class));
                                scorePd3.setText(snapshot.child("playerDua").child("Score").getValue(String.class));
                            });
                            break;
                        case 4:
                            Platform.runLater(() -> {
                                roomId4.setText(snapshot.child("idRoom").getValue(String.class));
                                namaPs4.setText(snapshot.child("playerSatu").child("Nama").getValue(String.class));
                                namaPd4.setText(snapshot.child("playerDua").child("Nama").getValue(String.class));
                                scorePs4.setText(snapshot.child("playerSatu").child("Score").getValue(String.class));
                                scorePd4.setText(snapshot.child("playerDua").child("Score").getValue(String.class));
                            });
                            break;
                        case 5:
                            Platform.runLater(() -> {
                                roomId5.setText(snapshot.child("idRoom").getValue(String.class));
                                namaPs5.setText(snapshot.child("playerSatu").child("Nama").getValue(String.class));
                                namaPd5.setText(snapshot.child("playerDua").child("Nama").getValue(String.class));
                                scorePs5.setText(snapshot.child("playerSatu").child("Score").getValue(String.class));
                                scorePd5.setText(snapshot.child("playerDua").child("Score").getValue(String.class));
                            });
                            break;
                    }
                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        ServerService.getDatabase().getReference().addValueEventListener(Lister);
    }
    private void intoRoom() {
        FirebaseDatabase m = ServerService.getDatabase();
        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child("Room")
                            .child(idRoom)
                            .child("idRoom")
                            .getValue(String.class)
                            .equalsIgnoreCase(Room.getText())){
                        ServerService.mSNamaPlayerDua(Nama.getText(), idRoom);
                        NamaL = dataSnapshot
                                .child("Room")
                                .child(idRoom)
                                .child("playerSatu")
                                .child("Nama")
                                .getValue(String.class);
                        System.out.println("Ketemu " + NamaL);
                        runLater(() -> {
                            try {
                                Stage stage = (Stage) Window.getScene().getWindow();
                                setStage(Nama.getText(), NamaL, "playerDua", "playerSatu", idRoom);
                                Status.setText("No Connect");
                                stage.hide();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        m.getReference().addListenerForSingleValueEvent(Lister);
    }
    private void createRoom(){
        if(Room.getText().equalsIgnoreCase("")) {
            idRoom = RandomString.generate(5);
            Room.setText(idRoom);
        }else
            idRoom = Room.getText();
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(idRoom)
                .child("idRoom")
                .setValue(idRoom, null);
        ServerService.mSNamaPlayerSatu(Nama.getText(), idRoom);
    }
    private void waitForJoin(){
        ServerService.getDatabase().getReference().addValueEventListener(listerWaitForJoin);
        timeSeconds = 15;
        Timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (timeSeconds <= 0) {
                ServerService.getDatabase().getReference().removeEventListener(listerWaitForJoin);
                if(!NamaL.equalsIgnoreCase("")){
                    try {
                        Stage stage = (Stage) Window.getScene().getWindow();
                        Start.setText("Create");
                        Status.setText("No Connect");
                        setStage(Nama.getText(), NamaL, "playerSatu","playerDua", idRoom);
                        Room.disableProperty().set(false);
                        Get.disableProperty().set(false);
                        stage.hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Status.setText("No Connect");
                    batalP();
                }
                Timer.stop();
            }else{
                Status.setText("Wait....["+ timeSeconds +"]");
                timeSeconds--;
            }
        }));
        Timer.setCycleCount(15);
        Timer.playFromStart();
    }

    @FXML
    public void ActionClose() {
        if (!idRoom.equalsIgnoreCase(" ")) {
            batalP();
            batalL();
        }
        System.exit(0);
    }

    @FXML
    public void ActionGet(){
        root.setOnMousePressed((MouseEvent e) -> {
            roomGet = (HBox) e.getTarget();
            roomLabel = (Label) roomGet.getParent().lookup("#IdRoom");
            idRoom = roomLabel.getText();
            Room.setText(roomLabel.getText());
            Body.setCenter(Form);
        });
        Body.setCenter(root);
    }

    @FXML
    public void ActionStart() {
        if (Start.getText().equalsIgnoreCase("Create")) {

            createRoom();
            waitForJoin();
            Start.setText("Batal");
            Status.setText("No Connect");
            Room.disableProperty().set(true);
            Get.disableProperty().set(true);
        } else {
            Timer.stop();
            Start.setText("Create");
            Join.setText("Join");
            Status.setText("No Connect");
            Get.disableProperty().set(false);
            batalP();
        }
    }

    @FXML
    public void ActionJoin() {
        if (Join.getText().equalsIgnoreCase("Join")) {
            intoRoom();
        } else {
            Join.setText("Join");
            Start.setText("Create");
            Start.disableProperty().set(false);
            Get.disableProperty().set(false);
            Status.setText("No Connect");
            batalL();
        }
    }

    private void setStage(String nama, String namaL, String Player, String lawan, String noRoom
    ) throws IOException{
        NewStage newStage = new NewStage();
        newStage.NewStage().show();
        newStage.getAndset(nama, namaL, Player, lawan, noRoom, ServerService, (Stage) Window.getScene().getWindow());
    }

    private void batalP(){
        FirebaseDatabase m = ServerService.getDatabase();
        m.getReference().child("Room").child(idRoom).child("idRoom").removeValue(null);
        m.getReference().child("Room").child(idRoom).child("playerSatu")
                .child("Nama")
                .removeValue(null);
        m.getReference().child("Room").child(idRoom).child("playerSatu")
                .child("Bxy")
                .removeValue(null);
    }
    private void batalL(){
        ServerService.getDatabase().getReference()
                .child("Room").child(idRoom).child("idRoom").removeValue(null);
    }
}
