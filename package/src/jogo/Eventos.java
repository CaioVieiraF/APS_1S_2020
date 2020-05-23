package jogo;

import Modelos.Personagem;

public class Eventos {

	boolean loop = false;
	Utilits ferramenta = new Utilits();
	
	public void inicio(Personagem player1, Personagem player2) {
		while(!loop) {
			loop = ferramenta.menuPrincipal(player1, player2);
		}
	}
}
