package principal;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import Modelos.Personagem;
import jogo.Eventos;

public class Main {

	//Método principal que é executado pela JVM.
	public static void main(String[] args) {
		jogo();
	}

	//Método que lida com os eventos do jogo.
	public static void jogo() {
		//int escolha;
		Eventos rotina = new Eventos();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		Personagem guerreiro = new Guerreiro(teclado.next());
		rotina.mapa();
		reino1(guerreiro);
		reino2();
		reino3();
		reino4();
		reino5();

		teclado.close();
	}

	public static void reino1(Personagem player){
		Eventos rotina = new Eventos();
		Map<String, Integer> ambiente = new HashMap<String, Integer>();
		ambiente.put("Lixeira", -1);
		ambiente.put("Lata vazia", 2);
		ambiente.put("Garrafa plástica vazia", 3);
		String[] opcoes = {"Observar", "conversar", "usar", "sair"};
		Personagem inimigo = null;
		boolean condicao = true;
		while (condicao) {
			condicao = !rotina.menuPrincipal(player, inimigo, opcoes, ambiente, 0);
		}

	}
	public static void reino2(){

	}
	public static void reino3(){

	}
	public static void reino4(){

	}
	public static void reino5(){

	}


}
