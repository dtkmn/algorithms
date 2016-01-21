package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();

            phonebook.put(name, phone+"");
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            String value = phonebook.get(s);
            System.out.println(value == null ? "Not found" : s + "=" + value);
        }
    }

}
