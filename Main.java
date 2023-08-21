import java.util.*;

class Dice{
	private Random rd = new Random();
	int rollDice(){
		return (Math.abs(rd.nextInt())%6+1);
	}
}

class Position{
	private int xCordinate,yCordinate;
	Position(){
		this.xCordinate = 1;
		this.yCordinate = 1;
	}
	Position(int xCordinate,int yCordinate){
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}
	int getXcordinate(){
		return this.xCordinate;
	}
	int getYcordinate(){
		return this.yCordinate;
	}
	void setXcordinate(int xCordinate){
		this.xCordinate = xCordinate;
	}
	void setYcordinate(int yCordinate){
		this.yCordinate = yCordinate;
	}
}


class Player{
	private Position currentPosition;
	private String playerName;
	Player(String playerName){
		this.currentPosition = new Position();
		this.playerName = playerName;
	}
	String getName(){
		return this.playerName;
	}
	Position getPosition(){
		return currentPosition;
	}
	boolean isValidMove(int step){
		if(currentPosition.getYcordinate() == 10 && currentPosition.getXcordinate()+step>10){
			return false;
		}
		return true;
	}
	void updatePlayerPosition(Position position){
		currentPosition = position;
	}
	boolean isWinner(){
		return (currentPosition.getXcordinate() == 10) && (currentPosition.getYcordinate() == 10);
	}
}

class SnakeLadderHelpper{
	private Position start;
	private Position end;
	SnakeLadderHelpper(Position start,Position end){
		start = new Position();
		end = new Position();
	}
	Position getStart(){
		return start;
	}
	Position getEnd(){
		return end;
	}
	void setStart(Position position){
		start = position;
	}
	void setEnd(Position position){
		end = position;
	}
}

class Snake{
	private SnakeLadderHelpper snakePosition;
	Snake(Position start,Position end){
		snakePosition = new SnakeLadderHelpper(start,end);
	}
	Position getEnd(){
		return snakePosition.getEnd();
	}
}

class Ladder{
	private SnakeLadderHelpper ladderPosition;
	Ladder(Position start,Position end){
		ladderPosition = new SnakeLadderHelpper(start,end);
	}
	Position getEnd(){
		return ladderPosition.getEnd();
	}
}

class Board{
	private Random rd = new Random();
	private int numOfSnake,numOfLadder;
	private Position[][] box = new Position[11][11];

	Board(){
		numOfSnake = 5;
		numOfLadder = 5;

		//snakes
		box[10][9] = new Position(2,8);
		box[9][1] = new Position(7,7);
		box[8][4] = new Position(7,4);
		box[7][6] = new Position(6,3);
		box[2][2] = new Position(1,8);
		
		//Ladder
		box[2][4] = new Position(10,5);
		box[3][1] = new Position(7,1);
		box[1][4] = new Position(8,7);
		box[5][6] = new Position(7,9);
		box[2][5] = new Position(4,4);

	}
	Position getBoxInfo(Position position){
		Position obj = box[position.getXcordinate()][position.getYcordinate()];
		if(obj == null || (obj.getXcordinate() == position.getXcordinate() && obj.getYcordinate() == position.getYcordinate())){
			return position;
		}
		return obj;
	}
}

class SnakeLadderGame{
	private Board board = new Board();
	void start(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number Of Players : ");
		int numOfPlayers = Integer.parseInt(sc.nextLine());
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < numOfPlayers; i++){
			System.out.print("Enter Name of player" + (i+1) + " : ");
			String playerName = sc.nextLine();
			players.add(new Player(playerName));
		}
		Dice dice = new Dice();
		int i = 0;
		while(true){
			Player player = players.get(i);
			System.out.print("Press 'r' for Roll the Dice for " + player.getName() + " ('e' for exit the game): ");
			String key = sc.nextLine();
			if(!key.equals("r")){
				System.out.println("Press Valid Key :) ");
				continue;
			}else if(key.equals("e")){
				break;
			}
			int diceNumber = dice.rollDice();
			if(player.isValidMove(diceNumber)){
				Position position = player.getPosition();
				position.setXcordinate(position.getXcordinate()+diceNumber);
				if(position.getXcordinate()>10){
					position.setYcordinate(position.getYcordinate()+1);
					position.setXcordinate((position.getXcordinate()%10)+1);
				}
				position = board.getBoxInfo(position);
				player.updatePlayerPosition(position);
				if(player.isWinner()){
					System.out.println(player.getName() + " is Winner.");
					break;
				}
			}else{
				System.out.println("InValid Move or steps exceding the boundary.");
			}
			i = (i+1)%numOfPlayers;
		}
	}
	
}



public class Main{
	public static void main(String[] args){
		SnakeLadderGame game = new SnakeLadderGame();
		game.start();
	}
}