package jogo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Modelos.Personagem;
import principal.LixoSvaldo;
import principal.MonstroDoPantano;

//classe que lida com eventos gerais decorrentes do jogo.
public class Utilits {
	
	//Declaração e inicialização de variáveis.
	Scanner teclado = new Scanner(System.in);
	Random rand = new Random();
	
	//Método construtor.
	//Sempre que o jogo começar ele vai ser chamado e
	//a abertura vai aparecer.
	public Utilits() {
		abertura();
	}
	
	//Método que gera um menu de opções de acordo com
	// uma lista e um título.
	public int menu(List<String> opcoes, String tituloSuperior, String tituloInferior) {
		boolean escolhendo = true;
		int opcao = 0;
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
		System.out.println("Bem vindo ao jogo!");
	}
	
	//Método que lida com as batalhas;
	public String batalha(Personagem player1, Personagem player2) {
		String vencedor = "Ninguem";
		boolean batalhando = true;
		while(batalhando) {
			int escolha = menu(player1.getAtaques(), "batalhando!");
			System.out.println(escolha);
			player1.atacar(escolha);
			player2.atacar(rand.nextInt(player2.getAtqs().length));
			System.out.println("Você ataca com "+player1.getDano()+" de dano");
			System.out.println(player2.getNome()+" ataca com "+player2.getDano()+" de dano");
			player1.recebeAtaque(player2.getDano());
			player2.recebeAtaque(player1.getDano());
			System.out.println("Você está com "+player1.getVida()+" de vida");
			System.out.println(player2.getNome()+" esta com "+player2.getVida()+" de vida");
			if(player1.estaVivo() && !player2.estaVivo()) {
				vencedor = player1.getNome();
			} else if(!player1.estaVivo() && player2.estaVivo()) {
				vencedor = player2.getNome();
			} else {
				continue;
			}
			batalhando = false;
		}
		
		return vencedor;
		
	}

	//Método que decide e gera uma batalha de  um jogador e
	//um inimigo aleatório através de um polimorfismo de classe.
	public Personagem gerarBatalha(int chance) {
		int escolha = rand.nextInt(100);
		Personagem inimigo = null;
		Personagem[] inimigos = {new MonstroDoPantano(), new LixoSvaldo()};
		if(escolha < chance) {
			escolha = rand.nextInt(inimigos.length);
			inimigo = inimigos[escolha];
		}
		return inimigo;
	}

	//Método que lida com as principais ações do jogo.
	public boolean menuPrincipal(Personagem player1, Personagem player2) {
		boolean sair = false;
		String[] opcoes = {"Observar", "conversar", "usar", "sair"};
		int escolha = menu(Arrays.asList(opcoes), "O que você faz?");
		String[] ambiente = {"Lixeira", "Lata vazia", "Garrafa plástica vazia"};
		
		switch(escolha) {
		case 0:
			player2 = gerarBatalha(100);
			if(player2==null) {
				player1.observar(ambiente, this);
			} else {
				System.out.println("A pareceu um "+player2.getNome());
				System.out.println(batalha(player1, player2)+" ganhou!");
			}
			break;
		case 1:
			player1.conversar();
			break;
		case 2:
			player1.usar(this);
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
}
