
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julio
 */
public class Consumidor extends Thread{
     private Buffer buffer; 
    
    public Consumidor (Buffer buf){
        
        this.buffer = buf; 
    }
    
    public void run(){
        
        
        while(true){
           
            try {
                String letr = this.buffer.Consumidor();
                System.out.println("El numero "+letr+ " seleccionado");
                sleep ((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
