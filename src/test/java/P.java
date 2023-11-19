import java.time.LocalDate;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import se.utility.DateTimeUtil;
public class P {

    public static void main(String[] args) {

        // DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        // LocalDate date = LocalDate.parse("20150927", formatter);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate date = LocalDate.parse("27/09/2015", formatter);
        // // String _date = date.format(formatter);
        
        // System.out.println("date string : 27/09/2015, " + "localdate : " 
        //                  + date);

        // System.out.println("Before formatting: " + myDateObj);
        // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // String formattedDate = myDateObj.format(myFormatObj);
        // System.out.println("After formatting: " + formattedDate);

        // System.out.println("After formatting: " + formattedDate);

//        System.out.println(DateTimeUtil.processMonth(02));
List<String> listOfGenders = Arrays.asList(
                "man", "woman", "non-binary", "something else", "prefer not to say");
       System.out.println(new Random().nextInt(1, 95));
       System.out.println(listOfGenders.get(0));
    }

}
