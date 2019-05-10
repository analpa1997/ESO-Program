package com.virtual.league.management.entities.Jugador.Posiciones;

import com.virtual.league.management.entities.Jugador.*;
import com.virtual.league.management.entities.Utils.Constantes;
import com.virtual.league.management.entities.Utils.Utils;

public class Portero extends Jugador {

    public Portero(String lineaFichero, String nombreFichero) {
        super(lineaFichero, nombreFichero);
        this.pos = Posicion.gk;
        this.posInt = Constantes.getInstance().getConstanteInt("posGK");
    }

    @Override
    public double calcularRendimiento() {
        double rendimiento;
        double par = Constantes.getInstance().getConstanteDouble("coefParadas");
        double enc = Constantes.getInstance().getConstanteDouble("coefEncajados");
        rendimiento = this.getStats().getParadas() * par - this.getStats().getEncajados() * enc;
        double multiplicador = (Constantes.getInstance().getConstanteInt("coefRendimiento") - (double) this.medias[0]) / 10;
        rendimiento *= multiplicador;
        setRendimiento(rendimiento);
        return rendimiento;
    }
}
