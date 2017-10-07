/**
 * Created by apetril2 on 10/7/2017.
 */
public class Infix
{
    public static String returnVariable(String expression)
    {
        char[] ch = expression.toCharArray();
        for (int i = 0; i < ch.length; i++)
        {
            ch[i] = convertToVariable(ch[i]);
        }

        String variableString = new String(ch);
        return variableString;
    }

    private static char convertToVariable(char c)
    {
        switch (c)
        {
            case '2': return 'a';
            case '3': return 'b';
            case '4': return 'c';
            case '5': return 'd';
            case '6': return 'e';
            case '0': return 'f';
            case '1': return 'g';
            case '8': return 'h';
        } // end switch

        return c; // Symbol or non-expected integer. Return same character.
    } // end valueOf
}
