package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nom) {
		if(!controlAcheterProduit.verififierIdentite(nom))
		{
			System.out.println("Vous devez faire partie du village si vous voulez utiliser notre marché!");
	
		} else {
			StringBuilder question = new StringBuilder();
			
			System.out.println("Quel produit souhaitez-vous acheter?");
			String produit= scan.next();
			
			Gaulois[] commercant= controlAcheterProduit.chercherProduit(produit);
			
			if(commercant==null&& commercant.length==0) {
				System.out.println("Aucun des nos marchands à le produit que vous cherchez");
			}else {
			question.append("Chez quel commerçant voules-vous acheter des" +produit+ "?\n");
			
			for (int i=1; (i<commercant.length)&&(commercant[i]!=null);i++)
				{
					question.append(i + "-" + commercant[i].getNom() +"\n");
				}
			
			int choixUtilisateur= Clavier.entrerEntier(question.toString());
			
			if (choixUtilisateur>commercant.length)
			{
				System.out.println("inserez un numero entre 1 et " +commercant.length+ " s'il vous plait");
			}
			else
			{
			System.out.println( nom + " Se déplace jusqu'à l'étal du vendeur " + commercant[choixUtilisateur-1].getNom());
			controlAcheterProduit.acheterProduit(nom,commercant[choixUtilisateur-1]);
		
			}
			
		}
	}
}
}
