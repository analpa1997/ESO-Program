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
public class CompareEquiposSalario implements Comparator <Equipo>{
    
    public int compare(Equipo e1, Equipo e2) {
        if (e1.getSalario()>e2.getSalario()) return -1;
        else if (e1.getSalario()<e2.getSalario()) return 1;
        else return 0;
    }
}
