package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class Dr_Planeta extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak"};
	String   desc = "Um velho cientista que quando jovem havia ca�do em um posso de lixo"
				  + " toxico e agora tem as habilidades de controlar mat�rias org�nicas "
				  + "criando monstros.\r\n" 
				  +"Ataque bola de lixo e horda de lixo.\r\n";

	Random rand = new Random();

	public Dr_Planeta() {
		super("Dr.Planeta", 30, 5, 15, 10);
		
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "bola_de_lixo");

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

	public void bola_de_lixo() {

		setEstamina(getEstamina()-10);
		setDano(10);


	}
}
