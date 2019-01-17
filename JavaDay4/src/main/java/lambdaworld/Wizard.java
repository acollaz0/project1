package lambdaworld;

public class Wizard {
	
	String name;
	Magic proficiency;
	
	public Wizard(String name, Magic proficiency) {
		this.name=name;
		this.proficiency = proficiency;
		
	}

	public static void main(String[] args) {
		
		Magic fireball = () -> {
			System.out.println("Cast a fireball!");
		};
		
		Wizard harry = new Wizard("Harry Potter", fireball);
		
		harry.proficiency.castSpell();
		
		Wizard merlin = new Wizard("Merlin", () -> System.out.println("Cast a thunderstrike"));
		merlin.proficiency.castSpell();

	}

}
