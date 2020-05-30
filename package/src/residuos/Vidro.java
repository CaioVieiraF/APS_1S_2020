package residuos;

import Modelos.Lixo;

public class Vidro extends Lixo {

    String[] objetos = {"Garrafa", "recipiente"};

    public Vidro(){
        super("vidro");
        setObjetos(objetos);
    }

}
