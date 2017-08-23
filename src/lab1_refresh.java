
import java.util.Arrays;

import java.math.BigInteger;

public class lab1_refresh {
	public static void q1(int[] arr){
		int count =0;
		for (int i=0;i<arr.length;i++){
			if (arr[i]==0){
				count++;
			}
			else{
				break;
			}
		}
		System.out.println(count);
		
	}
	
	public static void q2(BigInteger[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = i; j < m[0].length; j++) {
                BigInteger x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
        for (int  j = 0; j < m[0].length/2; j++) {
            for (int i = 0; i < m.length; i++) {
                BigInteger x = m[i][j];
                m[i][j] = m[i][m[0].length -1 -j]; 
                m[i][m[0].length -1 -j] = x;
            }
        }
    }

	public static boolean q3_uniquechar(String s){
		char[] c= s.toCharArray();
		Arrays.sort(c);
		for (int i=0;i<c.length-1;i++){
			if (c[i]!=c[i+1]){
				continue;
			}
			else{
				return false;
			}
		}
		return true;

	}
	
	public static boolean q3_uniquewords(String s){
		String[] arr=s.split(" ");
		for (int i=0; i<arr.length; i++)
            for (int j=i+1; j<arr.length; j++)
                if (arr[i] == arr[j]){
                    return false;
                }
		
		return true;
 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BigInteger arr[][]={{BigInteger.valueOf(1),BigInteger.valueOf(2)},{BigInteger.valueOf(3),BigInteger.valueOf(4)}};
		q2(arr);
		for (int i=0;i<arr.length;i++){
			for (int j=0;j<arr.length;j++){
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
		
		System.out.println(q3_uniquechar("hello"));
		System.out.println(q3_uniquewords("Hey how are you"));*/
		
		String nums="123+156";
		String[] a = nums.split("\\+");
		System.out.println(Arrays.toString(a));
		
		
	}

}
