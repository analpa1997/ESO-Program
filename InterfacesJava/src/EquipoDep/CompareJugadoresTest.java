/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import java.util.Comparator;
/**
 *
 * @author Antonio
 */
public class CompareJugadoresTest implements Comparator <Jugador>{
    
    public int compare (Jugador j1, Jugador j2){
        int resultado = 0;
        if (j1.getPosInt() < j2.getPosInt()) resultado = -1;
        else if (j1.getPosInt() > j2.getPosInt()) resultado = 1;
        else{
            if (j1.getExp()>j2.getExp()) resultado = -1;
            else if (j1.getExp()<j2.getExp()) resultado = 1;
            else resultado = 0;
        } 
        return resultado;
    }
}