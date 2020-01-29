
public class board {
	int[][] arr;
	public board(int[][] arr) {
		this.arr=arr;
	}
	public int[][] getArr() {
		return arr;
	}
	public void setArr(int[][] arr) {
		this.arr = arr;
	}
	//print array method 
	public void printArray(int [][] arr) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(arr[i][j]==0) {
					System.out.print("     *");
				}
				else {
					System.out.printf("%6d",arr[i][j]);
				}
			}
			System.out.println("");
		}
	}
	public void printArray1(int [][] arr) {
		System.out.println("");
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(arr[i][j]==0) {
					System.out.print("     *");
				}
				else {
					System.out.printf("%6d",arr[i][j]);
				}
			}
			System.out.println("");
		}
	}
	//method that randomizes number 2 or 4 on board 
	public void FirstSetting(int[][] arr) {
		int a=(int)(Math.random()*4);
		int b=(int)(Math.random()*4);
		double p=Math.random();
		if(arr[a][b]==0) {
			if(p<=0.2) {
				arr[a][b]=4;
			}
			else {
				arr[a][b]=2;
			}
		}
		else {
			FirstSetting(arr);
		}
		
	}
	//print the max number on the board 
	public void printMax(int [][] arr) {
		int max=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(arr[i][j]>max) {
					max=arr[i][j];
				}
			}
		}
		System.out.println("The maximum number on the board is "+max);
	} 
	//return true if you still can move otherwise return false
	public boolean checkEnd(int[][] arr) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(arr[i][j]==0) {
					return true;		
				}
				else if(i==0&&j==3||i==1&&j==3||i==2&&j==3) {
					if(arr[i][j]==arr[i+1][j]) {
						return true;
					}
				}
				else if(i==3&&j==3||i==3&&j==2||i==3&&j==1) {
					if(arr[i][j]==arr[i][j-1]) {
						return true;
					}
				}
				else {
					for(int k=0;k<=2;k++) {
						for(int l=0;l<=2;l++) {
							if(arr[k][l]==arr[k+1][l]||arr[k][l]==arr[k][l+1]) {
								return true;
							}
						}
					}
					
				}
			}
		}
		return false;
	}
	

}
