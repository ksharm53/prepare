package arraysAndStrings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromicSubstring {	

	public static void main(String[] args) {
		String A= "iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx";	

		Map<Integer,List<String>> map= new HashMap<>();
		int maxValue= Integer.MIN_VALUE;
		
		String R= new String(A);
		String result = "";

		StringBuilder sb= new StringBuilder(R);

		R=sb.reverse().toString();
		int sizeA=A.length();
		int sizeR=R.length();

		int[][] matrix= new int [sizeA+1][sizeR+1];

		int max=sample(A,R, sizeA, sizeR, map, matrix);
		System.out.println(max);		

		for(int l=max; l>=1; l--) {
			if(map.get(l) ==null) {
				continue;
			}
			List<String> value=map.get(l);	
			
			 for (String eachString : value) {
				String[] arrayChar=eachString.split(",");

				int k=Integer.valueOf(arrayChar[0]);
				int j= Integer.valueOf(arrayChar[1]);

				String valuTemp=validatePalindrome(k,j, A, R);
				if(valuTemp.length() > maxValue) {
					maxValue=valuTemp.length();
					result=valuTemp;
				}
			}	
		}

		System.out.println(result);
	}

	private static String validatePalindrome(int i, int j, String A, String R) {

		StringBuilder temp= new StringBuilder();

		while(i-1>=0 && j-1 >=0 && A.charAt(i-1) == R.charAt(j-1)) {
			temp.append(A.charAt(i-1));
			i--;
			j--;
		}

		String valueReverse= new String(temp);

		while(! new StringBuilder(valueReverse).reverse().toString().equalsIgnoreCase(temp.toString())) {
			temp.deleteCharAt(0);
			valueReverse= new String(temp);
		}
		return temp.toString();

	}

	private static int sample(String A, String R, int sizeA, int sizeR, Map<Integer, List<String>> map, int[][] matrix) {		

		for(int i=0; i<=sizeA; i++) {
			matrix[0][i]=0;
		}

		for(int i=0; i<=sizeR; i++) {
			matrix[i][0]=0;
		}

		for(int i=1; i<=sizeA; i++) {
			for(int j=1; j <=sizeR; j++) {
				if(A.charAt(i-1)==R.charAt(j-1)) {
					matrix[i][j]= 1+matrix[i-1][j-1];
				}
				else {
					matrix[i][j]= 0;
				}
			}
		}

		int max= Integer.MIN_VALUE;
		for(int i=0; i<=sizeA; i++) {
			for(int j=0; j <=sizeR; j++) {
				if (map.get(matrix[i][j]) == null) {
					map.put(matrix[i][j], new ArrayList<String>());
					map.get(matrix[i][j]).add(i+","+j);
				}
				else {
					map.get(matrix[i][j]).add(i+","+j);
				}
				max= Math.max(matrix[i][j], max);
			}
		}
		return max;
	}
}
