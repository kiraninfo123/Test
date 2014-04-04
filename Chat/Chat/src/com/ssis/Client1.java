package com.ssis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1 {
public void go(){
	try{
		Socket s = new Socket("127.0.0.1",5000);
		InputStreamReader is = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(is);
		String msg = br.readLine();
		System.out.println("msg is : " +msg);
		br.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
public static void main(String[] args) {
	Client1 c = new Client1();
	c.go();
}
}
