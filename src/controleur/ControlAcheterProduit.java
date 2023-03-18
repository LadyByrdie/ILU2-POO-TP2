package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public Gaulois[] chercherProduit(String produit) {
		int quantiteVendeur= village.donnerNbEtal();
		Gaulois[] vendeur= new Gaulois[quantiteVendeur];
		if (quantiteVendeur>0) {
			vendeur= this.village.rechercherVendeursProduit(produit);
		}else {
			System.out.println("Par le moment il n'y aucun vendeur disponible sur le marché!");
		}
		
		return vendeur;
	}
	
	public boolean verififierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	
	
	public void acheterProduit(String nom, Gaulois nomCommercant ){
		String commercant=nomCommercant.getNom();
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(commercant);
		StringBuilder question = new StringBuilder();
		
		int nbProduitDispo= etal.getQuantite();
		
		if(nbProduitDispo==0) {
			System.out.println("Je suis désolé " + nom + " mais je ne plus rien.");
			return;
		}
		
		question.append("Combien de"+ etal.getProduit() + " voulez-vous acheter?\n");
		int nbProduit=Clavier.entrerEntier(question.toString());
		
		if (nbProduitDispo>nbProduit){
			System.out.println( nom + " a acheter" +nbProduit+ "de fleurs à " + commercant);
			etal.acheterProduit(nbProduit);
		
		
		}else{
			System.out.println("Mins! je ne pas assez de " +etal.getProduit()+ 
					"j'ai en que " + nbProduitDispo + " voudrais tu les acheter quand même?");
			question.append("1- Oui");
			question.append("2- Non");
			
			int choixUtilisateur = Clavier.entrerEntier(question.toString());
			
			switch(choixUtilisateur) {
			case 1:
				System.out.println("Voila pour vous!");
				etal.acheterProduit(nbProduitDispo);
				break;
			case 2:
				System.out.println("Passez une bonne journée!");
				break;
			default:
				System.out.println("Inserez soit le 1 soit le 2");
			}
			
			
		}
	
	}
}

