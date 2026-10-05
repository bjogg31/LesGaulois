package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		if (quantitePotion <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public void remplirChaudron(int quantite, int force) {
		quantitePotion = quantite;
		forcePotion = force;
	}

	public int prendreLouche() {
		quantitePotion -= forcePotion;
		if (!resterPotion()) {
			forcePotion = 0;
		}
		return forcePotion;
	}
}
