package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

public class Mago extends Personagem{
	
	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Fire ball", "Relampago", "Regressao"};

	public Mago(String nome) {
		super(nome, 50, 5, 25, 35);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "Fire_ball");
		ataques.put(atqs[2], "Relampago");
		ataques.put(atqs[3], "Regress�o");
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		setDano(5);
	}
	
	public void Fire_ball() {
		setMana(getMana()-5);
		setDano(8);
	}
	
	public void Relampago() {
		setMana(getMana()-10);
		setDano(15);
	}
	
	public void Bencao_da_natureza() {
		setEstamina(getEstamina()-10);
		setMana(getMana()+10);
		setVida(getVida()+5);
	}

	public int getAtaque(int i) {
		return 0;
	}

}
