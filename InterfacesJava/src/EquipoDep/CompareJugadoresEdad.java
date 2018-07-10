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
public class CompareJugadoresEdad implements Comparator<Jugador>{

    public int compare(Jugador j1, Jugador j2) {
        if (j1.getEdad()<j2.getEdad()) return 1;
        else if (j2.getEdad()<j1.getEdad()) return -1;
        else return 0;
    }
    
}
