import java.io.IOException;
public class syntax extends lexical {
    public static int currentToken;
    public static int nextToken;
    public static int i = 0;
    public static void main(String[] args) throws IOException {
        mapping();
        listing();
        currentToken = lexArr.get(i); 
        start(currentToken);
        while (i < lexArr.size()) {
            stmt();
            i++;
        }

    }
    public static void start(int token_Now) {
        System.out.println("Start of program: ");
        while (token_Now == myMap.get("START")) {
            block();
        }
    }

    public static void block() {
        i++;
        currentToken = lexArr.get(i);
        // get the nextToken
        System.out.println("START <block>: ");
        if (currentToken == myMap.get("LEFT_CURLY")) {
            stmt();
        }
    }

    public static void stmt() {
        System.out.println("START <stmt>: ");
        i++;
        currentToken = lexArr.get(i);
       
        switch (currentToken) {
            case 40: // if "ha" statement == "ha"?
                looping(currentToken);
            case 42: // while "during" statement == "during"?
                looping(currentToken);
            case 45: // assignment == "$"?
                assignment();
            case 46: // addition or subtraction = "$$"?
                addminus();
            case 47: // multiplication, division or modulus == "$$$"?
                muldivmod();
            default:
                error();
        }
        System.out.println("END <stmt>");
    }

    public static void assignment() {
        System.out.println("START <assignment>: ");
        factor();
        ident();
        if (nextToken == myMap.get("SEMICO")) {
            i++; 
            nextToken = lexArr.get(i);
        } else {
            error();
        }
        System.out.println("END <assignment>");
    }

    public static void looping(int currentToken) {
        if (currentToken == myMap.get("HA_STMT")) {
            ha_stmt();
        } else if (currentToken == myMap.get("DURING_STMT")) {
            during_stmt();
        } else {
            error();
        }
    }

    public static void addminus() {
      
        System.out.println("START <addminus>: ");
     
        ident();
   
        if (nextToken == myMap.get("ADD_OP")) {
            ident();
        } else if (nextToken == myMap.get("SUB_OP")) {
            ident();
        } else if (nextToken == myMap.get("ASSIGN_OP")) {
            ident();
        } else {
            error();
        }
        System.out.println("END <addminus>: ");
    }

    public static void muldivmod() {
        
        System.out.println("START <muldivmod>: ");
     
        factor();
        // get next token and will it be an operator symbol
        if (nextToken == myMap.get("MULT_OP")) {
            factor();
        } else if (nextToken == myMap.get("DIV_OP")) {
            factor();
        } else if (nextToken == myMap.get("MODU")) {
            factor();
        } else {
            error();
        }
        System.out.println("END <muldivmod>");
    }

    public static void factor() {
       
        i++;
        nextToken = lexArr.get(i);
        System.out.println("START <factor>: ");
        if (nextToken == myMap.get("INT_LIT")) {
            
        } else if (nextToken == myMap.get("FLOAT_LIT")) {

        } else {
            error();
        }
        System.out.println("END <factor>");
    }

    public static void ident() {

    }
    public static void ha_stmt() {
       
        if (nextToken == myMap.get("LEFT_PAREN")) {
            bool_expr();
            // now is the next token a right parentheses?
            if (nextToken == myMap.get("RIGHT_PAREN")) {
                stmt();
                if (nextToken == myMap.get("ELSE_STMT")) {
                    stmt();
                } else {
                    error();
                }
            } else {
                error();
            }
        } else {
            error();
        }
    }

    public static void during_stmt() {
       
        if (nextToken == myMap.get("LEFT_PAREN")) {
            bool_expr();
            if (nextToken == myMap.get("RIGHT_PAREN")) {
                stmt();
            } else {
                error();
            }
        } else {
            error();
        }
    }

    public static void bool_expr() {
        System.out.println("START <bool_expr>: ");
     
        b_eq();
        System.out.println("END <bool_expr>");
    }

    public static void b_eq() {
        if (nextToken == myMap.get("NO")) {
           
            b_fact();
           
            switch(nextToken) {
                case 31:
                    b_fact();
                    break;
                case 32:
                    b_fact();
                    break;
                case 33:    
                    b_fact();
                    break;
                case 34:    
                    b_fact();
                    break;
                case 35:
                    b_fact();
                    break;
                case 36:
                    b_fact();
                    break;
                default: 
                    error();
                    break;
            }
        } else if (nextToken != myMap.get("NO")) {
          
            b_fact2();
          
            switch(nextToken) {
                case 31:
                    b_fact();
                    break;
                case 32:
                    b_fact();
                    break;
                case 33:    
                    b_fact();
                    break;
                case 34:    
                    b_fact();
                    break;
                case 35:
                    b_fact();
                    break;
                case 36:
                    b_fact();
                    break;
                default: 
                    error();
                    break;
            }
        } else {
            error();
        }
    }

    public static void b_fact() {
      
        System.out.println("START <factor>: ");
        if (nextToken == myMap.get("IDENT")) {
         
        } else if (nextToken == myMap.get("DIGIT")) {
       
        } else if (nextToken == myMap.get("LETTER")) {
          
        } else {
            error();
        }
    }

    public static void b_fact2() {
    
        System.out.println("START <factor>: ");
        if (nextToken == myMap.get("IDENT")) {
          
        } else if (nextToken == myMap.get("DIGIT")) {
   
        } else if (nextToken == myMap.get("LETTER")) {
      
        } else {
            error();
        }
    }

    public static void error() {
        System.out.println("ERROR - there has been an error in your program.");
    }
}
