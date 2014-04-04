package com.ssis;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
String smg[] = {"first msg","second msg","third msg"};
public void go(){
	try{
		ServerSocket s = new ServerSocket(5000);
		while (true){
			Socket sock = s.accept();
			PrintWriter pw = new PrintWriter(sock.getOutputStream());
			pw.write("hi sunil");
			pw.close();
			System.out.println("hi sunil");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	Server server  = new  Server();
	server.go();
}
}
