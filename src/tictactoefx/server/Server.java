/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoefx.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean Status = false;
    private int Port;
    private String nama;
    private String namal;
    private String IP;
    private String temp;

    public void setInput(String port, String ip, String nama) {
        this.nama = (nama.equalsIgnoreCase("")) ? "Player" : nama;
        this.IP = (ip.equalsIgnoreCase("")) ? "localhost" : ip;
        try {
            Port = (port.equalsIgnoreCase(null)) ? Integer.parseInt(port) : 2222;
        } catch (NumberFormatException e) {
        }
    }

    public void initializeServer() {
        try {
            this.serverSocket = new ServerSocket(Port, 1, InetAddress.getByName(IP));
            System.out.println("Listen at port " + Port + ".");
        } catch (IOException e) {
        }
    }

    public void WaitingClient() {
        try {
            this.clientSocket = this.serverSocket.accept();
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Accept clinet");
            System.out.println("Nama Server : " + nama);
            this.out.println(nama);
            this.out.println("X");
            namal = in.readLine();
            Status = true;
        } catch (IOException e) {
        }
    }

    public void ServerHandler() {
        new Thread() {
            @Override
            public void run() {
                WaitingClient();
            }
        }.start();
    }

    public boolean getStatus() {
        return Status;
    }
    public String getNamaL(){
        return this.namal;
    }
    public BufferedReader getIn(){
        return in;
    }
    public PrintWriter getOut() {
        return this.out;
    }
}
