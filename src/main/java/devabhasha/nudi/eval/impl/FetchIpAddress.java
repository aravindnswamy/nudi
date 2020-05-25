package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import devabhasha.nudi.utils.Output;
import io.vavr.collection.List;
import java.util.regex.Pattern;

/**
 * <Description>
 * @author aravind.n
 */
public class FetchIpAddress implements Evaluate {

    private static final String IP_PATTERN = "^[0-9]+[.][0-9]+[.][0-9]+[.][0-9]+";

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {

        Pattern pattern = Pattern.compile(IP_PATTERN);
        for (List<String> outerList : data) {
            for (String ip : outerList) {
                if (pattern.matcher(ip).find()) {
                    Output.out(ip);
                }
            }
        }
        return List.of(List.empty());
    }
}
