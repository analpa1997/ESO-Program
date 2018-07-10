/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import java.io.*;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class BonusMinutos {
    private ArrayList <ArrayList <int[]>> bonus = new ArrayList();
    
    public BonusMinutos (){
        
    }
    public BonusMinutos(BufferedReader b) throws IOException{
        String cadena = new String();
        
        for (int i = 0; i<10; i++){
            ArrayList <int[]> media = new ArrayList();
            int j = 0;
            while (j<7){
                cadena = b.readLine();
                StringTokenizer cadena2 = new StringTokenizer(cadena);
                int k = 0;
                int [] lineaBonus = new int [6];
                while (cadena2.hasMoreTokens() && k<6){
                    int token = Integer.parseInt(cadena2.nextToken());
                    lineaBonus[k] = token;
                    k++;
                }
                media.add(lineaBonus);
                j++;
            }
            bonus.add(media);
        }
    }
    public ArrayList <ArrayList<int[]>> getBonus(){
        return bonus;
    }
    public void setBonus (ArrayList<ArrayList<int[]>> nBonus){
        this.bonus = nBonus;
    }
}
