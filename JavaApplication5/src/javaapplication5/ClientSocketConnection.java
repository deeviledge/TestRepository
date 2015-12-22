/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.*;
import java.net.*;
/**
 *
 * @author tatoo
 */
public class ClientSocketConnection {
    private int port_num;
    private String server_ip;
    private String inform_sentence;
    private String send_data1;
    private String send_data2;
    

    
    public ClientSocketConnection(int port_Num,String server_Ip){
        try{
            this.port_num=port_Num;
            this.server_ip=server_Ip;
            System.out.println("接続するサーバIP："+this.server_ip+"/使用するポート："+this.port_num);
        }catch(NullPointerException e){
            System.out.println("接続する相手のアドレスまたはポート番号がうけとれませんでした");
        }
    }
    public String insert_data(String send_1){
            this.send_data1=send_1;
        return null;
    }
    public String insert_data(String send_Data1,String send_Data2){
            this.send_data1=send_Data1;
            this.send_data2=send_Data2;
        return null;
    }

    
    public void connection_start(){
        System.out.println("▼▼▼▼▼ソケット通信開始▼▼▼▼▼");
        try{
            //サーバーソケットの生成
            Socket socket=new Socket(server_ip,port_num);
            System.out.println("Socket生成完了/サーバーに接続要求を送信");
            
            /* サーバに年齢を送信する */
            ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(send_data1);
            oos.flush();

            /* サーバから判定結果を受信する */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String result = (String)ois.readObject();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ソケットの接続が確立されていません");
        }    
    }

    
}
//データの送信
//        ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
//        oos.writeObject(send_data);
//        oos.flush();
//
//データの受信
//        ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
//        (型宣言) receive_data = (キャスト)ois.readObject();
//        (型宣言) get_data = receive_data.intValue();
//        