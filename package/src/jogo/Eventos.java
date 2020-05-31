package jogo;

import Modelos.Npc;
import java.util.Arrays;
import Modelos.Personagem;

public class Eventos {

	private Utilits ferramenta = new Utilits();
	private String lugar;

	//Método que lida com as principais ações do jogo.
	public int menuPrincipal(Personagem player1, Personagem[] inimigos, String[] opcoes, String[] ambiente, int[] acoes, int chance, Npc[] npc) {
		int sair = 5;
		int escolha = ferramenta.menu(Arrays.asList(opcoes), "O que você faz?");

		switch(escolha) {
		case 0:
			Personagem player2 = ferramenta.gerarBatalha(chance, inimigos);
			if(player2==null) {
				player1.observar(ambiente, ferramenta, acoes);
			} else {
				System.out.println("A pareceu um "+player2.getNome());
				String vencedor = ferramenta.batalha(player1, player2);
				System.out.println(vencedor +" ganhou!");
				if (vencedor == player1.getNome()) {
					sair = 3;
				}
			}
			break;
		case 1:
			if (npc != null){
				if (player1.conversar(npc, ferramenta, ambiente, acoes)) {
					return 1;
				} else {
					return 2;
				}
			} else {
				System.out.println("Ninguém por perto!");
			}
		case 2:
			player1.inventário();
			break;
		case 3:
			player1.info();
			System.out.println("|Reino: "+lugar);
			break;
		case 4:
			System.out.println("Até mais!");
			sair = 0;
			break;
		default:
			System.out.println("Erro");
		}
		return sair;
	}

	public int menuPrincipal(Personagem player1, String[] opcoes, String[] ambiente, int[] acoes, Npc[] npc) {
		return menuPrincipal(player1, null, opcoes, ambiente, acoes, 0, npc);
	}

	//Getters e Setters
	public void lugar(String lugar) {
		this.lugar = lugar;
	}
	public String lugar(){
		return lugar;
	}
}
