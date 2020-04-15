import java.util.Scanner;

public class GameLoop{
    Scanner keyboard = new Scanner(System.in);

    public void Choice(String op[], boolean deco){
        if(deco){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        for(int i=1; i<=op.length; i++){
            System.out.println(i+" - "+op[i-1]);
        }

    }

    public void Menu(){
        String opt[] = {"Salvar", "Sair"};
        Choice(opt, true);
        System.out.print("\n: ");
        int esc = keyboard.nextInt();

        switch(esc){
            case 1:
                break;
            case 2:
                System.out.print("Salvar antes de sair?[S/N]: ");
                System.exit(0);
                break;
        }

    }

    public void DefaultOptions(int x){
        switch(x){
            case 1:
                MainGame.Player.CheckInventory();
                break;
            case 2:
                MainGame.Player.Status();
                break;
            case 3:
                Menu();
                break;
        }
    }
}
