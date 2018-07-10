/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenedor;
import java.util.*;
import java.io.*;

/**
 *
 * @author Antonio
 */
public class Calendario {
       private String nombre;
       private ArrayList<ArrayList<String[]>> partidos;
       
       public Calendario(){
           partidos = new ArrayList<ArrayList<String[]>>();
       }
       public ArrayList<String[]> getJornada (int j){
           return partidos.get(j);
       }
       public ArrayList<ArrayList<String[]>> getCalendario (){
           return partidos;
       }
       public String[] getPartido (int j, int partido){
           return partidos.get(j).get(partido);
       }
       public String getNombre(){
           return nombre;
       }
       public void setNombre (String name){
           nombre = name;
       }
       
       public void anadirPartido (int j, String[] partido){
           partidos.get(j).add(partido);
       }
       public void anadirJornada(ArrayList<String[]> jornada){
           partidos.add(jornada);
       }
       public String toString(){
           String res = new String();
           int i = 0;
           for (ArrayList<String[]> j: partidos){
               res = res + "" + ++i + "\n";
               for (String[] p: j){
                   res = res + p[0] + " - " + p[1] + "\n";
               }
           }
           return res;
       }
}
