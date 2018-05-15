/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messengerc;
import messengerC.ventanaC;
/**
 *
 * @author casa
 */
public class Messenger {
    public static conector cliente;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    ventanaC server=new ventanaC();
    server.main();
    
    }
    
    public static void initCliente(String ip)
    {System.out.println(ip);
        cliente= new conector(ip);
        cliente.start();
    }
}
