import java.util.*;
import java.io.*;

public class lexical {
    public static int token; 
    public static int semiToken;
    public static int lexCount = 0; 
    public static HashMap<String, Integer> myMap = new HashMap<String, Integer>(); 
    public static ArrayList<Character> arr = new ArrayList<Character>();
    public static ArrayList<String> arr2 = new ArrayList<String>();
    public static String youTube;
    public static String youTube2;
    public static String anotherInString;
    public static char firstLet;
    public static char secondLet;
    public static char lastLet;
    public static int count1 = 0;
    public static ArrayList<Integer> lexArr = new ArrayList<Integer>(); 
    public static void main(String[] args) throws IOException {
        mapping();
        listing();
    }

    public static void listing() throws IOException {
        File f = new File("secondPass.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int c = 0;
        while ((c = br.read()) != -1) {
            char character = (char) c;
            arr.add(character);
        }
        formComparison();
   
    }
  
    public static void formComparison() throws IOException {
        ArrayList<Character> youtube = new ArrayList<Character>();
        StringBuilder result = new StringBuilder(youtube.size());

        for (int i = 0; i < arr.size(); i++) {
           
            if (Character.isWhitespace(arr.get(i)) && !Character.isWhitespace(arr.get(i + 1))) {
               
                while (count1 < i) {
                    youtube.add(arr.get(count1));
                    count1++;
                }
                count1 = i + 1;
                
                for (Character c : youtube) {
                    result.append(c);
                }
                String output = result.toString();
                arr2.add(output);
                youtube.clear(); 
                result.setLength(0); 
            }
        }
       
        compareNow(arr2);
      
    }
 
    public static void compareNow(ArrayList<String> arr3) {
        for (int bread = 0; bread < arr3.size(); bread++) {
            youTube = arr3.get(bread);
            getChar(youTube);
        }
    }


    public static void outWithSyntax() {
        System.out.println(lexArr);
    }

    public static void mapping() {
        myMap.put("LETTER", 0);
        myMap.put("DIGIT", 1);
        myMap.put("UNKNOWN", 99);
        myMap.put("INT_LIT", 10);
        myMap.put("FLOAT_LIT", 11);
        myMap.put("IDENT", 12);
        myMap.put("ASSIGN_OP", 20);
        myMap.put("ADD_OP", 21);
        myMap.put("SUB_OP", 22);
        myMap.put("MULT_OP", 23);
        myMap.put("DIV_OP", 24);
        myMap.put("MODU", 25);
        myMap.put("LEFT_PAREN", 26);
        myMap.put("RIGHT_PAREN", 27);
        myMap.put("LEFT_CURLY", 28);
        myMap.put("RIGHT_CURLY", 29);
        myMap.put("SEMICO", 30);
        myMap.put("EQ", 31);
        myMap.put("NOT_EQ", 32);
        myMap.put("LESS_EQ", 33);
        myMap.put("LESSTH", 34);
        myMap.put("GRE_EQ", 35);
        myMap.put("GRE", 36);
        myMap.put("NO", 37);
        myMap.put("START", 38);
        myMap.put("END", 39);
        myMap.put("HA_STMT", 40);
        myMap.put("ELSE_STMT", 41);
        myMap.put("DURING_STMT", 42);
        myMap.put("AAND", 43);
        myMap.put("OOR", 44);
        myMap.put("INITIALIZE", 45);
        myMap.put("ADD_SUB", 46);
        myMap.put("MUL_DIV_MOD", 47);
    }
  
    public static int lookup(String inString) {
        if (inString.equals("lecture")) {
            lexCount++;
            token = myMap.get("START");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("hahaha")) {
            lexCount++;
            token = myMap.get("END");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("ha")) {
            lexCount++;
            token = myMap.get("HA_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("during")) {
            lexCount++;
            token = myMap.get("DURING_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("ehh")) {
            lexCount++;
            token = myMap.get("AAND");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("uhh")) {
            lexCount++;
            token = myMap.get("OOR");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("lol")) {
            lexCount++;
            token = myMap.get("ELSE_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.charAt(0) == '$') {
            if (inString.charAt(1) == '$') {
                if (inString.charAt(2) == '$') {
                    lexCount++;
                    token = myMap.get("MUL_DIV_MOD");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.substring(0, 3));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (Character.isDigit(inString.charAt(3))) {
                        lexCount++;
                        token = myMap.get("IDENT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(3));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (Character.isAlphabetic(inString.charAt(3))) {
                        lexCount++;
                        token = myMap.get("DIGIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(3));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                } else {
                    lexCount++;
                    token = myMap.get("ADD_SUB");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.substring(0, 2));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (Character.isDigit(inString.charAt(2))) {
                        lexCount++;
                        token = myMap.get("IDENT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(2));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (Character.isAlphabetic(inString.charAt(2))) {
                        lexCount++;
                        token = myMap.get("DIGIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(2));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                }
            } else {
                    lexCount++;
                    token = myMap.get("INITIALIZE");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.charAt(0));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (inString.charAt(1) == 'g') {
                        lexCount++;
                        token = myMap.get("INT_LIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(1));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (inString.charAt(1) == 'o') {
                        lexCount++;
                        token = myMap.get("FLOAT_LIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(1));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                }
        } else if (inString.equals("!")) {
            lexCount++;
            token = myMap.get("NO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("!=")) {
            lexCount++;
            token = myMap.get("NOT_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("==")) {
            lexCount++;
            token = myMap.get("EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("<=")) {
            lexCount++;
            token = myMap.get("LESS_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("<")) {
            lexCount++;
            token = myMap.get("LESS");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(">=")) {
            lexCount++;
            token = myMap.get("GRE_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(">")) {
            lexCount++;
            token = myMap.get("GRE");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("(")) {
            lexCount++;
            token = myMap.get("LEFT_PAREN");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(")")) {
            lexCount++;
            token = myMap.get("RIGHT_PAREN");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("=")) {
            lexCount++;
            token = myMap.get("ASSIGN_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("+")) {
            lexCount++;
            token = myMap.get("ADD_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("-")) {
            lexCount++;
            token = myMap.get("SUB_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("*")) {
            lexCount++;
            token = myMap.get("MULT_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("/")) {
            lexCount++;
            token = myMap.get("DIV_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("%")) {
            lexCount++;
            token = myMap.get("MODU");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.contentEquals("{")) {
            lexCount++;
            token = myMap.get("LEFT_CURLY");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("}")) {
            lexCount++;
            token = myMap.get("RIGHT_CURLY");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(";")) {
            lexCount++;
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("haha")) {
            lexCount++;
            token = myMap.get("HA_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("lol")) {
            lexCount++;
            token = myMap.get("ELSE_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("during")) {
            lexCount++;
            token = myMap.get("DURING_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            token = -1;
            System.out.println("There is an error in your program.");
        }
        return token;
    }
   
    public static void getChar(String inString2) {
        firstLet = inString2.charAt(0);
        lastLet = inString2.charAt(inString2.length() - 1);
        if (Character.isAlphabetic(firstLet) && lastLet != ';') {
            lookup(inString2);
        } else if (Character.isAlphabetic(firstLet)) {
            semiLex(inString2);
        } else if (Character.isDigit(firstLet)) {
            semiLex2(inString2);
        } else if (Character.isAlphabetic(firstLet) && lastLet == ';') {
            semiLex(inString2);
        } else {
            lookup(inString2);
        }
    }
 
    public static void semiLex(String inString5) {
        String inString4 = "";
        char lastsemi = inString5.charAt(inString5.length() - 1);
        if (lastsemi == ';') {
        for (int rain = 0; rain < inString5.length() - 1; rain++) {
            inString4 += inString5.charAt(rain);
        } 
            lexCount++;
            token = myMap.get("IDENT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
            lexCount++;
            inString4 = inString5.substring(inString5.length() - 1);
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + lastsemi);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            lexCount++;
            token = myMap.get("IDENT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
        }
    }
  
    public static void semiLex2(String inString5) {
        String inString4 = "";
        char lastsemi = inString5.charAt(inString5.length() - 1);
        if (lastsemi == ';') {
        for (int rain = 0; rain < inString5.length() - 1; rain++) {
            inString4 += inString5.charAt(rain);
        } 
            lexCount++;
            token = myMap.get("DIGIT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
            lexCount++;
            inString4 = inString5.substring(inString5.length() - 1);
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + lastsemi);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            lexCount++;
            token = myMap.get("DIGIT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
        }
    }


}
