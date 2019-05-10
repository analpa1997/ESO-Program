package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;

public class Medio extends Jugador {

    public Medio(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.mf;
        this.posInt = Constantes.getInstance().getConstanteInt("posMF");

    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double p = Constantes.getInstance().getConstanteDouble("coefPasesMF");
        double g = Constantes.getInstance().getConstanteDouble("coefGolesMF");
        double t = Constantes.getInstance().getConstanteDouble("coefTirosMF");
        double e = Constantes.getInstance().getConstanteDouble("coefEntradasMF");
        double a = Constantes.getInstance().getConstanteDouble("coefAsistenciasMF");

        rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;

        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
