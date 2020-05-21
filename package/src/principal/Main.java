package principal;

import java.util.Scanner;

import Modelos.Personagem;
import jogo.Utilits;

public class Main {

	//Método principal que é executado pela JVM.
	public static void main(String[] args) {
		try {
			jogo();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Método que lida com os eventos do jogo.
	public static void jogo() {
		//int escolha;
		boolean loop = false;
		Utilits ferramenta = new Utilits();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		Personagem guerreiro = new Guerreiro(teclado.next());
		Personagem inimigo = null;

		while(!loop) {
			loop = ferramenta.menuPrincipal(guerreiro, inimigo);
		}
		teclado.close();
	}

}
