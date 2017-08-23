//Lab Assignment 1 - Section A Question 3
import java.math.BigInteger;

public class prime_factorization {
	
	public static void fact(BigInteger a){
		
		for (BigInteger i=BigInteger.valueOf(2);i.compareTo(a) <= 0 ;i=i.add(BigInteger.ONE)){
			while (a.mod(i).compareTo(BigInteger.ZERO)==0){
				System.out.print(i+" ");
				a=a.divide(i);
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fact(BigInteger.valueOf(19));
	}
}
