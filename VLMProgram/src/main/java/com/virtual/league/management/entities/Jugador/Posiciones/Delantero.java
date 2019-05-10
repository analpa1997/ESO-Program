package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;

public class Delantero extends Jugador {

    public Delantero(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.fw;
        this.posInt = Constantes.getInstance().getConstanteInt("posFW");
    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double p = Constantes.getInstance().getConstanteDouble("coefPasesFW");
        double g = Constantes.getInstance().getConstanteDouble("coefGolesFW");
        double t = Constantes.getInstance().getConstanteDouble("coefTirosFW");
        double e = Constantes.getInstance().getConstanteDouble("coefEntradasFW");
        double a = Constantes.getInstance().getConstanteDouble("coefAsistenciasFW");

        rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;

        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
