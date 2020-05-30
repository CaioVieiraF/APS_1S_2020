package inimigos.Boss;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class BossElementarFogo extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Rajada de fogo", "Eleva aquecimento global"};
	String desc = "A personificação de todas as queimadas e do aquecimento global";
	Random rand = new Random();


	public BossElementarFogo() {
		super("Boss Elementar Fogo", 100, 10, 30, 40);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "rajadaFogo");
        ataques.put(atqs[2], "gasCarbonico");
	}


	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x = atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		int escolha = rand.nextInt(10);
		setDano(10-escolha);
	}

	public void rajadaFogo() {
		setEstamina(getEstamina()-6);
		setDano(15);
	}

    public void gasCarbonico(){
        setMana(getMana()-5);
		setDano(15);
    }

}
