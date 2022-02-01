public class SumLong {
	public static void main(String args[]) {
			long digit, sum;
			sum = 0L;
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				args[i] = args[i].trim();
				if (args[i].isEmpty() == false) {
					int argsLen = args[i].length();
					if (argsLen > 1) {
						for (int j = 0; j < argsLen; j++) {
							char ch = args[i].charAt(j);
							if (Character.isWhitespace(ch) == false) {
								s.append(ch);
							}
							else if (s.length() != 0) {
								digit = Long.parseLong(s.toString());
								s.delete(0, s.length());
								sum += digit;
							}
							if ((j == argsLen - 1) & (s.length() != 0)) {
								digit = Long.parseLong(s.toString());
								s.delete(0, s.length());
								sum += digit;
							}
						}
					}
					else {
						if (args[i].isBlank() == false) {
							digit = Long.parseLong(args[i]);
							sum += digit;
						}
					}
				}
			}
			System.out.println(sum);
		}
}