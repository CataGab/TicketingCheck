import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by etseko on 08/02/2018.
 */
public class csv_test2 {
    public static void main (String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("src/test.csv"));

        sc.useDelimiter(",");

        while(sc.hasNext()){
            System.out.println(sc.next()+ ",");
        }

        sc.close();
    }
}
