
public class Player {
	Coordinate human;
	char name;
	int Energy;
	Stack bag;
	
	public Player(int x , int y,char name,int energy,int number){
		this.name=name;
		Coordinate human=new Coordinate(x,y);
		this.Energy=energy;
		Stack bag= new Stack(number);
	}

	public Coordinate getHuman() {
		return human;
	}

	public void setHuman(Coordinate human) {
		this.human = human;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getEnergy() {
		return Energy;
	}

	public void setEnergy(int energy) {
		Energy = energy;
	}

	public Stack getBag() {
		return bag;
	}

	public void setBag(Stack bag) {
		this.bag = bag;
	}
}
