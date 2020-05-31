package Modelos;

import java.util.Arrays;
import jogo.Utilits;
import java.util.Random;
import residuos.*;

public class Npc extends Personagem {

    private boolean interacao;

    public Npc(String nome, boolean interacao){
        super(nome, 0, 0, 0, 0);
        setInteracao(interacao);
    }

    public void ataque(){

    }

    //Método que lida com as interações entre o usuário e um personagem não jogavel(NPC em inglês)
    public boolean interagir(Personagem player, Utilits ferramenta, String[] ambiente, int[] quant){
        Random rand = new Random();
        if (interacao) {
            String[] opcoes = {"Sim", "Não"};
            boolean escolha = ferramenta.menu(
                Arrays.asList(opcoes),
                "["+this.getNome()+"]- Eu preciso da ajuda de alguém!\nVocê quer fazer isso agora?"
            )==0;
            return escolha;
        } else {
            Lixo[] listaLixo = {new Aluminio(), new Plastico(), new Papel(), new Vidro()};
            int num = rand.nextInt(quant.length);
            if (num == 0) {
                num = 1;
            } else if (num == 5) {
                num = 4;
            }
            quant[num]++;
            System.out.println("Ele joga um " + ambiente[num] + " no chão e diz:");
            System.out.println("O que você quer de mim!?");
            String[] opcoes = {"Concientizar", "Ignorar"};
            int escolha = ferramenta.menu(Arrays.asList(opcoes), "O que você faz sobre isso?");
            if (escolha == 0) {
                if (num == 1) {
                    num = 0;
                } else if (num == 4) {
                    num = 3;
                }
                Lixo lixo = listaLixo[num];
                System.out.println("Você sabia que "+lixo.getDesc()[rand.nextInt(lixo.getDesc().length)]+"?");
                int funcionou = rand.nextInt(100);
                if (funcionou < 25) {
                    System.out.println("["+this.getNome()+"]- Nossa, eu nunca pensei desse jeito!");
                    player.setMana(player.getMana()+3);
                    System.out.println("Você ganha 3 de mana!");
                } else {
                    System.out.println("Ele resmunga e segue andando...");
                    System.out.println("["+player.getNome()+"]- Pelo menos eu tentei...");
                }
            } else if (escolha == 1) {
                System.out.println("["+player.getNome()+"]- Não tenho tempo para isso!");
                System.out.println("Ele resmunga e segue andando...");
                player.setMana(player.getMana()-2);
                System.out.println("Você perde 2 de mana!");
            }
        }

        return false;
    }


    //Getters e Setters
    public void setInteracao(boolean interacao){
        this.interacao = interacao;
    }
    public boolean getInteracao(){
        return interacao;
    }

}
