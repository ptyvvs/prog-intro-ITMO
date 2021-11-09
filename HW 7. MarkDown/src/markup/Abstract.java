package markup;

import java.util.List;

public abstract class Abstract implements MarkUp {
    protected String variant = "";
    protected String variantHtml1;
    protected String variantHtml2;
    protected List<Abstract> list;

    public Abstract(List<Abstract> l) {
        list = l;
    }

    public void toMarkdown(StringBuilder s) {
        s.append(variant);
        for (Abstract t : list) {
            t.toMarkdown(s);
        }
        s.append(variant);
    }

    public void toHtml(StringBuilder s) {
        s.append(variantHtml1);
        for (Abstract t : list) {
            t.toHtml(s);
        }
        s.append(variantHtml2);
    }
}
