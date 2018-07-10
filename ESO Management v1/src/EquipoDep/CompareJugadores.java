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
public class CompareJugadores implements Comparator <Jugador>{
    
    public int compare (Jugador j1, Jugador j2){
        int resultado = 0;
        if (j1.getPosInt() < j2.getPosInt()) resultado = -1;
        else if (j1.getPosInt() > j2.getPosInt()) resultado = 1;
        else{
            switch (j1.getPosInt()){
                case 1: resultado = j2.getGkSkills().compareTo(j1.getGkSkills()); break;
                case 2: resultado = j2.getDfSkills().compareTo(j1.getDfSkills()); break;
                case 3: resultado = j2.getMfSkills().compareTo(j1.getMfSkills()); break;
                case 4: resultado = j2.getMfSkills().compareTo(j1.getMfSkills()); break;
                case 5: resultado = j2.getMfSkills().compareTo(j1.getMfSkills()); break;
                case 6: resultado = j2.getFwSkills().compareTo(j1.getFwSkills()); break;
            }
        } 
        return resultado;
    }
}
