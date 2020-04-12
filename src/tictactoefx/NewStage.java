/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoefx.frame.board.BoardController;

/**
 *
 * @author Toshiba
 */
public class NewStage {

    private double xOffset = 0;
    private double yOffset = 0;
    private final FXMLLoader firstLoader = new FXMLLoader(
            getClass().getResource("/tictactoefx/frame/board/Board.fxml"));

    public Stage NewStage() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = firstLoader.load();
        Scene scene = (new WindowsHack()).getShadowScene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        primaryStage.setScene(scene);
        //primaryStage.show();

        return primaryStage;
    }

    public void getAndsetNama(String nama) {
        BoardController controller = firstLoader.<BoardController>getController();
        controller.setNama(nama);
    }

    public void getAndsetNamaL(String nama) {
        BoardController controller = firstLoader.<BoardController>getController();
        controller.setNamaL(nama);
    }

    public void getAndsetInput(BufferedReader in) {
        BoardController controller = firstLoader.<BoardController>getController();
        controller.getInput(in);
    }

    public void setOutput(PrintWriter out) {
        BoardController controller = firstLoader.<BoardController>getController();
        controller.setOutput(out);
    }
}
