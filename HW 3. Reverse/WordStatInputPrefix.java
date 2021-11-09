import java.util.*;
import java.io.*;

public class WordStatInputPrefix {
	public static void main(String[] args) {
		Map <String, Integer> map = new LinkedHashMap <> ();
		MyScanner sc;
		Writer writer;

		try {			
			sc = new MyScanner(new File(args[0]));	
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8")); 

			try {
				StringBuilder s = new StringBuilder ();
				
				while (sc.hasNextLine()) {
					String string = sc.nextLine();
					//System.err.println(string);
					
					for (int i = 0; i < string.length(); i++) {
						//System.err.print(buf[i]);
						if ((Character.isLetter(string.charAt(i))) || Character.getType(string.charAt(i)) == Character.DASH_PUNCTUATION || string.charAt(i) == '\'') {
							s.append(string.charAt(i));
						}
						
						else  {
							if (s.length() > 2) {
								String prefix = s.toString().substring(0,3).toLowerCase();
								
								if (map.containsKey(prefix)) {
									int count = map.get(prefix);
									count ++;
									map.put(prefix, count);
								}
								
								else {
									map.put(prefix, 1);
								}
							}
							s.setLength(0);
						}
					}
					if (s.length() > 2) {
						String prefix = s.toString().substring(0,3).toLowerCase();

						if (map.containsKey(prefix)) {
							int count = map.get (prefix);
							count ++;
							map.put (prefix, count);
						}
						
						else {
							map.put (prefix, 1);
						}
					}
					s.setLength(0);
				}


					

				for (Map.Entry<String,Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + " " + entry.getValue() + "\n");
				}

				/*for (Map.Entry<String,Integer> entry : map.entrySet()) {
				System.err.println(entry.getKey() + " " + entry.getValue() + "\n");
				}*/
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			System.out.println (e.getMessage());
		}
	} 
}