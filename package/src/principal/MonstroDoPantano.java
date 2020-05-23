package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class MonstroDoPantano extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum"};
	String desc = "";
	
	public MonstroDoPantano() {
		super("Monstro Do Pantano", 60, 4, 30, 0);
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
	}
	
	@Override
	public void atacar(int x) {
		super.atacar(0);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		Random rand = new Random();
		int escolha = rand.nextInt(10);
		setDano(10-escolha);
	}

}
