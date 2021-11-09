import java.util.*;
import java.io.*;

public class WordStatLineIndex {
	public static void main(String[] args) {
		Map <String, Integer> map = new LinkedHashMap <> ();
		Map <String, Integer> indexWord = new LinkedHashMap <> ();
		MyScanner sc;
		Writer writer;
		ArrayList<StringBuilder> index = new ArrayList();

		try {			
			sc = new MyScanner(new File(args[0]));	
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8")); 

			try {
				StringBuilder s = new StringBuilder ();
				int numString = 0;
				
				while (sc.hasNextLine()) {
					String string = sc.nextLine();
					numString++;
					int numWord = 0;
					int wordCounter = 0;
					//System.err.println(string);
					
					for (int i = 0; i < string.length(); i++) {
						//System.err.print(buf[i]);
						if ((Character.isLetter(string.charAt(i))) || Character.getType(string.charAt(i)) == Character.DASH_PUNCTUATION || string.charAt(i) == '\'') {
							s.append(string.charAt(i));
						}
						
						else  {
							if (s.length() > 2) {
								String word = s.toString().toLowerCase();
								numWord++;
								
								if (map.containsKey(word)) {
									int count = map.get(word);
									count ++;
									map.put(word, count);
								}
								
								else {
									map.put(word, 1);
									indexWord.put(word, wordCounter);
									wordCounter++;
								}
								int j = indexWord.get(word);
								index.get(j).append(numString);
								index.get(j).append(":");
								index.get(j).append(numWord);
							}
							s.setLength(0);
						}
					} 
					if (s.length() > 2) {
						String word = s.toString().toLowerCase();
						numWord++;
								
						if (map.containsKey(word)) {
							int count = map.get(word);
							count ++;
							map.put(word, count);
						}
								
						else {
							map.put(word, 1);
							indexWord.put(word, wordCounter);
							wordCounter++;
						}
						int j = indexWord.get(word);
						index.get(j).append(numString);
						index.get(j).append(":");
						index.get(j).append(numWord);
					}
					s.setLength(0);
				}

					

			/*for (Map.Entry <String,ArrayList<String>> entry : map.entrySet()) {
				writer.write(entry.getKey());
				for (int i = 0; i < entry.get(entry.getKey()).size(); i++) {
					writer.write(" " + entry.get(entry.getKey()).get(i));
				}
				writer.write('\n');
			}*/

				/*for (Map.Entry<String,Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + " " + entry.getValue() + "\n");
				}*/
				int i = 0;
				for (Map.Entry<String,Integer> entry : map.entrySet()) {
				System.err.println(entry.getKey() + " " + entry.getValue() + index.get(i) +"\n");
				i++;
				}

				/*for (Map.Entry<String,Integer> entry : map.entrySet()) {
					writer.write(entry.getKey());
					for (int i = 0; i < entry.getValue().length; i++) {
						writer.write(" " + entry.getValue().get(i));
					}
					writer.write("\n");
				}*/


			} finally {
				writer.close();
			}
		} catch (IOException e) {
			System.out.println (e.getMessage());
		}
	} 
}