package AlineacionAlAzar.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author analpa1997
 */
public class Alineacion {

        //<editor-fold defaultstate="collapsed" desc="Desplegable para crear mas desplegables">
//</editor-fold>
        private ArrayList<JugadorEnAlineacion> titulares;
        private final String[] TACTICAS = {"A", "C", "E", "P", "D", "L", "N"};
        private Equipo equipo;
        private String abreviatura;
        private ArrayList<Jugador> portero, defensa, dm, medio, am, delantero;
        private int nDefensa, nDm, nMf, nMedio, nAm, nDelantero;
        private ArrayList<JugadorEnAlineacion> defensaAli, dmAli, medioAli, amAli, delanteroAli;
        private String tiradorPenaltis;
        private JugadorEnAlineacion porteroAli;
        private ArrayList<JugadorEnAlineacion> suplentes;
        private String tactica;
        private ArrayList<String> condiciones;

        //<editor-fold defaultstate="collapsed" desc="Constructores">
        public Alineacion() {
                titulares = new ArrayList(11);
                suplentes = new ArrayList(5);
                equipo = new Equipo();
                tactica = "";
                abreviatura = "";
                tiradorPenaltis = "PK: ";
                defensaAli = new ArrayList<>();
                dmAli = new ArrayList<>();
                medioAli = new ArrayList<>();
                amAli = new ArrayList<>();
                delanteroAli = new ArrayList<>();
                porteroAli = new JugadorEnAlineacion(null, "GK");
                portero = new ArrayList();
                defensa = new ArrayList();
                dm = new ArrayList();
                medio = new ArrayList();
                am = new ArrayList();
                delantero = new ArrayList();
                condiciones = new ArrayList();
        }

        public Alineacion(ArrayList<JugadorEnAlineacion> titulares, ArrayList<JugadorEnAlineacion> suplentes) {
                this();
                this.titulares = titulares;
                this.suplentes = suplentes;
        }

        public Alineacion(ArrayList<JugadorEnAlineacion> titulares, ArrayList<JugadorEnAlineacion> suplentes, String tactica) {
                this();
                this.titulares = titulares;
                this.suplentes = suplentes;
                this.tactica = tactica;
        }

        public Alineacion(ArrayList<JugadorEnAlineacion> titulares, ArrayList<JugadorEnAlineacion> suplentes, String tactica, ArrayList<String> condiciones) {
                this();
                this.titulares = titulares;
                this.suplentes = suplentes;
                this.tactica = tactica;
                this.condiciones = condiciones;
        }

        public Alineacion(ArrayList<JugadorEnAlineacion> titulares, ArrayList<JugadorEnAlineacion> suplentes, String tactica, String abreviatura, ArrayList<String> condiciones) {
                this();
                this.abreviatura = abreviatura;
                this.titulares = titulares;
                this.suplentes = suplentes;
                this.tactica = tactica;
                this.condiciones = condiciones;
        }

        public Alineacion(Equipo equipo) {
                this();
                this.equipo = equipo;
                this.abreviatura = equipo.getAbreviatura();
                clasificarJugadores(70);
        }

        public Alineacion(Equipo equipo, String tactica) {
                this();
                this.equipo = equipo;
                this.tactica = tactica;
                this.abreviatura = equipo.getAbreviatura();
                clasificarJugadores(70);
        }

        public Alineacion(Equipo equipo, int nDefensa, int nDm, int nMf, int nAm, int nDelantero, String tactica) {
                this();
                this.equipo = equipo;
                this.abreviatura = equipo.getAbreviatura();
                this.tactica = tactica;
                this.nDefensa = nDefensa;
                this.nDm = nDm;
                this.nMf = nMf;
                this.nAm = nAm;
                this.nDelantero = nDelantero;
                defensaAli = new ArrayList<>(nDefensa);
                dmAli = new ArrayList<>(nDm);
                medioAli = new ArrayList<>(nMf);
                amAli = new ArrayList<>(nAm);
                delanteroAli = new ArrayList<>(nDelantero);
                setnMedio();
                clasificarJugadores(70);
        }

        public Alineacion(Equipo equipo, int fit) {
                this();
                this.equipo = equipo;
                this.abreviatura = equipo.getAbreviatura();
                clasificarJugadores(fit);
        }

        public Alineacion(Equipo equipo, String tactica, int fit) {
                this();
                this.equipo = equipo;
                this.tactica = tactica;
                this.abreviatura = equipo.getAbreviatura();
                clasificarJugadores(fit);
        }

        public Alineacion(Equipo equipo, int nDefensa, int nDm, int nMf, int nAm, int nDelantero, String tactica, int fit) {
                this();
                this.equipo = equipo;
                this.abreviatura = equipo.getAbreviatura();
                this.tactica = tactica;
                this.nDefensa = nDefensa;
                this.nDm = nDm;
                this.nMf = nMf;
                this.nAm = nAm;
                this.nDelantero = nDelantero;
                defensaAli = new ArrayList<>(nDefensa);
                dmAli = new ArrayList<>(nDm);
                medioAli = new ArrayList<>(nMf);
                amAli = new ArrayList<>(nAm);
                delanteroAli = new ArrayList<>(nDelantero);
                setnMedio();
                clasificarJugadores(fit);
        }
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
        public Equipo getEquipo() {
                return equipo;
        }

        public void setEquipo(Equipo equipo) {
                this.equipo = equipo;
        }

        public String[] getTACTICAS() {
                return TACTICAS;
        }

        public ArrayList<Jugador> getPortero() {
                return portero;
        }

        public void setPortero(ArrayList<Jugador> portero) {
                this.portero = portero;
        }

        public ArrayList<Jugador> getDefensa() {
                return defensa;
        }

        public void setDefensa(ArrayList<Jugador> defensa) {
                this.defensa = defensa;
        }

        public ArrayList<Jugador> getDm() {
                return dm;
        }

        public void setDm(ArrayList<Jugador> dm) {
                this.dm = dm;
        }

        public ArrayList<Jugador> getMedio() {
                return medio;
        }

        public void setMedio(ArrayList<Jugador> medio) {
                this.medio = medio;
        }

        public ArrayList<Jugador> getAm() {
                return am;
        }

        public void setAm(ArrayList<Jugador> am) {
                this.am = am;
        }

        public ArrayList<Jugador> getDelantero() {
                return delantero;
        }

        public void setDelantero(ArrayList<Jugador> delantero) {
                this.delantero = delantero;
        }

        public int getnDefensa() {
                return nDefensa;
        }

        public void setnDefensa(int nDefensa) {
                this.nDefensa = nDefensa;
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

        public int getnMedio() {
                return nMedio;
        }

        public void setnMedio(int nMedio) {
                this.nMedio = nMedio;
        }

        public void setnMedio() {
                this.nMedio = nDm + nMf + nAm;
        }

        public int getnAm() {
                return nAm;
        }

        public void setnAm(int nAm) {
                this.nAm = nAm;
        }

        public int getnDelantero() {
                return nDelantero;
        }

        public void setnDelantero(int nDelantero) {
                this.nDelantero = nDelantero;
        }

        public ArrayList<JugadorEnAlineacion> getDefensaAli() {
                return defensaAli;
        }

        public void setDefensaAli(ArrayList<JugadorEnAlineacion> defensaAli) {
                this.defensaAli = defensaAli;
        }

        public ArrayList<JugadorEnAlineacion> getDmAli() {
                return dmAli;
        }

        public void setDmAli(ArrayList<JugadorEnAlineacion> dmAli) {
                this.dmAli = dmAli;
        }

        public ArrayList<JugadorEnAlineacion> getMedioAli() {
                return medioAli;
        }

        public void setMedioAli(ArrayList<JugadorEnAlineacion> medioAli) {
                this.medioAli = medioAli;
        }

        public ArrayList<JugadorEnAlineacion> getAmAli() {
                return amAli;
        }

        public void setAmAli(ArrayList<JugadorEnAlineacion> amAli) {
                this.amAli = amAli;
        }

        public ArrayList<JugadorEnAlineacion> getDelanteroAli() {
                return delanteroAli;
        }

        public void setDelanteroAli(ArrayList<JugadorEnAlineacion> delanteroAli) {
                this.delanteroAli = delanteroAli;
        }

        public JugadorEnAlineacion getPorteroAli() {
                return porteroAli;
        }

        public void setPorteroAli(JugadorEnAlineacion porteroAli) {
                this.porteroAli = porteroAli;
        }

        public String getTactica() {
                return tactica;
        }

        public void setTactica(String tactica) {
                this.tactica = tactica;
        }

        public String getAbreviatura() {
                return abreviatura;
        }

        public void setAbreviatura(String abreviatura) {
                this.abreviatura = abreviatura;
        }

        public ArrayList<JugadorEnAlineacion> getTitulares() {
                return titulares;
        }

        public void setTitulares(ArrayList<JugadorEnAlineacion> titulares) {
                this.titulares = titulares;
        }

        public ArrayList<JugadorEnAlineacion> getSuplentes() {
                return suplentes;
        }

        public void setSuplentes(ArrayList<JugadorEnAlineacion> suplentes) {
                this.suplentes = suplentes;
        }

        public ArrayList<String> getCondiciones() {
                return condiciones;
        }

        public void setCondiciones(ArrayList<String> condiciones) {
                this.condiciones = condiciones;
        }
        //</editor-fold>

        public String getFormacion() {
                String formacion = "";
                formacion = nDefensa + "-" + nDm + "-" + nMf + "-" + nAm + "-" + nDelantero + " " + tactica;
                return formacion;
        }

        public String toString() {
                String resultado = "";
                resultado = resultado + abreviatura + "\n";
                resultado = resultado + tactica + "\n\n";
                for (JugadorEnAlineacion j : titulares) {
                        resultado = resultado + j + "\n";
                }
                resultado = resultado + " \n";
                for (JugadorEnAlineacion j : suplentes) {
                        resultado = resultado + j + "\n";
                }
                resultado = resultado + " \n";
                for (int i = 10; i >= 0; i--) {
                        if (titulares.get(i).getJugador() != null) {
                                tiradorPenaltis = tiradorPenaltis + titulares.get(i).getJugador().getNombre();
                                break;
                        }
                }

                resultado = resultado + tiradorPenaltis + "\n";
                for (String condicion : condiciones) {
                        resultado = resultado + condicion + "\n";
                }
                return resultado;
        }

        private void clasificarJugadores(int fit) {
                for (Jugador j : equipo.getJugadores()) {
                        if (j.estaDisponible(fit)) {
                                switch (j.getPosInt()) {
                                        case 1:
                                                portero.add(j);
                                                break;
                                        case 2:
                                                defensa.add(j);
                                                break;
                                        case 3:
                                                dm.add(j);
                                                break;
                                        case 4:
                                                medio.add(j);
                                                break;
                                        case 5:
                                                am.add(j);
                                                break;
                                        case 6:
                                                delantero.add(j);
                                                break;
                                }
                        }
                }
        }

        private ArrayList<JugadorEnAlineacion> rellenarPosiciones(ArrayList<Jugador> jugadores, String posicion, int numMaximo) {
                ArrayList<JugadorEnAlineacion> resultado = new ArrayList(numMaximo);
                // int i = 0;
                for (int i = 0; i < numMaximo; i++) {
                        if (jugadores.isEmpty()) {
                                resultado.add(new JugadorEnAlineacion(null, posicion));
                        } else {
                                resultado.add(new JugadorEnAlineacion(jugadores.remove(0), posicion));
                        }
                }
                return resultado;
        }

        private void formacionRandom() {
                ArrayList<String> tacticas = new ArrayList();
                // || (nDefensa > defensa.size()) || (nDm > dm.size()) || (nMf > medio.size()) || (nAm > am.size()) || (nDelantero > delantero.size())
                Collections.addAll(tacticas, TACTICAS);
                do {
                        Collections.shuffle(tacticas);
                        this.tactica = tacticas.get(0);
                        nDefensa = (int) (Math.random() * 3 + 3);
                        nDm = (int) (Math.random() * 3);
                        nMf = (int) (Math.random() * 3 + 1);
                        nAm = (int) (Math.random() * 3);
                        nDelantero = (int) (Math.random() * 3 + 1);
                        setnMedio();
                } while (((nDefensa + nMedio + nDelantero) != 10) || ((nMedio < 2) || (nMedio > 8)));
        }

        private JugadorEnAlineacion insertarPorteroTitular() {
                if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "GK");
                } else {
                        return new JugadorEnAlineacion(null, "GK");
                }
        }

        private void guardarTitularesPosicion(ArrayList<JugadorEnAlineacion> jugadores) {
                for (JugadorEnAlineacion j : jugadores) {
                        titulares.add(j);
                }
        }

        private void insertarTitulares() {
                titulares.add(porteroAli);
                guardarTitularesPosicion(defensaAli);
                guardarTitularesPosicion(dmAli);
                guardarTitularesPosicion(medioAli);
                guardarTitularesPosicion(amAli);
                guardarTitularesPosicion(delanteroAli);
        }

        private void decidirTitulares() {
                porteroAli = insertarPorteroTitular();
                defensaAli = rellenarPosiciones(defensa, "DF", nDefensa);
                dmAli = rellenarPosiciones(dm, "DM", nDm);
                medioAli = rellenarPosiciones(medio, "MF", nMf);
                amAli = rellenarPosiciones(am, "AM", nAm);
                delanteroAli = rellenarPosiciones(delantero, "FW", nDelantero);
        }

        public void crearAlineacionFormElegida() {
                decidirTitulares();
                rellenarVacios();
                insertarTitulares();

                JugadorEnAlineacion[] suplentes = rellenarSuplentes();

                for (JugadorEnAlineacion j : suplentes) {
                        this.suplentes.add(j);
                }
        }

        public void crearAlineacionRandom() {
                formacionRandom();
                crearAlineacionFormElegida();
        }

        public void escribirAlineacionEnFichero(boolean esNoEnviada) throws IOException {
                FileWriter ficheroAlineacion = new FileWriter(abreviatura + "sht.txt");
                PrintWriter pW = new PrintWriter(new BufferedWriter(ficheroAlineacion));
                String[] alineacion = this.toString().split("\n");
                for (String linea : alineacion) {
                        if (linea.equals(" ")) {
                                pW.println();
                        } else {
                                pW.println(linea);
                        }
                }
                if (!esNoEnviada) {
                        pW.println();
                        pW.println("SUB 2 13 DF IF MIN = 55");
                        pW.println("SUB 11 16 FW IF MIN = 70");
                        pW.println("SUB 6 14 MF IF MIN = 60");
                }
                pW.close();
                ficheroAlineacion.close();
        }

        private void rellenarVacioPortero() {
                if (porteroAli == null) {
                        if (defensa.size() > 0) {
                                porteroAli = new JugadorEnAlineacion(defensa.remove(0), "GK");
                        } else if (dm.size() > 0) {
                                porteroAli = new JugadorEnAlineacion(dm.remove(0), "GK");
                        } else if (medio.size() > 0) {
                                porteroAli = new JugadorEnAlineacion(medio.remove(0), "GK");
                        } else if (am.size() > 0) {
                                porteroAli = new JugadorEnAlineacion(am.remove(0), "GK");
                        } else if (delantero.size() > 0) {
                                porteroAli = new JugadorEnAlineacion(delantero.remove(0), "GK");
                        }
                }
        }

        private JugadorEnAlineacion rellenarVacioDefensa() {
                if (dm.size() > 0) {
                        return new JugadorEnAlineacion(dm.remove(0), "DF");
                } else if (medio.size() > 0) {
                        return new JugadorEnAlineacion(medio.remove(0), "DF");
                } else if (am.size() > 0) {
                        return new JugadorEnAlineacion(am.remove(0), "DF");
                } else if (delantero.size() > 0) {
                        return new JugadorEnAlineacion(delantero.remove(0), "DF");
                } else if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "DF");
                } else {
                        return new JugadorEnAlineacion(null, "DF");
                }

        }

        private JugadorEnAlineacion rellenarVacioDm() {
                if (medio.size() > 0) {
                        return new JugadorEnAlineacion(medio.remove(0), "DM");
                } else if (defensa.size() > 0) {
                        return new JugadorEnAlineacion(defensa.remove(0), "DM");
                } else if (am.size() > 0) {
                        return new JugadorEnAlineacion(am.remove(0), "DM");
                } else if (delantero.size() > 0) {
                        return new JugadorEnAlineacion(delantero.remove(0), "DM");
                } else if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "DM");
                } else {
                        return new JugadorEnAlineacion(null, "DM");
                }
        }

        private JugadorEnAlineacion rellenarVacioMedio() {
                if (dm.size() > 0) {
                        return new JugadorEnAlineacion(dm.remove(0), "MF");
                } else if (am.size() > 0) {
                        return new JugadorEnAlineacion(am.remove(0), "MF");
                } else if (defensa.size() > 0) {
                        return new JugadorEnAlineacion(defensa.remove(0), "MF");
                } else if (delantero.size() > 0) {
                        return new JugadorEnAlineacion(delantero.remove(0), "MF");
                } else if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "MF");
                } else {
                        return new JugadorEnAlineacion(null, "MF");
                }

        }

        private JugadorEnAlineacion rellenarVacioAm() {
                if (medio.size() > 0) {
                        return new JugadorEnAlineacion(medio.remove(0), "AM");
                } else if (delantero.size() > 0) {
                        return new JugadorEnAlineacion(delantero.remove(0), "AM");
                } else if (dm.size() > 0) {
                        return new JugadorEnAlineacion(dm.remove(0), "AM");
                } else if (defensa.size() > 0) {
                        return new JugadorEnAlineacion(defensa.remove(0), "AM");
                } else if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "AM");
                } else {
                        return new JugadorEnAlineacion(null, "AM");
                }

        }

        private JugadorEnAlineacion rellenarVacioDelantero() {
                if (am.size() > 0) {
                        return new JugadorEnAlineacion(am.remove(0), "FW");
                } else if (medio.size() > 0) {
                        return new JugadorEnAlineacion(medio.remove(0), "FW");
                } else if (dm.size() > 0) {
                        return new JugadorEnAlineacion(dm.remove(0), "FW");
                } else if (defensa.size() > 0) {
                        return new JugadorEnAlineacion(defensa.remove(0), "FW");
                } else if (portero.size() > 0) {
                        return new JugadorEnAlineacion(portero.remove(0), "FW");
                } else {
                        return new JugadorEnAlineacion(null, "FW");
                }
        }

        private void inicializarNullRestoJugaodres(JugadorEnAlineacion[] posicionesAli, int posInicial) {
                for (int j = posInicial; j < posicionesAli.length; j++) {
                        posicionesAli[j] = new JugadorEnAlineacion(null, "GK");
                }
        }

        private int inicializarArrayJugadores(ArrayList<JugadorEnAlineacion> array, JugadorEnAlineacion[] posicionesAli) {
                int i = 0;
                for (JugadorEnAlineacion j : array) {
                        posicionesAli[i] = j;
                        i++;
                }
                return i;
        }

        private ArrayList<JugadorEnAlineacion> rellenarArrayPosiciones(ArrayList<JugadorEnAlineacion> array, JugadorEnAlineacion[] posicionesAli, int longitud) {
                array = new ArrayList<JugadorEnAlineacion>(longitud);
                for (JugadorEnAlineacion j : posicionesAli) {
                        array.add(j);
                }
                return array;
        }

        private void rellenarVacios() {

                rellenarVacioPortero();

                JugadorEnAlineacion[] posicionesAli = new JugadorEnAlineacion[nDefensa];
                inicializarNullRestoJugaodres(posicionesAli, inicializarArrayJugadores(defensaAli, posicionesAli));
                for (int i = 0; i < posicionesAli.length; i++) {
                        if (posicionesAli[i].getJugador() == null) {
                                posicionesAli[i] = rellenarVacioDefensa();
                        }
                }
                defensaAli = rellenarArrayPosiciones(defensaAli, posicionesAli, nDefensa);

                posicionesAli = new JugadorEnAlineacion[nDm];
                inicializarNullRestoJugaodres(posicionesAli, inicializarArrayJugadores(dmAli, posicionesAli));
                for (int i = 0; i < posicionesAli.length; i++) {
                        if (posicionesAli[i].getJugador() == null) {
                                posicionesAli[i] = rellenarVacioDm();
                        }
                }
                dmAli = rellenarArrayPosiciones(dmAli, posicionesAli, nDm);

                posicionesAli = new JugadorEnAlineacion[nMf];
                inicializarNullRestoJugaodres(posicionesAli, inicializarArrayJugadores(medioAli, posicionesAli));
                for (int i = 0; i < posicionesAli.length; i++) {
                        if (posicionesAli[i].getJugador() == null) {
                                posicionesAli[i] = rellenarVacioMedio();
                        }
                }
                medioAli = rellenarArrayPosiciones(medioAli, posicionesAli, nMf);

                posicionesAli = new JugadorEnAlineacion[nAm];
                inicializarNullRestoJugaodres(posicionesAli, inicializarArrayJugadores(amAli, posicionesAli));
                for (int i = 0; i < posicionesAli.length; i++) {
                        if (posicionesAli[i].getJugador() == null) {
                                posicionesAli[i] = rellenarVacioAm();
                        }
                }
                amAli = rellenarArrayPosiciones(amAli, posicionesAli, nAm);

                posicionesAli = new JugadorEnAlineacion[nDelantero];
                inicializarNullRestoJugaodres(posicionesAli, inicializarArrayJugadores(delanteroAli, posicionesAli));
                for (int i = 0; i < posicionesAli.length; i++) {
                        if (posicionesAli[i].getJugador() == null) {
                                posicionesAli[i] = rellenarVacioDelantero();
                        }
                }
                delanteroAli = rellenarArrayPosiciones(delanteroAli, posicionesAli, nDelantero);
        }

        private JugadorEnAlineacion[] rellenarSuplentes() {
                JugadorEnAlineacion[] suplentes = new JugadorEnAlineacion[5];
                if (!portero.isEmpty()) {
                        suplentes[0] = new JugadorEnAlineacion(portero.get(0), "GK");
                        portero.remove(portero.get(0));
                } else if (defensa.size() > 0) {
                        suplentes[0] = new JugadorEnAlineacion(defensa.get(0), "GK");
                        defensa.remove(defensa.get(0));
                } else if (dm.size() > 0) {
                        suplentes[0] = new JugadorEnAlineacion(dm.get(0), "GK");
                        dm.remove(dm.get(0));
                } else if (medio.size() > 0) {
                        suplentes[0] = new JugadorEnAlineacion(medio.get(0), "GK");
                        medio.remove(medio.get(0));
                } else if (am.size() > 0) {
                        suplentes[0] = new JugadorEnAlineacion(am.get(0), "GK");
                        am.remove(am.get(0));
                } else if (delantero.size() > 0) {
                        suplentes[0] = new JugadorEnAlineacion(delantero.get(0), "GK");
                        delantero.remove(delantero.get(0));
                } else {
                        suplentes[0] = new JugadorEnAlineacion(null, "GK");
                }

                if (!defensa.isEmpty()) {
                        suplentes[1] = new JugadorEnAlineacion(defensa.get(0), "DF");
                        defensa.remove(defensa.get(0));
                } else if (dm.size() > 0) {
                        suplentes[1] = new JugadorEnAlineacion(dm.get(0), "DF");
                        dm.remove(dm.get(0));
                } else if (medio.size() > 0) {
                        suplentes[1] = new JugadorEnAlineacion(medio.get(0), "DF");
                        medio.remove(medio.get(0));
                } else if (am.size() > 0) {
                        suplentes[1] = new JugadorEnAlineacion(am.get(0), "DF");
                        am.remove(am.get(0));
                } else if (delantero.size() > 0) {
                        suplentes[1] = new JugadorEnAlineacion(delantero.get(0), "DF");
                        delantero.remove(delantero.get(0));
                } else if (portero.size() > 0) {
                        suplentes[1] = new JugadorEnAlineacion(portero.get(0), "DF");
                        portero.remove(portero.get(0));
                } else {
                        suplentes[1] = new JugadorEnAlineacion(null, "DF");
                }

                if (nDm > 0 && !dm.isEmpty()) {
                        suplentes[2] = new JugadorEnAlineacion(dm.get(0), "DM");
                        dm.remove(dm.get(0));
                        if (nAm > 0 && !am.isEmpty()) {
                                suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                am.remove(am.get(0));
                        } else {
                                if (medio.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(medio.get(0), "MF");
                                        medio.remove(medio.get(0));
                                } else if (defensa.size() > 0) {
                                        suplentes[3] = suplentes[2];
                                        suplentes[2] = new JugadorEnAlineacion(defensa.get(0), "DF");
                                        defensa.remove(defensa.get(0));
                                } else if (delantero.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(delantero.get(0), "FW");
                                        delantero.remove(delantero.get(0));
                                } else if (portero.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(portero.get(0), "MF");
                                        portero.remove(portero.get(0));
                                } else {
                                        suplentes[3] = new JugadorEnAlineacion(null, "MF");
                                }

                        }
                } else {
                        if (nAm > 0 && !am.isEmpty()) {
                                if (medio.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(medio.get(0), "MF");
                                        medio.remove(medio.get(0));
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                } else if (dm.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(dm.get(0), "DM");
                                        dm.remove(dm.get(0));
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                } else if (defensa.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(defensa.get(0), "DF");
                                        defensa.remove(defensa.get(0));
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                } else if (delantero.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                        suplentes[3] = new JugadorEnAlineacion(delantero.get(0), "FW");
                                        delantero.remove(delantero.get(0));
                                } else if (portero.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(portero.get(0), "MF");
                                        portero.remove(portero.get(0));
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                } else {
                                        suplentes[2] = new JugadorEnAlineacion(null, "AM");
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "AM");
                                        am.remove(am.get(0));
                                }
                        } else {
                                if (defensa.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(defensa.get(0), "DF");
                                        defensa.remove(defensa.get(0));
                                } else if (dm.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(dm.get(0), "DM");
                                        dm.remove(dm.get(0));
                                } else if (medio.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(medio.get(0), "MF");
                                        medio.remove(medio.get(0));
                                } else if (am.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(am.get(0), "DM");
                                        am.remove(am.get(0));
                                } else if (delantero.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(delantero.get(0), "FW");
                                        delantero.remove(delantero.get(0));
                                } else if (portero.size() > 0) {
                                        suplentes[2] = new JugadorEnAlineacion(portero.get(0), "DM");
                                        portero.remove(portero.get(0));
                                } else {
                                        suplentes[2] = new JugadorEnAlineacion(null, "DM");
                                }

                                if (defensa.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(defensa.get(0), "DF");;
                                        defensa.remove(defensa.get(0));
                                } else if (dm.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(dm.get(0), "DM");;
                                        dm.remove(dm.get(0));
                                } else if (medio.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(medio.get(0), "MF");
                                        medio.remove(medio.get(0));
                                } else if (am.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(am.get(0), "DM");
                                        am.remove(am.get(0));
                                } else if (delantero.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(delantero.get(0), "FW");
                                        delantero.remove(delantero.get(0));
                                } else if (portero.size() > 0) {
                                        suplentes[3] = new JugadorEnAlineacion(portero.get(0), "DM");
                                        portero.remove(portero.get(0));
                                } else {
                                        suplentes[3] = new JugadorEnAlineacion(null, "MF");
                                }
                        }
                }

                if (!delantero.isEmpty()) {
                        suplentes[4] = new JugadorEnAlineacion(delantero.get(0), "FW");
                        delantero.remove(delantero.get(0));
                } else if (am.size() > 0) {
                        suplentes[4] = new JugadorEnAlineacion(am.get(0), "FW");
                        am.remove(am.get(0));
                } else if (medio.size() > 0) {
                        suplentes[4] = new JugadorEnAlineacion(medio.get(0), "FW");
                        medio.remove(medio.get(0));
                } else if (dm.size() > 0) {
                        suplentes[4] = new JugadorEnAlineacion(dm.get(0), "FW");
                        dm.remove(dm.get(0));
                } else if (defensa.size() > 0) {
                        suplentes[4] = new JugadorEnAlineacion(defensa.get(0), "FW");
                        defensa.remove(defensa.get(0));
                } else if (portero.size() > 0) {
                        suplentes[4] = new JugadorEnAlineacion(portero.get(0), "FW");
                        portero.remove(portero.get(0));
                } else {
                        suplentes[4] = new JugadorEnAlineacion(null, "FW");
                }
                return suplentes;
        }
}
