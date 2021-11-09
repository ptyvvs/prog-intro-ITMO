package markup;

import java.util.List;

public class Emphasis extends Abstract {

    public Emphasis(List<Abstract> l) {
        super(l);
        variant = "*";
        variantHtml1 = "<em>";
        variantHtml2 = "</em>";
    }
}
