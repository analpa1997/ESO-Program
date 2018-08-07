/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Jugador;

/**
 *
 * @author Antonio
 */
public class Jugador implements Comparable<Jugador> {

        private String nombre, nacionalidad, equipo;

        public enum Posicion {
                gk, df, dm, mf, am, fw
        };
        private Posicion pos;
        private int edad, posInt, ag, salario, exp;
        private Habilidad portero, defensa, medio, delantero;
        private Estadisticas stats;
        private double rendimiento;
        private int[] medias = new int[4];

        public Jugador() {

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
                return (this.getNombre() == other.getNombre() && this.getNacionalidad() == other.getNacionalidad() && other.getEdad() == this.getEdad());
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

        public double calcularPotencial() {
                double multEdad = 0;
                double[] multMedia = {50, 80, 120, 180, 260, 400, 600, 900, 1340, 2000};
                if (this.getEdad() < 36) {
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
                }
                return multEdad * multMedia[this.mediaMax() - 16];
        }

        public double promPartido(double dato) {
                return (dato / this.getStats().getpJugados());
        }

        public double calcularRendimiento() {
                double rendimiento;
                double p = 0, g = 0, t = 0, e = 0, a = 0;
                switch (getPosInt()) {
                        case 1:
                                double par = 0.7,
                                 enc = 1.8;
                                rendimiento = this.getStats().getParadas() * par - this.getStats().getEncajados() * enc;
                                break;
                        case 2:
                                p = 0.23;
                                g = 0.01;
                                t = 0.14;
                                e = 0.6;
                                a = 0.02;
                                rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;
                                break;
                        case 3:
                                p = 0.63;
                                g = 0.01;
                                t = 0.05;
                                e = 0.25;
                                a = 0.06;
                                rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;
                                break;
                        case 4:
                                p = 0.55;
                                g = 0.04;
                                t = 0.26;
                                e = 0.1;
                                a = 0.05;
                                rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;
                                break;
                        case 5:
                                p = 0.38;
                                g = 0.08;
                                t = 0.49;
                                e = 0.01;
                                a = 0.04;
                                rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;

                                break;
                        case 6:
                                p = 0.11;
                                g = 0.13;
                                t = 0.74;
                                e = 0.01;
                                a = 0.01;
                                rendimiento = this.getStats().getTackles() * e + this.getStats().getPases() * p + this.getStats().getGoles() * g + this.getStats().getAsistencias() * a + this.getStats().getTiros() * t;
                                break;
                        default:
                                rendimiento = 0;
                }
                double multiplicador = (30 - (double) this.medias[0]) / 10;
                rendimiento *= multiplicador;
                setRendimiento(rendimiento);
                return rendimiento;
        }

        public void definirMedias() {
                int[] medias = {this.getPortero().getMedia(), this.getDefensa().getMedia(), this.getMedio().getMedia(), this.getDelantero().getMedia()};
                for (int i : medias) {
                        if (i > this.medias[0]) {
                                this.medias[3] = (this.medias[2]);
                                this.medias[2] = (this.medias[1]);
                                this.medias[1] = (this.medias[0]);
                                this.medias[0] = (i);
                        } else if (i > this.medias[1]) {
                                this.medias[3] = (this.medias[2]);
                                this.medias[2] = (this.medias[1]);
                                this.medias[1] = (i);
                        } else if (i > this.medias[2]) {
                                this.medias[3] = (this.medias[2]);
                                this.medias[2] = (i);
                        } else {
                                this.medias[3] = (i);
                        }
                }
        }

        public void calcularExpTest(double rendMedio) {
                double parteMinutos, parteRend;
                parteMinutos = ((double) this.getStats().getMinutos() / 5) - (getEdad() * 20) * (1 - ((double) this.medias[0] / 50));
                parteRend = ((getRendimiento() - rendMedio) * 15);
                setExp((int) (parteMinutos * 0.3 + parteRend * 0.7));
        }

        public void definirSalario() {
                setSalario(0);
                int suma = 0;
                switch (this.medias[0]) {
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
                }
                setSalario(getSalario() + suma);
                if (this.medias[1] - 1 > 0) {
                        setSalario(getSalario() + ((this.medias[1] - 1) * 80000));
                }
                if (this.medias[2] - 1 > 0) {
                        setSalario(getSalario() + ((this.medias[2] - 1) * 40000));
                }
                double mult = 1;
                if ((getEdad() >= 24) && (getEdad() <= 26)) {
                        mult = 0.95;
                } else if ((getEdad() >= 27) && (getEdad() <= 29)) {
                        mult = 0.9;
                } else if ((getEdad() >= 30) && (getEdad() <= 33)) {
                        mult = 0.8;
                } else if ((getEdad() >= 34) && (getEdad() <= 36)) {
                        mult = 0.7;
                } else if ((getEdad() > 36)) {
                        mult = 0.6;
                }

                setSalario((int) (getSalario() * mult));
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
                return resultado;
        }

        public void sumarFit(int nFit) {
                getStats().setFit(getStats().getFit() + nFit);
        }

        public String toStringReducido() {
                return this.nombre + " (" + this.equipo.toLowerCase() + ")";
        }
}
