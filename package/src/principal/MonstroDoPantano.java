package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class MonstroDoPantano extends Personagem{

	Map<String, Integer> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum"};
	String desc = "Montro criado pela alta poluição de rios";
	
	public MonstroDoPantano() {
		super("Monstro Do Pantano", 60, 4, 30, 0);
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], this.ataque());
	}
	
	@Override
	public void atacar(int x) {
		Random rand = new Random();
		int escolha = rand.nextInt(10);
		setDano(ataque()-escolha);
	}

	@Override
	public int ataque() {
		setEstamina(getEstamina()-1);
		return 10;
	}

}
