package inimigos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Modelos.Personagem;

//classe de inimigo.
public class VerminosoEscoria extends Personagem{

    Random rand = new Random();
	Map<String, String> ataques = new HashMap<>();
	String[] atqs = {"Ataque comum"};
	String desc = "Ele personifica os problemas gerados pela falta de saneamento público e expansão urbana e criminal sem limite.";

	public VerminosoEscoria() {
		super("Verminoso Escória", 40, 4, 15, 0);
		setDesc(desc);
		setMap(ataques);
		setAtqs(atqs);
		ataques.put(atqs[0], "ataque");
	}

	@Override
	public void atacar(int x) {
		if (x>=atqs.length) x=atqs.length-1;
		super.atacar(x);
	}

	@Override
	public void ataque() {
		setEstamina(getEstamina()-1);
		int escolha = rand.nextInt(7);
		setDano(7-escolha);
	}

    public void ordaRatos(){
        setEstamina(getEstamina()-3);
		int escolha = rand.nextInt(8);
		setDano(8-escolha);
    }

}
