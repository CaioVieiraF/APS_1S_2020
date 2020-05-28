package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Insectoide extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Ácido"};
	String desc = "";
	Random rand = new Random();


	public Insectoide() {
		super("Insectoide", 25, 5, 10, 0);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "acido");
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

	public void acido() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}

}
