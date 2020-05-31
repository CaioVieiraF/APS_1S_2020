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
		String[] tipos = {"Guerreiro", "Arqueiro", "Mago", "Ninja"};
		int escolha = ferramenta.menu(Arrays.asList(tipos), "Escolha a sua classe:");
		nome = tipos[escolha] +" "+ nome;
		Personagem[] classe = {new Guerreiro(nome), new Arqueiro(nome), new Mago(nome), new Ninja(nome)};
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
			new Npc("criança", false),
			new Npc("Carpinteiro", false),
			new Npc("Bibliotecário", true),
			new Npc("Senhora", false)
		};
		Npc[] npc3 = {
			new Npc("Senhora", false),
			new Npc("Ferreiro", false),
			new Npc("Bobo da corte", false),
			new Npc("Acião Zefir", true)
		};
		Npc[] npc4 = {
			new Npc("criança", false),
			new Npc("Bibliotecario", false),
			new Npc("Acião Zefir", false),
			new Npc("Rei de Solaria", true)
		};
		String dialogo1 = "\n["+player.getNome()+"] – Ola eu sou" +player.getNome()+ "e o senhor ? \n"
		+"[Bibliotecario] – Eu sou o bibliotecario, jovem percebi a algum tempo que você \n"
		+ " vem treinando próximo a floresta das Conchas estou correto ? \n"
		+"["+player.getNome()+"] – Sim senhor, mais porque a pergunta ? \n"
		+"[Bibliotecario] - A resposta é muito simple, nessa floresta se encontra um monstro, \n"
		+ "essa é  a criatura mais temida desse local. \n"
		+ "Mas se por algum acaso voce se deparar com ele fuja imediatamente. \n"
		+ "Todos que o enfrentaram tiveram um terrivel fim. \n"
		+"["+player.getNome()+"] – Mas semhor bibliotecario eu vim aqui para derrotar esse monstro \n"
		+ "não aparento mas sou muito forte e tenho certesa de que acabarei com ele custe o que custar. \n"
		+"[Bibliotecario] - Voce esta louco! \n"
		+ "Se voce conseguir sair dessa vivo voce conseguira ficar mais poderoso \n"
		+ "que qualquer outro... Boa sorte em sua jornada. \n"
		+ "Lembrese sempre do nome dessa floresta... \n"
		+"["+player.getNome()+"] – Obrigado! Ate a proxima senhor Bibliotecario... \n";

		String dialogo2 = "[Bibliotecario de arcadia] - Benvindo a cidade de arcadia, voce procura por algo ? \n"
		+"["+player.getNome()+"] – Sim, um senhor que cuida da biblioteca da cidade de arcadia. \n"
		+"[Bibliotecario de arcadia] - Pois bem, ca estou o senhor bibliotecario. \n"
		+ "Voce teria algo a tratar comigo ? \n"
		+"["+player.getNome()+"] – Tenho perguntas, se o senhor puder me responder. \n"
		+"[Bibliotecario de arcadia] - E porque eu deveria responder tal insolencia \n"
		+ "o que eu ganharia com isso ? \n"
		+"["+player.getNome()+"] – E esto procurando a Dungeon secreta de arcadia \n"
		+ "para livra a cidade do mal provido dela ! \n"
		+"[Bibliotecario de arcadia] - hahaha!!! Voce é um idiota por pensar que \n"
		+ "sosinho consegue derrotar o monstro que vive por la. \n"
		+ "A cidade ja enviou muitos soldados e guerreiros de classe superior \n"
		+ "mas voce um aventureiro desconhecido acha que consegue hahaha \n"
		+ "Pois bem vou indicar a direção. \n"
		+ "Boa sorte jovem tolo...Tente não perecer. \n"
		+"["+player.getNome()+"] – Obrigado senhor bibliotecario não vou te decepcionar... \n"
		+"[Bibliotecario de arcadia] - Jovem tolo que os deuses o protejam. \n"
		+"["+player.getNome()+"] – Vamos até a Dungeon secreta de arcadia... \n";

		String dialogo3 = "["+player.getNome()+"] – Nosso esse ultimo monstro o da \n "
		+"Dungeon não foi moleza não, ainda bem que consegui chegar ate o reino da terra. \n"
		+"[Ancião Zefir] - Olá jovem não pude deixar de ouvir você comentando \n"
		+"o ultimo monstro da dungeon foi deureza. \n"
		+"Por acaso você não ceria uma aventureiro certo ? \n"
		+"["+player.getNome()+"] – Sim, eu sou um aventureiro e um dos melhores \n"
		+"e a minha jornada atual é para acabar com todos os quatro monstros \n"
		+"elementares, ques são os mais temidos. Mas eu não temho medo deles. \n"
		+"[Ancião Zefir] - Jovem você ouviu falar da criatura que fica ao redor \n"
		+"do pantano sombrio, dizem que é uma criatura horenda e maldoza. \n"
		+"["+player.getNome()+"] – Ancião poderia me dizer onde fica esse local, talvez seja \n"
		+"a criatura que a tanto aceio em derrota-lo para livrar o mundo do caos... \n"
		+"[Ancião Zefir] - É muito perigoso enfrenta-lo... \n"
		+"Mas se você enciste que ira então eu endicarei o caminho... \n"
		+"["+player.getNome()+"] – Obrigado ancião por me ajudar sou grato au senhor. \n"
		+"Adeus Ancião Zefir... \n";

		String dialogo4 = "["+player.getNome()+"] – Esta jornada esta cada vez mais intensa \n"
		+ "estão aparecendo cada vez monstros mais fortes, \n"
		+ "mas não posso fraquejar agora quando falta tão pouco. \n"
		+"["+player.getNome()+"] – acho que vou até o palacio real onde meu tio \n"
		+ "o rei de solaria reina a duas decadas. \n"
		+ "Ele deve saber algo sobre a criatura fogosa das lendas. \n"
		+"["+player.getNome()+"] – Olá meu tio, seu sobrinho retorna depois de uma longa \n"
		+ "jornada. Preciso perguntar algo muito serio ao senhor, meu tio \n"
		+ "senhor governante de todo o Reino de Solaria... \n"
		+"[Rei de Solaria] - Olá meu sobrinho, idota \n"
		+ "hahaha! há quanto tempo não nos vemos hahaha \n"
		+"[Rei de Solaria] - Diga sobrinho o quesejas ? \n"
		+"["+player.getNome()+"] – Gostaria de saber onde se encontra a criatura de chamas \n"
		+ "que a tempos ouço faler. \n"
		+"[Rei de Solaria] - Quem contou isso a você, esse é o maior segredo de nosso reino \n"
		+ "há decadas, nem os conselheiros reais sabem sobre isso. \n"
		+ "Fale agora quem destes a você tal imformação para que eu acabe com ele. \n"
		+"["+player.getNome()+"] – Não, tio se acalme não foi nenhum de seus suditos. \n"
		+ "Mas sim outra das quatro criaturas que eu dei um fim. \n"
		+ "Porfavor digame onde esta a criatura que reina sobre o fogo... \n"
		+"[Rei de Solaria] - Esta bem então direi onde você poderá encontrala! \n"
		+"[Rei de Solaria] - Ao Sul de nosso reino encontra-se um vulcão que \n"
		+ "há duas semanas aproximadamente começou a fazer barulhos como \n"
		+ "se fossem gritos de uma monstruozidade que em todos os meus anos \n"
		+ "de vida ja mais sentira tal terror, até meus ossos congelaram. \n"
		+ "Mas Porfavor não segua em frente com tal ato de loucura, isso é \n"
		+ "suicidio..... \n"
		+"["+player.getNome()+"] – Não se preocupe atoa meu tio, eu me tornarei o maior heroi \n"
		+ "de todos os quatro reinos... \n"
		+ "Obrigado por se preocupar comigo.\n"
		+ "Até breve...... \n";

		Personagem[] inimigo1 = {
			new MonstroDoPantano(),
			new VerminosoEscoria(),
			new LixoSvaldo(),
			new Dr_Planeta(),
			new Smog()
		};
		Personagem[] inimigo2 = {
			new VerminosoEscoria(),
			new Pollution(),
			new Insectoide(),
			new Plastic_Pig()
		};
		Personagem[] inimigo3 = {
			new MonstroDoPantano(),
			new VerminosoEscoria(),
			new Grinch(),
			new LixoSvaldo(),
			new Lixao()
		};
		Personagem[] inimigo4 = {
			new MonstroDoPantano(),
			new VerminosoEscoria(),
			new LixoSvaldo(),
			new Lixao(),
			new Pollution()
		};

		reino(
			player,
			"Cidade das conchas",
			"Floresta das conchas",
			acoes1,
			npc1,
			dialogo1,
			inimigo1,
			new Boss_Elementar_Agua()
			);
		reino(
			player,
			"cidade de arcadia",
			"Dungeon secreta",
			acoes2,
			npc2,
			dialogo2,
			inimigo2,
			new Boss_Elementar_Ar()
			);
		reino(
			player,
			"Proximidades do pantano sombrio",
			"pantano sombrio",
			acoes3,
			npc3,
			dialogo3,
			inimigo3,
			new Boss_Elementar_Terra()
			);
		reino(
			player,
			"reino solaria",
			"vulcão",
			acoes4,
			npc4,
			dialogo4,
			inimigo4,
			new BossElementarFogo()
			);

		System.out.println("Uma forte rajada de luz puxa o nosso \n"
		+"heroi até um local desconhecido \n"
		+"\n ----- Reino perdido de Atlantis -----"
		+"\n\n"
		+"["+player.getNome()+"] – O que aconteceu, onde estou, quem sou \n"
		+ "o que estou fazendo nesse lugar e que local é esse... \n"
		+"Local - reino submersso de Atlantis \n"
		+"["+player.getNome()+"] – Melembro agora eu estava em uma jornada \n"
		+ "para acabar com os monstros que foram criados atravez da poluição. \n"
		+ "Mas como vim parar aqui e como consigo respirar em baixo da água. \n"
		+ "Entendo agora logo apos eu derrotar a criatura de fogo acabei sendo teleportado \n"
		+ "a força de dentro do vulcão. \n"
		+"[Boss Elemental] - HAhaha!!! \n"
		+"[Boss Elemental] - Quem ousa adentrar em meus dominios ? \n"
		+"["+player.getNome()+"] – Quem é você criatura malefica ? \n"
		+"[Boss Elemental] - Eu! eu sou Elemental o ser possuidor dos quatro elementos \n"
		+ "e você pequena criatura de carne se tornara o meu jantar hoje hahaha! \n"
		+"["+player.getNome()+"] – Eu sou o heroi que veio para te destruir de uma vez por todas. \n"
		+ "assim como acabei com seus irmãos. \n"
		+"[Boss Elemental] - Ora seu vermezinho, você acha que pode me encarar então \n"
		+ "vamos ver do que você é capaz. \n"
		+ "Seu vermezinho hahaha.... preparece para perecer diante a meu poder supremo. \n");

		System.out.println(ferramenta.batalha(player, new Boss_Elemental())+" Venceu");
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
