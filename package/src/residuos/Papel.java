package residuos;

import Modelos.Lixo;

public class Papel extends Lixo {

    String[] objetos = {"Folha", "panfleto"};
    String[] desc = {"a indústria da celulose está na terceira posição\nem emissão de gases de efeito estufa"};

    public Papel(){
        super("papel");
        setObjetos(objetos);
        setDesc(desc);
    }

}
