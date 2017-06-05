import java.io.*;
import java.util.*;

class Anagram {
	static void isAnagram(String s1, String s2){	
		boolean isAnagram = true;
		if(s1.length() != s2.length()){
			isAnagram = false;
		}else{
			char[] s1Array = s1.toLowerCase().toCharArray();
			char[] s2Array = s2.toLowerCase().toCharArray();			
			Arrays.sort(s1Array);
			Arrays.sort(s2Array);
			isAnagram = Arrays.equals(s1Array,s2Array);
		}
		if(isAnagram){
			System.out.println(s1+" and "+s2+" are anagram");
		}else{
			System.out.println(s1+" and "+s2+" are not anagram");
		}
	}
	public static void main(String[] agrs) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the first word: ");
		String first_word = br.readLine();
		System.out.print("Enter the second word: ");
		String second_word = br.readLine();
		isAnagram(first_word, second_word);
	}
}