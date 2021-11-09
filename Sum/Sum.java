public class Sum {
	public static void main(String args[]) {
			int a;
			int sum;
			sum = 0;
			String s = "";
			int i = 0;
			while (i < args.length) {
				args[i] = args[i].trim();
				if (args[i].isEmpty() == false) {
					int len1 = args[i].length();
					if (len1 > 1) {
						int j = 0;
						char c = args[i].charAt(0);
						while (j < len1) {
							if (Character.isWhitespace(c) == false) {
								s += c;
							}
							else if (s != "") {
								a = Integer.parseInt(s);
								s = "";
								sum += a;
							}
							if ((j == len1-1) & (s != "")) {
								a = Integer.parseInt(s);
								s = "";
								sum += a;
							}
							j += 1;
							if (j < len1) {
								c = args[i].charAt(j);
							}
						}
					}
					else {
						if (args[i] != " ") {
							a = Integer.parseInt(args[i]);
							sum = sum + a;
						}
					}
					i += 1;
				}
				else {
					i += 1;
				}
			}
			System.out.println(sum);
		}
}