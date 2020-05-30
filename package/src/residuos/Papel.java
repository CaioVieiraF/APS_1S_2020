package residuos;

import Modelos.Lixo;

public class Papel extends Lixo {

    String[] objetos = {"Folha", "panfleto"};

    public Papel(){
        super("papel");
        setObjetos(objetos);
    }

}
