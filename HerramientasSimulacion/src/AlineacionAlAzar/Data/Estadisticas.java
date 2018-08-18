package AlineacionAlAzar.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Antonio
 */
public class Estadisticas {

        private int minutos, pJugados, pSuplente, mom, paradas, encajados, tackles, pases, tiros, goles, asistencias, lesion, sancion, dp, fit;
        private double promAux;

        public int getMinutos() {
                return minutos;
        }

        public void setMinutos(int minutos) {
                this.minutos = minutos;
        }

        public int getpJugados() {
                return pJugados;
        }

        public void setpJugados(int pJugados) {
                this.pJugados = pJugados;
        }

        public int getpSuplente() {
                return pSuplente;
        }

        public void setpSuplente(int pSuplente) {
                this.pSuplente = pSuplente;
        }

        public int getMom() {
                return mom;
        }

        public void setMom(int mom) {
                this.mom = mom;
        }

        public int getParadas() {
                return paradas;
        }

        public void setParadas(int paradas) {
                this.paradas = paradas;
        }

        public int getEncajados() {
                return encajados;
        }

        public void setEncajados(int encajados) {
                this.encajados = encajados;
        }

        public int getTackles() {
                return tackles;
        }

        public void setTackles(int tackles) {
                this.tackles = tackles;
        }

        public int getPases() {
                return pases;
        }

        public void setPases(int pases) {
                this.pases = pases;
        }

        public int getTiros() {
                return tiros;
        }

        public void setTiros(int tiros) {
                this.tiros = tiros;
        }

        public int getGoles() {
                return goles;
        }

        public void setGoles(int goles) {
                this.goles = goles;
        }

        public int getAsistencias() {
                return asistencias;
        }

        public void setAsistencias(int asistencias) {
                this.asistencias = asistencias;
        }

        public int getLesion() {
                return lesion;
        }

        public void setLesion(int lesion) {
                this.lesion = lesion;
        }

        public int getSancion() {
                return sancion;
        }

        public void setSancion(int sancion) {
                this.sancion = sancion;
        }

        public int getDp() {
                return dp;
        }

        public void setDp(int dp) {
                this.dp = dp;
        }

        public int getFit() {
                return fit;
        }

        public void setFit(int fit) {
                if (fit > 100) {
                        fit = 100;
                } else if (fit < 0) {
                        fit = 0;
                }
                this.fit = fit;
        }

        public double getPromAux() {
                return promAux;
        }

        public void setPromAux(double promAux) {
                this.promAux = promAux;
        }

        public Estadisticas() {

        }

        public Estadisticas(int[] stats) {
                this();
                setpJugados(stats[0]);
                setpSuplente(stats[1]);
                setMinutos(stats[2]);
                setMom(stats[3]);
                setParadas(stats[4]);
                setEncajados(stats[5]);
                setTackles(stats[6]);
                setPases(stats[7]);
                setTiros(stats[8]);
                setGoles(stats[9]);
                setAsistencias(stats[10]);
                setDp(stats[11]);
                setLesion(stats[12]);
                setSancion(stats[13]);
                setFit(stats[14]);
        }

        public int compararStats(Estadisticas e, int estadistica) {
                double contEstadisticas1[] = {e.getGoles(), (double) e.getGoles() / (double) e.getMinutos(), (double) e.getGoles() / (double) e.getpJugados(),
                        e.getEncajados(), (double) e.getEncajados() / (double) e.getMinutos(), (double) e.getEncajados() / (double) e.getpJugados(),
                        e.getParadas(), (double) e.getParadas() / (double) e.getMinutos(), (double) e.getParadas() / (double) e.getpJugados(),
                        e.getTiros(), e.getTiros() - e.getGoles(), (double) e.getTiros() / (double) e.getMinutos(), (double) e.getTiros() / (double) e.getpJugados(),
                        e.getPases(), (double) e.getPases() / (double) e.getMinutos(), (double) e.getPases() / (double) e.getpJugados(),
                        e.getTackles(), (double) e.getTackles() / (double) e.getMinutos(), (double) e.getTackles() / (double) e.getpJugados(),
                        e.getAsistencias(), (double) e.getAsistencias() / (double) e.getMinutos(), (double) e.getAsistencias() / (double) e.getpJugados(),
                        e.getpJugados(), e.getpSuplente(), e.getMinutos(), e.getMinutos(), e.getMom(), e.getDp(),};
                double contEstadisticas2[] = {this.getGoles(), (double) this.getGoles() / (double) this.getMinutos(), (double) this.getGoles() / (double) this.getpJugados(),
                        this.getEncajados(), (double) this.getEncajados() / (double) this.getMinutos(), (double) this.getEncajados() / (double) this.getpJugados(),
                        this.getParadas(), (double) this.getParadas() / (double) this.getMinutos(), (double) this.getParadas() / (double) this.getpJugados(),
                        this.getTiros(), this.getTiros() - this.getGoles(), (double) this.getTiros() / (double) this.getMinutos(), (double) this.getTiros() / (double) this.getpJugados(),
                        this.getPases(), (double) this.getPases() / (double) this.getMinutos(), (double) this.getPases() / (double) this.getpJugados(),
                        this.getTackles(), (double) this.getTackles() / (double) this.getMinutos(), (double) this.getTackles() / (double) this.getpJugados(),
                        this.getAsistencias(), (double) this.getAsistencias() / (double) this.getMinutos(), (double) this.getAsistencias() / (double) this.getpJugados(),
                        this.getpJugados(), this.getpSuplente(), this.getMinutos(), this.getMinutos(), this.getMom(), this.getDp(),};
                if (estadistica >= 4 && (estadistica <= 5)) {
                        return compararInteger(contEstadisticas2[estadistica], contEstadisticas1[estadistica], this.getPromAux(), e.getPromAux());
                } else {
                        return compararInteger(contEstadisticas1[estadistica], contEstadisticas2[estadistica], e.getPromAux(), this.getPromAux());
                }
        }

        private int compararInteger(double num1, double num2, double promMin1, double promMin2) {
                if (num1 > num2) {
                        return 1;
                } else if (num1 < num2) {
                        return -1;
                } else {
                        if (promMin1 > promMin2 || (promMin2 < 0 && promMin1 > 0)) {
                                return 1;
                        } else if (promMin1 < promMin2 || (promMin1 < 0 && promMin2 > 0)) {
                                return -1;
                        } else {
                                return 0;
                        }
                }
        }
}
