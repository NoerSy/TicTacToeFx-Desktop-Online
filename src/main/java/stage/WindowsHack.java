package stage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Toshiba
 */
public class WindowsHack {

    public Scene getShadowScene(Parent p) {
        Scene scene;
        Pane outer = new Pane();
        outer.getChildren().add(p);
        outer.setPadding(new Insets(10.0d));
        outer.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0), new CornerRadii(0), new Insets(0))));
        
        p.setEffect(new DropShadow());
        ((Pane) p).setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0)
        )));
        
        scene = new Scene(outer);
        scene.setFill(Color.rgb(0, 255, 0, 0));
        return scene;
    }
}
