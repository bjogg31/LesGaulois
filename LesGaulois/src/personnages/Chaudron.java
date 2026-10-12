package personnages;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public boolean resterPotion() {
		return quantitePotion > 0;
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
