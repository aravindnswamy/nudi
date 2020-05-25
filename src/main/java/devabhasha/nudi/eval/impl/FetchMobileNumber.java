package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import devabhasha.nudi.utils.Output;
import io.vavr.collection.List;
import java.util.regex.Pattern;

/**
 * Class to fetch Mobile Number.
 * @author aravind.n
 */
public class FetchMobileNumber implements Evaluate {

    private static final String PHONE_NUMBER_PATTERN = "^[a-zA-Z0-9]*[\\:]\\+\\([\\d]{1,3}\\)[ ][\\d]{10}";

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        for (List<String> phoneNumberList : data) {
            for (String number : phoneNumberList) {
                if (pattern.matcher(number).find()) {
                    Output.out(number);
                }
            }
        }
        return List.of(List.empty());
    }
}
