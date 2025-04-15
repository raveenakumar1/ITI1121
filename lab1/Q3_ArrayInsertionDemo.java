public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		// Your code here
		int afterArray[] = new int[beforeArray.length+1];
		afterArray[indexToInsert] = valueToInsert;
		for(int i =0;i<indexToInsert;i++){
			afterArray[i] = beforeArray[i];
		}
		for(int i = indexToInsert + 1;i<afterArray.length;i++){
			afterArray[i] = beforeArray[i-1];
		}
		return afterArray;
		
		
	}

	public static void main(String[] args){
		// Your code here
		int[] beforeArray = new int[]{1,5,3,5,7};
		int indexToInsert = 2;
		int valueToInsert = 16;
		System.out.println("Array before insertion: ");
		for(int i = 0; i<beforeArray.length;i++){
			System.out.println(beforeArray[i]);
		}
		int[] afterArray = insertIntoArray(beforeArray,indexToInsert,valueToInsert);
		System.out.println("Array after insertion of " + valueToInsert + " at position " + indexToInsert + ":");
		for(int i = 0;i<afterArray.length;i++){
			System.out.println(afterArray[i]);
		}
		
	}
}