package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

public class LixoSvaldo extends Personagem{
	
	Map<String, Integer> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum"};
	String desc = "";
	
	public LixoSvaldo() {
		super("Loxosvaldo", 75, 7, 30, 25);
		
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], this.ataque());
	}

	@Override
	public int ataque() {
		return 0;
	}

}
