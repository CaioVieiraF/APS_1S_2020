package inimigos.Boss;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Boss_Elementar_Agua extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak", "Special two"};
	String desc = "";
	Random rand = new Random();


	public Boss_Elementar_Agua() {
		super("Boss aquatico", 100, 10, 20, 40);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "devastacao_aquatica");
		ataques.put(atqs[2], "onda_de_gelo");
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

	public void devastacao_aquatica  () {

		setEstamina(getMana() - 4);
		setDano(12);


	}

	public void onda_de_gelo () {

		setEstamina(getMana() - 8);
		setDano(15);


	}

}
