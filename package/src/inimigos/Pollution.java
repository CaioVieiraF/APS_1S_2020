package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Pollution extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Golpe Fumaçante"};
	String desc = "Vindo da poluição eminente de fábricas e automóveis.\nPollution pode trazer graves problemas de respiração devido sua forma gasosa.";
	Random rand = new Random();


	public Pollution() {
		super("Pollution", 40, 9, 10, 0);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "GolpeFumacante");
	}


	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x = atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		int escolha = rand.nextInt(5);
		setDano(5-escolha);

	}

	public void GolpeFumacante() {

		setEstamina(getEstamina()-9);
		setDano(9);


	}

}
