package residuos;

import Modelos.Lixo;

public class Plastico extends Lixo {

    String[] objetos = {"Garrafa", "Sacola"};
    String[] desc = {
        "até 2050, haverá mais plástico nos oceanos do que peixes",
        "o plástico pode levar mais de 400 anos para se decompor",
        "O plástico é responsável pela morte de 100 mil animais marinhos a cada ano",
        "91% do plástico utilizado no mundo não é reciclado"
    };

    public Plastico(){
        super("plástico");
        setObjetos(objetos);
        setDesc(desc);
    }

}
