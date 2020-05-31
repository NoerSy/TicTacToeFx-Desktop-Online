package stage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import frame.start.Common;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import frame.board.BoardController;

public class NewStage {

    private double xOffset = 0;
    private double yOffset = 0;
    private final FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Board.fxml"));

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
    public void getAndset(String nama,
                          String namaL,
                          String player,
                          String lawan,
                          String noRoom,
                          Common setServerService,
                          Stage stage) {
        BoardController controller = firstLoader.<BoardController>getController();
        controller.setNama(nama);
        controller.setNamaL(namaL);
        controller.setnoRoom(noRoom);
        controller.setPlayer(player, lawan);
        controller.setServerService(setServerService);
        controller.setStage(stage);
    }
}
