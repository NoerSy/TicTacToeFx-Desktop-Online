import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import stage.MainStage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        new MainStage(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}





        