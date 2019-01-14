package primitives;

public class Primitives {
	
	byte y;    // 8 bits
	char c;    // 16 bits
	short s;   // 16 bits
	int i;     // 32 bits
	float f;   // 32 bits
	long l;    // 64 bits
	double d;  // 64 bits
	boolean b; // boolean does not have a size. It changes. N/A
	
	// an int being less bits can fit into a double which has more space
	int number1 = 100;
	double number2 = number1;
}
