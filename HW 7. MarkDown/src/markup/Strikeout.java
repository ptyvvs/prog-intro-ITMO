package markup;

import java.util.List;

public class Strikeout extends Abstract {

    public Strikeout(List<Abstract> l) {
        super(l);
        variant = "~";
        variantHtml1 = "<s>";
        variantHtml2 = "</s>";
    }

}
