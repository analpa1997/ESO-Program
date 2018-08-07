/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        this.lesion = i;
    }
    public void setSancion (int i){
        this.sancion = i;
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
    
}
