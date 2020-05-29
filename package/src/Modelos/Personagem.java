package Modelos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jogo.Utilits;

//classe abstrata de personagem.
public abstract class Personagem {
	private int vida, escudo, estamina, mana, dano;
	private String nome;
	private Map<String, String> map;
	private String[] atqs;
	private String desc;
	private Map<String, Integer> inventario = new HashMap<>();

	//Método construtor com informações necessárias
	public Personagem(String nome,int vida, int escudo, int estamina, int mana) {
		this.setNome(nome);
		this.setVida(vida);
		this.setEscudo(escudo);
		this.setEstamina(estamina);
		this.setMana(mana);
	}

	//Método abstrato de ataque que varia de acordo com o personagem.
	public abstract void ataque();

	//Método que retorna uma lista com todos os nomes dos
	// ataques que estão nas chaves de um dicionário.
	public List<String> getAtaques() {
		List<String> atqs = new ArrayList<String>();
		for(String i : map.keySet()) {
			atqs.add(i);
		}
		Collections.reverse(atqs);
		return atqs;
	}

	//Método que executa a função de ataque escolhida.
	public void atacar(int opcao) {
		String nome = atqs[opcao];
		Method metodo = null;

		try {
			metodo = this.getClass().getMethod(map.get(nome));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			metodo.invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void ataque(int dano) {
		setDano(dano);
	}

	//Método que calcula o dano real do ataque e
	// modifica o valor da vida de acordo.
	public void recebeAtaque(int dano) {
		dano -= escudo;
		if(dano < 0) dano=0;
		vida -= dano;
	}

	//Método que verifica se o personagem está vivo.
	public boolean estaVivo() {
		return vida>0;
	}

	//Método que mostra itens ao redor do personagem.
	public void observar(Map<String, Integer> ambiente, Utilits ferramenta) {
		String[] objetos = ambiente.keySet().toArray(new String[ambiente.keySet().size()]);
		Integer[] quant = ambiente.values().toArray(new Integer[ambiente.keySet().size()]);
		String[] objetos2 = new String[objetos.length];
		for (int i = 0; i < objetos2.length ; i++) {
			if (quant[i] == -1) {
				objetos2[i] = objetos[i] + " (usar)";
			} else if(quant[i] != 0) {
				objetos2[i] = objetos[i] + " (" + quant[i] + ")";
			}
		}
		int escolha = ferramenta.menu(Arrays.asList(objetos2), "Você olha em volta e vê:", "O que você pega?[0 para voltar]");
		if(escolha<0) {
			return;
		}

		if(inventario.size() == 8) {
			System.out.println("O inventário está cheio!");
			return;
		}

		if(inventario.get(objetos[escolha]) != null) {
			if(inventario.get(objetos[escolha]) == 5) {
				inventario.put(objetos[escolha], 1);
			} else {
				inventario.replace(objetos[escolha], inventario.get(objetos[escolha]), inventario.get(objetos[escolha])+1);
			}
		} else {
			inventario.put(objetos[escolha], 1);
		}

		ambiente.replace(objetos[escolha], quant[escolha], quant[escolha]-1);
		System.out.println(objetos[escolha]+" foi colocado no inventário");

	}

	//Método que lida com diálogos entre personagens.
	public void conversar() {
		System.out.println("Ninguém por perto");
	}

	//Método que faz o personagem usar um item do inventário.
	public void usar(Utilits ferramenta) {
		Set<String> keys = inventario.keySet();
		String[] lista = keys.toArray(new String[keys.size()]);
		String[] lista2 = new String[lista.length];
		for (int i = 0; i < lista.length ; i++) {
			lista2[i] = lista[i] + " (" + inventario.get(lista[i]) + ")";
		}
		if(inventario.size()==0) {
			System.out.println("Inventário vazio");
			return;
		}
		int escolha = ferramenta.menu(Arrays.asList(lista2), "Seu inventário:", "O que você quer usar?[0 para voltar]");
		if(escolha<0) {
			return;
		} else if (lista[escolha]==null) {
			System.out.println("Valor inválido!");
			return;
		}
		inventario.replace(lista[escolha], inventario.get(lista[escolha]), inventario.get(lista[escolha])-1);
		System.out.println("Usando "+lista[escolha]);
		if(inventario.get(lista[escolha]) == 0) {
			inventario.remove(lista[escolha]);
		}
	}

	//Métodos Getters e Setters.
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getEstamina() {
		return estamina;
	}

	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String[] getAtqs() {
		return atqs;
	}

	public void setAtqs(String[] atqs) {
		this.atqs = atqs;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map<String, Integer> getInventario() {
		return inventario;
	}

	public void setInventario(Map<String, Integer> inventario) {
		this.inventario = inventario;
	}

}
