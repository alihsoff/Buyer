package com.buyer.TCPClient;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPConnection {

    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private String message = "";
    private String serverIP;
    private static Socket connection;
    private int port;

    public TCPConnection(String serverIP, int port) {
        this.serverIP = serverIP;
        this.port = port;
    }

    public void startConnection() {
        try {
            try {
                try {
                    connection = new Socket(InetAddress.getByName(serverIP), port);
                } catch (IOException ioEception) {
                    System.out.println("Server Down!");
                }
                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());

                whileMessaging();

            } catch (EOFException eofException) {
                System.out.println("Connection down");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void whileMessaging() {
        String message = "";
        do {
            try {
                message = (String) input.readObject();
                System.out.println(message);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!message.equals("STOP"));
    }

    public static void sendMessage(String message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
