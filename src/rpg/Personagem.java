package rpg;

public class Personagem extends Item {
	
	
	private String nome;
	private String espécie;
	private int vida;
	private Item equipamento;

	
	public Personagem(String nome, String espécie, int vida, Item equipamento) {
		super(); // Chama o construtor da superclasse (Item)
		this.nome = nome;
		this.espécie = espécie;
		this.vida = vida;
		this.equipamento = equipamento;
	}

	
	public Personagem() {
		super();
		
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspécie() {
		return espécie;
	}

	public void setEspécie(String espécie) {
		this.espécie = espécie;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Item getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Item equipamento) {
		this.equipamento = equipamento;
	}
	
	
	public void resetarVida(int novaVida) {
	    this.setVida(novaVida);
	}
 
	
	public void vidaBonus() {
	 	this.setVida(getVida() + 2);
	}

	
	public void tomarDano(int x) {
	 	this.setVida(getVida() - x);
	}
	
	
	@Override
	public String toString() {
	    String itens = (equipamento != null && equipamento.getEquipar().size() > 0)
	        ? String.join(", ", equipamento.getEquipar())
	        : "Nenhum";

	    return "\nPersonagem: " + nome +
	           "\nEspécie: " + espécie +
	           "\nVida: " + vida +
	           "\nEquipamento(s): " + itens + "\n";
	}
}