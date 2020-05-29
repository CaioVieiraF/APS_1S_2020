package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class MonstroDoPantano extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum"};
	String   desc = "Quando o descarte de lixo se acumula em meio aos rios e lagos,\n"
				  + " monstros do pântano são criados, possui ataque de gosma e jato de lama.";

	public MonstroDoPantano() {
		super("Monstro Do Pantano", 40, 4, 15, 0);
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
	}

	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x=atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		Random rand = new Random();
		int escolha = rand.nextInt(10);
		setDano(10-escolha);
	}

}
