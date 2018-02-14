/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluviadeletras;


/**
 *
 * @author Jose
 */
public class Modelo {
    private Controlador c;
    private int marcador, velocidad=1, nivel=1, numLetras;
    private int xbarra,ybarra,lado = 20, ladobarra=50;

    
    public Modelo(Controlador c) {
        this.c=c;
        
    }
    
   
    
    

    /**
     * comprueba si la letra ha chocado con la barra
     *
     * @param xletra
     * @param yletra
     * @return
     */
    public boolean comprobarChoque(int xletra, int yletra) {
        if ((yletra + lado) >= ybarra) {
            if ((xletra + lado) >= xbarra && xletra <= (xbarra + ladobarra)) {
                //ha chocado con la barra
                return true;
            } else {
                //no se ha chocado con la barra.
                finJuego(1);
                return false;
            }
        }
        return false;

    }
    public void setXBarra(int x){
        xbarra=x;
    }
    public void setYBarra(int y){
        ybarra=y;
    }

    /**
     * COmprueba si la letra se ha salido de la ventana por arriba
     * @param x
     * @param y
     */
    public void comprobarSalida(int x, int y) {
        if (y<0) {
            finJuego(2);
        }
    }

    /**
     * Finaliza la ejecucion del programa
     * @param n parametro que indicara en que momento se ha llamado a esta funcion.
     */
    private void finJuego(int n) {
        c.finTime();
        System.exit(n);
    }
    /**
     * Establece el nivel en el modelo y llama a actualizar velocidad de la vista
     * @param nivel 
     */
    public void cambiarNivel(int nivel){
        this.nivel=nivel;
        modifVelocidad();
        c.actualizarV(velocidad);
    }
    /**
     * Ajusta la velocidad de caida de la letra al nivel.
     */
    public void modifVelocidad(){
        velocidad=nivel;
    }
    /**
     * Aumenta el marcador
     * @return devuelve el numero del marcador
     */
    public int incrementarMarcador(){
        marcador++;
        return marcador;

    }
    /**
     * Disminuye el marcador
     * @return devuelve el valor del marcador
     */
    public int restarMarcador(){
        marcador--;
        return marcador;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
}
