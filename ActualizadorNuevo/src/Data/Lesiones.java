/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class Lesiones {
    public ArrayList <String> cero, uno, dos, tres, cuatro, cinco, seis;
    public Lesiones(){
        this.inicializarCero();
        this.inicializarUno();
        this.inicializarDos();
        this.inicializarTres();
        this.inicializarCuatro();
        this.inicializarCinco();
        this.inicializarSeis();
    }
    
    public void inicializarCero(){
        cero = new ArrayList();
        cero.add("un golpe");
        cero.add("un corte en la mano");
        cero.add("una fisura en la falange");
        cero.add("un golpe en la pierna");
        cero.add("unas ampollas");
        cero.add("una contusión en una costilla");
        cero.add("un corte en el brazo");
        cero.add("un golpe en la cabeza");
        cero.add("una lesión cervical");
        cero.add("una lesión en la cara");
        cero.add("unas magulladuras en el muslo");
        cero.add("una conmoción cerebral");
        cero.add("una contractura en el cuello");
        cero.add("una contusión en el hombro");
        cero.add("una contusión en el talón");
        cero.add("un corte en la pierna");
        cero.add("una fractura de la nariz");
        cero.add("un golpe en el dedo del pie");
        cero.add("un golpe en la mandíbula");
        cero.add("una lesión en el pecho");
        cero.add("una magulladura en la espinilla");
        cero.add("unas magulladuras en la cabeza");
        cero.add("una sobrecarga en el muslo");
        cero.add("una sobrecarga muscular");
    }
    public void inicializarUno(){
        uno = new ArrayList();
        uno.add("una contusión en el codo");
        uno.add("una luxación de muñeca");
        uno.add("una contusión en el cuello");
        uno.add("una contusión en el pie");
        uno.add("un desgarro abdominal");
        uno.add("un esguince de muñeca");
        uno.add("un esguince leve de rodilla");
    }
    public void inicializarDos(){
        dos = new ArrayList();
        dos.add("una inflamación en la pierna");
        dos.add("un esguince leve de tobillo");
        dos.add("una sobrecarga del abductor");
        dos.add("un esguince de ligamentos del tobillo");
        dos.add("una fractura del dedo");
        dos.add("una inflamación en los ligamentos de la rodilla");
        dos.add("una sobrecarga del gemelo");
        dos.add("una contusión en la rótula");
        dos.add("una dislocación de mandíbula");
        dos.add("una factura del pómulo");
        dos.add("una fractura de costillas");
        dos.add("una fractura de la mandíbula");
        dos.add("una fractura del brazo");
        dos.add("una fractura del hombro");
        dos.add("una rotura de costillas");
        dos.add("una rotura del pómulo");
        dos.add("una tendinitis en el talón de aquiles");
    }
    public void inicializarTres(){
        tres = new ArrayList();
        tres.add("una distensión en la espalda");
        tres.add("una contusión en el menisco");
        tres.add("un esguince de tobillo");
        tres.add("una inflamación en el tendón");
        tres.add("una fractura de la tibia");
        tres.add("una hernia");
        tres.add("una hernia deportiva");
        tres.add("una rotura de fibras del abductor");
    }
    public void inicializarCuatro(){
        cuatro = new ArrayList();
        cuatro.add("una artritis");
        cuatro.add("una fractura de la mano");
        cuatro.add("una rotura de la muñeca");
        cuatro.add("una rotura de los ligamentos del tobillo");
        cuatro.add("una rotura del brazo");
    }
    public void inicializarCinco(){
        cinco = new ArrayList();
        cinco.add("un esguince de ligamentos de la rodilla");
        cinco.add("una fractura de la muñeca");
        cinco.add("una fractura de la clavícula");
        cinco.add("una hernia doble");
        cinco.add("una lesión lumbar");
    }
    public void inicializarSeis(){
        seis = new ArrayList();
        seis.add("una contusión en la columna vertebral");
        seis.add("una fisura del metatarsiano");
        seis.add("una luxación del hombro");
        seis.add("un coágulo de sangre");
        seis.add("una lesión de cadera");
        seis.add("una rotura de los ligamentos de la rodilla");
        seis.add("un esguince de ligamento lateral de la rodilla");
        seis.add("una fractura del tobillo");
        seis.add("una fractura del cráneo");
        seis.add("una hernia discal");
        seis.add("una fractura de la pelvis");
        seis.add("una fractura del pie");
        seis.add("una rotura de fibras del gemelo");
        seis.add("una tendinitis en la rodilla");
        seis.add("una contusión en el tendón de aquiles");
        seis.add("una fractura de la pierna");
        seis.add("una rotura de la pierna");
        seis.add("ligamentos cruzados dañados");
    }
    
    public void lesionRandom(){
        Collections.shuffle(cero);
        Collections.shuffle(uno);
        Collections.shuffle(dos);
        Collections.shuffle(tres);
        Collections.shuffle(cuatro);
        Collections.shuffle(cinco);
        Collections.shuffle(seis);
    }
}
