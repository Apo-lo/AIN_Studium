
public class main {

    public static void main(String[] args)  {
        String testString = createString(3000);
        System.out.println(toUpperTailRecursive(testString));
        System.out.println(toUpperRecursive(testString));
    }

    private static String toUpperRecursive(String s)  {
        if(s.length() == 0)
            return "";
        return toUpperRecursive(s.substring(0, s.length() - 1)) + Character.toUpperCase(s.charAt(s.length() - 1));
    }

    static private String toUpperTailRecursiveHelp(String n, String s)   {
        if(n.length() == 0)
            return s;
        return toUpperTailRecursiveHelp(n.substring(0, n.length() - 1), Character.toUpperCase(n.charAt(n.length() - 1)) + s);
    }

    private static String toUpperTailRecursive(String s)   {
        return toUpperTailRecursiveHelp(s ,"");
    }

    private static String createString(int n){
        String tmp = "";
        for(int i=0; i < n; i++){
            tmp += "a";
        }
        return tmp;
    }
}
