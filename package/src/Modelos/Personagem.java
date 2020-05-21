package Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jogo.Utilits;

//classe abstrata de personagem.
public abstract class Personagem {
	private int vida, escudo, estamina, mana, dano;
	private String nome;
	private Map<String, Integer> map;
	private String[] atqs;
	private String desc;
	private String[] inventario;
	
	//Método construtor com informações necessárias
	public Personagem(String nome,int vida, int escudo, int estamina, int mana) {
		this.setNome(nome);
		this.setVida(vida);
		this.setEscudo(escudo);
		this.setEstamina(estamina);
		this.setMana(mana);
	}
	
	//Método abstrato de ataque que varia de acordo com o personagem.
	public abstract int ataque();
	
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
	
	//Método que define o dano do personagem.
	public void atacar(int opcao) {
		String nome = atqs[opcao];
		dano = map.get(nome);
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
	public void observar(String[] objetos, Utilits ferramenta) {
		boolean cheio = true;
		int escolha = ferramenta.menu(Arrays.asList(objetos), "Você olha em volta e vê:", "O que você pega?[0 para voltar]");
		if(escolha<0) {
			return;
		}
		for(int i=0; i<inventario.length; i++) {
			if(inventario[i]==null) {
				cheio = false;
				inventario[i] = objetos[escolha];
				System.out.println(inventario[i]+" foi colocado no inventário");
				break;
			}
		}
		
		if(cheio) {
			System.out.println("O inventário está cheio!");
		}
	}

	//Método que lida com diálogos entre personagens.
	public void conversar() {
		System.out.println("Ninguém por perto");
	}
	
	//Método que faz o personagem usar um item do inventário.
	public void usar(Utilits ferramenta) {
		int escolha = ferramenta.menu(Arrays.asList(inventario), "Seu inventário:", "O que você quer usar?[0 para voltar]");
		if(escolha<0) {
			return;
		}
		System.out.println("Usando "+inventario[escolha]);
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

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
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

	public String[] getInventario() {
		return inventario;
	}

	public void setInventario(String[] inventario) {
		this.inventario = inventario;
	}
	
}
