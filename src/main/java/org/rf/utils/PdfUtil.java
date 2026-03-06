package org.rf.utils;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.rf.utils.Product;

import java.io.File;

public class PdfUtil {

    public static void createProductPdf(Product product, String filePath) {
        try {
            // PDF dosyasını yazmak için
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // klasör yoksa oluştur

            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Başlık
            document.add(new Paragraph("ÜRÜN BİLGİLERİ").setBold().setFontSize(18));

            // Ürün detayları
            document.add(new Paragraph("Başlık: " + product.getTitle()));
            document.add(new Paragraph("Marka: " + product.getUsername()));
            document.add(new Paragraph("Fiyat: " + product.getPrice()));
            document.add(new Paragraph("Beden: " + product.getSize()));
            document.add(new Paragraph("Özellikler: \n" + product.getInformation()));

            document.close();
            System.out.println("PDF başarıyla oluşturuldu: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
