import java.util.*;
public class LongestSubstring{
	public static void main(String[] args){
		String s = "ihakfdshfhdfkhalahlahlf";
		Set<Character> frequency = new HashSet<>(); 
		int start = 0, end = 0, last = 0;
		for(int i = 0; i < s.length(); i++){
			while(frequency.contains(s.charAt(i))){
				frequency.remove(s.charAt(last));
				last++;
			}
			frequency.add(s.charAt(i));
			if(i-last+1 > end-start+1){
				start = last;
				end = i;
			}
		}
		System.out.println("String : " + s);
		System.out.println("Longest substring without reapeating character : " + s.substring(start,end+1));
	}
}