package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class Lixao extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum","Ataque de chorume"};
	String desc = "Criado do encontro de resto de lixo mal reciclado surge o Lixão.\nSeu maior objetivo é acabar com o mundo com seu gás tóxico: o chorume.";

	public Lixao() {
		super("Lixao", 20, 5, 10, 15);
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "GolpeDeChorume");
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

	public void GolpeDeChorume(){
		setEstamina(getEstamina()-15);
		setDano(15);
	}

}
