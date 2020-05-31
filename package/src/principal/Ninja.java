package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

public class Ninja extends Personagem{
	
	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Rajada de flechas", "Flecha estelar", "Ben��o da natureza"};

	public Ninja(String nome) {
		super(nome, 50, 5, 35, 25);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "Atacar_shuriken");
		ataques.put(atqs[2], "Shadow_ataque");
		ataques.put(atqs[3], "Meditar");
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		setDano(5);
	}
	
	public void Atacar_shuriken() {
		setEstamina(getEstamina()-5);
		setDano(8);
	}
	
	public void Shadow_ataque() {
		setEstamina(getMana()-10);
		setDano(15);
	}
	
	public void Meditar() {
		setMana(getMana()-10);
		setEstamina(getEstamina()+10);
		setVida(getVida()+5);
	}

	public int getAtaque(int i) {
		return 0;
	}

}
