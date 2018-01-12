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
public class CompareEquiposAZ implements Comparator <Equipo>{

    public int compare(Equipo e1, Equipo e2) {
       return e1.getAbrev().toLowerCase().compareTo(e2.getAbrev().toLowerCase());
    }
    
}
