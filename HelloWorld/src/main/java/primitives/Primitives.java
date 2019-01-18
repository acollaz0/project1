package primitives;

public class Primitives {
	
	byte y;		//8 bits
	char c;		//16 bits
	short s;	//16 bits
	int i;		//32 bits
	float f;	//32 bits
	long l;		//64 bits
	double d;	//64 bits
	boolean b; 	//doesn't have a size. Weird way java handles it, can use more or less memory.
	
	// smaller bit size primitives can fit into larger bit size prims.
	int x = 999;
	double xd = x;
	
	
	
	

}
