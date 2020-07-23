/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.66
 */
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class RefMetStatic {
	public static void main(String[] args) {
		// Métodos com assinatura double (double)
		DoubleUnaryOperator f_cbrt = Math::cbrt;
		DoubleFunction<Double> f_exp = Math::exp;
		Function<Double, Double> f_log = Math::log;
		System.out.println("cbrt(8.0)=" + f_cbrt.applyAsDouble(8.0));
		System.out.println("exp(1.0)=" + f_exp.apply(1.0));
		System.out.println("log(64.0)=" + f_log.apply(64.0));

		// Métodos com assinatura double (double, double)
		DoubleBinaryOperator f_max = Math::max;
		BinaryOperator<Double> f_min = Math::min;
		Calculavel f_pow = Math::pow;
		System.out.println("max(2.5, 5.2)=" + f_max.applyAsDouble(2.5, 5.2));
		System.out.println("min(2.5, 5.2)=" + f_min.apply(2.5, 5.2));
		System.out.println("pow(16.0, 0.5)=" + f_pow.calcular(16.0, 0.5));

		// Expressões lambda equivalentes
		DoubleUnaryOperator f_cbrt2 = v -> Math.cbrt(v);
		BinaryOperator<Double> f_min2 = (a, b) -> a < b ? a : b;
		System.out.println("cbrt2(512)=" + f_cbrt2.applyAsDouble(512));
		System.out.println("min2(2.5, 5.2)=" + f_min2.apply(2.5, 5.2));
	}
}
