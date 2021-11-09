import java.util.*;
import java.io.*;

public class WordStatLineIndex {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        MyScanner sc;
        Writer writer;

        try {
            sc = new MyScanner(new File(args[0]));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "utf-8"));

            try {
                StringBuilder s = new StringBuilder();
                int numString = 0;
                int numWord = 0;

                while (sc.hasNextLine()) {
                    String string = sc.nextLine();
                    numString++;
                    numWord = 0;
                    //System.err.println(string);

                    for (int i = 0; i < string.length(); i++) {
                        if ((Character.isLetter(string.charAt(i))) || Character.getType(string.charAt(i)) == Character.DASH_PUNCTUATION || string.charAt(i) == '\'') {
                            s.append(string.charAt(i));
                        } else {
                            if (s.length() > 0) {
                                String word = s.toString().toLowerCase();
                                numWord++;

                                if (map.containsKey(word)) {
                                    int count = Integer.parseInt(map.get(word).get(0));
                                    count++;
                                    String stat = new String(Integer.toString(count));
                                    map.get(word).set(0, stat);
                                } else {
                                    ArrayList<String> a = new ArrayList<String>();
                                    a.add("1");
                                    map.put(word, a);
                                }
                                StringBuilder stat = new StringBuilder();
                                stat.append(numString);
                                stat.append(":");
                                stat.append(numWord);
                                map.get(word).add(stat.toString());
                                stat.setLength(0);
                            }

                            s.setLength(0);
                        }
                    }
                    if (s.length() > 0) {
                        String word = s.toString().toLowerCase();
                        numWord++;

                        if (map.containsKey(word)) {
                            int count = Integer.parseInt(map.get(word).get(0));
                            count++;
                            String stat = new String(Integer.toString(count));
                            map.get(word).set(0, stat);
                        } else {
                            ArrayList<String> a = new ArrayList<String>();
                            a.add("1");
                            map.put(word, a);
                        }
                        StringBuilder stat = new StringBuilder();
                        stat.append(numString);
                        stat.append(":");
                        stat.append(numWord);
                        map.get(word).add(stat.toString());
                        stat.setLength(0);
                    }
                    s.setLength(0);
                }
                if (s.length() > 0) {
                    String word = s.toString().toLowerCase();
                    numWord++;

                    if (map.containsKey(word)) {
                        int count = Integer.parseInt(map.get(word).get(0));
                        count++;
                        String stat = new String(Integer.toString(count));
                        map.get(word).set(0, stat);
                    } else {
                        ArrayList<String> a = new ArrayList<String>();
                        a.add("1");
                        map.put(word, a);
                    }
                    StringBuilder stat = new StringBuilder();
                    stat.append(numString);
                    stat.append(":");
                    stat.append(numWord);
                    map.get(word).add(stat.toString());
                    stat.setLength(0);
                    s.setLength(0);
                }

                for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                    String p = new String(entry.getKey());
                    writer.write(p);
                    //System.err.println(p);
                    for (int i = 0; i < map.get(p).size(); i++) {
                        writer.write(" " + map.get(p).get(i));
                        //System.err.println(" " + map.get(p).get(i));
                    }
                    writer.write("\n");
                    //System.err.println("\n");
                }

            } finally {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
