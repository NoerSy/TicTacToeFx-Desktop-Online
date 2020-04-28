import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import stage.MainStage;

public class TicTacToeFx extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        new MainStage(primaryStage);

        //test(primaryStage);
    }

//    private void test(Stage primaryStage) throws IOException {
//        Parent root  = new FXMLLoader(getClass().getResource("/test.fxml")).load();
//        AnchorPane pane = new AnchorPane();
//        pane.getChildren().add(root);
//        Scene scene = new Scene(pane);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    public static void main(String[] args) {
        launch(args);
    }
}





        