package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;

public class Defensa extends Jugador {

    public Defensa(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.df;
        this.posInt = Constantes.getInstance().getConstanteInt("posDF");
    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double p = Constantes.getInstance().getConstanteDouble("coefPasesDF");
        double g = Constantes.getInstance().getConstanteDouble("coefGolesDF");
        double t = Constantes.getInstance().getConstanteDouble("coefTirosDF");
        double e = Constantes.getInstance().getConstanteDouble("coefEntradasDF");
        double a = Constantes.getInstance().getConstanteDouble("coefAsistenciasDF");

        rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;
        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
