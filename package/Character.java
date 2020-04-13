import java.util.Scanner;
import java.util.Arrays;

public class Character{
    Scanner keyboard = new Scanner(System.in);
    int life;
    String name;
    String slot[] = new String[8];
    String item = "nada";
    Armor armor = new Armor();
    GameLoop loop = new GameLoop();
    boolean choosing = false;

    public Character(){
        for(int i=0; i<slot.length; i++){
            slot[i] = "Vazio";
        }
    }

    public void TakeDamage(int damage){
        Armor dm = new Armor();
        life -= dm.ReciveDamage(damage);
    }
    public int Atack(int damage){
        Weapon wp = new Weapon();
        int dm = wp.Hit(damage);
        return dm;
    }
    public void Use(String opt){
        String[] thing = opt.split(" ");
        if (thing.length == 3){
            if( thing[0].equals("Armadura")){
                switch(thing[2]){
                    case "Ferro":
                        armor.Iron();
                        break;
                }
            }
        }else{
            item = opt;
        }
    }
    public void Use(){
        System.out.println("usou!");
    }
    public void CheckInventory(){
        for(int i=1; i <= slot.length; i++){
            System.out.println(i +" - "+slot[i-1]);
        }
        System.out.print("O que você quer usar?[0 para sair do inventário]: ");
        int opt = keyboard.nextInt();
        if (opt==0){

        }else if(slot[opt-1] != "Vazio" && opt > 0 && opt < slot.length){
            Use(slot[opt-1]);
        }else{
            CheckInventory();
        }

    }
    public void Status(){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Vida: "+life+" +"+armor.resistence);
        System.out.println("Usando: "+item);
        System.out.println("Armadura: "+armor.type);
        System.out.println("Inventário: "+slot.length+" espaços");
    }
    public void LookPic(String obj[]){
        int chosen[] = new int[obj.length];
        choosing = true;
        while (choosing) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Você olha em volta e vê:\n");
            loop.Choice(obj, false);
            System.out.print("\nO que você pega?[0 para voltar]: ");
            int opt = keyboard.nextInt();
            if(opt>0 && opt<slot.length && chosen[opt-1] != opt && Arrays.asList(slot).contains(obj[opt-1]) == false){
                for(int i=0;i<slot.length;i++){
                    if(slot[i]=="Vazio"){
                        slot[i] = obj[opt-1];
                        chosen[opt-1] = opt;
                        break;
                    }
                }
            }else if(opt == 0){
                choosing = false;
            }else if(chosen[opt-1] == opt || Arrays.asList(slot).contains(obj[opt-1])){
                System.out.println("\nVocê ja pegou isso!");
            }
        }
    }
}
