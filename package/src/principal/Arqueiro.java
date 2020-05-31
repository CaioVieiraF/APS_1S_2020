package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

public class Arqueiro extends Personagem{
	
	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Rajada de flechas", "Flecha estelar", "Ben��o da natureza"};

	public Arqueiro(String nome) {
		super(nome, 50, 5, 35, 25);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "rajada_de_flechas");
		ataques.put(atqs[2], "flecha_estelar");
		ataques.put(atqs[3], "Bencao_da_natureza");
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		setDano(5);
	}
	
	public void rajada_de_flechas() {
		setEstamina(getEstamina()-5);
		setDano(8);
	}
	
	public void flecha_estelar() {
		setEstamina(getMana()-10);
		setDano(15);
	}
	
	public void Bencao_da_natureza() {
		setMana(getMana()-10);
		setEstamina(getEstamina()+10);
		setVida(getVida()+5);
	}

	public int getAtaque(int i) {
		return 0;
	}

}
