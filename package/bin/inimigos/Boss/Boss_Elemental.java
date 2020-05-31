package inimigos.Boss;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

public class Boss_Elemental extends Personagem{

	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum", "Special atak", "Special two", "Special three", "Special four", "Special five"};
	String  desc = "Quanto todos os quatro Boss elementares são destruídos,"
				 + " um monstro Elemental que possuo as características de todos os outros é invocado"
				 + " para destruir todo o planeta ele é o possuidor das forças da natureza seus atributos"
				 + " são água, terra, fogo e ar, isso o torna o monstro mais temível de todos. \r\n"
				 + "Ataques: tempestade de chamas, iceberg, neblina toxica, magma, flechas de ar\r\n";
	Random rand = new Random();


	public Boss_Elemental() {
		super("Boss Elemental", 150, 13, 40, 80);

		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
		ataques.put(atqs[1], "tempestade_de_chamas");
		ataques.put(atqs[2], "iceberg");
		ataques.put(atqs[3], "neblina_toxica");
		ataques.put(atqs[4], "magma");
		ataques.put(atqs[5], "flechas_de_ar");
	}


	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x = atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-4);
		int escolha = rand.nextInt(10);
		setDano(10-escolha);

	}

	public void tempestade_de_chamas () {

		setEstamina(getMana() - 12);
		setDano(16);

	}

	public void iceberg () {

		setEstamina(getMana() - 15);
		setDano(16);

	}

	public void neblina_toxica () {

		setEstamina(getMana() - 8);
		setDano(12);

	}

	public void magma () {

		setEstamina(getMana() - 10);
		setDano(14);

	}
	public void flechas_de_ar () {

		setEstamina(getMana() - 18);
		setDano(20);

	}

}
