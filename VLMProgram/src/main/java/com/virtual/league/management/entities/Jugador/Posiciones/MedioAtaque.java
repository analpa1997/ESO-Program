package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;

public class MedioAtaque extends Jugador {

    public MedioAtaque(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.am;
        this.posInt = Constantes.getInstance().getConstanteInt("posAM");
    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double p = Constantes.getInstance().getConstanteDouble("coefPasesAM");
        double g = Constantes.getInstance().getConstanteDouble("coefGolesAM");
        double t = Constantes.getInstance().getConstanteDouble("coefTirosAM");
        double e = Constantes.getInstance().getConstanteDouble("coefEntradasAM");
        double a = Constantes.getInstance().getConstanteDouble("coefAsistenciasAM");

        rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;

        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
