/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class CompareJugadoresRend implements Comparator <Jugador>{

    public int compare(Jugador j1, Jugador j2) {
        
        if (j1.getRendimiento()>j2.getRendimiento()) return -1;
        else if (j1.getRendimiento()<j2.getRendimiento()) return 1;
        else{
            if (j1.getStats().getMinutos() == 0){
                if (j2.getStats().getMinutos() == 0) return 0;
                else return 1;
            }else{
                if (j2.getStats().getMinutos() == 0) return -1;
                else{
                    if (j1.getStats().getMinutos()<j2.getStats().getMinutos()) return -1;
                    else if (j1.getStats().getMinutos()>j2.getStats().getMinutos()) return 1;
                    else return 0;
                }
            }
        }
    }
   
}
