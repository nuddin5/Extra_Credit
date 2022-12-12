# Extra_Credit
Extra Credit Programming Language Concepts 

BLOCK -> { STMT } $END

STMT -> ASSIGNMENT | LOOPING | EXPR

ASSIGNMENT -> $ EXPR ;

LOOPING -> HA_STMT | DURING_STMT

EXPR -> $$ TERM { ( + | - | = ) TERM }

TERM -> $$$ FACTOR { ( * | / | % ) FACTOR }

FACTOR -> id | int_lit | float_int | ( EXPR )

END -> hahaha

HA_STMT -> ha ( BOOL_EXPR ) STMT [ lol STMT ]

DURING_STMT -> during ( BOOL_EXPR ) STMT

BOOL_EXPR -> AND { ehh AND }

AND -> EQ { uhh EQ }

EQ -> REL { ( == | != ) REL }

REL -> B_EXPR { ( <= | < | >= | > ) B_EXPR }

B_EXPR -> B_TERM { ( + | - ) B_TERM }

B_TERM -> NOT { ( * | / | % ) NOT }

NOT -> [ ! ]B_FACT













    myMap.put("DIGIT", 1);                  // any number
    myMap.put("UNKNOWN", 99);               // the unknown character
    myMap.put("INT_LIT", 10);               // integers
    myMap.put("FLOAT_LIT", 11);             // floating point numbers
    myMap.put("IDENT", 12);                 // identifiers
    myMap.put("ASSIGN_OP", 20);             // the assignment operation ( = )
    myMap.put("ADD_OP", 21);                // addition operator ( + )
    myMap.put("SUB_OP", 22);                // subtraction operator ( - )
    myMap.put("MULT_OP", 23);               // multiplication operator ( * )
    myMap.put("DIV_OP", 24);                // division operator ( / )
    myMap.put("MODU", 25);                  // modulus operator ( % ) 
    myMap.put("LEFT_PAREN", 26);            // left parentheses 
    myMap.put("RIGHT_PAREN", 27);           // right parentheses
    myMap.put("LEFT_CURLY", 28);            // left curly bracket
    myMap.put("RIGHT_CURLY", 29);           // right curly bracket
    myMap.put("SEMICO", 30);                // semicolon
    myMap.put("EQ", 31);                    // equals to operator ( == )
    myMap.put("NOT_EQ", 32);                // not equals operator ( != )
    myMap.put("LESS_EQ", 33);               // less than or equal to operator ( <= )
    myMap.put("LESSTH", 34);                // less than operator ( < )
    myMap.put("GRE_EQ", 35);                // greater than or equal to operator ( >= )
    myMap.put("GRE", 36);                   // greater than opeartor ( > )
