package lambdafun;

public class Wizard {
	String name;
	Magic proficiency;
	
	public Wizard(String name, Magic proficency) {
		this.name = name;
		this.proficiency = proficency;
	}
	
	public static void main(String[] args) {
		Magic fireball = () -> {
			System.out.println("Cast a fireball");
		};
		Wizard harry = new Wizard("Harry Potter", fireball);
		Wizard merlin = new Wizard("Merlin", () -> System.out.println("Thunder"));
	}
}
