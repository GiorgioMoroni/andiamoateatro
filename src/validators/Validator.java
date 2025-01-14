package validators;

import java.util.Date;

public class Validator {

    public static Object requireNotNull (Object o){
        if(o == null){
            throw new NullPointerException("Non può essere null");
        }
        return o;
    }


    public static String validRegex(String toValidate, String regex){
        if(!toValidate.matches(regex)){
            throw new IllegalArgumentException("Input non valido");
        }
        return toValidate;
    }

    public static String validRegexOrNull(String toValidate, String regex) {
        if (toValidate == null) return toValidate;
        return validRegex(toValidate, regex);
    }

    public static String requireNotBlank(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Input non valido");
        }
        return s;
    }

    public static Integer requirePositive(Integer n) {
        if(n == null){
            throw new NullPointerException("Non può essere null");
        }
        if(n < 0){
            throw new IllegalArgumentException("Input non valido");
        }
        return n;
    }

    public static Double requirePositive(Double n) {
        if(n == null){
            throw new NullPointerException("Non può essere null");
        }
        if(n < 0){
            throw new IllegalArgumentException("Input non valido");
        }
        return n;
    }

    public static Integer requireGreaterThanZero(Integer n){
        if(n == null){
            throw new NullPointerException("Non può essere null");
        }
        if(n < 0){
            throw new IllegalArgumentException("Input non valido");
        }
        return n;
    }

    public static Double requireGreaterThanZero(Double n){
        if(n == null){
            throw new NullPointerException("Non può essere null");
        }
        if(n < 0){
            throw new IllegalArgumentException("Input non valido");
        }
        return n;
    }

    public static Date requireDateBefore(Date firstDate, Date secondDate){
        if(firstDate == null || secondDate == null){
            throw new NullPointerException("Non può essere null");
        }
        if(firstDate.after(secondDate)){
            throw new IllegalArgumentException("Input non valido");
        }
        return firstDate;
    }

    public static Date requireDateAfter(Date firstDate, Date secondDate){
        if(firstDate == null || secondDate == null){
            throw new NullPointerException("Non può essere null");
        }
        if(secondDate.before(firstDate)){
            throw new IllegalArgumentException("Input non valido");
        }
        return secondDate;
    }

    public static Integer requireBetween(Integer a, Integer b, Integer c){
        if(a == null || b == null || c == null){
            throw new NullPointerException("Non può essere null");
        }
        if( a <= b || a >= c){
            throw new IllegalArgumentException("Fuori dall'intervallo");
        }
        return a;
    }

    public static Integer requireBetween(Integer a, Integer b){
        if(a == null || b == null){
            throw new NullPointerException("Non può essere null");
        }
        if(a > b){
            throw new IllegalArgumentException("Posto non esistente");
        }
        return a;
    }
}
