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
public class Buffer {
    private String []buffer;
    private int siguienteEn; 
    private boolean EstaVacio; 
    private boolean EstaLleno;

    public Buffer(int Tamano) {
        this.buffer = new String [Tamano]; 
        this.siguienteEn = siguienteEn = 0;
        this.EstaVacio = EstaVacio =true;
        this.EstaLleno = EstaLleno = false;
    }
    
    public synchronized String Consumidor(){
        
        while(this.EstaVacio){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        siguienteEn--; 
        this.EstaLleno = false; 
        if(siguienteEn==0){
            this.EstaVacio = true; 
        }
        notifyAll();
        
        return this.buffer[this.siguienteEn];    
    }
    
    
    public synchronized String pruductor(String palabra){
        
        while(this.EstaLleno){
            try { 
                //Hacemos una espera hasta que alguien lo consuma....
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        buffer[siguienteEn] = palabra; 
        siguienteEn++; 
        this.EstaVacio = false; 
        if (siguienteEn== this.buffer.length){
            this.EstaLleno = true; 
        }
        notifyAll();
        
        return this.buffer[this.siguienteEn]; 
    }
    
}
