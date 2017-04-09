
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ITP1_1_B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println((int)Math.pow(Integer.parseInt(br.readLine()), 3));
	}
}
