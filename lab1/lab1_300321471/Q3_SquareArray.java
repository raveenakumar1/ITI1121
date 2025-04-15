public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int[] newArr = new int[size];
		for(int i=0;i<size;i++){
			newArr[i] = i*i;
		}
		return newArr;
		// Your code here
	}

	public static void main(String[] args){
		// Your code here
		int[] myArr = createArray(13);
		for(int i=0;i<myArr.length;i++){
			System.out.println("The square of " +i+ " is: " + myArr[i]);
		}
	}

}