/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

/**
 *
 * @author casa
 */
public class Messenger {
    public static conector servidor,cliente;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Chat server= new Chat();
    server.main();
    
    }
    public static  void initserver()
    {
        servidor= new conector();
        servidor.start();
    }
   
}
