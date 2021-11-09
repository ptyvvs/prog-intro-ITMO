package markup;

public class Text extends Abstract {
    private String string;

    public Text(String s) {
        super(null);
        string = s;
    }

    @Override
    public void toMarkdown(StringBuilder s) {
        s.append(string);
    }

    @Override
    public void toHtml(StringBuilder s) {
        s.append(string);
    }
}
