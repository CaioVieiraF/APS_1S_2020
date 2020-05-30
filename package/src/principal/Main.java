package principal;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Modelos.Personagem;
import jogo.Eventos;
import jogo.Utilits;;
import residuos.*;

public class Main {

	//Método principal que é executado pela JVM.
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome = teclado.next();
		Utilits ferramenta = new Utilits();
		ferramenta.abertura();
		Personagem[] classe = {new Guerreiro(nome)};
		String[] tipos = {"Guerreiro"};
		int escolha = ferramenta.menu(Arrays.asList(tipos), "Escolha a sua classe:");
		//Personagem guerreiro = new Guerreiro(nome);
		jogo(classe[escolha]);
		teclado.close();
	}

	//Método que lida com os eventos do jogo.
	public static void jogo(Personagem player) {
		//int escolha;
		Eventos rotina = new Eventos();
		rotina.mapa();
		reino1(player);
		reino2();
		reino3();
		reino4();
		reino5();
	}

	public static void reino1(Personagem player){
		Random rand = new Random();
		Eventos rotina = new Eventos();
		Aluminio aluminio = new Aluminio();
		Plastico plastico = new Plastico();
		Vidro vidro = new Vidro();
		String[] ambiente = {
			"Lixeira",
			aluminio.setNames()[rand.nextInt(aluminio.getObjetos().length)],
			plastico.setNames()[rand.nextInt(plastico.getObjetos().length)],
			vidro.setNames()[rand.nextInt(vidro.getObjetos().length)],
			plastico.setNames()[rand.nextInt(plastico.getObjetos().length)],
			null
		};
		int[] acoes = {-1, 2, 3, 2, 2, 0};
		String[] opcoes = {"Observar", "conversar", "usar", "sair"};
		Personagem inimigo = null;
		boolean condicao = true;
		while (condicao) {
			condicao = !rotina.menuPrincipal(player, inimigo, opcoes, ambiente, acoes, 0);
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
