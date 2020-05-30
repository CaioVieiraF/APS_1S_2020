package residuos;

import Modelos.Lixo;

public class Organico extends Lixo {

    String[] objetos = {"Casca", "chiclete"};

    public Organico(){
        super("organico");
        setObjetos(objetos);
    }

}
