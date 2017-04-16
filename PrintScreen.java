//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.stream.IntStream;
//import enigma.core.Enigma;
//import enigma.event.TextMouseEvent;
//import enigma.event.TextMouseListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import enigma.console.TextAttributes;
//import java.awt.Color;
//import java.util.Scanner;
//
//
//public class PrintScreen {
//	
//	public void loading(char[][] a) throws IOException{
//		File t = new File("maze.txt");
//		FileReader f = new FileReader(t);
//		BufferedReader b = new BufferedReader(f);
//
//		char sharps;//LOADING # TO SCREEN
//
//		for (int i = 0; i < 21; i++) {
//			for (int j = 0; j < 69; j++) {
//				sharps=(char)b.read();
//				a[i][j]=sharps;
//			}
//		}
//	}
//
//	public void printingScreen(char[][] screen){
//		for(int k = 0 ; k < 21 ; k++){
//			for(int l = 0 ; l < 69; l++){		
//				System.out.print(screen[k][l]);	
//			}
//		}
//
//	}
//}
