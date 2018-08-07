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
    public enum Posicion {gk, df, dm, mf, am, fw};
    private Posicion pos;
    private int edad, posInt;
    private final int ag = 30;
    private Habilidad portero, defensa, medio, delantero;
    private Estadisticas stats;
    private double rendimiento;
    private int [] medias = new int [4];
    private int salario;
    
    public Jugador(){
        
    }
    
    public Jugador(Jugador j){
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
    
    public Jugador(StringBuilder lineaFichero, String nombreFichero){
        portero = new Habilidad();
        defensa = new Habilidad();
        medio = new Habilidad();
        delantero = new Habilidad ();
        stats = new Estadisticas();
        this.equipo = nombreFichero;
        this.nombre = lineaFichero.substring(0, lineaFichero.indexOf(" "));
        lineaFichero = lineaFichero.delete(0, 14);
        this.edad = Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" ")));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        this.nacionalidad = lineaFichero.substring(0, lineaFichero.indexOf(" "));
        lineaFichero = lineaFichero.delete(0, 4);
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero.delete(0, 1);
        }
        int mediaAux, expAux;
        mediaAux = Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" ")));
        portero.setMedia(mediaAux);
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero.delete(0, 1);
        }
        mediaAux = Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" ")));
        defensa.setMedia(mediaAux);
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero.delete(0, 1);
        }
        mediaAux = Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" ")));
        medio.setMedia(mediaAux);
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero.delete(0, 1);
        }
        mediaAux = Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" ")));
        delantero.setMedia(mediaAux);
        
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        lineaFichero = lineaFichero.delete(0, 1);
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        
        portero.setExp (Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        defensa.setExp (Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        medio.setExp (Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        delantero.setExp (Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setPJugados(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setPSuplente(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setMinutos(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setMom(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setParadas(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setEncajados(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setTackles(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setPases(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setTiros(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setGoles(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setAsistencias(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setDP(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setLesion(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setSancion(Integer.parseInt(lineaFichero.substring(0, lineaFichero.indexOf(" "))));
        lineaFichero = lineaFichero.delete(0, lineaFichero.indexOf(" "));
        while (lineaFichero.indexOf(" ") == 0){
            lineaFichero = lineaFichero.delete(0,1);
        }
        stats.setFit(Integer.parseInt(lineaFichero.substring(0, lineaFichero.length())));
        lineaFichero = lineaFichero.delete(0, lineaFichero.length());
        this.definirMedias();
        this.definirPosicion();
        this.definirPosInt();
    }
    
    public void definirPosInt(){
        if (null != pos) switch (pos) {
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
    public String getNombre (){
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
    public int getEdad(){
        return edad;
    }
    public Habilidad getGkSkills(){
        return portero;
    }
    public Habilidad getDfSkills(){
        return defensa;
    }
    public Habilidad getMfSkills(){
        return medio;
    }
    public Habilidad getFwSkills(){
        return delantero;
    }
    public Estadisticas getStats () {
        return stats;
    }
    public Posicion getPosicion(){
        return pos;
    }
    public int getPosInt(){
        return posInt;
    }
    public double getRendimiento(){
        return rendimiento;
    }
    public int[] getMedias(){
        return this.medias;
    }
    public double getSalario(){
        return this.salario;
    }
    public void setSalario (int wage){
        this.salario = wage;
    }
    public void setMedias(int[] nMedias){
        this.medias = nMedias;
    }
    private String espacios(){
        String space = new String ();
        space = " ";
        return space;
    }
    private String espaciosStats(int stat){
        String espacio = new String ();
        if (stat < 100){
            if (stat < 10){
                espacio = espacio + espacios();
            }
            espacio = espacio + espacios();
        }
        espacio = espacio + espacios() + stat;
        return espacio;
    }
    private String espaciosMin(int stat){
        String espacio = new String ();
        if (stat<1000){
            if (stat < 100){
                if (stat < 10){
                    espacio = espacio + espacios();
                }
                espacio = espacio + espacios();
            }
            espacio = espacio + espacios();
        }
        espacio = espacio + espacios() + stat;
        return espacio;
    }
    private String espaciosMedias(int stat){
        String aux = new String ();
        if (stat < 10){
            aux = aux + espacios();
        }
        aux = aux + espacios() + stat;
        return aux;
    }
    
    @Override
    public String toString (){
        String prueba = new String();
        prueba = this.nombre;
        for (int i = this.nombre.length(); i<14; i++){
            prueba = prueba + espacios();
        } 
        prueba = prueba + this.edad + espacios() + this.nacionalidad;
        prueba = prueba + espaciosMedias(this.portero.getMedia());
        prueba = prueba + espaciosMedias(this.defensa.getMedia());
        prueba = prueba + espaciosMedias(this.medio.getMedia());
        prueba = prueba + espaciosMedias(this.delantero.getMedia());
        prueba = prueba + espacios() + this.ag;
        prueba = prueba + espaciosStats(this.portero.getExp());
        prueba = prueba + espaciosStats(this.defensa.getExp());
        prueba = prueba + espaciosStats(this.medio.getExp());
        prueba = prueba + espaciosStats(this.delantero.getExp());
        prueba = prueba + espaciosStats(this.stats.getJugados());
        prueba = prueba + espaciosStats(this.stats.getSuplente());
        prueba = prueba + espaciosMin(this.stats.getMinutos());
        prueba = prueba + espaciosStats(this.stats.getMom());
        prueba = prueba + espaciosStats(this.stats.getParadas());
        prueba = prueba + espaciosStats(this.stats.getEncajados());
        prueba = prueba + espaciosStats(this.stats.getTackles());
        prueba = prueba + espaciosStats(this.stats.getPases());
        prueba = prueba + espaciosStats(this.stats.getTiros());
        prueba = prueba + espaciosStats(this.stats.getGoles());
        prueba = prueba + espaciosStats(this.stats.getAsistencias());
        prueba = prueba + espaciosStats(this.stats.getDP());
        prueba = prueba + espaciosStats(this.stats.getLesion());
        prueba = prueba + espaciosStats(this.stats.getSancion());
        prueba = prueba + espaciosStats(this.stats.getFit());
        return prueba;
    }
    public boolean equals (Jugador j){
        return((this.nombre.toLowerCase().equals(j.nombre.toLowerCase())) && (this.edad == j.edad) && (this.nacionalidad.toLowerCase().equals(j.nacionalidad.toLowerCase())));
    }
    public void definirPosicion(){
        int maximaMedia = this.medias[0];
        if (this.portero.getMedia() == maximaMedia) pos = Posicion.gk;
        else {
            if (this.defensa.getMedia() == maximaMedia){
                if (this.medio.getMedia() == maximaMedia){
                    if (this.delantero.getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.defensa.getExp(), Math.max(this.medio.getExp(), this.delantero.getExp()));
                        if (this.defensa.getExp() == maximaExp) pos = Posicion.df;
                        else if (this.medio.getExp() == maximaExp) pos = Posicion.mf;
                        else pos = Posicion.fw;
                    }
                    else{
                        int maximaExp = Math.max(this.defensa.getExp(), this.medio.getExp());
                        if (this.defensa.getExp() == maximaExp) pos = Posicion.df;
                        else pos = Posicion.dm;
                    }
                }
                else{
                    if (this.delantero.getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.defensa.getExp(), this.delantero.getExp());
                        if (this.defensa.getExp() == maximaExp) pos = Posicion.df;
                        else pos = Posicion.fw;
                    }
                    else pos = Posicion.df;
                }
            }
            else{
                if(this.medio.getMedia() == maximaMedia){
                    if (this.delantero.getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.medio.getExp(), this.delantero.getExp());
                        if (this.medio.getExp() == maximaExp) pos = Posicion.am;
                        else pos = Posicion.fw;
                    }
                    else{
                        if (((this.delantero.getMedia() - this.defensa.getMedia())<=-4) && (this.medio.getMedia() - this.defensa.getMedia() <= 5)){
                            pos = Posicion.dm;
                        }else if (((this.delantero.getMedia() - this.defensa.getMedia())>=4) && (this.medio.getMedia() - this.delantero.getMedia() <= 5)){
                            pos = Posicion.am;
                        }else{
                            pos = Posicion.mf;
                        }
                        
                    }
                }
                else pos = Posicion.fw;
            }
        }
    }
    public void definirMedias(){
        int [] medias = {this.getGkSkills().getMedia(), this.getDfSkills().getMedia(), this.getMfSkills().getMedia(), this.getFwSkills().getMedia()};
        for (int i:medias){
            if (i>this.medias[0]){
                this.medias[3] = this.medias[2];
                this.medias[2] = this.medias[1];
                this.medias[1] = this.medias[0];
                this.medias[0] = i;
            }else if (i>this.medias[1]){
                this.medias[3] = this.medias[2];
                this.medias[2] = this.medias[1];
                this.medias[1] = i;
            }else if (i>this.medias[2]){
                this.medias[3] = this.medias[2];
                this.medias[2] = i;
            }else{
                this.medias[3] = i;
            }
        }
    }
    public boolean estaDisponible(){
        return (this.getStats().getFit() >= 80) && (this.getStats().getLesion() == 0) && (this.getStats().getSancion() == 0);
    }
}
