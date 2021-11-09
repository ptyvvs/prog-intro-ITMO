import java.util.Scanner;

public class ReverseMax {
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

		int maxCountString = 0; //Максимальное количество чиселок в строке
		int[] strings = new int[10000000];
			
		for (i = 0; i < count; i++) {
			sc = new MyScanner(originStr[i]);
			int j = 0;
			int countDigit = 0;
			while (sc.hasNextInt()) {
				strings[j] = sc.nextInt();
				countDigit += 1;
				j++;
			}
			if (maxCountString < countDigit) {
				maxCountString = countDigit;
			}			
			matrix[i] = new int[countDigit];
			System.arraycopy(strings, 0, matrix[i], 0, countDigit);
		}

		int[] maxString = new int[count]; 
		for (i = 0; i < count; i++) {  // Заполняем массив максимумов по строкам
			maxString[i] = Integer.MIN_VALUE;

			for (int j = 0; j < matrix[i].length; j++) {
				
				if (matrix[i][j] > maxString[i]) {
					maxString[i] = matrix[i][j];
				}

			}
		}

		int[] maxColum = new int[maxCountString];

		for (i = 0; i < maxCountString; i++) {
			maxColum[i] = Integer.MIN_VALUE;
		}

		
		if (count > 0) {
			for (i = 0; i < count; i++) {  // Заполняем массив максимумов по столбцам
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] > maxColum[j]) {
						maxColum[j] = matrix[i][j];
					}
				}
			}
		}
		

		for (i = 0; i < count; i++) {
			for (int j = 0; j < matrix[i].length; j++) {  // Меняем матрицу чиселок на матрицу максимумов
				matrix[i][j] = Math.max(maxString[i], maxColum[j]);			
			}
		}

		for (i = 0; i < count; i++) {
			for (int j = 0;j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}