package frame.start;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import java.io.IOException;
import java.io.InputStream;

public class Common {

    Common() throws IOException {
        InputStream serviceAccount = this.getClass().getResourceAsStream(
                        "/tictactoefx-firebase-admin.json"
                );
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tictactoefx.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
    }

    public FirebaseDatabase getDatabase(){
        return FirebaseDatabase.getInstance();
    }
    void setIDRoom(String Id, String noRoom){
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(noRoom)
                .child("ID Room")
                .setValue(Id, null);
    }
    public void mSNamaPlayerSatu(String nama, String noRoom) {
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(noRoom)
                .child("playerSatu")
                .child("Nama")
                .setValue(nama, null);
    }
    public void mSNamaPlayerDua(String nama, String noRoom) {
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(noRoom)
                .child("playerDua")
                .child("Nama")
                .setValue(nama, null);
    }
    public void mSMovePlayer(String Bxy, String noRoom, String Player) {
        FirebaseDatabase.getInstance().getReference()
                .child("Room")
                .child(noRoom)
                .child(Player)
                .child("Bxy")
                .setValue(Bxy, null);
    }
}
