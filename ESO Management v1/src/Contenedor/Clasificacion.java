/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedor;
import EquipoDep.*;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class Clasificacion {
    ArrayList <EquipoClas> equipos;
    
    public Clasificacion(){
        equipos = new ArrayList();
    }
    public Clasificacion(ArrayList<EquipoClas> c){
        this();
        equipos = c;
    }
    public ArrayList<EquipoClas> getEquipos(){
        return equipos;
    }
    public void setEquipos (ArrayList<EquipoClas> c){
        equipos = c;
    }
    public EquipoClas buscarEquipoClas(String nombre){
        EquipoClas e = new EquipoClas();
        boolean encontrado = false;
        Iterator it = equipos.iterator();
        while (!encontrado && it.hasNext()){
            e = (EquipoClas) it.next();
            encontrado = (e.getEquipo().getNombre().equals(nombre));
        }
        return e;
    }
    
    public String toString(){
        String result = "";
        for (EquipoClas e: equipos){
            result = result + e.toString();
        }
        return result;
    }
}
