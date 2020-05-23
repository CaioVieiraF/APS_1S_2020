package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

//classe do nosso personagem.
public class Guerreiro extends Personagem{
	
	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Ataque de espada"};
	
	public Guerreiro(String nome) {
		super(nome, 50, 5, 20, 15);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "ataqueDeEspada");
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
	
	public int getAtaque(int i) {
		return 0;
	}

}
