/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Equipo;

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
import program.model.Jugador.*;

/**
 *
 * @author Antonio
 */
public class Roster implements Comparable<Roster> {

// <editor-fold defaultstate="collapsed" desc=" Atributos ">
        private double potencial, edadMedia, rendimiento, elo;
        private int salario, nGk, nDf, nDm, nMf, nAm, nFw;
        private String nombre, abreviatura;
        private SortedSet<Jugador> jugadores;
        private List<Double> stats;
        private URL imagenPath;
        private ImageIcon imagen;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" Constructores ">
        public Roster(String nombre, String abrev) {
                setNombre(nombre);
                setAbreviatura(abrev);
                stats = new ArrayList();
                jugadores = new TreeSet();
                setPosJugadores();
        }

        public Roster(String nombre, String abrev, TreeSet<Jugador> roster) {
                this(nombre, abrev);
                this.jugadores = roster;
                setPosJugadores();
        }

        public Roster(String abrev, TreeSet<Jugador> roster) {
                this("", abrev);
                this.jugadores = roster;
                setPosJugadores();
        }

        public Roster(String abrev) {
                this("", abrev);
        }

        public Roster(TreeSet<Jugador> roster) {
                this("", "");
                this.jugadores = roster;
                setPosJugadores();
        }

        public Roster() {
                this("", "");
                setElo(2000);
        }

// </editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
        public double getPotencial() {
                return potencial;
        }

        public void setPotencial(double potencial) {
                this.potencial = potencial;
        }

        public double getEdadMedia() {
                return edadMedia;
        }

        public void setEdadMedia(double edadMedia) {
                this.edadMedia = edadMedia;
        }

        public double getRendimiento() {
                return rendimiento;
        }

        public void setRendimiento(double rendimiento) {
                this.rendimiento = rendimiento;
        }

        public double getElo() {
                return elo;
        }

        public void setElo(double elo) {
                this.elo = elo;
        }

        public int getSalario() {
                return salario;
        }

        public void setSalario(int salario) {
                this.salario = salario;
        }

        public int getnGk() {
                return nGk;
        }

        public void setnGk(int nGk) {
                this.nGk = nGk;
        }

        public int getnDf() {
                return nDf;
        }

        public void setnDf(int nDf) {
                this.nDf = nDf;
        }

        public int getnDm() {
                return nDm;
        }

        public void setnDm(int nDm) {
                this.nDm = nDm;
        }

        public int getnMf() {
                return nMf;
        }

        public void setnMf(int nMf) {
                this.nMf = nMf;
        }

        public int getnAm() {
                return nAm;
        }

        public void setnAm(int nAm) {
                this.nAm = nAm;
        }

        public int getnFw() {
                return nFw;
        }

        public void setnFw(int nFw) {
                this.nFw = nFw;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getAbreviatura() {
                return abreviatura;
        }

        public void setAbreviatura(String abreviatura) {
                this.abreviatura = abreviatura;
        }

        public List<Double> getStats() {
                return stats;
        }

        public void setStats(List<Double> stats) {
                this.stats = stats;
        }

        public SortedSet<Jugador> getJugadores() {
                return this.jugadores;
        }

        public void setJugadores(SortedSet<Jugador> roster) {
                this.jugadores = roster;
        }

        public URL getImagenPath() {
                return imagenPath;
        }

        public void setImagenPath(URL imagenPath) {
                this.imagenPath = imagenPath;
        }

        public ImageIcon getImagen() {
                return imagen;
        }

        public void setImagen(ImageIcon imagen) {
                this.imagen = imagen;
        }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="toString/toStringHTML/equals">
        public String toString() {
                String equipo = new String();
                equipo = "Nombre: " + this.getNombre() + "\nAbreviatura: " + this.getAbreviatura() + "\n\n";
                equipo += "Número de jugadores: " + this.getJugadores().size()
                        + " (" + this.getnGk() + " GK, " + this.getnDf() + " DF, " + this.getnDm() + " DM, " + this.getnMf() + " MF, " + this.getnAm() + " AM, "
                        + this.getnFw() + " FW)\n\n";
                equipo = equipo + this.obtenerCabecera();
                for (Jugador j : this.jugadores) {
                        equipo = equipo + j.toString() + "\n";
                }
                return equipo;
        }

        public String escribirHTML(String texto) {
                String equipo = texto;
                equipo = equipo.replaceAll("\n", "<br>");
                equipo = "<pre>" + equipo + "</pre>";
                return equipo;
        }

        public boolean equals(Roster r2) {
                return (this.getAbreviatura().equals(r2.getAbreviatura()));
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Obtener cabeceras de plantillas">
        private String obtenerCabecera() {
                String cabecera = new String();
                cabecera = "Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit";
                cabecera = cabecera + "\n----------------------------------------------------------------------------------------------------------------\n";
                return cabecera;
        }

        private void escribirCabecera(PrintWriter pw) {
                pw.println("Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit");
                pw.println("----------------------------------------------------------------------------------------------------------------");
        }

        private String obtenerCabeceraHTML() {
                String cabecera = new String();
                cabecera = "<pre>Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit";
                cabecera = cabecera + "\n----------------------------------------------------------------------------------------------------------------\n";
                return cabecera;
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Gestion de la ED del roster">
        public void setPosJugadores() {
                setnGk(0);
                setnDf(0);
                setnDm(0);
                setnMf(0);
                setnAm(0);
                setnFw(0);
                Iterator it = jugadores.iterator();
                while (it.hasNext()) {
                        Jugador j = (Jugador) it.next();
                        switch (j.getPos()) {
                                case gk:
                                        setnGk(getnGk() + 1);
                                        break;
                                case df:
                                        setnGk(getnDf() + 1);
                                        break;
                                case dm:
                                        setnGk(getnDm() + 1);
                                        break;
                                case mf:
                                        setnGk(getnMf() + 1);
                                        break;
                                case am:
                                        setnGk(getnAm() + 1);
                                        break;
                                case fw:
                                        setnGk(getnFw() + 1);
                                        break;
                        }
                }
        }

        public void anadirJugador(Jugador j) {
                switch (j.getPos()) {
                        case gk:
                                nGk++;
                                break;
                        case df:
                                nDf++;
                                break;
                        case dm:
                                nDm++;
                                break;
                        case mf:
                                nMf++;
                                break;
                        case am:
                                nAm++;
                                break;
                        case fw:
                                nFw++;
                                break;
                }
                this.jugadores.add(j);
        }

        public void quitarJugador(Jugador j) {
                if (estaJugador(j)) {
                        switch (j.getPos()) {
                                case gk:
                                        setnGk(getnGk() - 1);
                                        break;
                                case df:
                                        setnGk(getnDf() - 1);
                                        break;
                                case dm:
                                        setnGk(getnDm() - 1);
                                        break;
                                case mf:
                                        setnGk(getnMf() - 1);
                                        break;
                                case am:
                                        setnGk(getnAm() - 1);
                                        break;
                                case fw:
                                        setnGk(getnFw() - 1);
                                        break;
                        }
                        this.jugadores.remove(j);
                }
        }

        public Jugador buscarJugador(String nombre) {
                Iterator it = jugadores.iterator();
                boolean encontrado = false;
                Jugador buscado = null;
                while (it.hasNext() && !encontrado) {
                        buscado = (Jugador) it.next();
                        if (buscado.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                                encontrado = true;
                        }
                }
                return buscado;
        }

        public void ordenarRoster(int num, int stat) {
                TreeSet<Jugador> aux;
                switch (num) {

                        case 1: //<editor-fold defaultstate="collapsed" desc="Comparador de orden de mayor edad a menor edad">
                                aux = new TreeSet<Jugador>((o1, o2) -> {
                                        if (o2.getEdad() - o1.getEdad() == 0) {
                                                return o1.getNombre().compareTo(o2.getNombre());
                                        }
                                        return o2.getEdad() - o1.getEdad();
                                });
                                break;
//</editor-fold>

                        case 2: //<editor-fold defaultstate="collapsed" desc="Comparador de orden de menor edad a mayor edad">
                                aux = new TreeSet<Jugador>((o1, o2) -> {
                                        if (o1.getEdad() - o2.getEdad() == 0) {
                                                return o1.getNombre().compareTo(o2.getNombre());
                                        }
                                        return o1.getEdad() - o2.getEdad();
                                });
                                break;
//</editor-fold>

                        case 3: //<editor-fold defaultstate="collapsed" desc="Comparador de orden alfabetico A-Z">
                                aux = new TreeSet<Jugador>((o1, o2) -> o2.getNombre().compareTo(o1.getNombre()));
                                break;
//</editor-fold>

                        case 4: //<editor-fold defaultstate="collapsed" desc="Comparador de orden alfabetico Z-A">
                                aux = new TreeSet<Jugador>((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
                                break;
//</editor-fold>

                        case 5: //<editor-fold defaultstate="collapsed" desc="Comparador de orden alfabetico A-Z Nacionalidad">
                                aux = new TreeSet<Jugador>((o1, o2) -> {
                                        if (o1.getNacionalidad().compareTo(o2.getNacionalidad()) == 0) {
                                                return o1.getNombre().compareTo(o2.getNombre());
                                        }
                                        return o1.getNacionalidad().compareTo(o2.getNacionalidad());
                                });
                                break;
//</editor-fold>

                        case 6: //<editor-fold defaultstate="collapsed" desc="Comparador de orden alfabetico Z-A Nacionalidad">
                                aux = new TreeSet<Jugador>((o1, o2) -> {
                                        if (o2.getNacionalidad().compareTo(o1.getNacionalidad()) == 0) {
                                                return o1.getNombre().compareTo(o2.getNombre());
                                        }
                                        return o2.getNacionalidad().compareTo(o1.getNacionalidad());
                                });
                                break;
//</editor-fold>

                        case 7: //<editor-fold defaultstate="collapsed" desc="Comparador de orden de mayor salario a menor salario">
                                aux = new TreeSet<Jugador>((o1, o2) -> o2.getSalario() - o1.getSalario());
                                break;
//</editor-fold>

                        case 8: //<editor-fold defaultstate="collapsed" desc="Comparador de orden de menor salario a mayor salario">
                                aux = new TreeSet<Jugador>((o1, o2) -> o1.getSalario() - o2.getSalario());
                                break;
//</editor-fold>

                        case 9: // <editor-fold desc="Comparador de orden de mayor rendimiento a menor rendimiento">
                                aux = new TreeSet<Jugador>((o1, o2) -> {
                                        if (o1.getRendimiento() > o2.getRendimiento()) {
                                                return -1;
                                        } else if (o1.getRendimiento() < o2.getRendimiento()) {
                                                return 1;
                                        } else {
                                                if (o1.getStats().getMinutos() == 0) {
                                                        if (o2.getStats().getMinutos() == 0) {
                                                                return o1.getNombre().compareTo(o2.getNombre());
                                                        } else {
                                                                return 1;
                                                        }
                                                } else {
                                                        if (o2.getStats().getMinutos() == 0) {
                                                                return -1;
                                                        } else {
                                                                if (o1.getStats().getMinutos() < o2.getStats().getMinutos()) {
                                                                        return -1;
                                                                } else if (o1.getStats().getMinutos() > o2.getStats().getMinutos()) {
                                                                        return 1;
                                                                } else {
                                                                        return o1.getNombre().compareTo(o2.getNombre());
                                                                }
                                                        }
                                                }
                                        }
                                });
                                break;
                        //</editor-fold>

                        case 10: //<editor-fold defaultstate="collapsed" desc="Comparador de orden de menor rendimiento a mayor rendimiento">
                                aux = new TreeSet<Jugador>((o2, o1) -> {
                                        if (o1.getRendimiento() > o2.getRendimiento()) {
                                                return -1;
                                        } else if (o1.getRendimiento() < o2.getRendimiento()) {
                                                return 1;
                                        } else {
                                                if (o1.getStats().getMinutos() == 0) {
                                                        if (o2.getStats().getMinutos() == 0) {
                                                                return o2.getNombre().compareTo(o1.getNombre());
                                                        } else {
                                                                return 1;
                                                        }
                                                } else {
                                                        if (o2.getStats().getMinutos() == 0) {
                                                                return -1;
                                                        } else {
                                                                if (o1.getStats().getMinutos() < o2.getStats().getMinutos()) {
                                                                        return -1;
                                                                } else if (o1.getStats().getMinutos() > o2.getStats().getMinutos()) {
                                                                        return 1;
                                                                } else {
                                                                        return o2.getNombre().compareTo(o1.getNombre());
                                                                }
                                                        }
                                                }
                                        }
                                });
                                break;
                        //</editor-fold>

                        case 11: //<editor-fold defaultstate="collapsed" desc="Comparador por orden de max exp subida en el bonus test de minutos a min exp subida">
                                aux = new TreeSet<Jugador>((j1, j2) -> {
                                        int resultado = 0;
                                        if (j1.getPosInt() < j2.getPosInt()) {
                                                resultado = -1;
                                        } else if (j1.getPosInt() > j2.getPosInt()) {
                                                resultado = 1;
                                        } else {
                                                if (j1.getExp() > j2.getExp()) {
                                                        resultado = -1;
                                                } else if (j1.getExp() < j2.getExp()) {
                                                        resultado = 1;
                                                } else {
                                                        resultado = 0;
                                                }
                                        }
                                        return resultado;
                                });
                                break;
//</editor-fold>

                        case 12: //<editor-fold defaultstate="collapsed" desc="Comparador por orden de min exp subida en el bonus test de minutos a max exp subida">
                                aux = new TreeSet<Jugador>((j2, j1) -> {
                                        int resultado = 0;
                                        if (j1.getPosInt() < j2.getPosInt()) {
                                                resultado = -1;
                                        } else if (j1.getPosInt() > j2.getPosInt()) {
                                                resultado = 1;
                                        } else {
                                                if (j1.getExp() > j2.getExp()) {
                                                        resultado = -1;
                                                } else if (j1.getExp() < j2.getExp()) {
                                                        resultado = 1;
                                                } else {
                                                        resultado = 0;
                                                }
                                        }
                                        return resultado;
                                });
                                break;
//</editor-fold>

                        case 13: //<editor-fold defaultstate="collapsed" desc="Comparador por orden de stat normal">
                                aux = new TreeSet<Jugador>((j1, j2) -> {
                                        if ((stat / 3 != 1) || (stat / 3 != 2)) {
                                                return j1.getStats().compararStats(j2.getStats(), stat);
                                        } else {
                                                if (j1.getPos() == Jugador.Posicion.gk) {
                                                        if (j2.getPos() == Jugador.Posicion.gk) {
                                                                return j1.getStats().compararStats(j2.getStats(), stat);
                                                        } else {
                                                                return 1;
                                                        }
                                                } else {
                                                        if (j2.getPos() == Jugador.Posicion.gk) {
                                                                return -1;
                                                        } else {
                                                                return 0;
                                                        }
                                                }
                                        }
                                });
                                break;
//</editor-fold>

                        case 14: //<editor-fold defaultstate="collapsed" desc="Comparador por orden de stat inverso">
                                aux = new TreeSet<Jugador>((j2, j1) -> {
                                        if ((stat / 3 != 1) || (stat / 3 != 2)) {
                                                return j1.getStats().compararStats(j2.getStats(), stat);
                                        } else {
                                                if (j1.getPos() == Jugador.Posicion.gk) {
                                                        if (j2.getPos() == Jugador.Posicion.gk) {
                                                                return j1.getStats().compararStats(j2.getStats(), stat);
                                                        } else {
                                                                return 1;
                                                        }
                                                } else {
                                                        if (j2.getPos() == Jugador.Posicion.gk) {
                                                                return -1;
                                                        } else {
                                                                return 0;
                                                        }
                                                }
                                        }
                                });
                                break;
//</editor-fold>

                        default: //<editor-fold defaultstate="collapsed" desc="Comparador por defecto, orden de medias">
                                aux = new TreeSet<Jugador>();
//</editor-fold>

                }

                Iterator it = jugadores.iterator();
                while (it.hasNext()) {
                        Jugador j = (Jugador) it.next();
                        aux.add(j);
                }
                setJugadores(aux);
        }

        public boolean estaJugador(Jugador j2) {
                boolean resultado = false;
                Iterator it = this.jugadores.iterator();
                while (it.hasNext() && !resultado) {
                        Jugador j1 = (Jugador) it.next();
                        if (j1.equals(j2)) {
                                resultado = true;
                        }
                }
                return resultado;
        }

        public void guardarEquipo() throws IOException {
                FileWriter equipo = new FileWriter(getAbreviatura() + ".txt");
                BufferedWriter bw = new BufferedWriter(equipo);
                PrintWriter output = new PrintWriter(bw);
                escribirCabecera(output);
                ordenarRoster(0, 0);
                for (Jugador j : getJugadores()) {
                        output.println(j.toString());
                }
                output.close();
        }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Calculos">
        public void sumarFit(int nFit) {
                for (Jugador j : jugadores) {
                        j.sumarFit(nFit);
                        j.definirPosicion();
                        j.definirPosInt();
                        j.definirMedias();
                        j.definirSalario();
                }
        }

        public void calcularPotencial() {
                int potencial = 0;
                for (Jugador j : jugadores) {
                        potencial += j.calcularPotencial();
                }
                setPotencial(potencial);
        }

        public void calcularRendimiento() {
                int rendimiento = 0;
                for (Jugador j : jugadores) {
                        rendimiento += j.calcularRendimiento();
                }
                setRendimiento(rendimiento);
        }

        public void calcularEdadMedia() {
                int edadMedia = 0;
                for (Jugador j : jugadores) {
                        edadMedia += j.getEdad();
                }
                edadMedia = edadMedia / jugadores.size();
                setEdadMedia(edadMedia);
        }

        public void calcularSalario() {
                int salario = 0;
                for (Jugador j : jugadores) {
                        salario += j.getSalario();
                }
                setSalario(salario);
        }

        public void obtenerStats() {
                double suma;
                for (int i = 0; i < 9; i++) {
                        suma = 0;
                        for (Jugador j : jugadores) {
                                switch (i) {
                                        case 0:
                                                suma += j.getStats().getMom();
                                                break;
                                        case 1:
                                                suma += j.getStats().getParadas();
                                                break;
                                        case 2:
                                                suma += j.getStats().getEncajados();
                                                break;
                                        case 3:
                                                suma += j.getStats().getTackles();
                                                break;
                                        case 4:
                                                suma += j.getStats().getPases();
                                                break;
                                        case 5:
                                                suma += j.getStats().getAsistencias();
                                                break;
                                        case 6:
                                                suma += j.getStats().getTiros();
                                                break;
                                        case 7:
                                                suma += j.getStats().getGoles();
                                                break;
                                        case 8:
                                                suma += j.getStats().getDp();
                                                break;
                                        case 9:
                                                suma += j.getStats().getFit();
                                                break;
                                        default:
                                                suma = 0;
                                                break;
                                }
                        }
                        if (i == 9) {
                                suma /= jugadores.size();
                        }
                        stats.add(suma);
                }
        }

        public int compareStats(Roster r2, int stat) {
                return Double.compare(this.stats.get(stat), r2.stats.get(stat));
        }

        @Override
        public int compareTo(Roster r) {
                return this.getNombre().compareTo(r.getNombre());
        }
//</editor-fold>

}
