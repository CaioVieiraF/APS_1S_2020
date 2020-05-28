package principal;

import java.util.Scanner;

import Modelos.Personagem;
import jogo.Eventos;
import jogo.Utilits;

public class Main {

	//Método principal que é executado pela JVM.
	public static void main(String[] args) {
		jogo();
	}

	//Método que lida com os eventos do jogo.
	public static void jogo() {
		//int escolha;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		Personagem guerreiro = new Guerreiro(teclado.next());
		reino1(guerreiro);

		teclado.close();
	}

	public static void reino1(Personagem player){
		Eventos rotina = new Eventos();
		Personagem inimigo = null;
		rotina.inicio(player, inimigo);

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
