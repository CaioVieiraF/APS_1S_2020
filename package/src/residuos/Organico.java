package residuos;

import Modelos.Lixo;

public class Organico extends Lixo {

    String[] objetos = {"Casca", "chiclete"};
    String[] desc = {"com a decomposição de resíduos orgânicos é produzido o metano (CH4),\num gás tóxico incolor e inodoro,\nque contribui para o aumento do efeito estufa no planeta"};

    public Organico(){
        super("orgânico");
        setObjetos(objetos);
        setDesc(desc);
    }

}
