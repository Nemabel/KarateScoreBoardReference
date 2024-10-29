import java.awt.*;

public class CustomFont {
    String font;
    int cNameSize;
    int cPointSize;

    int dNameSize;
    int dPointSize;

    public CustomFont(String _font, int _cNameSize, int _cPointSize, int _dNameSize, int _dPointSize) {
        font = _font;
        cNameSize = _cNameSize;
        cPointSize = _cPointSize;
        dNameSize = _dNameSize;
        dPointSize = _dPointSize;
    }

    public Font getcNameFont() {
        return new Font(font, Font.PLAIN, cNameSize);
    }

    public Font getcPointFont() {
        return new Font(font, Font.PLAIN, cPointSize);
    }

    public Font getdNameFont() {
        return new Font(font, Font.PLAIN, dNameSize);
    }

    public Font getdPointFont() {
        return new Font(font, Font.PLAIN, dPointSize);
    }
}
