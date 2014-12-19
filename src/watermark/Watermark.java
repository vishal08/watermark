/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package watermark;
import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


/**
 *
 * @author Vishal
 */
public class Watermark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            PdfReader Read_PDF_To_Watermark = new PdfReader("New_PDF_With_Watermark_Image.pdf");
            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("D:/New_PDF_With_Watermark_Image.pdf"));
            int i = 0;
            Image watermark_image = Image.getInstance("D:/watermark.jpg");
            watermark_image.setAbsolutePosition(200, 400);
            PdfContentByte add_watermark;            
            while (i < number_of_pages) {
              i++;
              add_watermark = stamp.getUnderContent(i);
              add_watermark.addImage(watermark_image);
            }
            stamp.close();
        }
        catch (Exception i1) {
            i1.printStackTrace();
        }
    }
}
