package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup >= 0;
		int temp = force;
		force -= forceCoup;
		if (force <= 0) {
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert temp > force;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
			} else {
				equipements[1] = equipement;
				extracted(equipement);
			}
			break;
		}
		default:
			equipements[0] = equipement;
			extracted(equipement);

		}
	}

	private void extracted(Equipement equipement) {
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

		for (Equipement e : Equipement.values()) {
			System.out.println(e);
		}

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
