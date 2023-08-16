import java.util.*;
public class Occurance{
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		Random rd = new Random();
		int size = (Math.abs(rd.nextInt())%100+10);
		for(int i = 0; i < size; i++){
			arr.add(Math.abs(rd.nextInt())%10);
		}
		Map<Integer,Integer> count = new HashMap<>();
		for(int i = 0; i < size; i++){
			count.put(arr.get(i),count.getOrDefault(arr.get(i),0)+1);
		}
		for(Map.Entry<Integer,Integer> mapElement : count.entrySet()){
			System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
		}
	}
}