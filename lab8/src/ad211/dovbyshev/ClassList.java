package ad211.dovbyshev;

import java.util.Arrays;
import java.util.LinkedList;

public class ClassList<Num extends Number> {
    private LinkedList<Num> list;
    @SafeVarargs
    public ClassList(Num... items) {
        this.list = new LinkedList<>();
        setList(items);
    }
    public ClassList() {
        this.list = new LinkedList<>();
    }
    public LinkedList<Num> getList() {
        return list;
    }
    @SafeVarargs
    public final void setList(Num... items) {
        list = new LinkedList<>();
        list.addAll(Arrays.asList(items));
    }
}
