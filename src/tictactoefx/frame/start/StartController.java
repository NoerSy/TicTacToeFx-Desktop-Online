/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefx.frame.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoefx.NewStage;

import tictactoefx.client.Client;
import tictactoefx.server.Server;

/**
 * FXML Controller class
 *
 * @author NoerSy
 */
public class StartController implements Initializable {

    private Server server;
    private Client client;

    @FXML
    private VBox Window;
    @FXML
    private Button Start;
    @FXML
    private Button Join;
    @FXML
    private TextField Nama;
    @FXML
    private TextField Port;
    @FXML
    private TextField IP;
    @FXML
    private Label Status;

    @FXML
    public void ActionClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    public void ActionStart(ActionEvent event) throws IOException {
        if (Start.getText().equalsIgnoreCase("Create")) {
            Start.setText("Batal");
            server = new Server();
            server.setInput("2222", "localhost", Nama.getText());
            server.initializeServer();
            server.ServerHandler();
            waiting();
            Status.setText("Waitting Client...");
            Join.disableProperty().set(true);
        } else if (Start.getText().equalsIgnoreCase("Start")) {
            Stage stage = (Stage) Window.getScene().getWindow();
            
            setStage(client.getNamaL(), 
                    Nama.getText(), 
                    client.getOut(),
                    client.getIn()
            );
            
            stage.close();
        } else {
            Start.setText("Create");
            Status.setText("No Connect");
            Join.disableProperty().set(false);
        }

    }

    @FXML
    public void ActionJoin(ActionEvent event) throws IOException {
        if (Join.getText().equalsIgnoreCase("Join")) {
            client = new Client();
            client.setInput("2222", "localhost", Nama.getText());
            client.clientHandler();
            Join.setText("Batal");
            Start.disableProperty().set(true);
            waiting();
        } else if (Join.getText().equalsIgnoreCase("Start")) {
            Stage stage = (Stage) Window.getScene().getWindow();

            setStage(server.getNamaL(), 
                    Nama.getText(), 
                    server.getOut(),
                    server.getIn()
            );
            
            stage.close();
        } else {
            Join.setText("Join");
            Start.disableProperty().set(false);
            Status.setText("No Connect");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void setStage(String inL, 
            String nama, 
            PrintWriter out,
            BufferedReader in
    ) throws IOException {
        NewStage newStage = new NewStage();
        newStage.NewStage().show();
        newStage.getAndsetNamaL(inL);
        newStage.getAndsetNama(nama);
        newStage.setOutput(out);
        newStage.getAndsetInput(in);
    }

    private void waiting() {
        if (Start.getText().equalsIgnoreCase("Batal")) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        if (server.getStatus()) {
                            Platform.runLater(() -> {
                                Join.disableProperty().set(false);
                                Join.setText("Start");
                                Status.setText("Connected");
                            });
                            break;
                        }
                    }
                    this.interrupt();
                }
            }.start();
        } else {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        if (client.getStatus()) {
                            Platform.runLater(() -> {
                                Start.disableProperty().set(false);
                                Start.setText("Start");
                                Status.setText("Connected");
                            });
                            break;
                        }
                    }
                    this.interrupt();
                }
            }.start();
        }
    }
}
