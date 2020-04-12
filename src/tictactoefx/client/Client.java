/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefx.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Toshiba
 */
public class Client {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean Status = false;
    private String temp;
    private String IP;
    private String nama;
    private String NamaLawan;
    private int Port;

    public void setInput(String port, String ip, String nama) {
        this.nama = (nama.equalsIgnoreCase("")) ? "Player" : nama;
        this.IP = (ip.equalsIgnoreCase("")) ? "localhost" : ip;
        try {
            Port = (port.equalsIgnoreCase(null)) ? Integer.parseInt(port) : 2222;
        } catch (NumberFormatException e) {
        }
    }

    private void connect() {
        System.out.println("Port : " + Port + "\nNama Client : " + nama + "\nIP : " + IP);
        try {
            clientSocket = new Socket(InetAddress.getByName(IP), Port);
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out.println(nama);
            NamaLawan = in.readLine();
            Status = true;
        } catch (SocketException e) {
            System.out.println("Error : " + e);
        } catch (IOException u) {
        }
    }

    public void clientHandler() {
        new Thread() {
            @Override
            public void run() {
                connect();
            }
        }.start();
    }
    
    public String getNamaL() {
        return NamaLawan;
    }

    public boolean getStatus() {
        return Status;
    }
    public BufferedReader getIn(){
        return in;
    }
    public PrintWriter getOut() {
        return this.out;
    }
}
