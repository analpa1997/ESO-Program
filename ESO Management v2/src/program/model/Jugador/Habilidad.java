/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model.Jugador;

/**
 *
 * @author Antonio
 */
public class Habilidad {

        private int media, experiencia;

        public Habilidad() {

        }

        public Habilidad(int media, int experiencia) {
                this();
                this.setMedia(media);
                this.setExperiencia(experiencia);
        }

        public Habilidad(Habilidad hCopia) {
                this(hCopia.getMedia(), hCopia.getExperiencia());
        }

        public int getMedia() {
                return media;
        }

        public void setMedia(int media) {
                this.media = media;
        }

        public int getExperiencia() {
                return experiencia;
        }

        public void setExperiencia(int experiencia) {

                while ((experiencia > 1000) || (experiencia < 0)) {
                        if (experiencia < 0) {
                                experiencia = experiencia + 1000;
                                this.setMedia(this.getMedia() - 1);
                        } else if (experiencia > 1000) {
                                experiencia = experiencia - 1000;
                                this.setMedia(this.getMedia() + 1);;
                        }
                }
                if (experiencia == 1000) {
                        experiencia = 1;
                        this.setMedia(this.getMedia() + 1);
                } else if (experiencia == 0) {
                        experiencia = 999;
                        this.setMedia(this.getMedia() - 1);
                }
                this.experiencia = experiencia;
        }

        public boolean equals(Habilidad obj) {

                if ((this.getMedia() != obj.getMedia()) || (this.getExperiencia() != obj.getExperiencia())) {
                        return false;
                }
                return true;
        }

        public int compareTo(Habilidad h) {
                int resultado = 0;
                if (getMedia() < h.getMedia()) {
                        resultado = -1;
                } else if (getMedia() > h.getMedia()) {
                        resultado = 1;
                } else {
                        if (getExperiencia() < h.getExperiencia()) {
                                resultado = -1;
                        } else if (getExperiencia() > h.getExperiencia()) {
                                resultado = 1;
                        } else {
                                resultado = 0;
                        }
                }
                return resultado;
        }

}
