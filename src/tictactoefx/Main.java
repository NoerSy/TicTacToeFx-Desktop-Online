package tictactoefx;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Toshiba
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException{
        MainStage mainStage = new MainStage(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
} 