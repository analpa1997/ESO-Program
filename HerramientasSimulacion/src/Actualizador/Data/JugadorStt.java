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
public class JugadorStt {
    public String nombre;
    public int jugados, suplente, minutos, mom, paradas, encajados, tackles, pases, tiros, goles, assists, dp, lesion, expGK, expDF, expMF, expFW, fit;
    
    public JugadorStt(){
        
    }
    public JugadorStt (String [] cadena){
        nombre = cadena[0];
        jugados = Integer.parseInt(cadena[1]);
        suplente = Integer.parseInt(cadena[2]);
        minutos = Integer.parseInt(cadena[3]);
        mom = Integer.parseInt(cadena[4]);
        paradas = Integer.parseInt(cadena[5]);
        encajados = Integer.parseInt(cadena[6]);
        tackles = Integer.parseInt(cadena[7]);
        pases = Integer.parseInt(cadena[8]);
        tiros = Integer.parseInt(cadena[9]);
        goles = Integer.parseInt(cadena[10]);
        assists = Integer.parseInt(cadena[11]);
        dp = Integer.parseInt(cadena[12]);
        lesion = Integer.parseInt(cadena[13]);
        expGK = Integer.parseInt(cadena[14]);
        expDF = Integer.parseInt(cadena[15]);
        expMF = Integer.parseInt(cadena[16]);
        expFW = Integer.parseInt(cadena[17]);
        fit = Integer.parseInt(cadena[19]);
    }
    
    public String toString(){
        String s = "";
        s = nombre + "\n";
        s += "Partidos jugados: " + jugados + "\n";
        s += "Partidos suplente: " + suplente + "\n";
        s += "Minutos: " + minutos + "\n";
        s += "Mom: " + mom + "\n";
        s += "Paradas: " + paradas + "\n";
        s += "Encajados: " + encajados + "\n";
        s += "Tackles: " + tackles + "\n";
        s += "Pases: " + pases + "\n";
        s += "Tiros: " + tiros + "\n";
        s += "Goles: " + goles + "\n";
        s += "Asistencias: " + assists + "\n";
        s += "DP: " + dp + "\n";
        s += "Lsion: " + lesion + "\n";
        s += "ExpGK: " + expGK + "\n";
        s += "ExpDF: " + expDF + "\n";
        s += "ExpMF: " + expMF + "\n";
        s += "ExpFW: " + expFW + "\n";
        s += "Fit: " + fit + "\n";
        return s;
    }
}
