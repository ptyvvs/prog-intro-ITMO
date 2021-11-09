package markup;

import java.util.List;

public class Paragraph extends Abstract {

    public Paragraph(List<Abstract> l) {
        super(l);
    }

    @Override
    public void toMarkdown(StringBuilder s) {
        for (Abstract t : list) {
            t.toMarkdown(s);
        }
    }

    @Override
    public void toHtml(StringBuilder s) {
        for (Abstract t : list) {
            t.toHtml(s);
        }
    }
}
