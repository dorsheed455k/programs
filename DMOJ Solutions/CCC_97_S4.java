/*
  CCC '97 S4 - Dynamic Dictionary Coding
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            String input;
            StringBuilder sb = new StringBuilder();
           do {
                input = in.readLine();
                sb.append(input);
                sb.append(" 0 ");
            } while (!input.equals(""));
           
            String str = dynamicDict(sb.toString());
            System.out.println(str);

        }
    }


    public static String dynamicDict(String txt) {
        String[] code = txt.split("\\s+");
        StringBuilder sb = new StringBuilder();
        ArrayList<String> line = new ArrayList<>();

        for (int i = 0; i < code.length-1; i++) {
            if (!line.contains(code[i])) {
                if(code[i+1].equals("0") && !code[i].equals("0")) {
                    line.add(code[i]);
                    sb.append(code[i]);
                    sb.append("\n");
                } else if (!code[i+1].equals("0") && !code[i].equals("0")){
                    line.add(code[i]);
                    sb.append(code[i]);
                    sb.append(" ");
                }
            } else if(line.contains(code[i])){
                for (int j = 0; j < line.size(); j++) {
                    if (code[i].equals(line.get(j))) {
                        if(code[i+1].equals("0") && !code[i].equals("0")) {
                            sb.append((j + 1));
                            sb.append("\n");
                        } else if (!code[i+1].equals("0") && !code[i].equals("0")){
                            sb.append((j + 1));
                            sb.append(" ");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
 }
