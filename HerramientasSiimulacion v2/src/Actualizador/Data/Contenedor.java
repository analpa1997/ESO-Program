package Actualizador.Data;

import java.io.*;
import java.util.*;

/**
 *
 * @author Antonio
 */
public class Contenedor {

        private ArrayList<Equipo> equiposLiga = new ArrayList();
        private ArrayList<Jugador> jugadoresLiga = new ArrayList();

        /*private ArrayList <Seleccion> seleccionesLiga = new ArrayList();
    private ArrayList <Calendario> calendariosLiga = new ArrayList();
    private ArrayList <Resultado> resultadosLiga = new ArrayList();
    private ArrayList <Clasificacion> clasificacionesLiga = new ArrayList();
    private ArrayList <BonusMinutos> bonusLiga = new ArrayList();*/
        public Contenedor() {
                equiposLiga = new ArrayList();
                jugadoresLiga = new ArrayList();
                /*seleccionesLiga = new ArrayList();
        calendariosLiga = new ArrayList();
        resultadosLiga = new ArrayList();
        clasificacionesLiga = new ArrayList();
        bonusLiga = new ArrayList();*/
        }

        /* public ArrayList <Resultado> getResultados(){
        return this.resultadosLiga;
    }
    public ArrayList <BonusMinutos> getBonus(){
        return this.bonusLiga;
    }*/
        public ArrayList<Equipo> getEquipos() {
                return this.equiposLiga;
        }

        public ArrayList<Jugador> getJugadores() {
                return this.jugadoresLiga;
        }

        /*public ArrayList <Seleccion> getSelecciones(){
        return this.seleccionesLiga;
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
    }*/
        public void setEquipos(ArrayList<Equipo> nuevosEquipos) {
                this.equiposLiga = nuevosEquipos;
        }

        public void setJugadores(ArrayList<Jugador> nuevosJugadores) {
                this.jugadoresLiga = nuevosJugadores;
        }

        /*public void setSelecciones (ArrayList <Seleccion> nuevasSelecciones){
        this.seleccionesLiga = nuevasSelecciones;
    }
    public void setCalendarios (ArrayList<Calendario> nuevosCalendarios){
        this.calendariosLiga = nuevosCalendarios;
    }
    public void setClasificaciones (ArrayList<Clasificacion> nuevasClasificaciones){
        this.clasificacionesLiga = nuevasClasificaciones;
    }*/
        public void setJugadores() {
                this.jugadoresLiga = devolverJugadores();
        }

        private ArrayList<Jugador> devolverJugadores() {
                ArrayList<Jugador> rosterGeneral = new ArrayList();
                for (Equipo e : this.equiposLiga) {
                        for (Jugador j : e.getRoster()) {
                                rosterGeneral.add(j);
                        }
                }
                return rosterGeneral;
        }

        /* public void cargarSelecciones() throws FileNotFoundException, IOException{
        this.seleccionesLiga = new ArrayList();
        FileReader seleccionesDir = new FileReader("selecciones.dir");
        BufferedReader bR = new BufferedReader(seleccionesDir);
        String seleccion = new String();
        ArrayList <Seleccion> nuevasSelecciones = new ArrayList <Seleccion>();
        while((seleccion = bR.readLine()) != null){
            Seleccion sel = new Seleccion();
            sel.setAbrev(seleccion.substring(0,3));
            this.seleccionesLiga.add(sel);
            FileReader fSeleccion = new FileReader (seleccion);
            BufferedReader bR2 = new BufferedReader (fSeleccion);
            String jugadorSeleccion = new String();
            bR2.readLine();
            bR2.readLine();
            while ((jugadorSeleccion = bR2.readLine())!= null){
                Jugador jugador = new Jugador (jugadorSeleccion, sel.getAbrev());
                sel.añadirJugador(jugador);
            }
        }
    }*/
        public void ordenarRoster() {
                Collections.sort(this.getJugadores(), new CompareJugadores());
        }

        public void ordenarRosterAZ() {
                Collections.sort(this.getJugadores());
        }

        public void cargarDatos() throws FileNotFoundException, IOException {
                FileReader teamsDir = new FileReader("teams.dir");
                BufferedReader bR = new BufferedReader(teamsDir);
                String nombrePlantilla = new String();
                while ((nombrePlantilla = bR.readLine()) != null) {

                        Equipo nuevoEquipo = new Equipo();
                        nuevoEquipo.setAbrev(nombrePlantilla.substring(0, 3));

                        nuevoEquipo.setNombre(nuevoEquipo.getAbrev());
                        FileReader rosterEquipo = new FileReader(nombrePlantilla);
                        BufferedReader bR2 = new BufferedReader(rosterEquipo);
                        String cadenaJugador = new String();
                        bR2.readLine();
                        bR2.readLine();

                        while ((cadenaJugador = bR2.readLine()) != null) {
                                if (!cadenaJugador.equals("") && !cadenaJugador.matches("\\s+")) {
                                        Jugador player = new Jugador(cadenaJugador, nuevoEquipo.getAbrev());
                                        nuevoEquipo.anadirJugador(player);
                                        this.jugadoresLiga.add(player);
                                }
                        }
                        this.equiposLiga.add(nuevoEquipo);
                        //this.guardarSelecciones();
                }
                /*   File nombresEquipos = new File("Nombre Equipos.txt");
                if (nombresEquipos.exists()) {
                        FileReader nombres = new FileReader(nombresEquipos);
                        bR = new BufferedReader(nombres);
                        ArrayList<String[]> nEquipos = new ArrayList<>();
                        String s;
                        while ((s = bR.readLine()) != null) {
                                nEquipos.add(s.split("="));
                        }
                        for (Equipo e : this.equiposLiga) {
                                for (String[] s1 : nEquipos) {
                                        if (s1[0].equals(e.getAbrev())) {
                                                e.setNombre(s1[1]);
                                                break;
                                        }
                                }
                        }
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
                }*/
 /*File eloEquipos = new File ("ELO Equipos.txt");
        if (eloEquipos.exists()){
            FileReader fR = new FileReader (eloEquipos);
            bR = new BufferedReader (fR);
            StringBuilder s;
            String aux;
            bR.readLine();
            bR.readLine();
            while ((aux = bR.readLine())!= null){
                s = new StringBuilder (aux);
                s.delete (0, s.indexOf(" ")+2);
                String abrev = s.substring(0, s.indexOf(")"));
                s.delete (0, s.indexOf(" ")+1);
                double elo = Double.parseDouble(s.toString());
                this.buscarEquipo(abrev).setElo(elo);
            }
        }*/
 /*File bonusMin = new File ("Bonus de Minutos.txt");
        if (bonusMin.exists()){
            FileReader fR = new FileReader (bonusMin);
            bR = new BufferedReader (fR);
            BonusMinutos bM = new BonusMinutos(bR);
            this.bonusLiga.add(bM);
        }*/
        }

        /*public void generarClasificacion(){
        ArrayList <Equipo> equipos = new ArrayList ();
        for (Resultado r: this.resultadosLiga){
            if (!equipos.contains(r.getLocal())){
                equipos.add(r.getLocal());
            }
            if (!equipos.contains(r.getVisitante())){
                equipos.add(r.getVisitante());
            }
        }
        Clasificacion c = new Clasificacion();
        for (Equipo e: equipos){
            c.getEquipos().add(new EquipoClas(e));
        }
        clasificacionesLiga.add(c);
        for (Resultado r: this.resultadosLiga){
            EquipoClas local = c.buscarEquipoClas(r.getLocal().getNombre());
            EquipoClas visitante = c.buscarEquipoClas(r.getVisitante().getNombre());
            local.setGFavor(local.getGFavor() + r.getResLocal());
            local.setGContra(local.getGContra() + r.getResVisitante());
            visitante.setGFavor(visitante.getGFavor() + r.getResVisitante());
            visitante.setGContra(visitante.getGContra() + r.getResLocal());
            if (r.getResLocal() - r.getResVisitante() > 0){
                local.setGanados(local.getGanados() + 1);
                visitante.setPerdidos(visitante.getPerdidos() + 1);
            }else if (r.getResLocal() - r.getResVisitante() < 0){
                local.setPerdidos(local.getPerdidos() + 1);
                visitante.setGanados(visitante.getGanados() + 1);
            }else{
                local.setEmpatados(local.getEmpatados() + 1);
                visitante.setEmpatados(visitante.getEmpatados() + 1);
            }
            local.setJugados();
            local.setDGoles();
            local.setPuntos();
            visitante.setJugados();
            visitante.setDGoles();
            visitante.setPuntos();
        }
}*/
        public void escribirCabecera(PrintWriter pw) {
                pw.println("Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit");
                pw.println("----------------------------------------------------------------------------------------------------------------");
        }

        /*public void ordenarPorStats(){
        int stat = 0;
        ArrayList <Jugador> jugadores = this.getJugadores();
        Scanner kbd = new Scanner(System.in);
        stat = kbd.nextInt();
        Collections.sort(jugadores, new CompareStats(stat));
    }*/
        public String traspasarJugador(String abrevOrigen, String abrevDestino, Jugador j) {
                boolean encontradoOrigen = false;
                boolean encontradoDestino = false;
                Equipo equipoOrigen = new Equipo(), equipoDestino = new Equipo(), e = new Equipo();
                Iterator it = this.equiposLiga.iterator();
                while (it.hasNext() && (!encontradoOrigen || !encontradoDestino)) {
                        e = (Equipo) it.next();
                        if ((abrevOrigen == e.getAbrev()) && (!encontradoOrigen)) {
                                equipoOrigen = e;
                                encontradoOrigen = true;
                        }
                        if ((abrevDestino == e.getAbrev()) && (!encontradoDestino)) {
                                equipoDestino = e;
                                encontradoDestino = true;
                        }
                }
                equipoOrigen.getRoster().remove(j);
                equipoDestino.getRoster().add(j);
                j.setEquipo(abrevDestino);
                equipoOrigen.ordenarRoster();
                equipoDestino.ordenarRoster();
                return ("El jugador " + j.getNombre() + " ha sido traspasado con exito de (" + equipoOrigen.getAbrev().toLowerCase()
                        + ") a (" + equipoDestino.getAbrev().toLowerCase() + ").");
        }

        public Equipo buscarEquipo(String abrev) {
                Iterator it = this.getEquipos().iterator();
                boolean encontrado = false;
                Equipo buscado = new Equipo();
                while (it.hasNext() && !encontrado) {
                        buscado = (Equipo) it.next();
                        if (buscado.getAbrev().equalsIgnoreCase(abrev)) {
                                encontrado = true;
                        }
                }
                return buscado;
        }

        public Equipo buscarEquipoNombre(String nombre) {
                Iterator it = this.getEquipos().iterator();
                boolean encontrado = false;
                Equipo buscado = new Equipo();
                while (it.hasNext() && !encontrado) {
                        buscado = (Equipo) it.next();
                        if (buscado.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                                encontrado = true;
                        }
                }
                return buscado;
        }

        public Jugador buscarJugador(String nombre) {
                Iterator it = this.getJugadores().iterator();
                boolean encontrado = false;
                Jugador buscado = new Jugador();
                while (it.hasNext() && !encontrado) {
                        buscado = (Jugador) it.next();
                        if (buscado.getNombre().equals(nombre)) {
                                encontrado = true;
                        }
                }
                return buscado;
        }

        public void guardarEquipos() throws IOException {
                for (Equipo e : this.equiposLiga) {
                        FileWriter equipo = new FileWriter(e.getAbrev() + ".txt");
                        BufferedWriter bw = new BufferedWriter(equipo);
                        PrintWriter output = new PrintWriter(bw);
                        escribirCabecera(output);
                        e.ordenarRoster();
                        for (Jugador j : e.getRoster()) {
                                output.println(j.toString());
                        }
                        output.close();
                }
        }

        public void guardarJugadores() throws IOException {
                FileWriter jugadoresLiga = new FileWriter("Todos los jugadores.txt");
                BufferedWriter bw = new BufferedWriter(jugadoresLiga);
                PrintWriter output = new PrintWriter(bw);
                escribirCabecera(output);
                ordenarRoster();
                for (Jugador j : this.jugadoresLiga) {
                        output.println(j.toString());
                }
                output.close();
        }
        /*public Seleccion existeSeleccion(String abrev){
        boolean resultado = false;
        Iterator it = this.seleccionesLiga.iterator();
        Seleccion s = null;
        while (it.hasNext() && !resultado){
            s = (Seleccion) it.next();
            if (s.getAbrev().equals(abrev)){
                resultado = true;
            }
        }
        if (!resultado){
            s = null;
        }
        return s;
    }*/
 /*public void guardarSelecciones(){
        for (Equipo e: this.equiposLiga){
            ArrayList <Jugador> roster = e.getRoster();
            for (Jugador j : roster){
                String nac = j.getNacionalidad().toLowerCase();
                Seleccion s = existeSeleccion(nac);
                if (s == null){
                    s = new Seleccion (nac);
                    this.seleccionesLiga.add(s);
                }
                if(!s.estaJugador(j)){
                    s.añadirJugador(j);
                }
                s = null;
            }
        }
    }*/
 /*public void escribirSelecciones() throws IOException{
        for (Seleccion s: this.seleccionesLiga){
            FileWriter equipo = new FileWriter(s.getAbrev() + ".txt");
            BufferedWriter bw = new BufferedWriter(equipo);
            PrintWriter output = new PrintWriter(bw);
            escribirCabecera(output);
            s.ordenarRoster();
            for (Jugador j: s.getJugadores()){
                output.println(j.toString());
            }
            output.close();
        }
    }*/
}
