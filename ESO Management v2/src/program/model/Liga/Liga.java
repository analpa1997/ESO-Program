/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Liga;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.ImageIcon;
import program.model.Equipo.*;
import program.model.Jugador.*;

/**
 *
 * @author Antonio
 */
public class Liga {

//<editor-fold defaultstate="collapsed" desc="Atributos">
        private Equipos equiposLiga, seleccionesLiga, todasSelecciones;
        private Roster todosJugadores;
        private Map<String, String> nombresEquipos;

        private final URL PATH_IMAGEN_VACIA = this.getClass().getClassLoader().getResource("imagenes/vacia.png");

        /*private ArrayList <Calendario> calendariosLiga = new ArrayList();
    private ArrayList <Resultado> resultadosLiga = new ArrayList();
    private ArrayList <Clasificacion> clasificacionesLiga = new ArrayList();
    private ArrayList <BonusMinutos> bonusLiga = new ArrayList();*/
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Constructores">
        public Liga() {
                equiposLiga = new Equipos();
                seleccionesLiga = new Equipos();
                todasSelecciones = new Equipos();
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
        /**
         * Método para obtener todos los jugadores de la liga
         *
         * @return Un objeto Roster con todos los jugadores de la liga
         */
        public Roster getJugadores() {
                return this.todosJugadores;
        }

        public Map<String, String> getNombresEquipos() {
                return nombresEquipos;
        }

        public void setNombresEquipos(Map<String, String> names) {
                nombresEquipos = names;
        }

        public void setJugadores(Roster nuevosJugadores) {
                this.todosJugadores = nuevosJugadores;
        }

        public Equipos getEquiposLiga() {
                return equiposLiga;
        }

        public void setEquiposLiga(Equipos equiposLiga) {
                this.equiposLiga = equiposLiga;
        }

        public Equipos getSeleccionesLiga() {
                return seleccionesLiga;
        }

        public void setSeleccionesLiga(Equipos seleccionesLiga) {
                this.seleccionesLiga = seleccionesLiga;
        }

        public Equipos getTodasSelecciones() {
                return todasSelecciones;
        }

        public void setTodasSelecciones(Equipos todasSelecciones) {
                this.todasSelecciones = todasSelecciones;
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
                for (Roster r : equiposLiga.getEquipos()) {
                        r.setNombre(nombresEquipos.get(r.getAbreviatura().toUpperCase()));
                }
        }

        public void cargarPlantillas() throws FileNotFoundException, IOException {
                FileReader teamsDir = new FileReader("teams.dir");
                BufferedReader bR = new BufferedReader(teamsDir);
                String nombrePlantilla = new String();
                while ((nombrePlantilla = bR.readLine()) != null) {
                        System.out.println(nombrePlantilla);
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
                                        URL imagenS = this.getClass().getClassLoader().getResource("imagenes/escudos/" + nuevoEquipo.getAbreviatura() + ".png");
                                        if (imagenS != null) {
                                                s.setImagenPath(imagenS);
                                        } else {
                                                s.setImagenPath(PATH_IMAGEN_VACIA);
                                        }
                                        s.setImagen(new ImageIcon(s.getImagenPath()));
                                        todasSelecciones.añadirEquipo(s);
                                }

                                s.anadirJugador(player);
                        }
                        URL imagen = this.getClass().getClassLoader().getResource("imagenes/escudos/" + nuevoEquipo.getAbreviatura() + ".png");
                        if (imagen != null) {
                                nuevoEquipo.setImagenPath(imagen);
                        } else {
                                nuevoEquipo.setImagenPath(PATH_IMAGEN_VACIA);
                        }
                        nuevoEquipo.setImagen(new ImageIcon(nuevoEquipo.getImagenPath()));
                        this.equiposLiga.añadirEquipo(nuevoEquipo);
                }
        }

        public void cargarSelecciones() throws FileNotFoundException, IOException {
                FileReader seleccionesDir = new FileReader("selecciones.dir");
                BufferedReader bR = new BufferedReader(seleccionesDir);
                String seleccion = new String();
                while ((seleccion = bR.readLine()) != null) {
                        Roster sel = todasSelecciones.buscarEquipo(seleccion.substring(0, 3));
                        if (sel != null) {
                                this.seleccionesLiga.añadirEquipo(sel);
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
                                equiposLiga.buscarEquipo(abrev).setElo(elo);
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
                for (Roster e : this.equiposLiga.getEquipos()) {
                        e.guardarEquipo();
                }
        }

        public void guardarTodosJugadores() throws IOException {
                todosJugadores.guardarEquipo();
        }

        public void guardarSeleccionesLiga() throws IOException {
                for (Roster r : this.seleccionesLiga.getEquipos()) {
                        r.guardarEquipo();
                }
        }

        public void guardarTodasSelecciones() throws IOException {

        }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Gestion de ED de la Liga">
        public Roster existeSeleccion(String abrev) {
                return todasSelecciones.buscarEquipo(abrev);
        }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Operaciones">
        public String traspasarJugador(String abrevOrigen, String abrevDestino, Jugador j) {
                boolean encontradoOrigen = false;
                boolean encontradoDestino = false;
                Roster equipoOrigen = new Roster(), equipoDestino = new Roster(), e = new Roster();
                Iterator it = this.equiposLiga.getEquipos().iterator();
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
