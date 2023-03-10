package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'^etes pas inscrit sur notre marché aujourd'hui!");
		}else{
			String[] donneesEtal;
			donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.getBoolean(donneesEtal[0])) {
				String produit=donneesEtal[2];
				int quantiteInitial=Integer.valueOf(donneesEtal[3]);
				int quantiteVendu= Integer.valueOf(donneesEtal[3]);
				
				System.out.println("Vous avez vendu " + quantiteVendu + " sur"+ quantiteInitial+""+produit+".");
				
			}
			System.out.println("Au revoir "+nomVendeur+",passez une bonne journée");
			
		}
	}

}
