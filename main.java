/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julio
 */
public class main {
    
    public static void main(String[] args) {
        Buffer b = new Buffer(77); 
        Productor p = new Productor(b); 
        Consumidor c = new Consumidor(b);
        
        p.start(); 
        c.start(); 
    }
}
