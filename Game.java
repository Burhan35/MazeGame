import enigma.core.Enigma;

import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;

public class Game  {
	public enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	public TextMouseListener tmlis; 
	public KeyListener klis; 
	public char[][] sc=new char[21][69];
	public int cord_x_h;
	public int cord_y_h;
	public int cord_x_c;
	public int cord_y_c;
	public CircularQueue input_queue = new CircularQueue(10);
	//	public Stack back_pack = new Stack(5);
	//	public Stack tempS = new Stack(5);
	public int numberOrStar;
	int number_random;
	public static int count_input = 0;
	public static int total_number = 20;
	TextAttributes other11 = new TextAttributes(Color.BLUE,Color.GREEN);		
	TextAttributes color1 = new TextAttributes(Color.RED,Color.WHITE);		


	// ------ Standard variables for mouse and keyboard ------
	public int mousepr;          // mouse pressed?
	public int mousex, mousey;   // mouse text coords.
	public int keypr;   // key pressed?
	public int rkey;    // key   (for press/release)

	// ----------------------------------------------------


	Game() throws Exception {	

		klis=new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(keypr==0) {
					keypr=1;
					rkey=e.getKeyCode();
				}
			}
			public void keyReleased(KeyEvent e) {}
		};
		cn.getTextWindow().addKeyListener(klis);
		// ----------------------------------------------------
		TextAttributes hashtagColor = new TextAttributes(Color.WHITE,Color.BLACK);
		TextAttributes others = new TextAttributes(Color.BLACK,Color.WHITE);	

		Screen ps = new Screen();
		ps.loading(sc);
		//loading_C_H(sc);
		loading_Stars_Num(sc);

		load_input(input_queue);

		cord_x_c =(int) (Math.random()*18+1);
		cord_y_c =(int) (Math.random()*52+1);		
		cord_x_h =(int) (Math.random()*18+1);
		cord_y_h =(int) (Math.random()*52+1);		

		Coordinate c = new Coordinate(cord_x_c, cord_y_c);
		Player Computer = new Player(c.getX(),c.getY(),'C',100,0);
		Coordinate h = new Coordinate(cord_x_h,cord_y_h);
		Player Human = new Player (h.getX(),h.getY(),'H',100,5);
		Stack back_bag = new Stack(5);
		Stack tempS = new Stack(5);

		sc[h.getX()][h.getY()] = 'H';
		sc[c.getX()][c.getY()] = 'C';

		while(true) {

			if (count_input < 10) {
				load_input(input_queue);
			}

			int px=h.getX(),py=h.getY();
			cn.getTextWindow().setCursorPosition(0, 0);
			for(int k = 0 ; k < 21 ; k++){
				for(int l = 0 ; l < 69; l++){	
					if(sc[k][l] == '#' || sc[k][l] == '<'){
						cn.setTextAttributes(hashtagColor);
						System.out.print(sc[k][l]);	
					}
					else {
						cn.setTextAttributes(others);
						System.out.print(sc[k][l]);	

					}
				}

			}
			//ps.printingScreen(sc);


			cn.getTextWindow().setCursorPosition(60, 18);
			System.out.println(Human.getEnergy());

			cn.getTextWindow().setCursorPosition(57, 3);
			printQueue(input_queue);


			print_backbag(back_bag, tempS);

			if(keypr==1) { 


				if(!back_bag.isEmpty() && rkey==KeyEvent.VK_J){
					if(sc[px][py-1] == ' '){
						sc[px][py-1] = (char) back_bag.pop();
					}
				}

				if(!back_bag.isFull() && rkey==KeyEvent.VK_A){
					if(sc[px][py-1] == '1'){
						back_bag.push('1');
						sc[px][py-1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py-1] == '2'){
						back_bag.push('2');
						sc[px][py-1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py-1] == '3'){
						back_bag.push('3');
						sc[px][py-1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py-1] == '4'){
						back_bag.push('4');
						sc[px][py-1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py-1] == '*'){
						back_bag.push('*');
						sc[px][py-1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
				}
				if(rkey==KeyEvent.VK_LEFT){
					if (Human.getEnergy() > 0 && sc[px][py-1]!='#') {
						Human.setEnergy(Human.getEnergy()-1);
					}
					if (sc[px][py-1]==' ') {						
						sc[px][py]=' ';
						sc[px][py-1]='H';
						h.setY(py-1);
					}
					else if(sc[px][py-1]=='1' && sc[px][py-2]==' ' ){
						sc[px][py]=' ';
						sc[px][py-1]='H';
						sc[px][py-2]='1';
						h.setY(py-1);
					}
					else if(sc[px][py-1]=='2' && sc[px][py-2]==' ' ){
						sc[px][py]=' ';
						sc[px][py-1]='H';
						sc[px][py-2]='2';
						h.setY(py-1);
					}
					else if(sc[px][py-1]=='3' && sc[px][py-2]==' ' ){
						sc[px][py]=' ';
						sc[px][py-1]='H';
						sc[px][py-2]='3';
						h.setY(py-1);
					}
					else if(sc[px][py-1]=='4' && sc[px][py-2]==' ' ){
						sc[px][py]=' ';
						sc[px][py-1]='H';
						sc[px][py-2]='4';
						h.setY(py-1);
					}
					else if(sc[px][py-1] == '*'){
						sc[px][py]=' ';
						sc[px][py-1]='H';
						Human.setEnergy(Human.getEnergy()+25);					
						h.setY(py-1);
						total_number--;
					}
				}

				if(!back_bag.isEmpty() && rkey==KeyEvent.VK_L){
					if(sc[px][py+1] == ' '){
						sc[px][py+1] = (char) back_bag.pop();
					}
				}
				if(!back_bag.isFull() && rkey==KeyEvent.VK_D){
					if(sc[px][py+1] == '1'){
						back_bag.push('1');
						sc[px][py+1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py+1] == '2'){
						back_bag.push('2');
						sc[px][py+1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py+1] == '3'){
						back_bag.push('3');
						sc[px][py+1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py+1] == '4'){
						back_bag.push('4');
						sc[px][py+1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px][py+1] == '*'){
						back_bag.push('*');
						sc[px][py+1] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
				}
				if(rkey==KeyEvent.VK_RIGHT){
					if (Human.getEnergy() > 0 && sc[px][py+1]!='#') {
						Human.setEnergy(Human.getEnergy()-1);
					}
					if (sc[px][py+1]==' ') {
						sc[px][py]=' ';
						sc[px][py+1]='H';
						h.setY(py+1);
					}
					else if(sc[px][py+1]=='1' && sc[px][py+2]==' ' ){
						sc[px][py]=' ';
						sc[px][py+1]='H';
						sc[px][py+2]='1';
						h.setY(py+1);
					}
					else if(sc[px][py+1]=='2' && sc[px][py+2]==' ' ){
						sc[px][py]=' ';
						sc[px][py+1]='H';
						sc[px][py+2]='2';
						h.setY(py+1);
					}
					else if(sc[px][py+1]=='3' && sc[px][py+2]==' ' ){
						sc[px][py]=' ';
						sc[px][py+1]='H';
						sc[px][py+2]='3';
						h.setY(py+1);
					}
					else if(sc[px][py+1]=='4' && sc[px][py+2]==' ' ){
						sc[px][py]=' ';
						sc[px][py+1]='H';
						sc[px][py+2]='4';
						h.setY(py+1);
					}
					else if(sc[px][py+1] == '*'){
						sc[px][py]=' ';
						sc[px][py+1]='H';
						Human.setEnergy(Human.getEnergy()+25);					
						h.setY(py+1);
						total_number--;
					}
				}

				if(!back_bag.isEmpty() && rkey==KeyEvent.VK_I){
					if(sc[px-1][py] == ' '){
						sc[px-1][py] = (char) back_bag.pop();
					}
				}				
				if(!back_bag.isFull() && rkey==KeyEvent.VK_W){
					if(sc[px-1][py] == '1'){
						back_bag.push('1');
						sc[px-1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px-1][py] == '2'){
						back_bag.push('2');
						sc[px-1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px-1][py] == '3'){
						back_bag.push('3');
						sc[px-1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px-1][py] == '4'){
						back_bag.push('4');
						sc[px-1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px-1][py] == '*'){
						back_bag.push('*');
						sc[px-1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
				}
				if(rkey==KeyEvent.VK_UP)
				{
					if (Human.getEnergy() > 0 && sc[px-1][py]!='#') {
						Human.setEnergy(Human.getEnergy()-1);
					}

					if (sc[px-1][py]==' ') {
						sc[px][py]=' ';
						sc[px-1][py]='H';
						h.setX(px-1);
					}
					else if(sc[px-1][py]=='1' && sc[px-2][py]==' ' ){
						sc[px][py]=' ';
						sc[px-1][py]='H';
						sc[px-2][py]='1';
						h.setX(px-1);
					}
					else if(sc[px-1][py]=='2' && sc[px-2][py]==' ' ){
						sc[px][py]=' ';
						sc[px-1][py]='H';
						sc[px-2][py]='2';
						h.setX(px-1);
					}
					else if(sc[px-1][py]=='3' && sc[px-2][py]==' ' ){
						sc[px][py]=' ';
						sc[px-1][py]='H';
						sc[px-2][py]='3';
						h.setX(px-1);
					}
					else if(sc[px-1][py]=='4' && sc[px-2][py]==' ' ){
						sc[px][py]=' ';
						sc[px-1][py]='H';
						sc[px-2][py]='4';
						h.setX(px-1);
					}
					else if(sc[px-1][py] == '*'){
						sc[px][py]=' ';
						sc[px-1][py]='H';
						Human.setEnergy(Human.getEnergy()+25);					
						h.setX(px-1);
						total_number--;
					}
				}

				if(!back_bag.isEmpty() && rkey==KeyEvent.VK_K){
					if(sc[px+1][py] == ' '){
						sc[px+1][py] = (char) back_bag.pop();
					}
				}			
				if(!back_bag.isFull() && rkey==KeyEvent.VK_S){
					if(sc[px+1][py] == '1'){
						back_bag.push('1');
						sc[px+1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px+1][py] == '2'){
						back_bag.push('2');
						sc[px+1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px+1][py] == '3'){
						back_bag.push('3');
						sc[px+1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px+1][py] == '4'){
						back_bag.push('4');
						sc[px+1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
					else if(sc[px+1][py] == '*'){
						back_bag.push('*');
						sc[px+1][py] = ' ';
						if(Human.getEnergy() > 100) Human.setEnergy(Human.getEnergy()-100);
						else if(Human.getEnergy() <= 100) Human.setEnergy(0);
						total_number--;
					}
				}
				if(rkey==KeyEvent.VK_DOWN){
					if (Human.getEnergy() > 0 && sc[px+1][py]!='#') {
						Human.setEnergy(Human.getEnergy()-1);
					}

					if (sc[px+1][py]==' ') {
						sc[px][py]=' ';
						sc[px+1][py]='H';
						h.setX(px+1);
					}
					else if(sc[px+1][py]=='1' && sc[px+2][py]==' ' ){
						sc[px][py]=' ';
						sc[px+1][py]='H';
						sc[px+2][py]='1';
						h.setX(px+1);
					}
					else if(sc[px+1][py]=='2' && sc[px+2][py]==' ' ){
						sc[px][py]=' ';
						sc[px+1][py]='H';
						sc[px+2][py]='2';
						h.setX(px+1);
					}
					else if(sc[px+1][py]=='3' && sc[px+2][py]==' ' ){
						sc[px][py]=' ';
						sc[px+1][py]='H';
						sc[px+2][py]='3';
						h.setX(px+1);
					}
					else if(sc[px+1][py]=='4' && sc[px+2][py]==' ' ){
						sc[px][py]=' ';
						sc[px+1][py]='H';
						sc[px+2][py]='4';
						h.setX(px+1);
					}
					else if(sc[px+1][py] == '*'){//kuyruktan deðer çekme
						sc[px][py]=' ';
						sc[px+1][py]='H';
						Human.setEnergy(Human.getEnergy()+25);					
						h.setX(px+1);
						total_number--;
					}
				}


				char rckey=(char)rkey;
				//        left          right          up            down
				/*if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='('){
					cn.getTextWindow().output(px,py,'p'); // VK kullanmadan test teknigi           
				}
				else
					cn.getTextWindow().output(rckey);*/




				keypr=0;    // last action  
			} // IF KEY PRESSED

			// DOUBLE:100 * TRIPLE:200
			for (int i = -1; i <=1 ; i++) 
			{
				for (int j = -1; j <=1; j++) 
				{
					if((i==0 && sc[px + i][py + j] == '1') || (j==0 && sc[px + i][py + j] == '1')){
						for (int m = -1; m <=1 ; m++) {
							for (int n = -1; n <=1; n++) {
								if (!(m==0 && n==0) && (m==0 && sc[px + i + m][py + j + n] == '1' || n==0 && sc[px + i + m][py + j + n] == '1')) {
									sc[px + i][py + j] = ' ';
									sc[px + i + m][py + j + n] = ' ';
									Human.setEnergy(Human.getEnergy() + 100);
								}
							}
						}
					}
					else if((i==0 && sc[px + i][py + j] == '2') || (j==0 && sc[px + i][py + j] == '2')){
						for (int m = -1; m <=1 ; m++) {
							for (int n = -1; n <=1; n++) {
								if (!(m==0 && n==0) && (m==0 && sc[px + i + m][py + j + n] == '2' || n==0 && sc[px + i + m][py + j + n] == '2')) {
									sc[px + i][py + j] = ' ';
									sc[px + i + m][py + j + n] = ' ';
									Human.setEnergy(Human.getEnergy() + 100);
								}
							}
						}
					}
					else if((i==0 && sc[px + i][py + j] == '3') || (j==0 && sc[px + i][py + j] == '3')){
						for (int m = -1; m <=1 ; m++) {
							for (int n = -1; n <=1; n++) {
								if (!(m==0 && n==0) && (m==0 && sc[px + i + m][py + j + n] == '3' || n==0 && sc[px + i + m][py + j + n] == '3')) {
									sc[px + i][py + j] = ' ';
									sc[px + i + m][py + j + n] = ' ';
									Human.setEnergy(Human.getEnergy() + 100);
								}
							}
						}
					}
					else if((i==0 && sc[px + i][py + j] == '4') || (j==0 && sc[px + i][py + j] == '4')){
						for (int m = -1; m <=1 ; m++) {
							for (int n = -1; n <=1; n++) {
								if (!(m==0 && n==0) && (m==0 && sc[px + i + m][py + j + n] == '4' || n==0 && sc[px + i + m][py + j + n] == '4')) {
									sc[px + i][py + j] = ' ';
									sc[px + i + m][py + j + n] = ' ';
									Human.setEnergy(Human.getEnergy() + 100);
								}
							}
						}
					}


				}
			}



			//			for (int i = 0; i < 21; i++) {
			//				for (int j = 0; j < 55; j++) {
			//					if(sc[i][j] == '1' || sc[i][j] == '2' || sc[i][j] == '3' || sc[i][j] == '4' || sc[i][j] == '*') total_number++;					
			//				}
			//			}
			while (total_number < 20 ) {
				int rnd_x_input = (int)(Math.random()*20);
				int rnd_y_input = (int)(Math.random()*55);						
				if(sc[rnd_x_input][rnd_y_input]==' '){
					sc[rnd_x_input][rnd_y_input]= (char) input_queue.peek();
					input_queue.dequeue();
					total_number++;
					count_input--;					
				}						
			}

			if(Human.getEnergy() == 0){
				Thread.sleep(50);
			}
			else{
				Thread.sleep(25);
			}			

		} //WHILE	
	}


	public void print_backbag(Stack bag, Stack tempS){
		int count_back_bag = 5;
		while(!bag.isEmpty()){			
			tempS.push(bag.pop());
		}
		while(!tempS.isEmpty()){
			cn.getTextWindow().setCursorPosition(59, 8+count_back_bag);
			System.out.print(tempS.peek());
			bag.push(tempS.pop());
			count_back_bag--;
		}		
	}
	//	public void print_backbag(Stack bag, Stack tempS){
	//		int count_back_bag = bag.size()-1;
	//		while(!bag.isEmpty()){			
	//			tempS.push(bag.pop());
	//		}
	//		while(!tempS.isEmpty()){
	//			cn.getTextWindow().setCursorPosition(59, 13-count_back_bag);
	//			System.out.print(tempS.peek());
	//			bag.push(tempS.pop());
	//			count_back_bag++;
	//		}		
	//	}

	public void load_input(CircularQueue q){
		for(int i = count_input; i < 10; i++){
			numberOrStar = (int) (Math.random()*2);

			if (numberOrStar == 0) q.enqueue('*');
			else if(numberOrStar == 1){
				number_random = (int) (Math.random()*4+1);				
				if (number_random == 1) q.enqueue('1');						
				else if (number_random == 2) q.enqueue('2');									
				else if (number_random == 3) q.enqueue('3');									
				else if (number_random == 4) q.enqueue('4');
			}
			count_input++;
		}
	}
	public void printQueue(CircularQueue q){
		for (int i = 0; i < count_input; i++) {
			System.out.print(q.peek());
			q.enqueue(q.dequeue());
		}
	}



	public void loading_Stars_Num(char screen[][]){
		//LOADING * and NUM to SCREEN
		for(int j = 0 ; j < 20 ; j++)
		{
			numberOrStar = (int) (Math.random()*2);
			int rnd_x = (int)(Math.random()*20);
			int rnd_y = (int)(Math.random()*55);
			if (numberOrStar == 0) {
				if(screen[rnd_x][rnd_y]==' ')
					screen[rnd_x][rnd_y]='*';
				else j--;
			}
			else if(numberOrStar == 1){
				number_random = (int) (Math.random()*4+1);				
				if(screen[rnd_x][rnd_y]==' '){
					if (number_random == 1) {
						screen[rnd_x][rnd_y]= '1';
					}
					else if (number_random == 2) {
						screen[rnd_x][rnd_y]= '2';
					}
					else if (number_random == 3) {
						screen[rnd_x][rnd_y]= '3';
					}
					else if (number_random == 4) {
						screen[rnd_x][rnd_y]= '4';
					}
				}
				else j--;
			}
		}
	}

}
