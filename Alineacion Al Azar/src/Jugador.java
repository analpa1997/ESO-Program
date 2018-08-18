/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
public class Jugador {

        private String nombre, nacionalidad, equipo;

        public enum Posicion {
                gk, df, dm, mf, am, fw
        };
        private Posicion pos;
        private int edad, posInt;
        private int ag = 30;
        private Habilidad portero, defensa, medio, delantero;
        private Estadisticas stats;
        private double rendimiento;
        private int[] medias = new int[4];
        private int salario;

        public Jugador() {
                portero = new Habilidad();
                defensa = new Habilidad();
                medio = new Habilidad();
                delantero = new Habilidad();
                stats = new Estadisticas();
        }

        public Jugador(Jugador j) {
                this.nombre = j.nombre;
                this.nacionalidad = j.nacionalidad;
                this.equipo = j.equipo;
                this.pos = j.pos;
                this.edad = j.edad;
                this.posInt = j.posInt;
                this.portero = j.portero;
                this.defensa = j.defensa;
                this.medio = j.medio;
                this.delantero = j.delantero;
                this.stats = j.stats;
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
                this.definirPosicion();
                this.definirPosInt();
                this.definirMedias();
        }

        public void definirPosInt() {
                if (null != pos) {
                        switch (pos) {
                                case gk:
                                        posInt = 1;
                                        break;
                                case df:
                                        posInt = 2;
                                        break;
                                case dm:
                                        posInt = 3;
                                        break;
                                case mf:
                                        posInt = 4;
                                        break;
                                case am:
                                        posInt = 5;
                                        break;
                                default:
                                        posInt = 6;
                                        break;
                        }
                }
        }

        public Posicion getPos() {
                return pos;
        }

        public void setPos(Posicion pos) {
                this.pos = pos;
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

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public void setNacionalidad(String nacionalidad) {
                this.nacionalidad = nacionalidad;
        }

        public void setEdad(int edad) {
                this.edad = edad;
        }

        public void setPosInt(int posInt) {
                this.posInt = posInt;
        }

        public void setStats(Estadisticas stats) {
                this.stats = stats;
        }

        public void setRendimiento(double rendimiento) {
                this.rendimiento = rendimiento;
        }

        public int getAg() {
                return ag;
        }

        public void setAg(int ag) {
                this.ag = ag;
        }

        public String getNombre() {
                return nombre;
        }

        public String getEquipo() {
                return equipo;
        }

        public void setEquipo(String abrev) {
                this.equipo = abrev;
        }

        public String getNacionalidad() {
                return nacionalidad;
        }

        public int getEdad() {
                return edad;
        }

        public Habilidad getGkSkills() {
                return portero;
        }

        public Habilidad getDfSkills() {
                return defensa;
        }

        public Habilidad getMfSkills() {
                return medio;
        }

        public Habilidad getFwSkills() {
                return delantero;
        }

        public Estadisticas getStats() {
                return stats;
        }

        public Posicion getPosicion() {
                return pos;
        }

        public int getPosInt() {
                return posInt;
        }

        public double getRendimiento() {
                return rendimiento;
        }

        public int[] getMedias() {
                return this.medias;
        }

        public double getSalario() {
                return this.salario;
        }

        public void setSalario(int wage) {
                this.salario = wage;
        }

        public void setMedias(int[] nMedias) {
                this.medias = nMedias;
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

        @Override
        public String toString() {
                String prueba = new String();
                prueba = this.nombre;
                for (int i = this.nombre.length(); i < 14; i++) {
                        prueba = prueba + espacios();
                }
                prueba = prueba + this.edad + espacios() + this.nacionalidad;
                prueba = prueba + espaciosMedias(this.portero.getMedia());
                prueba = prueba + espaciosMedias(this.defensa.getMedia());
                prueba = prueba + espaciosMedias(this.medio.getMedia());
                prueba = prueba + espaciosMedias(this.delantero.getMedia());
                prueba = prueba + espacios() + this.ag;
                prueba = prueba + espaciosStats(this.portero.getExperiencia());
                prueba = prueba + espaciosStats(this.defensa.getExperiencia());
                prueba = prueba + espaciosStats(this.medio.getExperiencia());
                prueba = prueba + espaciosStats(this.delantero.getExperiencia());
                prueba = prueba + espaciosStats(this.stats.getpJugados());
                prueba = prueba + espaciosStats(this.stats.getpSuplente());
                prueba = prueba + espaciosMin(this.stats.getMinutos());
                prueba = prueba + espaciosStats(this.stats.getMom());
                prueba = prueba + espaciosStats(this.stats.getParadas());
                prueba = prueba + espaciosStats(this.stats.getEncajados());
                prueba = prueba + espaciosStats(this.stats.getTackles());
                prueba = prueba + espaciosStats(this.stats.getPases());
                prueba = prueba + espaciosStats(this.stats.getTiros());
                prueba = prueba + espaciosStats(this.stats.getGoles());
                prueba = prueba + espaciosStats(this.stats.getAsistencias());
                prueba = prueba + espaciosStats(this.stats.getDp());
                prueba = prueba + espaciosStats(this.stats.getLesion());
                prueba = prueba + espaciosStats(this.stats.getSancion());
                prueba = prueba + espaciosStats(this.stats.getFit());
                return prueba;
        }

        public boolean equals(Jugador j) {
                return ((this.nombre.toLowerCase().equals(j.nombre.toLowerCase())) && (this.edad == j.edad) && (this.nacionalidad.toLowerCase().equals(j.nacionalidad.toLowerCase())));
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
                int[] medias = {this.getPortero().getMedia(), this.getDefensa().getMedia(), this.getMedio().getMedia(), this.getDelantero().getMedia()};
                int resultado = 0;
                for (int i : medias) {
                        resultado = Math.max(resultado, i);
                }
                return resultado;
        }

        public void definirMedias() {
                int[] medias = {this.getGkSkills().getMedia(), this.getDfSkills().getMedia(), this.getMfSkills().getMedia(), this.getFwSkills().getMedia()};
                for (int i : medias) {
                        if (i > this.medias[0]) {
                                this.medias[3] = this.medias[2];
                                this.medias[2] = this.medias[1];
                                this.medias[1] = this.medias[0];
                                this.medias[0] = i;
                        } else if (i > this.medias[1]) {
                                this.medias[3] = this.medias[2];
                                this.medias[2] = this.medias[1];
                                this.medias[1] = i;
                        } else if (i > this.medias[2]) {
                                this.medias[3] = this.medias[2];
                                this.medias[2] = i;
                        } else {
                                this.medias[3] = i;
                        }
                }
        }

        public boolean estaDisponible() {
                return (this.getStats().getFit() >= 80) && (this.getStats().getLesion() == 0) && (this.getStats().getSancion() == 0);
        }
}
