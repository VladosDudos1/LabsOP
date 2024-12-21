import java.util.ArrayList;
import java.util.Collection;

public class FigureList<E extends Figure> extends ArrayList<E> {
    public FigureList() {
        super();
    }
    public FigureList(Collection<? extends E> c) {
        super(c);
    }
}
