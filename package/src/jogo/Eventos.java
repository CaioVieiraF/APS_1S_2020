package jogo;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import Modelos.Personagem;

public class Eventos {

	boolean loop = false;
	Utilits ferramenta = new Utilits();

	//Método que lida com as principais ações do jogo.
	public boolean menuPrincipal(Personagem player1, Personagem player2, String[] opcoes, Map<String, Integer> ambiente, int chance) {
		boolean sair = false;
		int escolha = ferramenta.menu(Arrays.asList(opcoes), "O que você faz?");

		switch(escolha) {
		case 0:
			player2 = ferramenta.gerarBatalha(chance);
			if(player2==null) {
				player1.observar(ambiente, ferramenta);
			} else {
				System.out.println("A pareceu um "+player2.getNome());
				System.out.println(ferramenta.batalha(player1, player2)+" ganhou!");
			}
			break;
		case 1:
			player1.conversar();
			break;
		case 2:
			player1.usar(ferramenta);
			break;
		case 3:
			System.out.println("Tchau!");
			sair = true;
			break;
		default:
			System.out.println("Erro");
		}
		return sair;
	}


	public void mapa() {

	}
}
