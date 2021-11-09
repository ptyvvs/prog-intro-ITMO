public class Reverse {

	public static void main (String[] args) {

		MyScanner sc = new MyScanner (System.in);
		String[] originStr = new String[1000000];
		int i = 0;
		int count = 0;

		while (sc.hasNextLine()) {   // Считываем по строке входные данные в массив строк
			originStr[i] = sc.nextLine();
			i++;          
			count++;
		}

		int[][] matrix = new int[count][];

		int[] strings = new int[1000000];

		int j;
			
		for (i = 0; i < count; i++) {
			sc = new MyScanner(originStr[i]);
			j = 0;
			int countDigit = 0;
			while (sc.hasNextInt()) {
				strings[j] = sc.nextInt();
				countDigit++;
				j++;
			}		
			matrix[i] = new int[countDigit];
			System.arraycopy(strings, 0, matrix[i], 0, countDigit);
		}

		/*for (i = 0; i < count; i++) {
			for (j = 0; j < matrix[i].length; j++) {
				System.err.print(matrix[i][j] + " ");
			}
			System.err.println();
		}*/

		for (i = count - 1; i >= 0; i--) {
			for (j = matrix[i].length - 1; j >= 0; j--) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		/*for (i = count - 1; i >= 0; i--) {
			for (j = matrix[i].length - 1; j >= 0; j--) {
				System.err.print(matrix[i][j] + " ");
			}
			System.err.println();
		}*/


	}
}