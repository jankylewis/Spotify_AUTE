package se.utility.fileUtil.fileReaderUtil;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CsvFileReader {

    private CSVPrinter csvPrinter;
    private CSVFormat csvFormat;
    private FileWriter fileWriter;
//    private String[] headers = null;

    //Handling instance

    static String[] headers = {"Expired tokens provided", "Tokens' unique ids"};

    public static void main (String[] args) throws IOException {

        Reader r = new FileReader(
                "./src/test/java/se/spo/testDataFiles/apiTestDataFiles/expired_tokens.csv");

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> csvRecords = csvFormat.parse(r);

        for (CSVRecord csvRecord : csvRecords) {

            String expiredToken = csvRecord.get(headers[0]);
            String expiredTokenUniqueId = csvRecord.get(headers[1]);

            System.out.println();
        }
    }
}
