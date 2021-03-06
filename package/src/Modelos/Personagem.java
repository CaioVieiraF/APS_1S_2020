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

	//Método que retorna informações sobre um personagem
	public void info(boolean descricao){
		System.out.println("+----------------");
		System.out.println("|Nome: "+getNome());
		System.out.println("|Vida: "+getVida());
		System.out.println("|Escudo: "+getEscudo());
		System.out.println("|Estamina: "+getEstamina());
		System.out.println("|Mana: "+getMana());
		System.out.println("+----------------");
		if (descricao) {
			System.out.println(this.desc);
		}
	}

	public void info(){
		info(false);
	}

	//Método que atualiza os status de um personagem
	public void refresh(){
		if (estaVivo()) {
			if (getMana() < 0) {
				setMana(0);
			}
			if (getEstamina() < 0) {
				setEstamina(0);
			}
		}
	}

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
	public void observar(String[] objetos, Utilits ferramenta, int[] acoes) {

		int escolha = ferramenta.menu(Arrays.asList(objetos), "Você olha em volta e vê:", "O que você pega?[0 para voltar]");
		if(escolha < 0) {
			return;
		}

		if (acoes[escolha] > 0) {
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
			acoes[escolha]--;
			if (acoes[escolha] == 0) {
				objetos[escolha] = null;
				for (int i = 0; i < objetos.length; i++) {
					if (objetos[i] == null && i != objetos.length-1) {
						if (objetos[i+1] == null) {
							break;
						} else {
							objetos[i] = objetos[i+1];
							objetos[i+1] = null;
							acoes[i] = acoes[i+1];
							acoes[i+1] = 0;
						}
					}
				}
			}
			System.out.println(objetos[escolha]+" foi colocado no inventário");
		} else if (acoes[escolha] == -1) {
			String reciclar = usar(new Utilits(), false);
			if (reciclar != null) {
				System.out.println(" foi reciclado!");
				setEstamina(getEstamina()+2);
				System.out.println("Você ganhou +2 de estamina!");
			}
		}
	}

	//Método que lida com diálogos entre personagens.
	public boolean conversar(Npc[] npc, Utilits ferramenta, String[] ambiente, int[] acoes) {
		String[] pessoas = new String[npc.length];
		for (int i = 0; i < pessoas.length ; i++) {
			pessoas[i] = npc[i].getNome();
		}
		int escolha = ferramenta.menu(Arrays.asList(pessoas), "Você olha em volta e vê:", "Com quem você fala?[0 para voltar]");
		if (escolha == -1) {
			return false;
		}
		return npc[escolha].interagir(this, ferramenta, ambiente, acoes);

	}

	//Método que faz o personagem usar um item do inventário.
	public String usar(Utilits ferramenta, boolean checar) {
		Set<String> keys = inventario.keySet();
		String[] lista = keys.toArray(new String[keys.size()]);
		String[] lista2 = new String[lista.length];
		for (int i = 0; i < lista.length ; i++) {
			lista2[i] = lista[i] + " (" + inventario.get(lista[i]) + ")";
		}
		if(inventario.size()==0) {
			System.out.println("Inventário vazio");
			return null;
		}
		int escolha = ferramenta.menu(Arrays.asList(lista2), "Seu inventário:", "O que você quer usar?[0 para voltar]");
		if(escolha<0) {
			return null;
		} else if (lista[escolha]==null) {
			System.out.println("Valor inválido!");
			return null;
		}
		inventario.replace(lista[escolha], inventario.get(lista[escolha]), inventario.get(lista[escolha])-1);
		if (checar) {
			System.out.println("Usando "+lista[escolha]);
		} else {
			System.out.print(lista[escolha]);
		}
		if(inventario.get(lista[escolha]) == 0) {
			inventario.remove(lista[escolha]);
		}
		return lista[escolha];
	}

	public void usar(Utilits ferramenta) {
		usar(ferramenta, true);
	}

	//Método que mostra os itens do inventário
	public void inventário(){
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
		System.out.println("+-----------------+");
		System.out.println("| Seu inventário:");
		for (int i = 0; i < lista2.length ; i++) {
			System.out.println("| ["+(i+1)+"] - "+lista2[i]);
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
