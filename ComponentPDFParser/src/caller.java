import PDFParser.PDFManager;

import java.io.IOException;

/**
 * Created by guitte_a on 09/12/15.
 */

public class caller {

    public static void main(String[] args) throws IOException {

        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("/Users/guitte_a/Downloads/test.pdf");
        System.out.println(pdfManager.ToText());

    }
}