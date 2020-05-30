package residuos;

import Modelos.Lixo;

public class Plastico extends Lixo {

    String[] objetos = {"Garrafa", "Sacola"};

    public Plastico(){
        super("plastico");
        setObjetos(objetos);
    }

}
