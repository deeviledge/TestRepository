/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.net.*;

/**
 *
 * @author tatoo
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ServerSocket serverSocket=new ServerSocket();
            Socket socket=serverSocket.accept();      
            System.out.println(socket.getInetAddress()+"接続完了");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
