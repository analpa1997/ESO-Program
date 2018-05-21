/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Liga;

import java.io.*;
import java.util.*;
import program.model.Equipo.*;
import program.model.Jugador.*;

/**
 *
 * @author Antonio
 */
public class Liga {

//<editor-fold defaultstate="collapsed" desc="Atributos">
        private SortedSet<Roster> equiposLiga;
        private SortedSet<Roster> seleccionesLiga;
        private SortedSet<Roster> todasSelecciones;
        private Roster todosJugadores;
        private Map<String, String> nombresEquipos;

        /*private ArrayList <Calendario> calendariosLiga = new ArrayList();
    private ArrayList <Resultado> resultadosLiga = new ArrayList();
    private ArrayList <Clasificacion> clasificacionesLiga = new ArrayList();
    private ArrayList <BonusMinutos> bonusLiga = new ArrayList();*/
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Constructores">
        public Liga() {
                equiposLiga = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                seleccionesLiga = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                todasSelecciones = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                todosJugadores = new Roster("Todos los jugadores", "ALL");
                nombresEquipos = new HashMap();
                initNombres();
                /*calendariosLiga = new ArrayList();
        resultadosLiga = new ArrayList();
        clasificacionesLiga = new ArrayList();
        bonusLiga = new ArrayList();*/
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
        public SortedSet<Roster> getEquipos() {
                return this.equiposLiga;
        }

        public Roster getJugadores() {
                return this.todosJugadores;
        }

        public SortedSet<Roster> getSeleccionesLiga() {
                return this.seleccionesLiga;
        }

        public SortedSet<Roster> getTodasSelecciones() {
                return this.todasSelecciones;
        }

        public Map<String, String> getNombresEquipos() {
                return nombresEquipos;
        }

        public void setNombresEquipos(Map<String, String> names) {
                nombresEquipos = names;
        }

        public void setEquipos(SortedSet<Roster> nuevosEquipos) {
                this.equiposLiga = nuevosEquipos;
        }

        public void setJugadores(Roster nuevosJugadores) {
                this.todosJugadores = nuevosJugadores;
        }

        public void setSeleccionesLiga(SortedSet<Roster> nuevasSelecciones) {
                this.seleccionesLiga = nuevasSelecciones;
        }

        public void setTodasSelecciones(SortedSet<Roster> nuevasSelecciones) {
                this.todasSelecciones = nuevasSelecciones;
        }

        /*public ArrayList <Resultado> getResultados(){
        return this.resultadosLiga;
    }
    public ArrayList <BonusMinutos> getBonus(){
        return this.bonusLiga;
    }

    public ArrayList <Calendario> getCalendarios(){
        return this.calendariosLiga;
    }
    public ArrayList <Clasificacion> getClasificaciones(){
        return this.clasificacionesLiga;
    }
    public void setResultados (ArrayList <Resultado> nuevosResultados){
        this.resultadosLiga = nuevosResultados;
    }
    public void setBonus (ArrayList <BonusMinutos> nuevosBonus){
        this.bonusLiga = nuevosBonus;
    }
    public void setCalendarios (ArrayList<Calendario> nuevosCalendarios){
        this.calendariosLiga = nuevosCalendarios;
    }
    public void setClasificaciones (ArrayList<Clasificacion> nuevasClasificaciones){
        this.clasificacionesLiga = nuevasClasificaciones;
    }*/
 /*public void setJugadores(){
        this.jugadoresLiga = devolverJugadores();
    }*/
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Cargar Datos">
        public void cargarDatos() throws IOException {
                cargarPlantillas();
                cargarNombresEquipos();
                cargarELO();
        }

        public void cargarNombresEquipos() throws FileNotFoundException, IOException {
                for (Roster r : equiposLiga) {
                        r.setNombre(nombresEquipos.get(r.getAbreviatura().toUpperCase()));
                }
        }

        public void cargarPlantillas() throws FileNotFoundException, IOException {
                FileReader teamsDir = new FileReader("teams.dir");
                BufferedReader bR = new BufferedReader(teamsDir);
                String nombrePlantilla = new String();
                while ((nombrePlantilla = bR.readLine()) != null) {
                        Roster nuevoEquipo = new Roster();
                        nuevoEquipo.setAbreviatura(nombrePlantilla.substring(0, 3));
                        nuevoEquipo.setNombre(nuevoEquipo.getAbreviatura());
                        FileReader rosterEquipo = new FileReader(nombrePlantilla);
                        BufferedReader bR2 = new BufferedReader(rosterEquipo);
                        String cadenaJugador = new String();
                        bR2.readLine();
                        bR2.readLine();
                        while ((cadenaJugador = bR2.readLine()) != null) {
                                Jugador player = new Jugador(cadenaJugador, nuevoEquipo.getAbreviatura());
                                nuevoEquipo.anadirJugador(player);
                                todosJugadores.anadirJugador(player);
                                Roster s = existeSeleccion(player.getNacionalidad());
                                if (s == null) {
                                        s = new Roster(player.getNacionalidad());
                                        todasSelecciones.add(s);
                                }

                                s.anadirJugador(player);
                        }
                        this.equiposLiga.add(nuevoEquipo);
                        // this.guardarSelecciones();
                }
        }

        public void cargarSelecciones() throws FileNotFoundException, IOException {
                FileReader seleccionesDir = new FileReader("selecciones.dir");
                BufferedReader bR = new BufferedReader(seleccionesDir);
                String seleccion = new String();
                while ((seleccion = bR.readLine()) != null) {
                        Roster sel = buscarEquipo(seleccion.substring(0, 3), todasSelecciones);
                        if (sel != null) {
                                this.seleccionesLiga.add(sel);
                        }
                }
        }

        public void cargarELO() throws FileNotFoundException, IOException {
                BufferedReader bR;
                File eloEquipos = new File("ELO Equipos.txt");
                if (eloEquipos.exists()) {
                        FileReader fR = new FileReader(eloEquipos);
                        bR = new BufferedReader(fR);
                        StringBuilder s;
                        String aux;
                        bR.readLine();
                        bR.readLine();
                        while ((aux = bR.readLine()) != null) {
                                s = new StringBuilder(aux);
                                s.delete(0, s.indexOf(" ") + 2);
                                String abrev = s.substring(0, s.indexOf(")"));
                                s.delete(0, s.indexOf(" ") + 1);
                                double elo = Double.parseDouble(s.toString());
                                buscarEquipo(abrev, equiposLiga).setElo(elo);
                        }
                }
        }

        public void cargarBonusMinutos() {
                /*    -------- Codigo Bonus Minutos -----------
        File bonusMin = new File ("Bonus de Minutos.txt");
                if (bonusMin.exists()){
                    FileReader fR = new FileReader (bonusMin);
                    bR = new BufferedReader (fR);
                    BonusMinutos bM = new BonusMinutos(bR);
                    this.bonusLiga.add(bM);
                }
        }*/
        }

        public void cargarResultados() {
                /*------- Codigo resultados equipos -----------
        File resultadosEquipos = new File ("results.txt");
        if (resultadosEquipos.exists()){
            FileReader results = new FileReader (resultadosEquipos);
            bR = new BufferedReader (results);
            StringBuilder s;
            String aux;
            while ((aux = bR.readLine())!=null){
                s = new StringBuilder (aux);
                String nombreLocal = s.substring(0, s.indexOf(" "));
                Equipo local = this.buscarEquipoNombre(nombreLocal);
                s.delete(0, s.indexOf(" ") + 1);
                int rLocal = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                s.delete (0, s.indexOf(" ") + 3);
                int rVisitante = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                s.delete(0, s.indexOf(" ") + 1);
                Equipo visitante = this.buscarEquipoNombre(s.toString());
                Resultado r = new Resultado (local, visitante, rLocal, rVisitante);
                this.resultadosLiga.add(r);
            }
        }
                 */
        }

        private void initNombres() {
                nombresEquipos.put("AJX", "AFC Ajax Amsterdam");
                nombresEquipos.put("ARS", "Arsenal FC");
                nombresEquipos.put("BLE", "TSV Bayer Leverkusen 04");
                nombresEquipos.put("ASM", "AS Monaco");
                nombresEquipos.put("ATM", "Atlético de Madrid");
                nombresEquipos.put("BAR", "FC Barcelona");
                nombresEquipos.put("CHE", "Chelsea FC");
                nombresEquipos.put("BDO", "Borussia Dortmund");
                nombresEquipos.put("BMU", "FC Bayern Munchen");
                nombresEquipos.put("INT", "Internazionale Milano");
                nombresEquipos.put("EVE", "Everton FC");
                nombresEquipos.put("NAP", "SSC Napoli");
                nombresEquipos.put("LEI", "Leicester City FC");
                nombresEquipos.put("JUV", "Juventus de Turín");
                nombresEquipos.put("TOT", "Tottenham Hotspurs");
                nombresEquipos.put("VAL", "Valencia CF");
                nombresEquipos.put("VIL", "Villarreal CF");
                nombresEquipos.put("S04", "Schalke 04");
                nombresEquipos.put("RMA", "Real Madrid CF");
                nombresEquipos.put("OMA", "Olympique Marsella");
                nombresEquipos.put("OPO", "FC Oporto");
                nombresEquipos.put("SEV", "Sevilla FC");
                nombresEquipos.put("SLB", "SL Benfica");
                nombresEquipos.put("NIC", "OGC Nice");
                nombresEquipos.put("MUN", "Manchester United FC");
                nombresEquipos.put("MCI", "Manchester City");
                nombresEquipos.put("ROM", "AS Roma");
                nombresEquipos.put("LYO", "Olympique Lyonnais");
                nombresEquipos.put("MIL", "AC Milan");
                nombresEquipos.put("PSV", "PSV Eindhoven");
                nombresEquipos.put("PSG", "Paris Saint Germain");
                nombresEquipos.put("LIV", "Liverpool FC");
                nombresEquipos.put("LIB", "Jugadores Libres");
        }

        public void guardarEquipos() throws IOException {
                for (Roster e : this.equiposLiga) {
                        e.guardarEquipo();
                }
        }

        public void guardarTodosJugadores() throws IOException {
                todosJugadores.guardarEquipo();
        }

        public void guardarSeleccionesLiga() throws IOException {
                for (Roster r : this.seleccionesLiga) {
                        r.guardarEquipo();
                }
        }

        public void guardarTodasSelecciones() throws IOException {
                for (Roster r : this.todasSelecciones) {
                        r.guardarEquipo();
                }
        }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Gestion de ED de la Liga">
        public Roster existeSeleccion(String abrev) {
                boolean resultado = false;
                Iterator it = this.todasSelecciones.iterator();
                Roster s = null;
                while (it.hasNext() && !resultado) {
                        s = (Roster) it.next();
                        if (s.getAbreviatura().equals(abrev)) {
                                resultado = true;
                        }
                }

                if (!resultado) {
                        s = null;
                }
                return s;
        }

        public Roster buscarEquipo(String abrev, SortedSet<Roster> contenedor) {
                Iterator it = contenedor.iterator();
                boolean encontrado = false;
                Roster buscado = null;
                while (it.hasNext() && !encontrado) {
                        Roster aux = (Roster) it.next();
                        if (aux.getAbreviatura().equalsIgnoreCase(abrev)) {
                                encontrado = true;
                                buscado = aux;
                        }
                }
                return buscado;
        }

        public void ordenarEquipos(int num, SortedSet<Roster> contenedor, int stat) {
                TreeSet<Roster> aux;
                switch (num) {

                        case 1: //<editor-fold defaultstate="collapsed" desc="Orden equipos Z - A (nombre)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
                                break;
//</editor-fold>

                        case 2: //<editor-fold defaultstate="collapsed" desc="Orden equipos A - Z (abreviatura)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                                break;
//</editor-fold>

                        case 3: //<editor-fold defaultstate="collapsed" desc="Orden equipos Z - A (abreviatura)">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getAbreviatura().compareTo(o2.getAbreviatura()));
                                break;
//</editor-fold>

                        case 4: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor tamaño plantilla a menor tamaño plantilla">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getJugadores().size() - o1.getJugadores().size());
                                break;
//</editor-fold>

                        case 5: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor tamaño plantilla a mayor tamaño plantilla">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getJugadores().size() - o2.getJugadores().size());
                                break;
//</editor-fold>

                        case 6: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor numero porteros a menor numero porteros">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnGk() - o1.getnGk());
                                break;
//</editor-fold>

                        case 7: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor numero porteros a mayor numero porteros">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnGk() - o2.getnGk());
                                break;
//</editor-fold>

                        case 8: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor numero defensas a menor numero">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnDf() - o1.getnDf());
                                break;
//</editor-fold>

                        case 9: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor numero defensas a mayor numero">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnDf() - o2.getnDf());
                                break;
//</editor-fold>

                        case 10: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero dm">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnDm() - o1.getnDm());
                                break;
//</editor-fold>

                        case 11: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero dm">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnDm() - o2.getnDm());
                                break;
//</editor-fold>

                        case 12: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero mf">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnMf() - o1.getnMf());
                                break;
//</editor-fold>

                        case 13: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero mf">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnMf() - o2.getnMf());
                                break;
//</editor-fold>

                        case 14: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero am">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnAm() - o1.getnAm());
                                break;
//</editor-fold>

                        case 15: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero am">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnAm() - o2.getnAm());
                                break;
//</editor-fold>

                        case 16: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor numero fw">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getnFw() - o1.getnFw());
                                break;
//</editor-fold>

                        case 17: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor numero fw">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getnFw() - o2.getnFw());
                                break;
//</editor-fold>

                        case 18: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor salario">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.getSalario() - o1.getSalario());
                                break;
//</editor-fold>

                        case 19: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor salario">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.getSalario() - o2.getSalario());
                                break;
//</editor-fold>

                        case 20: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor rendimiento">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getRendimiento(), o1.getRendimiento()));
                                break;
//</editor-fold>

                        case 21: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor rendimiento">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getRendimiento(), o2.getRendimiento()));
                                break;
//</editor-fold>

                        case 22: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor potencial">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getPotencial(), o1.getPotencial()));
                                break;
//</editor-fold>

                        case 23: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor potencial">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getPotencial(), o2.getPotencial()));
                                break;
//</editor-fold>

                        case 24: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor edad media">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getEdadMedia(), o1.getEdadMedia()));
                                break;
//</editor-fold>

                        case 25: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor edad media">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getEdadMedia(), o2.getEdadMedia()));
                                break;
//</editor-fold>

                        case 26: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor elo">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o2.getElo(), o1.getElo()));
                                break;
//</editor-fold>

                        case 27: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor elo">
                                aux = new TreeSet<Roster>((o1, o2) -> Double.compare(o1.getElo(), o2.getElo()));
                                break;
//</editor-fold>

                        case 28: //<editor-fold defaultstate="collapsed" desc="Orden equipos mayor a menor estadistica">
                                aux = new TreeSet<Roster>((o1, o2) -> o2.compareStats(o1, stat));
                                break;
//</editor-fold>

                        case 29: //<editor-fold defaultstate="collapsed" desc="Orden equipos menor a mayor estadistica">
                                aux = new TreeSet<Roster>((o1, o2) -> o1.compareStats(o2, stat));
                                break;
//</editor-fold>

                        default: //<editor-fold defaultstate="collapsed" desc="Orden por defecto, equipos A-Z (nombre)">
                                aux = new TreeSet<Roster>();
                                break;
//</editor-fold>
                }
                Iterator it = contenedor.iterator();
                while (it.hasNext()) {
                        Roster r = (Roster) it.next();
                        aux.add(r);
                }
                contenedor = aux;
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Operaciones">
        public String traspasarJugador(String abrevOrigen, String abrevDestino, Jugador j) {
                boolean encontradoOrigen = false;
                boolean encontradoDestino = false;
                Roster equipoOrigen = new Roster(), equipoDestino = new Roster(), e = new Roster();
                Iterator it = this.equiposLiga.iterator();
                while (it.hasNext() && (!encontradoOrigen || !encontradoDestino)) {
                        e = (Roster) it.next();
                        if ((abrevOrigen == e.getAbreviatura()) && (!encontradoOrigen)) {
                                equipoOrigen = e;
                                encontradoOrigen = true;
                        }
                        if ((abrevDestino == e.getAbreviatura()) && (!encontradoDestino)) {
                                equipoDestino = e;
                                encontradoDestino = true;
                        }
                }
                equipoOrigen.quitarJugador(j);
                equipoDestino.anadirJugador(j);
                j.setEquipo(abrevDestino);
                return ("El jugador " + j.getNombre() + " ha sido traspasado con exito de (" + equipoOrigen.getAbreviatura().toLowerCase()
                        + ") a (" + equipoDestino.getAbreviatura().toLowerCase() + ").");
        }
//</editor-fold>
}
