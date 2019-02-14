package model;

public class Toppings {
	
	private int t_id;
	private int p_id;
	private int pepperoni;
	private int i_sausage;
	private int bacon;
	private int ham;
	private int salami;
	private int mushrooms;
	private int b_olives;
	private int b_peppers;
	private int pineapple;
	private int onions;
	private int g_peppers;
	private int feta;
	private int spinach;
	
	public Toppings() {
		super();
	}
	
	public Toppings(int t_id,int p_id, int pepperoni, int i_sausage, int bacon, int ham, int salami, int mushrooms, int b_olives,
			int b_peppers, int pineapple, int onions, int g_peppers, int feta, int spinach) {
		super();
		this.t_id = t_id;
		this.p_id = p_id;
		this.pepperoni = pepperoni;
		this.i_sausage = i_sausage;
		this.bacon = bacon;
		this.ham = ham;
		this.salami = salami;
		this.mushrooms = mushrooms;
		this.b_olives = b_olives;
		this.b_peppers = b_peppers;
		this.pineapple = pineapple;
		this.onions = onions;
		this.g_peppers = g_peppers;
		this.feta = feta;
		this.spinach = spinach;
	}
	@Override
	public String toString() {
		return "Toppings [t_id=" + t_id + ", p_id=" + p_id + ", pepperoni=" + pepperoni + ", i_sausage=" + i_sausage + ", bacon=" + bacon
				+ ", ham=" + ham + ", salami=" + salami + ", mushrooms=" + mushrooms + ", b_olives=" + b_olives
				+ ", b_peppers=" + b_peppers + ", pineapple=" + pineapple + ", onions=" + onions + ", g_peppers="
				+ g_peppers + ", feta=" + feta + ", spinach=" + spinach + "]";
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getPepperoni() {
		return pepperoni;
	}
	public void setPepperoni(int pepperoni) {
		this.pepperoni = pepperoni;
	}
	public int getI_sausage() {
		return i_sausage;
	}
	public void setI_sausage(int i_sausage) {
		this.i_sausage = i_sausage;
	}
	public int getBacon() {
		return bacon;
	}
	public void setBacon(int bacon) {
		this.bacon = bacon;
	}
	public int getHam() {
		return ham;
	}
	public void setHam(int ham) {
		this.ham = ham;
	}
	public int getSalami() {
		return salami;
	}
	public void setSalami(int salami) {
		this.salami = salami;
	}
	public int getMushrooms() {
		return mushrooms;
	}
	public void setMushrooms(int mushrooms) {
		this.mushrooms = mushrooms;
	}
	public int getB_olives() {
		return b_olives;
	}
	public void setB_olives(int b_olives) {
		this.b_olives = b_olives;
	}
	public int getB_peppers() {
		return b_peppers;
	}
	public void setB_peppers(int b_peppers) {
		this.b_peppers = b_peppers;
	}
	public int getPineapple() {
		return pineapple;
	}
	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;
	}
	public int getOnions() {
		return onions;
	}
	public void setOnions(int onions) {
		this.onions = onions;
	}
	public int getG_peppers() {
		return g_peppers;
	}
	public void setG_peppers(int g_peppers) {
		this.g_peppers = g_peppers;
	}
	public int getFeta() {
		return feta;
	}
	public void setFeta(int feta) {
		this.feta = feta;
	}
	public int getSpinach() {
		return spinach;
	}
	public void setSpinach(int spinach) {
		this.spinach = spinach;
	}
	

}
