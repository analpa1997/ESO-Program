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
public class CompareJugadoresSalario implements Comparator <Jugador> {

    public int compare(Jugador j1, Jugador j2) {
        if (j1.getSalario()>j2.getSalario()) return -1;
        else if (j1.getSalario()<j2.getSalario()) return 1;
        else return 0;
    }
    
}
