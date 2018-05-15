/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casa
 */
public class conector extends Thread {
    private Socket s;
    private ServerSocket ss;       
    private InputStreamReader entradasocket;
    private DataOutputStream salida;       
    private BufferedReader entrada;
    private int puerto=8000;
   
    public conector(){
      try{
         ss=new ServerSocket(puerto);
         s=ss.accept();
         entradasocket=new InputStreamReader(s.getInputStream());
         entrada=new BufferedReader(entradasocket);
         salida=new DataOutputStream(s.getOutputStream());
     }   catch(Exception e){}
    }
    public void run(){
        String text;  
    while(true){
       try {
             text=entrada.readLine();
             Chat.jTextArea1.setText(Chat.jTextArea1.getText()+"\n"+text);
        } catch (IOException ex) {}
             }
    }
    
    public void envMSG(String str)
    {
        try {
            
            salida.writeUTF(str+"\n");
        } catch (IOException ex) {}
    }
    public String LeerMSG(){
        try {
            return entrada.readLine();
        } catch (IOException ex) {}
        return null;
    }
    public void desconectar()
    {
        try {
            s.close();
        } catch (IOException ex) {}
        try {
            ss.close();
        } catch (IOException ex) {}
    }
}
