package com.NULP.Hnitetskyi.LAB1.Arguments;

public class Arguments {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++)
            System.out.print("\nArguments = " + args[i] + "\n");
    }
}

//javac -d bin src/com/NULP/Hnitetskyi/LAB1/Arguments/Arguments.java
//java -classpath ./bin com.NULP.Hnitetskyi.LAB1.Arguments.Arguments