package residuos;

import Modelos.Lixo;

public class Aluminio extends Lixo {

    String[] objetos = {"Latinha"};
    String[] desc = {"a produção de alumínio,\ndesde a extração da bauxita até a transformação da alumina em alumínio,\ngera alguns gases poluentes,\ncomo o gás carbônico (CO2) e os perfluorcarbonetos (PFCs)"};

    public Aluminio(){
        super("alumínio");
        setObjetos(objetos);
        setDesc(desc);
    }

}
