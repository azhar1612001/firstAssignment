import java.util.*;
class Pair{
	int first,second;
	Pair(int first,int second){
		this.first = first;
		this.second = second;
	}
}
class StudentComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
    	if(p1.second < p2.second){
    		return -1;
    	}else if(p1.second == p2.second){
    		return 0;
    	}
    	return 1;
    }       
}
public class KFrequent{
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		Random rd = new Random();
		int size = (Math.abs(rd.nextInt())%100+10);
		int k = (Math.abs(rd.nextInt())%size+1);
		for(int i = 0; i < size; i++){
			arr.add(Math.abs(rd.nextInt())%10);
		}
		Map<Integer,Integer> count = new HashMap<>();
		for(int i = 0; i < size; i++){
			count.put(arr.get(i),count.getOrDefault(arr.get(i),0)+1);
		}
		PriorityQueue<Pair> que = new PriorityQueue<>(new StudentComparator());
		for(Map.Entry<Integer,Integer> mapElement : count.entrySet()){
			que.add(new Pair(mapElement.getKey(),mapElement.getValue()));
			if(que.size() > k){
				que.poll();
			}
		}
		while(que.size() > 0){
			System.out.println(que.peek().first + " : " + que.peek().second);
			que.poll();
		}
	}
}