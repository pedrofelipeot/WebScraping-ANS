package org.example;

import org.example.downloader.FileDownloader;
import org.example.extractor.PdfTableExtractor;
import org.example.utils.ZipUtils;
import org.example.web.AnexoFinder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String userHome = System.getProperty("user.home");
            String downloadDir = userHome + "/Downloads";
            String pdfPath1 = downloadDir + "/Anexo_I.pdf";
            String pdfPath2 = downloadDir + "/Anexo_II.pdf";
            String csvPath = downloadDir + "/Rol_de_Procedimentos.csv";
            String zipPathForPdfs = downloadDir + "/Pdfs_Anexos.zip";
            String zipPathForCsv = downloadDir + "/teste_pedro_felipe.zip";

            // 1. Encontrar URLs dos PDFs
            String pdfUrl1 = AnexoFinder.findAnexoUrl("anexo_i");
            String pdfUrl2 = AnexoFinder.findAnexoUrl("anexo_ii");

            if (pdfUrl1 == null || pdfUrl2 == null) {
                System.out.println("Erro: Não foi possível encontrar um dos anexos.");
                return;
            }

            // 2. Baixar os PDFs
            FileDownloader.downloadFile(pdfUrl1, pdfPath1);
            FileDownloader.downloadFile(pdfUrl2, pdfPath2);

            // 3. Extrair tabelas do Anexo I para CSV
            PdfTableExtractor.extractTablesWithTabula(pdfPath1, csvPath);

            // 4. Compactar os PDFs em um ZIP
            List<String> filesForPdfs = new ArrayList<>();
            filesForPdfs.add(pdfPath1);
            filesForPdfs.add(pdfPath2);
            ZipUtils.zipFiles(filesForPdfs, zipPathForPdfs);

            // 5. Compactar o CSV em um ZIP
            List<String> filesForCsv = new ArrayList<>();
            filesForCsv.add(csvPath);
            ZipUtils.zipFiles(filesForCsv, zipPathForCsv);

            System.out.println("Processo concluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
