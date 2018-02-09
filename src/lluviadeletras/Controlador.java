/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluviadeletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 *
 * @author Jose
 */
public class Controlador extends KeyAdapter implements ItemListener{
    private Timer timer,timer2;
    private Vista v;
    private Modelo m;
    
    public Controlador(){
        v=new Vista(this);
        m=new Modelo(this);
        m.setYBarra(v.getYBarra());
        m.setXBarra(v.getXBarra());
        generarLetras();
        mover();
    }
    
    public void generarLetras(){
        timer=new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.generarLetras();
            }
        });
        timer.start();
    }
    
    public void mover(){
        timer2=new Timer(100,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.mover();
            }
        });
        timer2.start();
    }
    

    
    public boolean comprobarPos(int xletra, int yletra){
       return m.comprobarChoque(xletra,yletra);
    }
    /**
     * Mueve la barra
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                v.moverDerechaBarra();
                m.setXBarra(v.getXBarra());
                break;
            case KeyEvent.VK_LEFT:
                v.moverIzquierdaBarra();
                m.setXBarra(v.getXBarra());
                break;
            default:
                System.out.println(Character.toUpperCase(e.getKeyChar()));
                v.eliminarLetra(Character.toUpperCase(e.getKeyChar()));
                break;
        }
        
    }
    public void setXbarra(int x){
        m.setXBarra(x);
    }

    public void finTime(){
        timer.stop();
        timer2.stop();
    }
    public void comprobarSalida(int x, int y) {
            m.comprobarSalida(x, y);
        }
  

    
    public void cambiarNivel(int nivel){
        m.cambiarNivel(nivel);
    }
    
    public void actualizarV(int velocidad){
        v.actualizarVelocidad(velocidad);
    }
    
    public int incrementarMarcador(){
        return m.incrementarMarcador();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        v.cbmiFalse();
        v.cbmiTrue(e.getItem().toString());
        //m.cambiarNivel(Integer.parseInt(e.getItem().toString().split(" ")[1]));
        cambiarNivel(Integer.parseInt(e.getItem().toString().split(" ")[1]));
    }

}
