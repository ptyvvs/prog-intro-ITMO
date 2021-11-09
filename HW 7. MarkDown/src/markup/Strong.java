package markup;

import java.util.List;

public class Strong extends Abstract {
    public Strong(List<Abstract> l) {
        super(l);
        variant = "__";
        variantHtml1 = "<strong>";
        variantHtml2 = "</strong>";
    }

}
