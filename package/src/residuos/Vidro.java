package residuos;

import Modelos.Lixo;

public class Vidro extends Lixo {

    String[] objetos = {"Garrafa", "recipiente"};
    String[] desc = {"se produzir-mos uma garrafa utilizando a extração de matérias-primas virgens (minérios),\nsomado ao custo de energia no processo de obtenção,\nteríamos um gasto muito maior do que com o reaproveitando de cacos de vidro"};

    public Vidro(){
        super("vidro");
        setObjetos(objetos);
        setDesc(desc);
    }

}
