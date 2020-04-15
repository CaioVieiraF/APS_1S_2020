
public class Weapon{
    int damage;
    int resis;

    public int Hit(int dm){
        damage = dm;
        resis -= 0.3;
        return damage;
    }
}
