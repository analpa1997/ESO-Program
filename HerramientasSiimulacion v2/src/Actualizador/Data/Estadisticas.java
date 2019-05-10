/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizador.Data;

/**
 *
 * @author Antonio
 */
public class Estadisticas{
    private int minutos, pJugados, pSuplente;
    private int mom, paradas, encajados, tackles, pases, tiros, goles, asistencias;
    private int lesion, sancion, dp, fit;
    private double promAux;
    
    public Estadisticas (){
    
    }
    public Estadisticas (int[] stats){
        this.pJugados = stats[0];
        this.pSuplente = stats[1];
        this.minutos = stats[2];
        this.mom = stats[3];
        this.paradas = stats[4];
        this.encajados = stats[5];
        this.tackles = stats[6];
        this.pases = stats[7];
        this.tiros = stats[8];
        this.goles = stats[9];
        this.asistencias = stats[10];
        this.dp = stats[11];
        this.lesion = stats[12];
        this.sancion = stats[13];
        this.fit = stats[14];
    }
    // METODOS GET
    public double getPromedio(){
        return promAux;
    }
    public int getMinutos(){
        return minutos;
    }
    public int getJugados(){
        return pJugados;
    }
    public int getSuplente (){
        return pSuplente;
    }
    public int getMom () {
        return mom;
    }
    public int getParadas(){
        return paradas;
    }
    public int getEncajados (){
        return encajados;
    }
    public int getTackles () {
        return tackles;
    }
    public int getPases () {
        return pases;
    }
    public int getTiros() {
        return tiros;
    }
    public int getGoles() {
        return goles;
    }
    public int getAsistencias(){
        return asistencias;
    }
    public int getDP () {
        return dp;
    }
    public int getLesion() {
        return lesion;
    }
    public int getSancion(){
        return sancion;
    }
    public int getFit(){
        return fit;
    }
    
    // METODOS SET
    
    public void setPromedio(double prom){
        this.promAux = prom;
    }
    public void setMinutos (int minutos){
        this.minutos = minutos;
    }
    public void setPJugados (int i){
        this.pJugados = i;
    }
    public void setPSuplente (int i){
        this.pSuplente = i;
    }
    public void setMom (int i){
        this.mom = i;
    }
    public void setParadas (int i){
        this.paradas = i;
    }
    public void setEncajados (int i){
        this.encajados = i;
    }
    public void setTackles (int i){
        this.tackles = i;
    }
    public void setPases (int i){
        this.pases = i;
    }
    public void setTiros (int i){
        this.tiros = i;
    }
    public void setGoles (int i){
        this.goles = i;
    }
    public void setAsistencias (int i){
        this.asistencias = i;
    }
    public void setDP (int i){
        this.dp = i;
    }
    public void setLesion (int i){
        if (i<0) lesion = 0;
        else this.lesion = i;
    }
    public void setSancion (int i){
        if (i<0) sancion = 0;
        else this.sancion = i;
    }
    public void setFit (int i){
        if (i>100){
            this.fit = 100;
        }
        else if (i<0){
            this.fit = 0;
        }
        else{this.fit = i;}
    }
    public int compararStats(Estadisticas e, int estadistica){
        double contEstadisticas1 [] = {e.goles, (double)e.goles/(double)e.minutos, (double)e.goles/(double)e.pJugados,
                                       e.encajados, (double)e.encajados/(double)e.minutos, (double)e.encajados/(double)e.pJugados,
                                       e.paradas, (double)e.paradas/(double)e.minutos, (double)e.paradas/(double)e.pJugados,
                                       e.tiros, e.tiros - e.goles, (double)e.tiros/(double)e.minutos, (double)e.tiros/(double)e.pJugados, 
                                       e.pases, (double)e.pases/(double)e.minutos, (double)e.pases/(double)e.pJugados,
                                       e.tackles, (double)e.tackles/(double)e.minutos, (double)e.tackles/(double)e.pJugados,
                                       e.asistencias, (double)e.asistencias/(double)e.minutos, (double)e.asistencias/(double)e.pJugados,
                                       e.pJugados, e.pSuplente, e.minutos, e.minutos, e.mom, e.dp, };
        double contEstadisticas2 [] = {this.goles, (double)this.goles/(double)this.minutos, (double)this.goles/(double)this.pJugados,
                                       this.encajados, (double)this.encajados/(double)this.minutos, (double)this.encajados/(double)this.pJugados,
                                       this.paradas, (double)this.paradas/(double)this.minutos, (double)this.paradas/(double)this.pJugados,
                                       this.tiros, this.tiros - this.goles, (double)this.tiros/(double)this.minutos, (double)this.tiros/(double)this.pJugados,
                                       this.pases, (double)this.pases/(double)this.minutos, (double)this.pases/(double)this.pJugados,
                                       this.tackles, (double)this.tackles/(double)this.minutos, (double)this.tackles/(double)this.pJugados,
                                       this.asistencias, (double)this.asistencias/(double)this.minutos, (double)this.asistencias/(double)this.pJugados,
                                       this.pJugados, this.pSuplente, this.minutos, this.minutos, this.mom, this.dp, };
        if (estadistica >=4 && (estadistica<=5)){
            return compararInteger(contEstadisticas2[estadistica], contEstadisticas1[estadistica], this.promAux, e.promAux);
        }else{
            return compararInteger(contEstadisticas1[estadistica], contEstadisticas2[estadistica], e.promAux, this.promAux);
        }
    }
    private double media (double[] numeros){
        double res = 0;
        for (double d: numeros){
            res += d;
        }
        return res / numeros.length;
    }
    private int compararPromedio (double prom1, double prom2, double[] stats1, double[] stats2){
        if (prom1>prom2) return 1;
        else if (prom1<prom2) return -1;
        else{
            int i = 0;
            while (i<stats1.length){
                if (stats1[i]>stats2[i]) return 1;
                else if (stats1[i] < stats2[i]) return -1;
                else i++;
            }
            return 0;
        }
    }
    private int compararInteger(double num1, double num2, double promMin1, double promMin2){
        if (num1>num2) return 1;
        else if (num1<num2) return -1;
        else {
            if (promMin1>promMin2 || (promMin2<0 && promMin1>0)) return 1;
            else if (promMin1<promMin2 || (promMin1<0 && promMin2>0)) return -1;
            else return 0;
        }
    }
}
