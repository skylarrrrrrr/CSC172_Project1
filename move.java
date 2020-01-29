
public class move {
	int[][] arr;
	String dir;
	int x=0;

	public move(int[][] arr,String dir) {
		// TODO Auto-generated constructor stub
		this.arr=arr;
		this.dir=dir;
	}

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	//check whether it can move or not 
	public boolean CheckValidMove(int[][] arr, String dir) {
		if(dir.equals("w")) {
			for(int j=0;j<4;j++) {
				for(int i=1;i<=3;i++) {
					if(arr[i][j]!=0&&arr[i-1][j]==0) {
						return true;
					}
					if(arr[i][j]!=0&&arr[i][j]==arr[i-1][j]) {
						return true;
					}
				}
			}	 
		}
		else if(dir.equals("s")) {
			for(int j=0;j<4;j++) {
				for(int i=3;i>=1;i--) {
					if(arr[i][j]==0&&arr[i-1][j]!=0) {
						return true;
					}
					if(arr[i][j]!=0&&arr[i][j]==arr[i-1][j]) {
						return true;
					}
				}
			}	 
		}
		else if(dir.equals("a")) {
			for(int i=0;i<4;i++) {
				for(int j=3;j>=1;j--) {
					if(arr[i][j]!=0&&arr[i][j-1]==0) {
						return true;
					}
					if(arr[i][j]!=0&&arr[i][j]==arr[i][j-1]) {
						return true;
					}
				}
			}	 
		}
		else if(dir.equals("d")) {
			for(int i=0;i<4;i++) {
				for(int j=3;j>=1;j--) {
					if(arr[i][j]==0&&arr[i][j-1]!=0) {
						return true;
					}
					if(arr[i][j]!=0&&arr[i][j]==arr[i][j-1]) {
						return true;
					}
				}
			}	 
		}
		
			return false;
	}
	//actualMove contains merge and move two operations 
	public void actualMove(boolean ValidMove, String dir,int[][] arr) {
		if(ValidMove) {
			if(dir.equals("w")) {
				for(int a=0;a<=3;a++) {
					for(int j=0;j<4;j++) {
						for(int i=0;i<3;i++) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i+1][j];
								arr[i+1][j]=0;
							}
						}
					}
				}
				for(int j=0;j<4;j++) {
					for(int i=0;i<3;i++) {
						if(arr[i][j]==arr[i+1][j]) {
							arr[i][j]=arr[i][j]+arr[i+1][j];
							arr[i+1][j]=0;
						}
					}
				}
				for(int a=0;a<=3;a++) {
					for(int j=0;j<4;j++) {
						for(int i=0;i<3;i++) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i+1][j];
								arr[i+1][j]=0;
							}
						}
					}
				}
			}
			else if(dir.equals("s")) {
				//changing the position between 0 and the number
				for(int a=0;a<=2;a++) {
					for(int j=0;j<4;j++) {
						for(int i=3;i>=1;i--) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i-1][j];
								arr[i-1][j]=0;
							}
						}
					}
				}
				//adding the same number together 
				for(int j=0;j<4;j++) {
					for(int i=3;i>=1;i--) {
						if(arr[i][j]==arr[i-1][j]) {
							arr[i][j]=arr[i][j]+arr[i-1][j];
							arr[i-1][j]=0;
						}
					}
				}
				//changing the position between 0 and the number 
				for(int a=0;a<=2;a++) {
					for(int j=0;j<4;j++) {
						for(int i=3;i>=1;i--) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i-1][j];
								arr[i-1][j]=0;
							}
						}
					}
				}
				
			}
			else if(dir.equals("a")) {
				//changing the position between 0 and the number
				for(int a=0;a<=2;a++) {
					for(int i=0;i<4;i++) {
						for(int j=0;j<=2;j++) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i][j+1];
								arr[i][j+1]=0;
							}
						}
					}
				}
				//adding the same number together 
				for(int i=0;i<4;i++) {
					for(int j=0;j<3;j++) {
						if(arr[i][j]==arr[i][j+1]) {
							arr[i][j]=arr[i][j]+arr[i][j+1];
							arr[i][j+1]=0;
						}
					}
				}
				//changing the position between 0 and the number 
				for(int a=0;a<=2;a++) {
					for(int i=0;i<4;i++) {
						for(int j=0;j<=2;j++) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i][j+1];
								arr[i][j+1]=0;
							}
						}
					}
				}
				
			}
			else if(dir.equals("d")) {
				//changing the position between 0 and the number
				for(int a=0;a<=2;a++) {
					for(int i=0;i<4;i++) {
						for(int j=3;j>0;j--) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i][j-1];
								arr[i][j-1]=0;
							}
						}
					}
				}
				//adding the same number together 
				for(int i=0;i<4;i++) {
					for(int j=3;j>=1;j--) {
						if(arr[i][j]==arr[i][j-1]) {
							arr[i][j]=arr[i][j]+arr[i][j-1];
							arr[i][j-1]=0;
						}
					}
				}
				//changing the position between 0 and the number 
				for(int a=0;a<=2;a++) {
					for(int i=0;i<4;i++) {
						for(int j=3;j>0;j--) {
							if(arr[i][j]==0) {
								arr[i][j]=arr[i][j-1];
								arr[i][j-1]=0;
							}
						}
					}
				}
		  }
		}
		else {
			System.out.println("This is not a valid move.\nPlease enter another direction. ");
		}
	}

}
