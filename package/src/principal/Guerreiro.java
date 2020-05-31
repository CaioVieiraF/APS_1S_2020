package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

//classe do nosso personagem.
public class Guerreiro extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Ataque de espada", "Revigorar", "Ataque especial"};

	public Guerreiro(String nome) {
		super(nome, 50, 5, 20, 15);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "ataqueDeEspada");
		ataques.put(atqs[2], "revigorar");
		ataques.put(atqs[3], "especial");

	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		setDano(5);
	}

	public void ataqueDeEspada() {
		setEstamina(getEstamina()-4);
		setDano(8);
	}

	public void revigorar(){
		setMana(getMana()-1);
		setEstamina(getEstamina()+2);
		setDano(0);
	}

	public void especial(){
		setMana(getMana()-5);
		setEstamina(getEstamina()-3);
		setDano(15);
	}

	public int getAtaque(int i) {
		return 0;
	}

}
