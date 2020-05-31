package stage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;


public class Test {

    @FXML
    private TextField field;
    ///"tictactoefx-firebase-admin.json"
    FileInputStream serviceAccount = new FileInputStream(
            this.getClass().getClassLoader().getResource(
                    "tictactoefx-firebase-admin.json"
            ).getPath());

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://tictactoefx.firebaseio.com")
            .build();

    DatabaseReference mDatabase;

    public Test() throws IOException {
        FirebaseApp.initializeApp(options);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(postListener);
    }



    @FXML
    public void ActionB(ActionEvent actionEvent) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Location").child("X").setValue(field.getText(), null);
    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String rface = dataSnapshot.child("Location").child("X").getValue(String.class);
            System.out.println(rface);
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}
