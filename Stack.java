
public class Stack {
	private int top;
	private Object[] elements;

	Stack(int capacity) {
		elements = new Object[capacity];
		top = -1;
	}

	public void push(Object data) {
		if (isFull()) {
			System.out.println("Stack overflow");
		} else {
			top++;
			elements[top] = data;
		}
	}

	public Object pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			Object retData = elements[top];
			top--;
			return retData;
		}
	}

	public Object peek() {
		if (isEmpty()) {
			System.err.println("Stack is empty");
			return null;
		} else {
			return elements[top];
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top + 1 == elements.length);
	}

	public int size() {
		return top + 1;
	}

	//QUESTION 3 ÝÇÝN*******************************
	public void getIntersection(Stack s){

		Stack tempS = new Stack(20);

		while(!this.isEmpty())
		{
			int number =(int) this.pop();

			while(!s.isEmpty()){
				if(number ==(int) s.peek())
				{
					System.out.println(number+ " ");
					s.pop();
				}
				else
				{
					tempS.push(s.pop());
				}
			}
			while(!tempS.isEmpty())
			{
				s.push(tempS.pop());
			}
		}
	}

	public void getDifference(Stack s){

		Stack tempS = new Stack(20);
		int number =(int) this.pop();
		boolean catched = false;

		while(!s.isEmpty()){

			if(number ==(int) s.peek())
			{
				catched = true;
				s.pop();
				break;
			}
			else
			{
				tempS.push(s.pop());
			}
		}
		if(!catched){
			System.out.println(number+ " ");
		}
		while(!tempS.isEmpty())
		{
			s.push(tempS.pop());
		}
	}
	
	public void getUnion(Stack s){

		Stack tempThis = new Stack(20);

		while(!this.isEmpty()){
			System.out.println((int) this.peek());
			tempThis.push(this.pop());
		}
		while(!tempThis.isEmpty()){
			this.push(tempThis.pop());
		}
		s.getDifference(this);
	}
	
}


