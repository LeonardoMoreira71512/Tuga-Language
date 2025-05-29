package SVM;

import java.util.ArrayList;
import java.util.List;

public class ConstantPool {
    private final List<Object> constants = new ArrayList<>();

    public int add(Object o) {
        int index = constants.indexOf(o);
        if (index != -1) return index;
        constants.add(o);
        return constants.size() - 1;
    }

    public List<Object> getConstants() {
        return constants;
    }

    public int size() {
        return constants.size();
    }
}
