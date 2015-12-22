/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tatoo
 */
public class ServerSocketConnection {
    
    private int port_num;
    private String client_ip;
    private String inform_sentence;
    
    
    public ServerSocketConnection(int port_Num,String client_Ip){
        try{
            this.port_num=port_Num;
            this.client_ip=client_Ip;
            System.out.println("接続するクライアントIP："+this.client_ip+"/使用ポート："+this.port_num);
        }catch(NullPointerException e){
            System.out.println("接続する相手のアドレスまたはポート番号がうけとれませんでした");
        }
    }

    
    public void connection_start(){
        System.out.println("▼▼▼▼▼ソケット通信開始▼▼▼▼▼");
        try{
            //サーバーソケットの生成
            ServerSocket serverSocket=new ServerSocket();
            System.out.println("ServerSocket生成完了/ポートを監視中");
            
            //クライアントからの接続を待つ
            Socket socket=serverSocket.accept();  
            System.out.println(socket.getInetAddress()+"接続完了");//接続先のあd例を返して表示
            
            /* 年齢を受信する */
            ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
            Integer data = (Integer)ois.readObject();

            /* 飲酒の可否を判定する */
           //受け取ったデータのなんかしらの処理
            
            /* 判定結果をクライアントに送信する */
            ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(data);//送信したいデータのをソケットオブジェクトへ書き出す
            oos.flush();//書き出したデータを送り出す
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ソケットの接続が確立されていません");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerSocketConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ObjectInputStreamまたはObjectOutputStreamが生成できません");
        }
        
    }
}
//データの送信
//        ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
//        oos.writeObject(send_data);//送信したいデータのをソケットオブジェクトへ書き出す
//        oos.flush();//書き出したデータ(メモリ上に待機)を送り出す
//
//データの受信
//        ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
//        (型宣言) receive_data = (キャスト)ois.readObject();//読み込みの際は必ずキャストする
//        (型宣言) get_data = receive_data.intValue();
//      
//
//