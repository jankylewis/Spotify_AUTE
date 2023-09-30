package se.utility;

public class PLUtil {           //PL means Java Programming Language

    public static class ConversionUtil {
        public static Object convert(Object value, Class<?> parsedType) {

            Boolean isConvertedSuccessfully = false;

            //Parsing into Integer
            if (parsedType == int.class) {

                value = Integer.parseInt(value.toString());
                isConvertedSuccessfully = true;
            }

            //Parsing into String
            if (parsedType == String.class) {

                value = value.toString();
                isConvertedSuccessfully = true;
            }

            //Parsing into Double
            if (parsedType == Double.class) {

                value = Double.parseDouble(value.toString());
                isConvertedSuccessfully = true;
            }

            if (isConvertedSuccessfully) {
                return value.getClass().toGenericString();
            } else {
                throw new IllegalArgumentException("Your desired value was invalid! ");
            }
        }
    }
}


