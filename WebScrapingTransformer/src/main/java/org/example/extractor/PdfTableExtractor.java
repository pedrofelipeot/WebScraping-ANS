package org.example.extractor;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import technology.tabula.ObjectExtractor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PdfTableExtractor {
    public static void extractTablesWithTabula(String pdfPath, String csvPath) {
        try (PDDocument document = PDDocument.load(new File(pdfPath));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvPath, true), StandardCharsets.UTF_8))) {

            ObjectExtractor extractor = new ObjectExtractor(document);
            SpreadsheetExtractionAlgorithm algorithm = new SpreadsheetExtractionAlgorithm();
            BasicExtractionAlgorithm fallbackAlgorithm = new BasicExtractionAlgorithm();

            for (int i = 1; i <= document.getNumberOfPages(); i++) {
                Page page = extractor.extract(i);
                List<Table> tables = algorithm.extract(page);

                if (tables.isEmpty()) {
                    tables = fallbackAlgorithm.extract(page);
                }

                for (Table table : tables) {
                    List<String> rowDataList = new ArrayList<>();
                    boolean foundRN = false;

                    for (List<technology.tabula.RectangularTextContainer> row : table.getRows()) {
                        StringBuilder rowData = new StringBuilder();
                        boolean isEmptyRow = true;

                        for (technology.tabula.RectangularTextContainer cell : row) {
                            String cellText = cell.getText().trim();
                            cellText = cellText.replace("\n", " ").replace("\r", " ");
                            cellText = cellText.replace("OD", "Seg. Odontológica")
                                    .replace("AMB", "Seg. Ambulatorial");

                            if (cellText.equals("RN")) {
                                foundRN = true;
                                rowData.append(cellText).append(" ");
                                continue;
                            }

                            if (foundRN) {
                                rowData.append(cellText);
                                foundRN = false;
                            } else {
                                rowData.append(cellText).append(";");
                            }

                            if (!cellText.isEmpty()) {
                                isEmptyRow = false;
                            }
                        }

                        if (!isEmptyRow) {
                            if (rowData.length() > 0) {
                                rowData.setLength(rowData.length() - 1);
                            }
                            rowDataList.add(rowData.toString());
                        }
                    }

                    for (String rowData : rowDataList) {
                        writer.write(rowData);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Tabelas extraídas e salvas em CSV: " + csvPath);
        } catch (IOException e) {
            System.out.println("Erro ao extrair tabelas: " + e.getMessage());
        }
    }
}
