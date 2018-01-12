/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import java.util.*;
/**
 *
 * @author usuario
 */
public class CompareEquiposNumJ implements Comparator <Equipo>{

    @Override
    public int compare(Equipo e1, Equipo e2) {
        if (e1.getRoster().size()>e2.getRoster().size()) return -1;
        else if (e1.getRoster().size()<e2.getRoster().size()) return 1;
        else return 0;
    }
    
}
