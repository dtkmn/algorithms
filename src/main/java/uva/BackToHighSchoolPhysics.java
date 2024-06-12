package uva;

import java.util.Scanner;

/**
 * Created by datse on 6/08/2015.
 */
public class BackToHighSchoolPhysics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] inputs = line.split(" ");
            int v = Integer.parseInt(inputs[0]);
            int t = Integer.parseInt(inputs[1]);
            System.out.println(v * t * 2);
        }
    }

}
