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
import javax.swing.JOptionPane;
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
        private Map<String, Entrenamiento> entrenamientosEquipos;
        private Map<String, Fit> fitEquipos;

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
                entrenamientosEquipos = new HashMap();
                fitEquipos = new HashMap();
                equiposLiga.setDefEquiposContenidos("Equipos existentes en ESO");
                seleccionesLiga.setDefEquiposContenidos("Selecciones que disputan competiciones en ESO");
                todasSelecciones.setDefEquiposContenidos("Selecciones de todas las nacionalidades de ESO");
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

        public Roster getTodosJugadores() {
                return todosJugadores;
        }

        public void setTodosJugadores(Roster todosJugadores) {
                this.todosJugadores = todosJugadores;
        }

        public Map<String, Entrenamiento> getEntrenamientosEquipos() {
                return entrenamientosEquipos;
        }

        public void setEntrenamientosEquipos(Map<String, Entrenamiento> entrenamientosEquipos) {
                this.entrenamientosEquipos = entrenamientosEquipos;
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
                cargarSelecciones();
                cargarNombresEquipos();
                cargarELO();
                cargarEntrenamientos();
                cargarFit();
        }

        public void cargarNombresEquipos() throws FileNotFoundException, IOException {
                for (Roster r : equiposLiga.getEquipos()) {
                        r.setNombre(nombresEquipos.get(r.getAbreviatura().toUpperCase()));
                }
        }

        public void cargarPlantillas() throws FileNotFoundException, IOException {
                boolean b1, b2, b3;
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
                                b1 = nuevoEquipo.anadirJugador(player);

                                b2 = todosJugadores.anadirJugador(player);
                                Roster s = existeSeleccion(player.getNacionalidad());
                                if (s == null) {
                                        s = new Roster(player.getNacionalidad());
                                        URL imagenS = this.getClass().getClassLoader().getResource("imagenes/escudos/" + player.getNacionalidad() + ".png");
                                        if (imagenS != null) {
                                                s.setImagenPath(imagenS);
                                        } else {
                                                s.setImagenPath(PATH_IMAGEN_VACIA);
                                        }
                                        s.setImagen(new ImageIcon(s.getImagenPath()));
                                        todasSelecciones.añadirEquipo(s);
                                }
                                b3 = s.anadirJugador(player);
                                if (!b1) {

                                        JOptionPane.showMessageDialog(null, player.getNombre() + " no pudo añadirse a " + nuevoEquipo.getAbreviatura() + ", " + nuevoEquipo.getJugadores().contains(player), "No se pudo añadir jugador", JOptionPane.ERROR_MESSAGE);
                                }
                                if (!b2) {
                                        JOptionPane.showMessageDialog(null, player.getNombre() + " no pudo añadirse a " + todosJugadores.getAbreviatura() + ", " + todosJugadores.getJugadores().contains(player), "No se pudo añadir jugador", JOptionPane.ERROR_MESSAGE);
                                }
                                if (!b3) {
                                        JOptionPane.showMessageDialog(null, player.getNombre() + " no pudo añadirse a " + s.getAbreviatura() + ", " + s.getJugadores().contains(player), "No se pudo añadir jugador", JOptionPane.ERROR_MESSAGE);
                                }
                        }
                        URL imagen = this.getClass().getClassLoader().getResource("imagenes/escudos/" + nuevoEquipo.getAbreviatura() + ".png");
                        if (imagen != null) {
                                nuevoEquipo.setImagenPath(imagen);
                        } else {
                                nuevoEquipo.setImagenPath(PATH_IMAGEN_VACIA);
                        }
                        nuevoEquipo.setImagen(new ImageIcon(nuevoEquipo.getImagenPath()));
                        this.equiposLiga.añadirEquipo(nuevoEquipo);
                        /* if ((this.getEquiposLiga().buscarEquipo("LIB")) != null) {
                                SortedSet<Jugador> query = this.getEquiposLiga().buscarEquipo("LIB").buscarJugadoresLike("Muto");
                                for (Jugador j : query) {
                                        System.err.println(j);
                                }
                        } else {
                                System.err.println("No he añadido LIB todavia");
                        }*/
                }
                /*SortedSet<Jugador> query = (this.getEquiposLiga().buscarEquipo("LIB")).buscarJugadoresLike("");
                if (query != null) {
                        for (Jugador j : query) {
                                System.err.println(j);
                        }
                }*/

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

        public void cargarEntrenamientos() throws FileNotFoundException, IOException {
                FileReader entrenamientos = new FileReader("Entrenamientos.dir");
                BufferedReader bR = new BufferedReader(entrenamientos);
                String s;
                /*Calendar fecha = GregorianCalendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int año = fecha.get(Calendar.YEAR);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int min = fecha.get(Calendar.MINUTE);*/
                while ((s = bR.readLine()) != null) {
                        String[] cadena = s.split("\\s+");
                        int i;
                        for (i = 4; i < cadena.length; i++) {
                                Entrenamiento entreno = new Entrenamiento(equiposLiga.buscarEquipo(cadena[i].toLowerCase()));
                                entreno.setEntrenamiento(cadena[0], cadena[1], cadena[2], cadena[3]);
                                entrenamientosEquipos.put(entreno.getEquipo().getAbreviatura().toLowerCase(), entreno);
                        }
                }

        }

        public void cargarFit() throws FileNotFoundException, IOException, ClassCastException {
                FileReader fisio = new FileReader("Fisio.dir");
                BufferedReader bR = new BufferedReader(fisio);
                String s;
                /*Calendar fecha = GregorianCalendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int año = fecha.get(Calendar.YEAR);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int min = fecha.get(Calendar.MINUTE);*/
                while ((s = bR.readLine()) != null) {
                        String[] cadena = s.split("\\s+");
                        cadena[0] = cadena[0].replaceAll("[^0-9]", "");
                        int i;
                        for (i = 1; i < cadena.length; i++) {

                                Fit fitEquipo = new Fit(equiposLiga.buscarEquipo(cadena[i].toLowerCase()), Integer.parseInt(cadena[0]));
                                fitEquipos.put(cadena[i].toLowerCase(), fitEquipo);
                        }
                }

        }

        public void sumarEntrenamientos(String rutaFichero, int nSemanas) throws IOException {
                FileWriter fichero = new FileWriter(rutaFichero);
                PrintWriter pW = new PrintWriter(new BufferedWriter(fichero));
                pW.println("SUMA DE ENTRENAMIENTOS");
                pW.println();
                LinkedList<Entrenamiento> entrenamientos = new LinkedList(entrenamientosEquipos.values());
                for (Entrenamiento train : entrenamientos) {
                        train.setEquipo(equiposLiga.buscarEquipo(train.getEquipo().getAbreviatura().toLowerCase()));
                        String s = train.sumarEntrenamiento(nSemanas);
                        equiposLiga.actualizarEquipo(train.getEquipo());
                        String[] cadena = s.split("\n");
                        for (String linea : cadena) {
                                pW.println(linea);
                        }
                        pW.println();
                }
                pW.close();
                fichero.close();
        }

        public void sumarFit() {
                LinkedList<Fit> fits = new LinkedList(fitEquipos.values());
                for (Fit f : fits) {
                        f.setEquipo(equiposLiga.buscarEquipo(f.getEquipo().getAbreviatura()));
                        f.sumarFit();
                        equiposLiga.actualizarEquipo(f.getEquipo());
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
                nombresEquipos.put("ASM", "AS Monaco");
                nombresEquipos.put("ATM", "Atlético de Madrid");
                nombresEquipos.put("BAR", "FC Barcelona");
                nombresEquipos.put("BDO", "Borussia Dortmund");
                nombresEquipos.put("BMU", "FC Bayern de Múnich");
                nombresEquipos.put("CHE", "Chelsea FC");
                nombresEquipos.put("INT", "Inter de Milán");
                nombresEquipos.put("JUV", "Juventus de Turín");
                nombresEquipos.put("MUN", "Manchester United");
                nombresEquipos.put("NAP", "SSC Napoli");
                nombresEquipos.put("NIC", "OGC Nice");
                nombresEquipos.put("OPO", "FC Porto");
                nombresEquipos.put("RMA", "Real Madrid CF");
                nombresEquipos.put("ROM", "AS Roma");
                nombresEquipos.put("SEV", "Sevilla FC");
                nombresEquipos.put("TOT", "Tottenham Hotspur");
                nombresEquipos.put("AJX", "AFC Ajax Amsterdam");
                nombresEquipos.put("ARS", "FC Arsenal");
                nombresEquipos.put("BLE", "Bayer 04 Leverkusen");
                nombresEquipos.put("EVE", "FC Everton");
                nombresEquipos.put("LEI", "Leicester City");
                nombresEquipos.put("LIV", "FC Liverpool");
                nombresEquipos.put("LYO", "Olympique Lyonnais");
                nombresEquipos.put("MCI", "Manchester City");
                nombresEquipos.put("OMA", "Olympique de Marseille");
                nombresEquipos.put("MIL", "AC Milan");
                nombresEquipos.put("PSG", "FC Paris Saint-Germain");
                nombresEquipos.put("PSV", "PSV Eindhoven");
                nombresEquipos.put("SLB", "SL Benfica");
                nombresEquipos.put("S04", "FC Schalke 04");
                nombresEquipos.put("VAL", "Valencia CF");
                nombresEquipos.put("VIL", "Villarreal CF");
                nombresEquipos.put("BOC", "Club Atlético Boca Juniors");
                nombresEquipos.put("COR", "Sport Club Corinthians");
                nombresEquipos.put("CRU", "Cruzeiro Esporte Clube");
                nombresEquipos.put("FLA", "Club de Regatas do Flamengo");
                nombresEquipos.put("GRM", "Grêmio Foot-Ball");
                nombresEquipos.put("CAI", "Club Atlético Independiente");
                nombresEquipos.put("NAC", "Club Nacional de Montevideo");
                nombresEquipos.put("PNL", "Club Atlético Peñarol");
                nombresEquipos.put("RAC", "Racing Club de Avellaneda");
                nombresEquipos.put("RIV", "Club Atlético River Plate");
                nombresEquipos.put("SPO", "São Paulo Futebol Clube");
                nombresEquipos.put("TIG", "Tigres UANL");
                nombresEquipos.put("ALI", "Alianza Lima");
                nombresEquipos.put("ATN", "Atletico Nacional");
                nombresEquipos.put("AME", "CF América de Mexico");
                nombresEquipos.put("GUA", "Deportivo Guadalajara");
                nombresEquipos.put("ISF", "Independiente de Santa Fe");
                nombresEquipos.put("LAG", "Los Angeles Galaxy");
                nombresEquipos.put("NYC", "New York City FC");
                nombresEquipos.put("PUM", "Pumas UNAM");
                nombresEquipos.put("SAN", "San Lorenzo de Almagro");
                nombresEquipos.put("TOR", "Toronto FC");
                nombresEquipos.put("UCA", "CD Universidad Catolica");
                nombresEquipos.put("UCH", "Club Universidad de Chile");
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

        public void devolverJugadoresSelecciones() {
                for (Roster s : this.seleccionesLiga.getEquipos()) {
                        for (Jugador j : s.getJugadores()) {
                                boolean encontrado = false;
                                Iterator it = this.getJugadores().getJugadores().iterator();
                                Jugador j2 = new Jugador();
                                while ((it.hasNext()) && (!encontrado)) {
                                        j2 = (Jugador) it.next();
                                        if (j2.equals(j)) {
                                                encontrado = true;
                                        }
                                }
                                if (encontrado) {
                                        j.setEquipo(j2.getEquipo());
                                        this.getJugadores().getJugadores().remove(j2);
                                        j2 = new Jugador(j);
                                        this.getJugadores().getJugadores().add(j2);
                                        Iterator it2 = this.getEquiposLiga().getEquipos().iterator();
                                        Roster e = new Roster();
                                        encontrado = false;
                                        while ((it2.hasNext()) && !encontrado) {
                                                e = (Roster) it2.next();
                                                if (e.getAbreviatura().equals(j2.getEquipo())) {
                                                        encontrado = true;
                                                }
                                        }
                                        if (encontrado) {
                                                Iterator it3 = e.getJugadores().iterator();
                                                boolean estaJugador = false;
                                                Jugador j3 = new Jugador();
                                                while ((it3.hasNext()) && !estaJugador) {
                                                        j3 = (Jugador) it3.next();
                                                        if (j2.equals(j3)) {
                                                                estaJugador = true;
                                                        }
                                                }
                                                if (estaJugador) {
                                                        e.getJugadores().remove(j3);
                                                        j3 = new Jugador(j2);
                                                        e.getJugadores().add(j3);
                                                } else {
                                                        JOptionPane.showMessageDialog(null, j.getNombre() + " no se ha encontrado en el equipo " + e.getNombre(), "No se ha encontrado el jugador", JOptionPane.ERROR_MESSAGE);
                                                }
                                        } else {
                                                JOptionPane.showMessageDialog(null, j.getNombre() + " no se ha encontrado en todos los jugadores de la liga", "No se ha encontrado el jugador", JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                        }
                }
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
