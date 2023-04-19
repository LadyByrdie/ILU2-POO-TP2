package controleur;

import personnages.*;
import villagegaulois.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Intialisation...");
		village= new Village("le village des irr�ductible", 10,5);
		abraracourcix= new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Exist pas"));
		controlEmmenager.ajouterDruide("Panoramix",10,1,5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
	}
	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix",10,1,5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",5);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
	}
}
