public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){

		//your code here
        int n = values.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (values[i] < values[i + 1]) {  // Compare in reverse order
                    char temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
