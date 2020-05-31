package principal;

import Modelos.Lixo;
import Modelos.Npc;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Modelos.Personagem;
import jogo.Eventos;
import jogo.Utilits;;
import residuos.*;
import inimigos.*;
import inimigos.Boss.*;

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
		jogo(classe[escolha]);
		teclado.close();
	}

	//Método que lida com os eventos do jogo.
	public static void jogo(Personagem player) {
		Utilits ferramenta = new Utilits();
		int[] acoes1 = {-1, 5, 4, 6, 7, 5, 0};
		int[] acoes2 = {-1, 6, 7, 6, 5, 3, 0};
		int[] acoes3 = {-1, 8, 7, 6, 5, 7, 0};
		int[] acoes4 = {-1, 9, 8, 8, 9, 8, 0};
		Npc[] npc1 = {
			new Npc("Ferreiro", false),
			new Npc("Bibliotecário", true),
			new Npc("Fazendeiro", false),
			new Npc("Senhora", false)
		};
		Npc[] npc2 = {
			new Npc("Ferreiro", false),
			new Npc("Bibliotecário", true),
			new Npc("Fazendeiro", false),
			new Npc("Senhora", false)
		};
		Npc[] npc3 = {
			new Npc("Ferreiro", false),
			new Npc("Bibliotecário", true),
			new Npc("Fazendeiro", false),
			new Npc("Senhora", false)
		};
		Npc[] npc4 = {
			new Npc("Ferreiro", false),
			new Npc("Bibliotecário", true),
			new Npc("Fazendeiro", false),
			new Npc("Senhora", false)
		};
		String dialogo1 = "opa";
		String dialogo2 = "opa2";
		String dialogo3 = "opa3";
		String dialogo4 = "opa4";
		Personagem[] inimigo1 = {
			new MonstroDoPantano(),
			new VerminosoEscoria()
		};
		Personagem[] inimigo2 = {
			new MonstroDoPantano(),
			new VerminosoEscoria()
		};
		Personagem[] inimigo3 = {
			new MonstroDoPantano(),
			new VerminosoEscoria()
		};
		Personagem[] inimigo4 = {
			new MonstroDoPantano(),
			new VerminosoEscoria()
		};

		reino(
			player,
			"Cidade das conchas",
			"Floresta das conchas",
			acoes1,
			npc1,
			dialogo1,
			inimigo1,
			new BossElementarFogo()
			);
		reino(
			player,
			"",
			"",
			acoes2,
			npc2,
			dialogo2,
			inimigo2,
			new BossElementarFogo()
			);
		reino(
			player,
			"",
			"",
			acoes3,
			npc3,
			dialogo3,
			inimigo3,
			new BossElementarFogo()
			);
		reino(
			player,
			"",
			"",
			acoes4,
			npc4,
			dialogo4,
			inimigo4,
			new BossElementarFogo()
			);
		System.out.println();
		System.out.println(ferramenta.batalha(player, new BossElementarFogo())+" Venceu");
	}

	//Método que define um reino em que o personagem passa.
	public static void reino(Personagem player, String lugar1, String lugar2, int[] acoes, Npc[] npc, String dialogo, Personagem[] inimigo, Personagem boss){
		Random rand = new Random();
		Eventos rotina = new Eventos();
		Utilits ferramenta = new Utilits();
		rotina.lugar(lugar1);
		Lixo[] lixo = {new Aluminio(), new Plastico(), new Papel(), new Vidro(), new Organico()};
		String[] ambiente = {
			"Lixeira",
			lixo[0].setNames()[rand.nextInt(lixo[0].getObjetos().length)],
			lixo[1].setNames()[rand.nextInt(lixo[1].getObjetos().length)],
			lixo[2].setNames()[rand.nextInt(lixo[2].getObjetos().length)],
			lixo[3].setNames()[rand.nextInt(lixo[3].getObjetos().length)],
			lixo[4].setNames()[rand.nextInt(lixo[4].getObjetos().length)],
			null
		};
		String[] opcoes = {"Observar", "conversar", "inventário", "status", "sair"};
		boolean condicao = true;
		while (condicao) {
			switch (rotina.menuPrincipal(player, opcoes, ambiente, acoes, npc)) {
				case 0:
					System.exit(0);
				case 1:
					condicao = false;
					break;
				case 2:
					condicao = true;
					break;
				default:
					break;
			}
		}
		System.out.println(dialogo);
		rotina.lugar(lugar2);
		ambiente = null;
		npc = null;
		int vitorias = 0;
		condicao = true;
		while (condicao) {
			switch (rotina.menuPrincipal(player, inimigo, opcoes, ambiente, acoes, 100, npc)) {
				case 0:
					System.exit(0);
				case 1:
					condicao = false;
					break;
				case 2:
					condicao = true;
					break;
				case 3:
					vitorias++;
					break;
				default:
					break;
			}
			if (vitorias == 4) {
				player.setEscudo(player.getEscudo()+3);
				System.out.println("Seu escudo agora é "+player.getEscudo());
				ferramenta.batalha(player, boss);
			}
		}
	}

}
