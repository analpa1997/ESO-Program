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
public class CompareEquipoClas implements Comparator <EquipoClas> {

    @Override
    public int compare(EquipoClas e1, EquipoClas e2) {
        if (e1.getPuntos()>e2.getPuntos()) return -1;
        else if (e1.getPuntos()<e2.getPuntos()) return 1;
        else{
            if (e1.getDGoles()>e2.getDGoles()) return -1;
            else if (e1.getDGoles()<e2.getDGoles()) return 1;
            else{
                if (e1.getGFavor()>e2.getGFavor()) return -1;
                else if (e1.getGFavor()<e2.getGFavor()) return -1;
                else return e1.getEquipo().getNombre().compareTo(e2.getEquipo().getNombre());
            }
        }
    }
    
}
