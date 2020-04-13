import java.util.Scanner;

public class MainGame{
    static Character Player = new Character();
    public static void main(String args[]){
        Time t = new Time();
        Scanner keyboard = new Scanner(System.in);
        GameLoop loop = new GameLoop();
        Player.life = 50;
        String opt[] = {"inventário", "status", "menu"};
        boolean choosing = false;
        int choice = 0;

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Sua Jornada começa aqui!");
        t.Sleep(1);
        System.out.print("Digite seu nome: ");
        Player.name = keyboard.next();
        System.out.println("Olá "+Player.name+", bem vindo ao jogo!");
        t.Sleep(1);
        System.out.println("Você começa com "+Player.life+" de vida");
        t.Sleep(1);
        System.out.println("E você tem "+Player.slot.length+" espaços no seu inventário.");
        t.Sleep(1);
        System.out.println("Vamos começar!");
        t.Sleep(2);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("A sua cidade natal foi atacada, mas você e sua família sobreviveram.");
        System.out.println("Se passaram vários anos e agora você está disposto a fazer vingança às famìlias mortas daquele dia.");
        System.out.println("Você se dispede de todos e começa a sua jornada.");
        System.out.println("________________________________________________________________________________");
        System.out.println("   //\\\\          ||  //==\\\\  ||==\\\\  ||\\\\   ||    //\\\\    ||===\\\\    //\\\\   ");
        System.out.println("  //  \\\\         || ||    || ||  ||  || \\\\  ||   //  \\\\   ||    \\\\  //  \\\\      ");
        System.out.println(" //====\\\\   ||   || ||    || ||==\\\\  ||  \\\\ ||  //====\\\\  ||    // //====\\\\     ");
        System.out.println("//      \\\\   \\\\=//   \\\\==//  ||   \\\\ ||   \\\\|| //      \\\\ ||===// //      \\\\");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");

        choosing = true;
        String start[] = {"Observar", "conversar", "usar", "sair"};
        while(choosing){
            loop.Choice(start, true);
            System.out.print("5 - opções\n\n: ");
            choice = keyboard.nextInt();
            switch(choice){
                case 1:
                    String objects[] = {"Armadura de Ferro", "Espada"};
                    Player.LookPic(objects);
                    break;
                case 2:
                    break;
                case 3:
                    Player.Use();
                    break;
                case 4:
                    choosing = false;
                    break;
                case 5:
                    loop.Choice(opt, true);
                    System.out.print("\n: ");
                    choice = keyboard.nextInt();
                    loop.DefaultOptions(choice);
            }
        }
    }
}
