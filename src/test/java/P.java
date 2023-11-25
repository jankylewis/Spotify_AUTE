import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.microsoft.playwright.ElementHandle;
import se.utility.DateTimeUtil;
public class P {

    public static void main(String[] args) throws Exception {

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
//List<String> listOfGenders = Arrays.asList(
//                "man", "woman", "non-binary", "something else", "prefer not to say");
//       System.out.println(new Random().nextInt(1, 95));
//       System.out.println(listOfGenders.get(0));
//    }
        int birthDate = -1;

        System.out.println(                    birthDate == -1 ?
                String.valueOf(birthDate) :
                String.valueOf(2));

//        X obj4 = parseObjectFromString(X.class, X.class);
//        System.out.println("Obj: " + obj4.toString() + "; type: " + obj4.getClass().getSimpleName());

//        ElementHandle el = (ElementHandle)new Stream<>();

    }

    public static <Y> Y parseObjectFromString(Class<X> clazzz, Class<Y> clazz) throws Exception {
        return clazz.getConstructor(new Class[]{X.class}).newInstance(clazzz);
    }

    public class X {

    }

    public class Y {

    }
}


