import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by datse on 24/06/2015.
 */
public class TestProgram {
//  Sample input
//  5
//  1000000001 1000000002 1000000003 1000000004 1000000005

    // assume Unicode UTF-8 encoding
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with System.out.
    private static final Locale LOCALE = Locale.US;

    public static void main(String[] args) {
        try {
            Scanner scanner;
            File file = new File(args[0]);
            if (file.exists()) {
                scanner = new Scanner(file, CHARSET_NAME);
                scanner.useLocale(LOCALE);
                return;
            }
//            int t = in.nextInt();
//            System.out.println(t);
        } catch(IOException ioe) {

        }
    }




}
