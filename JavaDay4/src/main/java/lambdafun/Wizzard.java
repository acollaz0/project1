package lambdafun;

public class Wizzard {

	String name;
	Magic proficency;
	
	public Wizzard(String name, Magic proficency) {
		this.name = name;
		this.proficency = proficency;
		
	}
	
	public static void main(String[] args) {
		
		Magic fireball = () -> {
			System.out.println("Cast a fireball!!!!!");			
		};
		Wizzard harry = new Wizzard("Harry Potter", fireball);
		harry.proficency.castSpell();
		Wizzard merlin = new Wizzard("Merlin",()-> System.out.println("Thunder"));
		merlin.proficency.castSpell();
	}
	
}
