package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Boss_Elementar_Terra extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak", "Special two"};
	String desc = "";
	Random rand = new Random();


	public Boss_Elementar_Terra() {
		super("Boss terrestre", 100, 10, 20, 40);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "terremoto");
		ataques.put(atqs[2], "sedimentação");
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

	public void terremoto () {

		setEstamina(getMana() - 8);
		setDano(14);


	}
	
	public void sedimentação () {

		setEstamina(getMana() - 12);
		setDano(17);


	}

}
