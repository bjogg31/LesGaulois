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

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0;
//		int temp = force;
//		force -= forceCoup;
//		if (force <= 0) {
//			parler("J'abandonne !");
//		} else {
//			parler("Aïe");
//		}
//		assert temp > force;
// 		assert isInvariantVerified();
//	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
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
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
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

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");

		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		StringBuilder texte = new StringBuilder("Ma force est de " + this.force + ", et la force du coup est de " + forceCoup);
		int resistanceEquipement = 0;

		if (nbEquipement != 0) {
			texte.append("\nMais heureusement, grace à mon équipement sa force est ");
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 6;
				} else {
					resistanceEquipement += 3;
				}
			}
			if (resistanceEquipement >= forceCoup) {
				texte.append("complètement absorbée.");
				forceCoup = 0;
			} else {
				texte.append("diminuée de ");
				texte.append(resistanceEquipement);
				texte.append("!");
				forceCoup -= resistanceEquipement;
			}
		}
		parler(texte.toString());
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
}
