package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " +nomVendeur+ "mais il faut être un habitant de notre village pour commencer ici.");
		}else {
			System.out.println("Bonjour " +nomVendeur+ " , je vais regarder si je peux vous trouver un étal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+ nomVendeur+"je n'ai plus d'étal qui ne soit as déjà occupé.");
			}else {
				this.installerVendeur(nomVendeur);
				System.out.println("c'est parfait, il me reste un étal pour vous!");
				System.out.println("il me faudrait quelques renseignements: ");
				System.out.println("Quel produit souhaitez-vous vendre?");
				String produit= scan.toString();
				System.out.println("Combien souhaitez-vous en vendre?");
				int nbProduit= scan.nextInt();
				int numeroEtal= this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if(numeroEtal!=-1) {
					System.out.println("Le vendeur" +nomVendeur+ "s'est installé à l'étal n "+ numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
