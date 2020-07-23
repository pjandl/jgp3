
public class Lambda01 {
	public interface Function {
		double calculate(double p);
	}

	public static void main(String[] args) {
		double in = 25.3;
		Function f = (c) -> 1.8*c + 32;
		System.out.println(f.calculate(in));

	}

}
