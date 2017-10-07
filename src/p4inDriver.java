import java.io.*;
import java.util.LinkedList;

/**
 * Created by apetril2 on 10/7/2017.
 */
public class p4inDriver
{
    public static void main(String[] args) throws IOException
    {
        LinkedList<String> infixList = new LinkedList<>();
        LinkedList<String> infixVariableList = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("p4in.txt"));
        String str;
        int acc = 0;
        while((str=bufferedReader.readLine())!=null) //creates a list of infix strings and variable infix strings
        {
            infixList.add(str);
            infixVariableList.add(Infix.returnVariable(str));
        }
        bufferedReader.close();

        //begin write
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("p4out.txt"));
        bufferedWriter.write("\tSymbol Table\nVariable\tValue\n\n" +
                "a\t2\n" +
                "b\t3\n" +
                "c\t4\n" +
                "d\t5\n" +
                "e\t5\n" +
                "f\t0\n" +
                "g\t1\n" +
                "h\t8\n" +
                "Input\tInfix\tPostfix\tResult");


        for (int i = 0; i < infixVariableList.size(); i++) //converts to postfix
        {
            bufferedWriter.newLine();
            //input
            bufferedWriter.write(infixList.get(i).toString() + "\t");
            bufferedWriter.write(tableString(infixVariableList.get(i).toString()));
        }

        bufferedWriter.close();
    }

    public static String tableString(String infixExpression)
    {

        String s ;
        //infix
        s = (infixExpression + "\t");
        String postfixExpression =  Postfix.convertToPostfix(infixExpression);
        //postfix
        s += (postfixExpression + "\t");
        //result
        s += Postfix.evaluatePostfix(postfixExpression);
        return s;
    }
}
