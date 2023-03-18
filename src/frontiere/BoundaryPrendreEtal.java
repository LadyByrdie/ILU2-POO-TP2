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
			System.out.println("Je suis d�sol�e " +nomVendeur+ "mais il faut �tre un habitant de notre village pour commencer ici.");
		}else {
			System.out.println("Bonjour " +nomVendeur+ " , je vais regarder si je peux vous trouver un étal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+ nomVendeur+"je n'ai plus d'étal qui ne soit as déjà occupé.");
			}else {
				this.installerVendeur(nomVendeur);
				
				}
			}
		}


	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		
		System.out.println("C'est parfait, il me reste un �tal pour vous!");
		System.out.println("Il me faudrait quelques renseignements: ");
		
		System.out.println("Quel produit souhaitez-vous vendre?");
		String produit= scan.next();
		
		question.append("Combien souhaitez-vous en vendre?");
		int nbProduit= Clavier.entrerEntier(question.toString());
		
		int numeroEtal= this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit)+1;
		
		if(numeroEtal!=-1) {
			System.out.println("Le vendeur" +nomVendeur+ "s'est install� � l'�tal n� "+ numeroEtal);
		
	}
}

}