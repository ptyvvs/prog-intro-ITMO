import java.util.*;
import java.io.*;

public class WordStatInputPrefix {
	public static void main(String[] args) {
		Map <String, Integer> map = new LinkedHashMap<>();
		Reader reader;
		Writer writer;

		try {			
			reader = new InputStreamReader (new FileInputStream (args[0]), "utf-8");	
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8")); 

			try {
				StringBuilder s = new StringBuilder ();
				
				while (true) {
					char[] buf = new char [1000];
					int read = reader.read(buf);

					if (read < 0) {
						break;
					}
					
					for (int i = 0; i < read; i++) {
						//System.err.print(buf[i]);
						if ((Character.isLetter(buf[i])) || Character.getType(buf[i]) == Character.DASH_PUNCTUATION || buf[i] == '\'') {
							s.append(buf[i]);
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

				for (Map.Entry<String,Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + " " + entry.getValue() + "\n");
				}

				/*for (Map.Entry<String,Integer> entry : map.entrySet()) {
				System.err.println(entry.getKey() + " " + entry.getValue() + "\n");
				}*/
			} finally {
				reader.close();
				writer.close();
			}
		} catch (IOException e) {
			System.out.println (e.getMessage());
		}
	} 
}