package tagtext;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class splitpara {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "This is how I tried to split a paragraph into a sentence. But, there is a problem. My paragraph includes dates like Jan.13, 2014 , words like U.S and numbers like 2.2. They all got split by the above code.";
        String ty[] = new String[100];
        int i = 0;
        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            System.out.println(reMatcher.group());
            ty[i] = reMatcher.group();
            i++;
        }
        System.out.println(" ");
        for (int y = 0; y < i; y++) {
            System.out.println(ty[y]);
        }

    }

}
