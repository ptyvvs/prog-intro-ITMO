import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyScanner {

	BufferedReader reader;

	public MyScanner(InputStream input) {
		reader = new BufferedReader (new InputStreamReader (input, StandardCharsets.UTF_8));
	}

	public MyScanner (File input) {
		try {
			reader = new BufferedReader(new FileReader (input));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public MyScanner (String s) {
		reader = new BufferedReader(new StringReader (s));
	}

	public String nextLine () {
		try {
			return (reader.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean hasNextLine () {
		try {
			reader.mark(1);
			int ch = reader.read();
			reader.reset();
			if (ch == -1) {
				return false;
			} else {
				return true;
			}
		} catch (IOException e) {
			System.out.println (e.getMessage());
			return false;
		}
	}

	public int nextInt () {
		try {
			int ch = reader.read();
			StringBuilder s = new StringBuilder();
			while (ch != -1) {
				if ((char)ch == '-' || (char)ch == '+' || Character.isDigit((char)ch)) {
					s.append((char)ch);
				} else {
					int num = Integer.parseInt(s.toString());
					//System.err.println("Nextint: " + num);
					skipWhitespaces();
					return num;
				}
				ch = reader.read();
			}
				int num = Integer.parseInt(s.toString());
				//System.err.println("Nextint: " + num);
				skipWhitespaces();
				return num;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public boolean hasNextInt () {
		try {
			reader.mark(1000);
			int ch = reader.read();
			StringBuilder s = new StringBuilder ();
			while (ch != -1) {
				if ((char)ch == '-' || (char)ch == '+' || Character.isDigit((char)ch)) {
					s.append((char)ch);
				}
				else {
					int num = Integer.parseInt(s.toString());
					reader.reset();
					return true;
				}
				ch = reader.read();
			}
			int num = Integer.parseInt(s.toString());
			reader.reset();
			return true;
		} catch (NumberFormatException e) {
			try {
				reader.reset();
				
			} catch (IOException e1) {
			System.out.println (e1.getMessage());
		}
			return false;
		} catch (IOException e) {
			System.out.println (e.getMessage());
			return false;
		}
	}

	public void skipWhitespaces () {
		try {
			reader.mark(1);
			int ch = reader.read();
			while (ch != -1 && Character.isWhitespace((char)ch)) {
				reader.mark(1);
				ch = reader.read();
			}
			reader.reset();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean hasNext () {
		try {
			reader.mark(1000);
			int ch = reader.read();
			StringBuilder s = new StringBuilder ();
			while (ch != -1) {
				if (!Character.isWhitespace((char) ch)) {
					s.append((char)ch);
				}
				else {
					reader.reset();
					if (s.length() != 0) {
						return true;
					}
					else {
						return false;
					}
				}
				ch = reader.read();
			}
			reader.reset();
					if (s.length() != 0) {
						return true;
					}
					else {
						return false;
					}
		} catch (IOException e) {
			System.out.println (e.getMessage());
			return false;
		}
	}

	public String next () {
		try {
			int ch = reader.read();
			StringBuilder s = new StringBuilder();
			while (ch != -1) {
				if (!Character.isWhitespace((char) ch)) {
					s.append((char)ch);
				}
				else {
					//System.err.println("Nextint: " + num);
					skipWhitespaces();
					return s.toString();
				}
				ch = reader.read();
			}
				//System.err.println("Nextint: " + num);
				skipWhitespaces();
				return s.toString();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


}