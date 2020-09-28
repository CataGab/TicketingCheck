import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by soory on 31/01/2018.
 */
public class PDF_Export {
    public static void main(String[] args) {
        screenshot();
        pdfOutput();
    }

    /*function for taking screenshots. Current takes a screenshot of the whole screen
     * but in the final version it should only take a screenshot of the GUI. */
    public static void screenshot(){
        try {
            Robot robot = new Robot();
            String fileName = "Export";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, "png", new File(fileName));

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*function for creating a PDF and adding the screenshot to the PDF file */
    public static void pdfOutput(){
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("Export.pdf"));
            document.open();
            Image img = Image.getInstance("Export.png");
            document.add(img);
            document.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


