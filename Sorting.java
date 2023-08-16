import java.util.*;
public class Sorting{
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		Random rd = new Random();
		int size = (Math.abs(rd.nextInt())%100+10);
		for(int i = 0; i < size; i++){
			arr.add(Math.abs(rd.nextInt())%10);
		}
		System.out.println("Befor Sorting :");
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println("After sorting in Increasing order :");
		System.out.println(arr);
		Collections.sort(arr,Collections.reverseOrder());
		System.out.println("After sorting in Decreasing order :");
		System.out.println(arr);
	}
}