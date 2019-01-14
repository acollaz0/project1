package primitives;

public class Primitives {
	byte y;// 8 bits
	char c;//16bits
	short s;//16bits
	int i;//32bits
	float f;//32bits
	long l;//64bits
	double d;//64bits
	
	boolean b;//doesn't have a size it changes. N/A
	
	//an int being less bits can fit into a double which has more space
	int number1 = 100;
	double number2 = number1;
}
