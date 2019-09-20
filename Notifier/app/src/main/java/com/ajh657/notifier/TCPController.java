package com.ajh657.notifier;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPController {

    private Context context;
    private String ip;
    private int port;
    private Socket socketConnection;

    private PrintWriter out;
    private BufferedReader in;
    private String bufferString;

    public TCPController(String IP,int Port,Context currentContext){
        this.context = currentContext;
        this.ip = ip;
        this.port = Port;
    }

    public int testConn(){

        try {
            Log.d("TCPController", "Attempting to connect");
            InetAddress serverAddr = InetAddress.getByName(ip);
            socketConnection = new Socket(serverAddr,port);
        }catch (Exception e){
            Log.d("SocketException", e.getMessage(), e.getCause());
            return 400;
        }

        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketConnection.getOutputStream())),true);
            in = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
        }catch (Exception e){
            Log.d("BufferException",e.getMessage(),e.getCause());
            return 500;
        }

        try{

            out.println(System.getProperty("os.version"));
            bufferString = in.readLine();
            Log.d("Connection test", bufferString);

        }catch (Exception e){
            Log.d("SendReceiveException", e.getMessage(), e.getCause());
        }finally {
            try {
                in.close();
                out.close();
                socketConnection.close();
            }catch (Exception e){
                Log.d("ClosingException", e.getMessage(), e.getCause());
                return 400;
            }
        }

        return 200;
    }
}
