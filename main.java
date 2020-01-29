import java.util.Scanner;

public class main {

	public static void Main(int[][] arr) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int x=0;
		boolean y=true;
		board b=new board(arr);
			System.out.println("Are you ready to start the game?[Y/N]");
			String ans=s.next();
			if(ans.equals("Y")) {
				System.out.println("Print 'q' if you want to quit the game and 'r' for restarting the game.");
				for(int i=0;i<2;i++) {
					b.FirstSetting(arr);
				}
				b.printArray(arr);
				while(y) {
					System.out.println("Please enter the direction: ");
					String dir=s.next();
							if(dir.equals("q")) {
								System.out.println("Do you want to quit the game?[Y/N]");
								String quit=s.next();
								if(quit.equals("Y")) {
									System.out.println("You quit the game. See you next time!");
									break;
								}
							}
							else if(dir.equals("r")) {
								System.out.println("Do you want to restart the game?[Y/N]");
								String restart=s.next();
								if(restart.equals("Y")) {
									int[][] arr1= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
									Main(arr1);
								}
								else {
									continue;
								}
							}
							else if(dir.equals("w")||dir.equals("a")||dir.equals("s")||dir.equals("d")){
								move m=new move(arr,dir);
								boolean vm=m.CheckValidMove(arr,dir);
								if(vm) {
									x++;
									m.actualMove(vm,dir,arr);
									b.FirstSetting(arr);
									b.printMax(arr);
									System.out.println("Your total move is "+x);
									if(!b.checkEnd(arr)) {
										System.out.println("Game over!");
										y=false;
										break;
									}
									b.printArray1(arr);
								}
								else {
									m.actualMove(vm,dir,arr);
									b.printArray1(arr);
								}
							}
							else {
								System.out.println("This key is not valid.");
								y=true;
							}
						}
				}
			else {
				System.out.println("You quited the game.");
			}
		}
	public static void main (String args[]) {
		int [][] array= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		main.Main(array);
	}
	}
