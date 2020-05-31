package Modelos;

public abstract class Lixo {

    String[] objetos;
    String tipo;
    String[] desc;

    public Lixo(String tipo){
        this.tipo = tipo;
    }

    //Método que gera os nomes dos residuos de acordo com o tipo de material
    public String[] setNames(boolean setTipo){
        String[] nomes = new String[objetos.length];
        for (int i = 0; i < nomes.length; i++) {
            if (setTipo) {
                nomes[i] = objetos[i] + " de " + tipo;
            } else {
                nomes[i] = objetos[i];
            }
        }
        return nomes;
    }

    //Getters e Setters
    public String[] setNames(){
        String[] nomes = setNames(true);
        return nomes;
    }
    public String[] getObjetos(){
        return this.objetos;
    }
    public void setObjetos(String[] objetos){
        this.objetos = objetos;
    }

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String[] getDesc(){
        return this.desc;
    }
    public void setDesc(String[] desc){
        this.desc = desc;
    }

}
