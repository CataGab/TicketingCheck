import java.io.*;
import java.util.*;

/**
 * Created by etseko on 01/02/2018.
 */
public class CSV_parser_v1 {
    private static List<List<String>> outData;

    public static void main(String[] args) {
        //filename input
        System.out.println("Please Enter CSV File name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        StringBuilder path = new StringBuilder("src/");
        path.append(filename);

        //String path = "src/test.csv";
        File file = new File(path.toString());
        List<List<String>> data = new ArrayList<>();
        Scanner inputStream;

        //extension checker
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i >= 0) {
            extension = filename.substring(i + 1);
        }
        System.out.println(extension);

        if (extension.toUpperCase().equals("CSV")) {
            try {
                inputStream = new Scanner(file);

                while (inputStream.hasNext()) {
                    String record = inputStream.nextLine(); //Perhaps needs to be nextLine to avoid splitting spaces
                    String[] values = record.split(",");
                    data.add(Arrays.asList(values));
                }

            } catch (FileNotFoundException e) {
                System.out.println("The file was unable to open. Try again.");
            }

            outData = data; //Storing list in a new variable that will be returned when method called

            //print
            int rec = 1;
            for (List<String> record : data) {
                int cell = 1;
                for (String val : record) {
                    System.out.println("Record " + rec + " Cell:" + cell + " " + val);
                    cell++;
                }
                rec++;
            }
        } else {
            System.out.println("Please enter a file with comma separated vales(.csv) format.");
        }
    }

    public static List<List<String>> getOutData() { //To get list data from other classes
        return outData;
    }
}
