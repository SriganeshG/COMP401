package lec7.ex1;

public class Main {
	public static void main(String[] args) {
		
		ClassA a_instance = new ClassA();
		
		System.out.println(a_instance.intFieldA);
		System.out.println(a_instance.doubleFieldB);
		System.out.println(a_instance.boolFieldC);
		System.out.println(a_instance.stringFieldD);
		System.out.println(a_instance.objFieldE);		
	}
}


class ClassA {
	int intFieldA;
	double doubleFieldB;
	boolean boolFieldC;
	String stringFieldD;
	ClassB objFieldE;
}

class ClassB {
	// An empty class
}
