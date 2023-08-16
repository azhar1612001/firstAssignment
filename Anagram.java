import java.util.*;
public class Anagram{
	private static String findKey(String s){
		ArrayList<Character> arr = new ArrayList<>();
		for(int i = 0; i < s.length(); i++){
			arr.add(s.charAt(i));
		}
		Collections.sort(arr);
		String ans = "";
		for(Character ch : arr){
			ans+=ch;
		}
		return ans;
	}
	public static void main(String[] args){
		ArrayList<String> arr = new ArrayList<>();
		arr.add("dlkfhash");
		arr.add("dhfkhah");
		arr.add("dkhfhadlhf");
		arr.add("dfjhfa");
		arr.add("fa");
		arr.add("af");
		Map<String,ArrayList<String>> anagrams = new HashMap<>();
		for(String s : arr){
			String str = findKey(s);
			if(anagrams.containsKey(str)){
				anagrams.get(str).add(s);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				anagrams.put(str,list);
			}
		}
		for(Map.Entry<String,ArrayList<String>> mapElement : anagrams.entrySet()){
			System.out.println(mapElement.getValue());
		}
	}
}