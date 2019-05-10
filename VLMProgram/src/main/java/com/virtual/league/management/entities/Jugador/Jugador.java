/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual.league.management.entities.Jugador;

import java.text.DecimalFormat;

import com.virtual.league.management.entities.Utils.Constantes;
import com.virtual.league.management.entities.Utils.Utils;

/**
 *
 * @author Antonio
 */
public abstract class Jugador implements Comparable<Jugador> {

        protected String nombre, nacionalidad, equipo;
        protected Constantes ctes;

        protected enum Posicion {
                gk, df, dm, mf, am, fw
        };
        protected Posicion pos;
        protected int edad, posInt, ag, salario, exp;
        protected Habilidad portero, defensa, medio, delantero;
        protected Estadisticas stats;
        protected double rendimiento;
        protected Integer[] medias = new Integer[4];

        public Jugador() {
                ctes = Constantes.getInstance();
        }

        public Jugador(String nombre, String nacionalidad, String equipo, int edad, int ag, int exp, Habilidad portero, Habilidad defensa, Habilidad medio, Habilidad delantero, Estadisticas stats) {
                this();
                this.setNombre(nombre);
                this.setNacionalidad(nacionalidad);
                this.setEquipo(equipo);
                this.setEdad(edad);
                this.setAg(ag);
                this.setExp(exp);
                this.setPortero(portero);
                this.setDefensa(defensa);
                this.setMedio(medio);
                this.setDelantero(delantero);
                this.setStats(stats);
                this.definirPosicion();
                this.definirPosInt();
                this.definirMedias();
                this.definirSalario();
                this.calcularRendimiento();
        }

        public Jugador(String lineaFichero, String nombreFichero) {
                this();
                this.setEquipo(nombreFichero);
                String[] cadena = lineaFichero.split("\\s+");
                this.setNombre(cadena[0]);
                this.setEdad(Integer.parseInt(cadena[1]));
                this.setNacionalidad(cadena[2]);
                setPortero(new Habilidad(Integer.parseInt(cadena[3]), Integer.parseInt(cadena[8])));
                setDefensa(new Habilidad(Integer.parseInt(cadena[4]), Integer.parseInt(cadena[9])));
                setMedio(new Habilidad(Integer.parseInt(cadena[5]), Integer.parseInt(cadena[10])));
                setDelantero(new Habilidad(Integer.parseInt(cadena[6]), Integer.parseInt(cadena[11])));
                setAg(Integer.parseInt(cadena[7]));
                int[] statistics = new int[15];
                int g = 12;
                for (int i = 0; i < 15; i++) {
                        statistics[i] = Integer.parseInt(cadena[g]);
                        g++;
                }
                setStats(new Estadisticas(statistics));
                this.definirMedias();
                this.definirSalario();
                this.calcularRendimiento();
        }

        public Jugador(Jugador j) {
                this();
                this.nombre = j.nombre;
                this.nacionalidad = j.nacionalidad;
                this.equipo = j.equipo;
                this.pos = j.pos;
                this.ag = j.ag;
                this.edad = j.edad;
                this.posInt = j.posInt;
                this.portero = j.portero;
                this.defensa = j.defensa;
                this.medio = j.medio;
                this.delantero = j.delantero;
                this.stats = j.stats;
                this.definirPosicion();
                this.definirPosInt();
                this.definirMedias();
                this.definirSalario();
                this.calcularRendimiento();
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getNacionalidad() {
                return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
                this.nacionalidad = nacionalidad;
        }

        public String getEquipo() {
                return equipo;
        }

        public void setEquipo(String equipo) {
                this.equipo = equipo;
        }

        public Posicion getPos() {
                return pos;
        }

        public void setPos(Posicion pos) {
                this.pos = pos;
        }

        public int getEdad() {
                return edad;
        }

        public void setEdad(int edad) {
                this.edad = edad;
        }

        public int getPosInt() {
                return posInt;
        }

        public void setPosInt(int posInt) {
                this.posInt = posInt;
        }

        public int getAg() {
                return ag;
        }

        public void setAg(int ag) {
                this.ag = ag;
        }

        public int getSalario() {
                return salario;
        }

        public void setSalario(int salario) {
                this.salario = salario;
        }

        public int getExp() {
                return exp;
        }

        public void setExp(int exp) {
                this.exp = exp;
        }

        public Habilidad getPortero() {
                return portero;
        }

        public void setPortero(Habilidad portero) {
                this.portero = portero;
        }

        public Habilidad getDefensa() {
                return defensa;
        }

        public void setDefensa(Habilidad defensa) {
                this.defensa = defensa;
        }

        public Habilidad getMedio() {
                return medio;
        }

        public void setMedio(Habilidad medio) {
                this.medio = medio;
        }

        public Habilidad getDelantero() {
                return delantero;
        }

        public void setDelantero(Habilidad delantero) {
                this.delantero = delantero;
        }

        public Estadisticas getStats() {
                return stats;
        }

        public void setStats(Estadisticas stats) {
                this.stats = stats;
        }

        public double getRendimiento() {
                return rendimiento;
        }

        public void setRendimiento(double rendimiento) {
                this.rendimiento = rendimiento;
        }

        public int[] getMedias() {
                int[] aMedias = new int[medias.length];
                for (int i = 0; i < aMedias.length; i++) {
                        aMedias[i] = medias[i];
                }
                return aMedias;
        }

        public void setMedias(int[] medias) {
                for (int i = 0; i < medias.length; i++) {
                        this.medias[i] = medias[i];
                }

        }

        private String espacios() {
                String space = new String();
                space = " ";
                return space;
        }

        private String espaciosStats(int stat) {
                String espacio = new String();
                if (stat < 100) {
                        if (stat < 10) {
                                espacio = espacio + espacios();
                        }
                        espacio = espacio + espacios();
                }
                espacio = espacio + espacios() + stat;
                return espacio;
        }

        private String espaciosMin(int stat) {
                String espacio = new String();
                if (stat < 1000) {
                        if (stat < 100) {
                                if (stat < 10) {
                                        espacio = espacio + espacios();
                                }
                                espacio = espacio + espacios();
                        }
                        espacio = espacio + espacios();
                }
                espacio = espacio + espacios() + stat;
                return espacio;
        }

        private String espaciosMedias(int stat) {
                String aux = new String();
                if (stat < 10) {
                        aux = aux + espacios();
                }
                aux = aux + espacios() + stat;
                return aux;
        }

        public String toString() {
                String prueba = new String();
                prueba = this.getNombre();
                for (int i = this.getNombre().length(); i < 14; i++) {
                        prueba = prueba + espacios();
                }
                prueba = prueba + this.getEdad() + espacios() + this.getNacionalidad();
                prueba = prueba + espaciosMedias(this.getPortero().getMedia());
                prueba = prueba + espaciosMedias(this.getDefensa().getMedia());
                prueba = prueba + espaciosMedias(this.getMedio().getMedia());
                prueba = prueba + espaciosMedias(this.getDelantero().getMedia());
                prueba = prueba + espacios() + this.getAg();
                prueba = prueba + espaciosStats(this.getPortero().getExperiencia());
                prueba = prueba + espaciosStats(this.getDefensa().getExperiencia());
                prueba = prueba + espaciosStats(this.getMedio().getExperiencia());
                prueba = prueba + espaciosStats(this.getDelantero().getExperiencia());
                prueba = prueba + espaciosStats(this.getStats().getpJugados());
                prueba = prueba + espaciosStats(this.getStats().getpSuplente());
                prueba = prueba + espaciosMin(this.getStats().getMinutos());
                prueba = prueba + espaciosStats(this.getStats().getMom());
                prueba = prueba + espaciosStats(this.getStats().getParadas());
                prueba = prueba + espaciosStats(this.getStats().getEncajados());
                prueba = prueba + espaciosStats(this.getStats().getTackles());
                prueba = prueba + espaciosStats(this.getStats().getPases());
                prueba = prueba + espaciosStats(this.getStats().getTiros());
                prueba = prueba + espaciosStats(this.getStats().getGoles());
                prueba = prueba + espaciosStats(this.getStats().getAsistencias());
                prueba = prueba + espaciosStats(this.getStats().getDp());
                prueba = prueba + espaciosStats(this.getStats().getLesion());
                prueba = prueba + espaciosStats(this.getStats().getSancion());
                prueba = prueba + espaciosStats(this.getStats().getFit());
                return prueba;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                }
                if (obj == null) {
                        return false;
                }
                if (getClass() != obj.getClass()) {
                        return false;
                }
                final Jugador other = (Jugador) obj;
                return (this.getNombre().equals(other.getNombre()) && this.getNacionalidad().equals(other.getNacionalidad()) && other.getEdad() == this.getEdad());
        }

        public void definirPosicion() {
                int maximaMedia = this.mediaMax();
                if (this.getPortero().getMedia() == maximaMedia) {
                        setPos(Posicion.gk);
                } else {
                        if (this.getDefensa().getMedia() == maximaMedia) {
                                if (this.getMedio().getMedia() == maximaMedia) {
                                        if (this.getDelantero().getMedia() == maximaMedia) {
                                                int maximaExp = Math.max(this.getDefensa().getExperiencia(), Math.max(this.getMedio().getExperiencia(), this.getDelantero().getExperiencia()));
                                                if (this.getDefensa().getExperiencia() == maximaExp) {
                                                        setPos(Posicion.df);
                                                } else if (this.getMedio().getExperiencia() == maximaExp) {
                                                        setPos(Posicion.mf);
                                                } else {
                                                        setPos(Posicion.fw);
                                                }
                                        } else {
                                                int maximaExp = Math.max(this.getDefensa().getExperiencia(), this.getMedio().getExperiencia());
                                                if (this.getDefensa().getExperiencia() == maximaExp) {
                                                        setPos(Posicion.df);
                                                } else {
                                                        setPos(Posicion.dm);
                                                }
                                        }
                                } else {
                                        if (this.getDelantero().getMedia() == maximaMedia) {
                                                int maximaExp = Math.max(this.getDefensa().getExperiencia(), this.getDelantero().getExperiencia());
                                                if (this.getDefensa().getExperiencia() == maximaExp) {
                                                        setPos(Posicion.df);
                                                } else {
                                                        setPos(Posicion.fw);
                                                }
                                        } else {
                                                setPos(Posicion.df);
                                        }
                                }
                        } else {
                                if (this.getMedio().getMedia() == maximaMedia) {
                                        if (this.getDelantero().getMedia() == maximaMedia) {
                                                int maximaExp = Math.max(this.getMedio().getExperiencia(), this.getDelantero().getExperiencia());
                                                if (this.getMedio().getExperiencia() == maximaExp) {
                                                        setPos(Posicion.am);
                                                } else {
                                                        setPos(Posicion.fw);
                                                }
                                        } else {
                                                if (((this.getDelantero().getMedia() - this.getDefensa().getMedia()) <= -4) && (this.getMedio().getMedia() - this.getDefensa().getMedia() <= 5)) {
                                                        setPos(Posicion.dm);
                                                } else if (((this.getDelantero().getMedia() - this.getDefensa().getMedia()) >= 4) && (this.getMedio().getMedia() - this.getDelantero().getMedia() <= 5)) {
                                                        setPos(Posicion.am);
                                                } else {
                                                        setPos(Posicion.mf);
                                                }
                                        }
                                } else {
                                        setPos(Posicion.fw);
                                }
                        }
                }
        }

        public int mediaMax() {
                return this.medias[0];
        }

        public void definirPosInt() {
                if (null != pos) {
                        switch (pos) {
                                case gk:
                                        setPosInt(1);
                                        break;
                                case df:
                                        setPosInt(2);
                                        break;
                                case dm:
                                        setPosInt(3);
                                        break;
                                case mf:
                                        setPosInt(4);
                                        break;
                                case am:
                                        setPosInt(5);
                                        break;
                                default:
                                        setPosInt(6);
                                        break;
                        }
                }
        }

        public double calcularCalidadActual() {
                double[] multMedia = {50, 70, 100, 150, 250, 400, 600, 1000, 1500, 2200, 2700, 3000};
                return Integer.parseInt(Constantes.getInstance().getConstante("valorCA" + this.mediaMax()));//multMedia[this.mediaMax() - 16];
        }

        public double calcularPotencial() {
                double multEdad = -1;
                double[] multMedia = {50, 70, 100, 150, 250, 400, 600, 1000, 1500, 2200, 2700, 3000};
                for (int i = 1; i <= ctes.getConstanteInt("edadesPotenciales") && multEdad < 0; i++) {
                        if (Utils.menorIgualQue(this.getEdad(), ctes.getConstanteInt("edadesPotenciales" + i))) {
                                multEdad = ctes.getConstanteInt("multiplicadorPotenciales" + i);
                        }
                }
                /*       if (this.getEdad() < 36) {
                                if (this.getEdad() < 34) {
                                        if (this.getEdad() < 30) {
                                                if (this.getEdad() < 24) {
                                                        if (this.getEdad() < 21) {
                                                                multEdad = 0.7;
                                                        } else {
                                                                multEdad = 0.8;
                                                        }
                                                } else {
                                                        multEdad = 1;
                                                }
                                        } else {
                                                multEdad = 0.6;
                                        }
                                } else {
                                        multEdad = 0.4;
                                }
                        } else {
                                multEdad = 0.3;
                        }*/

                return multEdad * Integer.parseInt(Constantes.getInstance().getConstante("valorPotencial" + this.mediaMax())); //multMedia[this.mediaMax() - 16];
        }

        public double promPartido(double dato) {
                return (dato / this.getStats().getpJugados());
        }

        public abstract double calcularRendimiento();

        public void definirMedias() {
                Integer[] medias = {this.getPortero().getMedia(), this.getDefensa().getMedia(), this.getMedio().getMedia(), this.getDelantero().getMedia()};
                Utils.ordenarArrayEnteros(medias);
                this.medias = medias;
        }

        public void calcularExpTest(double rendMedio) {
                double parteMinutos, parteRend;
                parteMinutos = ((double) this.getStats().getMinutos() / 5) - (getEdad() * 20) * (1 - ((double) this.medias[0] / 50));
                parteRend = ((getRendimiento() - rendMedio) * 15);
                setExp((int) (parteMinutos * 0.3 + parteRend * 0.7));
        }

        public void definirSalario() {
                setSalario(0);
                int suma = ctes.getConstanteInt("salariosMedia" + this.mediaMax());
                /* switch (this.medias[0]) {
                        case 16:
                                suma = 180000;
                                break;
                        case 17:
                                suma = 350000;
                                break;
                        case 18:
                                suma = 685000;
                                break;
                        case 19:
                                suma = 975000;
                                break;
                        case 20:
                                suma = 1150000;
                                break;
                        case 21:
                                suma = 2950000;
                                break;
                        case 22:
                                suma = 6055000;
                                break;
                        case 23:
                                suma = 9500000;
                                break;
                        case 24:
                                suma = 14500000;
                                break;
                        case 25:
                                suma = 19500000;
                                break;
                        case 26:
                                suma = 23500000;
                                break;
                }*/
                if (this.medias[1] - 1 > 0) {
                        suma += (this.medias[1] - 1) * ctes.getConstanteInt("valorSecundaria");
                }
                if (this.medias[2] - 1 > 0) {
                        suma += (this.medias[1] - 1) * ctes.getConstanteInt("valorSecundaria");
                }
                double mult = -1;
                for (int i = 1; i <= ctes.getConstanteInt("edadesSalarios") && mult < 0; i++) {
                        if (this.edad <= ctes.getConstanteInt("edadesSalarios" + i)) {
                                mult = ctes.getConstanteInt("multiplicadorSalarios" + i);
                        }
                }
                /*  if ((getEdad() >= 24) && (getEdad() <= 26)) {
                        mult = 0.95;
                } else if ((getEdad() >= 27) && (getEdad() <= 29)) {
                        mult = 0.9;
                } else if ((getEdad() >= 30) && (getEdad() <= 33)) {
                        mult = 0.8;
                } else if ((getEdad() >= 34) && (getEdad() <= 36)) {
                        mult = 0.7;
                } else if ((getEdad() > 36)) {
                        mult = 0.6;
                }*/
                suma *= mult;
                setSalario((int) (suma));
        }

        @Override
        public int compareTo(Jugador j2) {
                int resultado = 0;
                if (getPosInt() < j2.getPosInt()) {
                        resultado = -1;
                } else if (getPosInt() > j2.getPosInt()) {
                        resultado = 1;
                } else {
                        switch (getPosInt()) {
                                case 1:
                                        resultado = j2.getPortero().compareTo(getPortero());
                                        break;
                                case 2:
                                        resultado = j2.getDefensa().compareTo(getDefensa());
                                        break;
                                case 3:
                                        resultado = j2.getMedio().compareTo(getMedio());
                                        break;
                                case 4:
                                        resultado = j2.getMedio().compareTo(getMedio());
                                        break;
                                case 5:
                                        resultado = j2.getMedio().compareTo(getMedio());
                                        break;
                                case 6:
                                        resultado = j2.getDelantero().compareTo(getDelantero());
                                        break;
                        }
                }
                if (resultado == 0) {
                        resultado = getNombre().compareTo(j2.getNombre());
                }
                if (resultado == 0) {
                        resultado = getNacionalidad().compareTo(j2.getNacionalidad());
                }
                if (resultado == 0) {
                        resultado = getEdad() - j2.getEdad();
                }
                return resultado;
        }

        public void sumarFit(int nFit) {
                getStats().setFit(getStats().getFit() + nFit);
        }

        public void aCeroStats(boolean sumarAnyo) {
                if (sumarAnyo) {
                        this.edad++;
                }
                this.stats.aCero();
        }

        public String toStringReducido() {
                return this.nombre + " (" + this.equipo.toLowerCase() + ")";
        }

        public Object[] jugadorEnteroTabulado() {
                Object[] array = {this.nombre, this.nacionalidad, this.edad, this.getPortero().getMedia(), this.getDefensa().getMedia(), this.getMedio().getMedia(), this.getDelantero().getMedia(),
                        this.ag, this.getPortero().getExperiencia(), this.getDefensa().getExperiencia(), this.getMedio().getExperiencia(), this.getDelantero().getExperiencia(),
                        this.getStats().getMinutos(), this.getStats().getpJugados(), this.getStats().getpSuplente(), this.getStats().getParadas(), this.getStats().getEncajados(),
                        this.getStats().getTackles(), this.getStats().getPases(), this.getStats().getTiros(), this.stats.getGoles(), this.stats.getAsistencias(), this.stats.getDp(),
                        this.stats.getLesion(), this.stats.getSancion(), this.stats.getFit()};
                return array;
        }

        public Object[] jugadorSalarioTabulado() {
                DecimalFormat df = new DecimalFormat("###.###,##");
                Object[] array = {this.nombre, this.nacionalidad, this.edad, df.format(this.salario) + "\u20ac"};
                //  df.format(this.salario) + "\u20ac";
                return array;
        }
}
