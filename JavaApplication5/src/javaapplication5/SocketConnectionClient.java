/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tatoo
 */
public class SocketConnectionClient {
    private int port_num;
    private String server_ip;
    private String inform_sentence;

    
    public SocketConnectionClient(int port_Num){
        try{
            this.port_num=port_Num;
            System.out.println("接続クライアント："+this.port_num+"/使用するポート："+this.port_num);
        }catch(NullPointerException e){
            System.out.println("接続する相手のアドレスまたはポート番号がうけとれませんでした");
        }
    }

    
    public void connection_start(){
        try{
            //サーバーソケットの生成
            Socket Socket=new Socket();
            
            //クライアントからの接続を待つ
//            Socket socket=Socket.accept();      
//            System.out.println(socket.getInetAddress()+"接続完了");
//            
//            //出力ストリームを取得
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            // 入力ストリームを取得
//            InputStream	is = socket.getInputStream();
//            BufferedReader in = new BufferedReader(new InputStreamReader(is));

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ソケットの接続が確立されていません");
        }    
    }

    
}
