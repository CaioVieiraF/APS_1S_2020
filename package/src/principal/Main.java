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
		Eventos rotina = new Eventos();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		Personagem guerreiro = new Guerreiro(teclado.next());
		Personagem inimigo = null;
		
		rotina.inicio(guerreiro, inimigo);
		
		teclado.close();
	}

}
