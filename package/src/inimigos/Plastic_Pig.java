package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Plastic_Pig extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak"};
	String 	 desc = "Um porco que morava próximo a uma fabrica de potes de plástico"
				  + " e essa mesma fabrica jogava os restos que sobravam dos materiais e "
				  + "por conta disso o porquinho começou a comer restos de plástico"
				  + " e se tornou o Plastc pig.\r\n"
				  +"Ataques cuspe colante e tiros de plástico.\r\n";
	Random rand = new Random();


	public Plastic_Pig() {
		super("Plastic_Pig", 15, 3, 8, 10);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "tiros_de_plastico");
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

	public void tiros_de_plastico() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}

}
