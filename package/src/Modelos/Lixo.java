package Modelos;

public abstract class Lixo {

    private String[] objetos;
    private String tipo;

    public Lixo(String tipo){
        this.tipo = tipo;
    }

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

}
