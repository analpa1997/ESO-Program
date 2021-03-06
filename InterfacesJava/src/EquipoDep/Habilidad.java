/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;

/**
 *
 * @author Antonio
 */
public class Habilidad implements Comparable <Habilidad>{
    private int media, experiencia;
    
    public Habilidad(){
        media = experiencia = 0;
    }
    public Habilidad (int media, int experiencia){
        this.media = media;
        this.experiencia = experiencia;
    }
    public Habilidad (Habilidad hCopia){
        this(hCopia.media, hCopia.experiencia);
    }
    public int getMedia(){
        return media;
    }
    public int getExp (){
        return experiencia;
    }
    public void setMedia(int media){
        this.media = media;
    }
    public void setExp (int exp){
        experiencia = exp;
        while ((experiencia > 1000) || (experiencia < 0)){
            if (experiencia < 0){
                experiencia = experiencia + 1000;
                media = media -1;
            }else if(experiencia > 1000){
                experiencia = experiencia - 1000;
                media = media + 1;
            }
        }
        if (experiencia == 1000){
            experiencia = 1;
            media += 1;
        } else if (experiencia == 0){
            experiencia = 999;
            media -= 1;
        }
    }
    public int compareTo (Habilidad h){
        int resultado = 0;
        if (this.media < h.media) resultado = -1;
        else if (this.media > h.media)resultado = 1;
        else {
            if (this.experiencia < h.experiencia) resultado = -1;
            else if (this.experiencia > h.experiencia) resultado = 1;
            else resultado = 0;
        }
        return resultado;
    }
    public boolean equals (Habilidad h){
        return ((this.media == h.media) && (this.experiencia == h.experiencia));
    }
}
