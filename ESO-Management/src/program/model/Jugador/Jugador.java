/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Jugador;

import javafx.beans.property.*;
/**
 *
 * @author Antonio
 */
public class Jugador {
        
        private StringProperty nombre, nacionalidad, equipo;
        public enum Posicion {gk, df, dm, mf, am, fw};
        private ObjectProperty<Posicion> pos;
        private IntegerProperty edad, posInt, ag, salario, exp;
        private ObjectProperty<Habilidad> portero, defensa, medio, delantero;
        private ObjectProperty<Estadisticas> stats;
        private DoubleProperty rendimiento;
        private IntegerProperty[] medias = new IntegerProperty [4];

        
        public String getNombre() {
                return nombre.get();
        }

        public void setNombre(String nombre) {
                this.nombre.set(nombre);
        }

        public String getNacionalidad() {
                return nacionalidad.get();
        }

        public void setNacionalidad(String nacionalidad) {
                this.nacionalidad.set(nacionalidad);
        }

        public String getEquipo() {
                return equipo.get();
        }

        public void setEquipo(String equipo) {
                this.equipo.set(equipo);
        }

        public Posicion getPos() {
                return pos.get();
        }

        public void setPos(Posicion pos) {
                this.pos.set(pos);
        }

        public int getEdad() {
                return edad.get();
        }

        public void setEdad(int edad) {
                this.edad.set(edad);
        }

        public int getPosInt() {
                return posInt.get();
        }

        public void setPosInt(int posInt) {
                this.posInt.set(posInt);
        }

        public int getAg() {
                return ag.get();
        }

        public void setAg(int ag) {
                this.ag.set(ag);
        }

        public Habilidad getPortero() {
                return portero.get();
        }

        public void setPortero(Habilidad portero) {
                this.portero.set(portero);
        }

        public Habilidad getDefensa() {
                return defensa.get();
        }

        public void setDefensa(Habilidad defensa) {
                this.defensa.set(defensa);
        }

        public Habilidad getMedio() {
                return medio.get();
        }

        public void setMedio(Habilidad medio) {
                this.medio.set(medio);
        }

        public Habilidad getDelantero() {
                return delantero.get();
        }

        public void setDelantero(Habilidad delantero) {
                this.delantero.set(delantero);
        }

        public Estadisticas getStats() {
                return stats.get();
        }

        public void setStats(Estadisticas stats) {
                this.stats.set(stats);
        }

        public double getRendimiento() {
                return rendimiento.get();
        }

        public void setRendimiento(double rendimiento) {
                this.rendimiento.set(rendimiento);
        }

        public int[] getMedias() {
                int[] aMedias = new int[medias.length];
                for (int i = 0; i<aMedias.length; i++){
                        aMedias[i] = medias[i].get();
                }
                return aMedias;
        }

        public void setMedias(int[] medias) {
                for (int i = 0; i<medias.length; i++){
                        this.medias[i].set(medias[i]);
                }
                
        }

        public int getSalario() {
                return salario.get();
        }

        public void setSalario(int salario) {
                this.salario.set(salario);
        }

        public int getExp() {
                return exp.get();
        }

        public void setExp(int exp) {
                this.exp.set(exp);
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
        public String toString (){
        String prueba = new String();
        prueba = this.getNombre();
        for (int i = this.getNombre().length(); i<14; i++){
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
        
        public void definirPosicion(){
        int maximaMedia = this.mediaMax();
        if (this.getPortero().getMedia() == maximaMedia) setPos(Posicion.gk);
        else {
            if (this.getDefensa().getMedia() == maximaMedia){
                if (this.getMedio().getMedia() == maximaMedia){
                    if (this.getDelantero().getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.getDefensa().getExperiencia(), Math.max(this.getMedio().getExperiencia(), this.getDelantero().getExperiencia()));
                        if (this.getDefensa().getExperiencia() == maximaExp) setPos(Posicion.df);
                        else if (this.getMedio().getExperiencia() == maximaExp) setPos(Posicion.mf);
                        else setPos(Posicion.fw);
                    }
                    else{
                        int maximaExp = Math.max(this.getDefensa().getExperiencia(), this.getMedio().getExperiencia());
                        if (this.getDefensa().getExperiencia() == maximaExp) setPos(Posicion.df);
                        else setPos(Posicion.dm);
                    }
                }
                else{
                    if (this.getDelantero().getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.getDefensa().getExperiencia(), this.getDelantero().getExperiencia());
                        if (this.getDefensa().getExperiencia() == maximaExp) setPos(Posicion.df);
                        else setPos(Posicion.fw);
                    }
                    else setPos(Posicion.df);
                }
            }
            else{
                if(this.getMedio().getMedia() == maximaMedia){
                    if (this.getDelantero().getMedia() == maximaMedia){
                        int maximaExp = Math.max(this.getMedio().getExperiencia(), this.getDelantero().getExperiencia());
                        if (this.getMedio().getExperiencia() == maximaExp) setPos(Posicion.am);
                        else setPos(Posicion.fw);
                    }
                    else{
                        if (((this.getDelantero().getMedia() - this.getDefensa().getMedia())<=-4) && (this.getMedio().getMedia() - this.getDefensa().getMedia() <= 5)) setPos(Posicion.dm);
                        else if (((this.getDelantero().getMedia() - this.getDefensa().getMedia())>=4) && (this.getMedio().getMedia() - this.getDelantero().getMedia() <= 5)) setPos(Posicion.am);
                        else setPos(Posicion.mf);
                    }
                }
                else setPos(Posicion.fw);
            }
        }
    }
        public int mediaMax (){
                int [] medias = {this.getPortero().getMedia(), this.getDefensa().getMedia(), this.getMedio().getMedia(), this.getDelantero().getMedia()};
                int resultado = 0;
                for (int i: medias){
                    resultado = Math.max(resultado, i);
                }
                return resultado;
    }
        
    public void definirPosInt(){
        if (null != pos.get()) switch (pos.get()) {
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
