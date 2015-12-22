/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author tatoo
 */
public class SocketConnection {
    
    private int port_no;
    private String inform_sentence;

    
    public SocketConnection(int port_num){
        try{
            this.port_no=port_num;
            System.out.println("接続クライアント："+this.port_no+"/使用するポート："+this.port_no);
        }catch(NullPointerException e){
            System.out.println("接続する相手のアドレスまたはポート番号がうけとれませんでした");
        }
    }

    
    public void connection_start(){
        try{
            //サーバーソケットの生成
            ServerSocket serverSocket=new ServerSocket();
            
            //クライアントからの接続を待つ
            Socket socket=serverSocket.accept();      
            System.out.println(socket.getInetAddress()+"接続完了");
            
            //出力ストリームを取得
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 入力ストリームを取得
            InputStream	is = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ソケットの接続が確立されていません");
        }
        
    }
    
    
    
}
