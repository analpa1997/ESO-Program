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
public class Habilidad {
        private IntegerProperty media, experiencia;

        public int getMedia() {
                return media.get();
        }

        public void setMedia(int media) {
                this.media.set(media);
        }

        public int getExperiencia() {
                return experiencia.get();
        }

        public void setExperiencia(int experiencia) {
                
                while ((experiencia > 1000) || (experiencia < 0)){
                    if (experiencia < 0){
                        experiencia = experiencia + 1000;
                        this.setMedia(this.getMedia()-1);
                    }else if(experiencia > 1000){
                        experiencia = experiencia - 1000;
                        this.setMedia(this.getMedia()+1);;
                    }
                }
                if (experiencia == 1000){
                    experiencia = 1;
                    this.setMedia(this.getMedia()+1);
                } else if (experiencia == 0){
                    experiencia = 999;
                    this.setMedia(this.getMedia()-1);
                }
                this.setExperiencia(experiencia);
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
                final Habilidad other = (Habilidad) obj;
                if ((this.getMedia() != other.getMedia()) || (this.getExperiencia() != other.getExperiencia())) {
                        return false;
                }
                return true;
        }
        
}
