package se.utility.fileUtil.fileWriterUtil;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.javatuples.Pair;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

public class CsvFileWriter {

    private final String relativeFilePath = "./src/test/java/se/spo/testDataFiles/";

    //region Introducing instance

    public static final CsvFileWriter INSTANCE = getInstance();

    private static final class CsvFileWriterHelper {
        private static final CsvFileWriter _INSTANCE = new CsvFileWriter();
    }

    private static CsvFileWriter getInstance() {
        return CsvFileWriterHelper._INSTANCE;
    }

    private CsvFileWriter() {}

    //endregion

    public Collection<?> modifyCsvFile(
            String destinationPath, String[] headers, Collection<?> modifiedValues)
            throws IOException {

        Collection<?> unmodifiableValues;

        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativeFilePath + destinationPath));
                CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT.withHeader(headers))
        ) {

            unmodifiableValues = Collections.unmodifiableCollection(modifiedValues);

            for (Object values : unmodifiableValues) {
                csvPrinter.printRecord(values);
            }

            csvPrinter.flush();
        }

        return unmodifiableValues;
    }

    public Collection<Pair<?, ?>> modifyCsvFileWithPairOfValues(
            String destinationPath, String[] headers, Collection<Pair<?, ?>> modifiedValues)
            throws IOException {

        Collection<Pair<?, ?>> unmodifiableValues;

        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativeFilePath + destinationPath));
                CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT.withHeader(headers))
        ) {

            unmodifiableValues = Collections.unmodifiableCollection(modifiedValues);

            for (Pair<?, ?> values : unmodifiableValues) {
                csvPrinter.printRecord(values.getValue0(), values.getValue1());
            }

            csvPrinter.flush();
        }

        return unmodifiableValues;
    }
}
