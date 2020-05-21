package principal;

import java.util.HashMap;
import java.util.Map;

import Modelos.Personagem;

//classe do nosso personagem.
public class Guerreiro extends Personagem{
	
	Map<String, Integer> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Ataque de espada"};
	String[] inventario = new String[8];
	
	public Guerreiro(String nome) {
		super(nome, 50, 5, 20, 15);
		setMap(ataques);
		setAtqs(atqs);
		setInventario(inventario);
		ataques.put(atqs[0], this.ataque());
		ataques.put(atqs[1], this.ataqueDeEspada());
	}

	@Override
	public int ataque() {
		setEstamina(getEstamina()-1);
		return 5;
	}
	
	public int ataqueDeEspada() {
		setEstamina(getEstamina()-4);
		return 8;
	}
	
	public int getAtaque(int i) {
		return 0;
	}

}
