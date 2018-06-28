/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;


/**
 *
 * @author Antonio
 */
public class Jugador implements Comparable <Jugador>{
    private String nombre, nacionalidad, equipo;
    public enum Posicion {gk, df, dm, mf, am, fw};
    private Posicion pos;
    private int edad, posInt;
    private int ag;
    private Habilidad portero, defensa, medio, delantero;
    private Estadisticas stats;
    private double rendimiento;
    private int [] medias = new int [4];
    private int salario;
    private boolean estaLesionado, estaSancionado;
    
    public Jugador(){
        
    }
    
    public Jugador(Jugador j){
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
    }
    
    public Jugador(String lineaFichero, String nombreFichero){
        this.equipo = nombreFichero;
        String[] cadena = lineaFichero.split("\\s+");
        this.nombre = cadena[0];
        this.edad = Integer.parseInt(cadena[1]);
        this.nacionalidad = cadena[2];
        portero = new Habilidad(Integer.parseInt(cadena[3]), Integer.parseInt(cadena[8]));
        defensa = new Habilidad(Integer.parseInt(cadena[4]), Integer.parseInt(cadena[9]));
        medio = new Habilidad(Integer.parseInt(cadena[5]), Integer.parseInt(cadena[10]));
        delantero = new Habilidad (Integer.parseInt(cadena[6]), Integer.parseInt(cadena[11]));
        ag = Integer.parseInt(cadena[7]);
        int[] statistics = new int[15];
        int g = 12;
        for (int i = 0; i<15; i++){
            statistics[i] = Integer.parseInt(cadena[g]);
            g++;
        }
        stats = new Estadisticas(statistics);
        this.setLesionado();
        this.setSancionado();
        this.definirPosicion();
        this.definirPosInt();
        this.definirMedias();
        this.definirSalario();
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
    public void setRendimiento(double nRend){
        rendimiento = nRend;
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
    public int compararStats(Jugador j, int stat){
        return this.stats.compararStats(j.stats, stat);
    }
    public boolean equals (Jugador j){
        return((this.nombre.toLowerCase().equals(j.nombre.toLowerCase())) && (this.edad == j.edad) && (this.nacionalidad.toLowerCase().equals(j.nacionalidad.toLowerCase())));
    }
    public void sumarFit(int nFit){
        this.stats.setFit(this.stats.getFit() + nFit);
    }
    public void definirPosicion(){
        int maximaMedia = this.mediaMax();
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
    public double calcularPotencial(){
        double multEdad = 0;
        double [] multMedia = {50, 80, 120, 180, 260, 400, 600, 900, 1340, 2000};
        if (this.getEdad() < 36){
            if (this.getEdad() <34){
                if (this.getEdad()<30){
                    if (this.getEdad()<24){
                        if (this.getEdad() < 21) multEdad = 0.7;
                        else multEdad = 0.8;
                    } else multEdad = 1;
                } else multEdad = 0.6;
            } else multEdad = 0.4;
        } else multEdad = 0.3;
        return multEdad*multMedia[this.mediaMax() - 16];
    }
    public double promPartido (double dato){
        return (dato/this.getStats().getJugados());
    }
    public double calcularRendimiento(){
        double rendimiento;
        double p = 0, g = 0, t = 0, e = 0, a = 0;
        switch (this.posInt){
            case 1:
               double par = 0.7, enc = 1.8;
               rendimiento = this.getStats().getParadas()*par - this.getStats().getEncajados()*enc;
            break;
            case 2:
                p = 0.3; g = 0.1; t = 0; e = 0.4; a = 0.2;
                rendimiento = this.getStats().getTackles()*e + this.getStats().getPases()*p + this.getStats().getGoles()*g + this.getStats().getAsistencias()*a + this.getStats().getTiros()*t;
            break;
            case 3:
                p = 0.4; g = 0.1; t = 0; e = 0.3; a = 0.2;
                rendimiento = this.getStats().getTackles()*e + this.getStats().getPases()*p + this.getStats().getGoles()*g + this.getStats().getAsistencias()*a + this.getStats().getTiros()*t;
            break;
            case 4:
                p = 0.4; g = 0.2; t = 0; e = 0.1; a = 0.3;
                rendimiento = this.getStats().getTackles()*e + this.getStats().getPases()*p + this.getStats().getGoles()*g + this.getStats().getAsistencias()*a + this.getStats().getTiros()*t;
            break;
            case 5:
                p = 0.3; g = 0.3; t = 0.1; e = 0; a = 0.3;
                rendimiento = this.getStats().getTackles()*e + this.getStats().getPases()*p + this.getStats().getGoles()*g + this.getStats().getAsistencias()*a + this.getStats().getTiros()*t;
                
            break;
            case 6:
                p = 0.1; g = 0.4; t = 0.2; e = 0; a = 0.3;
                rendimiento = this.getStats().getTackles()*e + this.getStats().getPases()*p + this.getStats().getGoles()*g + this.getStats().getAsistencias()*a + this.getStats().getTiros()*t;
            break;
            default:
                rendimiento = 0;
        }
        double multiplicador = (30 - (double) this.medias[0])/10;
        rendimiento *= multiplicador;
        this.rendimiento = rendimiento;
        return rendimiento;
    }
    public int mediaMax (){
        int [] medias = {this.getGkSkills().getMedia(), this.getDfSkills().getMedia(), this.getMfSkills().getMedia(), this.getFwSkills().getMedia()};
        int resultado = 0;
        for (int i: medias){
            resultado = Math.max(resultado, i);
        }
        return resultado;
    }
    public int compareTo(Jugador j) {
        return this.nombre.toLowerCase().compareTo(j.nombre.toLowerCase());
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
    public void definirSalario(){
        this.salario = 0;
        switch (this.medias[0]){
            case 16:
                this.salario += 350000;
            break;
            case 17:
                this.salario += 560000;
            break;
            case 18:
                this.salario += 980000;
            break;
            case 19:
                this.salario += 1470000;
            break;
            case 20:
                this.salario += 2660000;
            break;
            case 21:
                this.salario += 4900000;
            break;
            case 22:
                this.salario += 8820000;
            break;
            case 23:
                this.salario += 13300000;
            break;
            case 24:
                this.salario += 19600000;
            break;
            case 25:
                this.salario += 25200000;
            break;
        }
        if (this.medias[1] -1 > 0){
            this.salario += (this.medias[1] - 1) * 80000; 
        }
        if (this.medias[2] - 1 > 0){
            this.salario += (this.medias[2] - 1) * 40000; 
        }
        if (this.edad<=36){
            if (this.edad <34){
                if (!(this.edad<30)){
                    this.salario*=0.8;
                }
            }else{
                this.salario*=0.7;
            }
        }else{
            this.salario *= 0.6;
        }
    }
    public void setSancionado(boolean b){
        estaSancionado = b;
    }
    public void setLesionado (boolean b){
        estaLesionado = b;
    }
    public boolean getLesionado (){
        return estaLesionado;
    }
    public boolean getSancionado(){
        return estaSancionado;
    }
    public void setSancionado(){
        estaSancionado = (this.getStats().getSancion()>0);
    }
    public void setLesionado(){
        estaLesionado = (this.getStats().getLesion()>0);
    }
}
