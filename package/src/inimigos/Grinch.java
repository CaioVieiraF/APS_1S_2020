package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Grinch extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak"};
	String desc = "Essa pequena criatura é uma das maiores pestes contra a"
				+ " natureza, por onde passa deixa um caos, sempre atirando lixo "
				+ "nas pessoas e pregando pessas.\r\n"
				+ "Ataque atirar casca de bananas e jogar lixo.\r\n";
	Random rand = new Random();


	public Grinch() {
		super("Grinch", 10, 3, 5, 10);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "jogar_lixo");
	}


	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x = atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		int escolha = rand.nextInt(10);
		setDano(10-escolha);

	}

	public void jogar_lixo() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}

}
