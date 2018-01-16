/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Jugador;

import javafx.beans.property.*;
/**
 *
 * @author Antonio
 */
public class Estadisticas {
        private IntegerProperty minutos, pJugados, pSuplente, mom, paradas, encajados, tackles, pases, tiros, goles, asistencias, lesion, sancion, dp, fit;
        private DoubleProperty promAux;

        /**
         * @return the minutos
         */
        public int getMinutos() {
                return minutos.get();
        }

        /**
         * @param minutos the minutos to set
         */
        public void setMinutos(int minutos) {
                this.minutos.set(minutos);
        }

        /**
         * @return the pJugados
         */
        public int getpJugados() {
                return pJugados.get();
        }

        /**
         * @param pJugados the pJugados to set
         */
        public void setpJugados(int pJugados) {
                this.pJugados.set(pJugados);
        }

        /**
         * @return the pSuplente
         */
        public int getpSuplente() {
                return pSuplente.get();
        }

        /**
         * @param pSuplente the pSuplente to set
         */
        public void setpSuplente(int pSuplente) {
                this.pSuplente.set(pSuplente);
        }

        /**
         * @return the mom
         */
        public int getMom() {
                return mom.get();
        }

        /**
         * @param mom the mom to set
         */
        public void setMom(int mom) {
                this.mom.set(mom);
        }

        /**
         * @return the paradas
         */
        public int getParadas() {
                return paradas.get();
        }

        /**
         * @param paradas the paradas to set
         */
        public void setParadas(int paradas) {
                this.paradas.set(paradas);
        }

        /**
         * @return the encajados
         */
        public int getEncajados() {
                return encajados.get();
        }

        /**
         * @param encajados the encajados to set
         */
        public void setEncajados(int encajados) {
                this.encajados.set(encajados);
        }

        /**
         * @return the tackles
         */
        public int getTackles() {
                return tackles.get();
        }

        /**
         * @param tackles the tackles to set
         */
        public void setTackles(int tackles) {
                this.tackles.set(tackles);
        }

        /**
         * @return the pases
         */
        public int getPases() {
                return pases.get();
        }

        /**
         * @param pases the pases to set
         */
        public void setPases(int pases) {
                this.pases.set(pases);
        }

        /**
         * @return the tiros
         */
        public int getTiros() {
                return tiros.get();
        }

        /**
         * @param tiros the tiros to set
         */
        public void setTiros(int tiros) {
                this.tiros.set(tiros);
        }

        /**
         * @return the goles
         */
        public int getGoles() {
                return goles.get();
        }

        /**
         * @param goles the goles to set
         */
        public void setGoles(int goles) {
                this.goles.set(goles);
        }

        /**
         * @return the asistencias
         */
        public int getAsistencias() {
                return asistencias.get();
        }

        /**
         * @param asistencias the asistencias to set
         */
        public void setAsistencias(int asistencias) {
                this.asistencias.set(asistencias);
        }

        /**
         * @return the lesion
         */
        public int getLesion() {
                return lesion.get();
        }

        /**
         * @param lesion the lesion to set
         */
        public void setLesion(int lesion) {
                this.lesion.set(lesion);
        }

        /**
         * @return the sancion
         */
        public int getSancion() {
                return sancion.get();
        }

        /**
         * @param sancion the sancion to set
         */
        public void setSancion(int sancion) {
                this.sancion.set(sancion);
        }

        /**
         * @return the dp
         */
        public int getDp() {
                return dp.get();
        }

        /**
         * @param dp the dp to set
         */
        public void setDp(int dp) {
                this.dp.set(dp);
        }

        /**
         * @return the fit
         */
        public int getFit() {
                return fit.get();
        }

        /**
         * @param fit the fit to set
         */
        public void setFit(int fit) {
                if (fit>100) this.fit.set(100);
                else if (fit<0) this.fit.set(0);
                else this.fit.set(fit);
                
                
        }

        /**
         * @return the promAux
         */
        public double getPromAux() {
                return promAux.get();
        }

        /**
         * @param promAux the promAux to set
         */
        public void setPromAux(double promAux) {
                this.promAux.set(promAux);
        }
        
        public Estadisticas (){
    
    }
    public Estadisticas (int[] stats){
        this.pJugados.set(stats[0]);
        this.pSuplente.set(stats[1]);
        this.minutos.set(stats[2]);
        this.mom.set(stats[3]);
        this.paradas.set(stats[4]);
        this.encajados.set(stats[5]);
        this.tackles.set(stats[6]);
        this.pases.set(stats[7]);
        this.tiros.set(stats[8]);
        this.goles.set(stats[9]);
        this.asistencias.set(stats[10]);
        this.dp.set(stats[11]);
        this.lesion.set(stats[12]);
        this.sancion.set(stats[13]);
        this.fit.set(stats[14]);
    }
    
    public int compararStats(Estadisticas e, int estadistica){
        double contEstadisticas1 [] = {e.getGoles(), (double)e.getGoles()/(double)e.getMinutos(), (double)e.getGoles()/(double)e.getpJugados(),
                                       e.getEncajados(), (double)e.getEncajados()/(double)e.getMinutos(), (double)e.getEncajados()/(double)e.getpJugados(),
                                       e.getParadas(), (double)e.getParadas()/(double)e.getMinutos(), (double)e.getParadas()/(double)e.getpJugados(),
                                       e.getTiros(), e.getTiros() - e.getGoles(), (double)e.getTiros()/(double)e.getMinutos(), (double)e.getTiros()/(double)e.getpJugados(), 
                                       e.getPases(), (double)e.getPases()/(double)e.getMinutos(), (double)e.getPases()/(double)e.getpJugados(),
                                       e.getTackles(), (double)e.getTackles()/(double)e.getMinutos(), (double)e.getTackles()/(double)e.getpJugados(),
                                       e.getAsistencias(), (double)e.getAsistencias()/(double)e.getMinutos(), (double)e.getAsistencias()/(double)e.getpJugados(),
                                       e.getpJugados(), e.getpSuplente(), e.getMinutos(), e.getMinutos(), e.getMom(), e.getDp(), };
        double contEstadisticas2 [] = {this.getGoles(), (double)this.getGoles()/(double)this.getMinutos(), (double)this.getGoles()/(double)this.getpJugados(),
                                       this.getEncajados(), (double)this.getEncajados()/(double)this.getMinutos(), (double)this.getEncajados()/(double)this.getpJugados(),
                                       this.getParadas(), (double)this.getParadas()/(double)this.getMinutos(), (double)this.getParadas()/(double)this.getpJugados(),
                                       this.getTiros(), this.getTiros() - this.getGoles(), (double)this.getTiros()/(double)this.getMinutos(), (double)this.getTiros()/(double)this.getpJugados(), 
                                       this.getPases(), (double)this.getPases()/(double)this.getMinutos(), (double)this.getPases()/(double)this.getpJugados(),
                                       this.getTackles(), (double)this.getTackles()/(double)this.getMinutos(), (double)this.getTackles()/(double)this.getpJugados(),
                                       this.getAsistencias(), (double)this.getAsistencias()/(double)this.getMinutos(), (double)this.getAsistencias()/(double)this.getpJugados(),
                                       this.getpJugados(), this.getpSuplente(), this.getMinutos(), this.getMinutos(), this.getMom(), this.getDp(), };
        if (estadistica >=4 && (estadistica<=5)){
            return compararInteger(contEstadisticas2[estadistica], contEstadisticas1[estadistica], this.getPromAux(), e.getPromAux());
        }else{
            return compararInteger(contEstadisticas1[estadistica], contEstadisticas2[estadistica], e.getPromAux(), this.getPromAux());
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
