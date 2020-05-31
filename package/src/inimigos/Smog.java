package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Smog extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak"};
	String   desc = "Quando as cidades se enchem de veículos as fabricas e as fabricas queimam seus \n"
				  + " conteúdos químicos, em meio a esse caos nascem as Smog nuvens altamente toxicas que "
				  + "destroem o CO2\r\n"
				  +"Assim tirando o ar de suas vítimas.\r\n"
				  +"Ataque chuva de ácido e ar sufocante.\r\n";
	Random rand = new Random();


	public Smog() {
		super("Smog", 25, 5, 10, 0);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "Neblina_de_acido");
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

	public void Neblina_de_acido() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}

}
