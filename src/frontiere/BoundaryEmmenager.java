package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous �tes d�j� un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("�tes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					
					break;

				case 2:
					int force= 0;
					System.out.
						println("Bienvenu villageois "+ nomVisiteur);
					question.append("Quelle est votre force?\n");
					force= Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide;
		int effetPotionMin=0, effetPotionMax=0;
		StringBuilder question = new StringBuilder();
		System.out.println("Bienvenu druide "+ nomVisiteur);
		question.append("Quelle est votre force?\n");
		forceDruide= Clavier.entrerEntier(question.toString());
		do {
			question.append("Quelle est la force de potion la plus faible que vous produisez?\n");
			effetPotionMin=Clavier.entrerEntier(question.toString());
			question.append("Quelle est la force de potion la plus forte que vous produisez?\n");
			effetPotionMax= Clavier.entrerEntier(question.toString());
			if(effetPotionMin>effetPotionMax) {
				System.out.println("Attention Druide, vous voys �tes tromp� entre le minimum et le maximum");
			}
		}while(effetPotionMin>effetPotionMax);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
