import java.util.*;
public class NextGreater{
	private static class Pair{
		int first,second;
		Pair(int f,int s){
			first = f;
			second = s;
		}
	}
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		Random rd = new Random();
		int size = (Math.abs(rd.nextInt())%100+10);
		for(int i = 0; i < size; i++){
			arr.add(Math.abs(rd.nextInt())%10);
		}
		Stack<Pair> st =  new Stack<>();
		ArrayList<Integer> nextGreaterElement = new ArrayList<>(Collections.nCopies(size,-1));
		for(int i = 0; i < size; i++){
			while(!st.empty() && st.peek().first < arr.get(i)){
				nextGreaterElement.set(st.peek().second,arr.get(i));
				st.pop();
			}
			st.push(new Pair(arr.get(i),i));
		}
		System.out.println(arr);
		System.out.println(nextGreaterElement);
	}
}