package training;

public interface Calculator {
	default void print(){
		System.out.println("Test Print successful");
	}

	int square(int num);
}
