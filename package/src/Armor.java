
public class Armor{
    int resistence=10;
    String type = "Nenhuma";

    public void Iron(){
        resistence = 20;
        type = "Armadura de Ferro";
    }

    public int ReciveDamage(int dam){
        return (dam-resistence);
    }
}
