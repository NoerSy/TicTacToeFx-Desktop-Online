package stage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Toshiba
 */
public class MainStage {
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    public MainStage(Stage primaryStage) throws IOException {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Start.fxml"));
        Parent root = firstLoader.load();
        Scene scene = (new WindowsHack()).getShadowScene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}