package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;

public class MedioDefensa extends Jugador {

    public MedioDefensa(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.dm;
        this.posInt = Constantes.getInstance().getConstanteInt("posDM");
    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double p = Constantes.getInstance().getConstanteDouble("coefPasesDM");
        double g = Constantes.getInstance().getConstanteDouble("coefGolesDM");
        double t = Constantes.getInstance().getConstanteDouble("coefTirosDM");
        double e = Constantes.getInstance().getConstanteDouble("coefEntradasDM");
        double a = Constantes.getInstance().getConstanteDouble("coefAsistenciasDM");

        rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;

        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
