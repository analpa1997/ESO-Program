/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import EquipoDep.Jugador.*;
import java.util.Comparator;
/**
 *
 * @author Antonio
 */
public class CompareStats implements Comparator <Jugador> {
    private int stat;
    public CompareStats(int stat){
        this.stat = stat;
    }
    public int compare(Jugador j1, Jugador j2){
        if ((stat/3 != 1) || (stat/3 != 2)){
            return j1.getStats().compararStats(j2.getStats(), this.stat);    
        }else{
            if (j1.getPosicion() == Posicion.gk){
                if (j2.getPosicion() == Posicion.gk){
                    return j1.getStats().compararStats(j2.getStats(), this.stat); 
                }else{
                    return 1;
                }
            }else{
                if (j2.getPosicion() == Posicion.gk){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
        
    }
}
