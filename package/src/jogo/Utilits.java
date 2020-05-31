package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Modelos.Personagem;

//classe que lida com eventos gerais decorrentes do jogo.
public class Utilits {

	//Declaração e inicialização de variáveis.
	Scanner teclado = new Scanner(System.in);
	Random rand = new Random();

	//Método que gera um menu de opções de acordo com
	// uma lista e um título.
	public int menu(List<String> opcoes0, String tituloSuperior, String tituloInferior) {
		boolean escolhendo = true;
		int opcao = 0;
		List<String> opcoes = new ArrayList<String>();
		for (int i = 0; i < opcoes0.size(); i++) {
			if (opcoes0.get(i) != null) {
				opcoes.add(opcoes0.get(i));
			}
		}
		while(escolhendo) {
			escolhendo = false;
			System.out.println("__________________________");
			System.out.println(tituloSuperior + "\n");
			for(int i=0; i<opcoes.size(); i++) {
				if(opcoes.get(i)!=null) {
					System.out.println("["+(i+1)+"] - "+opcoes.get(i));
				}
			}
			System.out.print("\n"+tituloInferior+": ");
			try {
				opcao = Integer.parseInt(teclado.next());
			} catch(java.util.InputMismatchException e) {
				System.out.println("Digite um número!");
				escolhendo = true;
			} catch(NumberFormatException e) {
				System.out.println("Digite um número!");
				escolhendo = true;
			}

			if(opcao>opcoes.size() || opcao<0) {
				System.out.println("Valor inválido!");
				escolhendo = true;
			}
		}
		System.out.println();

		return opcao-1;
	}

	public int menu(List<String> opcoes, String titulo) {
		int opcao = menu(opcoes, titulo, "Escolha");
		return opcao;
	}

	//A abertura do jogo.
	public void abertura() {
		System.out.println("__________________________");
		System.out.println("Bem vindo ao jogo!\n");
		System.out.println("Em uma peque aldeia havia um velho senhor viajante que sempre contava uma história");
		System.out.println("assustadora de que havia um monstro adormecido sobre o planeta terra e que todos");
		System.out.println("deveriam amar o planeta como se amacem a si próprios, a história começa assim:");
		System.out.println("\nA muito tempo atrás uma criatura que acreditava-se ser apenas um mito estava prestes");
		System.out.println("a despertar, pois as terras começaram a estremecerem, os mares estavam muito agitados,");
		System.out.println("nos céus se encontravam um tremendo caos com tempestades devastadoras em alguns cantos do planeta e");
		System.out.println("muitos vulcões pelo planeta começaram a despertar de seu longo sono.");
		System.out.println("Essa criatura mitológica havia feito um acordo com a humanidade de que");
		System.out.println("se eles parassem de contaminar o planeta com sua poluição exagerada,");
		System.out.println("os humanos não teriam que se preocuparem com seu retorno. Mas os humanos não deram ouvidos a criatura e ");
		System.out.println("o exagero começou a destruir pouco a pouco os ares, as terras com lixo,");
		System.out.println("os mares e rios que hoje se encontram cheios de lixo causadores de doenças para");
		System.out.println("as criaturas que os habitam e que parassem de queimar as florestas,");
		System.out.println("o retorno da criatura parece ser algo inevitável.");
	}

	//Método que lida com as batalhas;
	public String batalha(Personagem player1, Personagem player2) {
		String vencedor = "Ninguem";
		boolean batalhando = true;
		int turno = 1;
		player1.info();
		player2.info(true);

		while(batalhando) {
			int escolha = menu(player1.getAtaques(), "batalhando!\nTurno: " + turno);
			player1.atacar(escolha);
			int ataqueInimigo = rand.nextInt(player2.getAtqs().length);
			player2.atacar(ataqueInimigo);
			System.out.println(player2.getNome()+" usa "+player2.getAtqs()[ataqueInimigo]);
			System.out.println("-Você ataca com "+player1.getDano()+" de dano");
			System.out.println("-"+player2.getNome()+" ataca com "+player2.getDano()+" de dano");
			player1.recebeAtaque(player2.getDano());
			player2.recebeAtaque(player1.getDano());
			player1.info();
			player2.info();
			player1.refresh();
			player2.refresh();
			turno++;
			if(player1.estaVivo() && !player2.estaVivo() || player1.getMana() == 0 && player1.getEstamina() == 0) {
				vencedor = player1.getNome();
			} else if(!player1.estaVivo() && player2.estaVivo() || player2.getMana() == 0 && player2.getEstamina() == 0) {
				vencedor = player2.getNome();
			} else {
				continue;
			}
			batalhando = false;
			turno = 0;
		}

		return vencedor;

	}

	//Método que decide e gera uma batalha de  um jogador e
	//um inimigo aleatório através de um polimorfismo de classe.
	public Personagem gerarBatalha(int chance, Personagem[] inimigos) {
		int escolha = rand.nextInt(100);
		Personagem inimigo = null;
		if(escolha < chance && inimigos != null) {
			escolha = rand.nextInt(inimigos.length);
			inimigo = inimigos[escolha];
		}
		return inimigo;
	}

}
