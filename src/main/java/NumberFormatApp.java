import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatApp {
    final static private NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "us"));

    static String formatMonetaryAmount(double amount) {
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(4);
        return numberFormat.format(amount);

    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(22.1214948);
        System.out.println(formatMonetaryAmount(bigDecimal.doubleValue()));
    }
}
