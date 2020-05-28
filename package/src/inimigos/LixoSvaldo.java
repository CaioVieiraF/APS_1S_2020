package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class LixoSvaldo extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak"};
	String desc = "";
	Random rand = new Random();


	public LixoSvaldo() {
		super("Lixosvaldo", 30, 7, 10, 25);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "Chuva_de_lixo");
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

	public void Chuva_de_lixo() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}

}
