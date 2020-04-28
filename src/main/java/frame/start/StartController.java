
package frame.start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import javafx.application.Platform;
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
import stage.NewStage;

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

    @FXML private HBox roomGet;
    @FXML private Label roomLabel;

    private String temp;
    private String noRoom;
    private String NamaL;

    private Common ServerService = new Common();
    private Parent root = new FXMLLoader(getClass().getResource("/Room.fxml")).load();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getRoom();
    }
    public StartController() throws IOException { }

    private void getRoom() {
        HBox hb1 = (HBox) root.lookup("#hb1");
        roomId1 = (Label) hb1.lookup("#IdRoom");
        HBox hb2 = (HBox) root.lookup("#hb2");
        roomId2 = (Label) hb2.lookup("#IdRoom");
        HBox hb3 = (HBox) root.lookup("#hb3");
        roomId3 = (Label) hb3.lookup("#IdRoom");
        HBox hb4 = (HBox) root.lookup("#hb4");
        roomId4 = (Label) hb4.lookup("#IdRoom");
        HBox hb5 = (HBox) root.lookup("#hb5");
        roomId5 = (Label) hb5.lookup("#IdRoom");

        FirebaseDatabase m = ServerService.getDatabase();
        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Platform.runLater(() -> {
                    roomId1.setText(dataSnapshot.child("Room")
                            .child("1")
                            .child("ID Room")
                            .getValue(String.class));
                    roomId2.setText(dataSnapshot.child("Room")
                            .child("2")
                            .child("ID Room")
                            .getValue(String.class));
                    roomId3.setText(dataSnapshot.child("Room")
                            .child("3")
                            .child("ID Room")
                            .getValue(String.class));
                    roomId4.setText(dataSnapshot.child("Room")
                            .child("4")
                            .child("ID Room")
                            .getValue(String.class));
                    roomId5.setText(dataSnapshot.child("Room")
                            .child("5")
                            .child("ID Room")
                            .getValue(String.class));
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        m.getReference().addValueEventListener(Lister);
    }
    private void intoRoom() {
        FirebaseDatabase m = ServerService.getDatabase();
        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new Thread(() -> {
                    for(int i = 1; true; i++){
                        temp = String.valueOf(i);
                        if(dataSnapshot.child("Room")
                                .child(temp)
                                .child("ID Room")
                                .getValue(String.class)
                                .equalsIgnoreCase(Room.getText())){
                            System.out.println("Ketemu " + i);
                            noRoom = String.valueOf(i);
                            ServerService.mSNamaPlayerDua(Nama.getText(), noRoom);
                            Platform.runLater(() -> {
                                Status.setText("Connected");
                                Start.setText("Start");
                                Start.disableProperty().set(false);
                            });
                            NamaL = dataSnapshot
                                    .child("Room")
                                    .child(noRoom)
                                    .child("playerSatu")
                                    .child("Nama")
                                    .getValue(String.class);
                            break;
                        }
                    }
                }).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        m.getReference().addListenerForSingleValueEvent(Lister);
    }
    private void createRoom(){
        FirebaseDatabase m = ServerService.getDatabase();
        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new Thread(() -> {
                    for(int i = 1; true; i++){
                        temp = String.valueOf(i);
                        if(dataSnapshot.child("Room")
                                .child(temp)
                                .child("ID Room")
                                .getValue(String.class)
                                .equalsIgnoreCase("")){
                            System.out.println("Ketemu " + i);
                            noRoom = String.valueOf(i);
                            ServerService.setIDRoom(Room.getText(), noRoom);
                            ServerService.mSNamaPlayerSatu(Nama.getText(), noRoom);
                            break;
                        }
                    }
                }).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        m.getReference().addListenerForSingleValueEvent(Lister);
    }
    private void waitforJoin(){
        FirebaseDatabase m = ServerService.getDatabase();
        ValueEventListener Lister = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                  if(!dataSnapshot
                                .child("Room")
                                .child(noRoom)
                                .child("playerDua")
                                .child("Nama")
                                .getValue(String.class)
                                .equalsIgnoreCase("")){
                      Platform.runLater(() -> {
                          Status.setText("Connected");
                          Join.setText("Start");
                          Join.disableProperty().set(false);
                      });
                      NamaL = dataSnapshot
                              .child("Room")
                              .child(noRoom)
                              .child("playerDua")
                              .child("Nama")
                              .getValue(String.class);
                  }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        m.getReference().addValueEventListener(Lister);
    }

    @FXML
    public void ActionClose() {
        if (!noRoom.equalsIgnoreCase(null)) {
            batalP();
            batalL();
        }
        System.exit(0);
    }

    @FXML
    public void ActionCek(){
        root.setOnMousePressed((MouseEvent e) -> {
            roomGet = (HBox) e.getTarget();
            roomLabel = (Label) roomGet.getParent().lookup("#IdRoom");
            Room.setText(roomLabel.getText());
            Body.setCenter(Form);
        });
        Body.setCenter(root);
    }

    @FXML
    public void ActionStart() throws IOException {
        if (Start.getText().equalsIgnoreCase("Create")) {
            Start.setText("Batal");

            createRoom();
            waitforJoin();

            Status.setText("Waitting Client...");
            Join.disableProperty().set(true);
        } else if (Start.getText().equalsIgnoreCase("Start")) {
            Stage stage = (Stage) Window.getScene().getWindow();

            setStage(Nama.getText(), NamaL, "playerDua", "playerSatu",noRoom);

            stage.close();
        } else {
            Start.setText("Create");
            Status.setText("No Connect");
            Join.disableProperty().set(false);
            batalP();
        }
    }

    @FXML
    public void ActionJoin() throws IOException {
        if (Join.getText().equalsIgnoreCase("Join")) {

            intoRoom();

            Join.setText("Batal");
            Start.disableProperty().set(true);
        } else if (Join.getText().equalsIgnoreCase("Start")) {
            Stage stage = (Stage) Window.getScene().getWindow();

            setStage(Nama.getText(), NamaL, "playerSatu","playerDua",noRoom);

            stage.close();
        } else {
            Join.setText("Join");
            Start.disableProperty().set(false);
            Status.setText("No Connect");
            batalL();
        }
    }

    private void setStage(String nama, String namaL, String Player, String lawan, String noRoom
    ) throws IOException {
        NewStage newStage = new NewStage();
        newStage.NewStage().show();
        newStage.getAndset(nama, namaL, Player, lawan, noRoom,ServerService);
    }

    private void batalP(){
        FirebaseDatabase m = ServerService.getDatabase();
        m.getReference().child("Room").child(temp).child("ID Room").setValue("", null);
        m.getReference().child("Room").child(temp).child("playerSatu")
                .child("Nama")
                .setValue("", null);
    }
    private void batalL(){
        ServerService.getDatabase().getReference().child("Room").child(temp).child("playerDua")
                .child("Nama")
                .setValue("", null);
    }
}
