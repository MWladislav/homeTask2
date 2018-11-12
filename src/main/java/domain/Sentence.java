package domain;

import java.util.ArrayList;

public class Sentence extends Composite {

    private ArrayList<Component> values;

    public Sentence(ArrayList<Component> value) {
        this.values = value;
    }

    public ArrayList<Component> getValues() {
        return values;
    }

    @Override
    void addComponent(Component component) {
        if (component instanceof Composite)
            return;
        this.values.add(component);
    }

    @Override
    Component removeComponent(int index) {
        return this.values.remove(index);
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        values.forEach(component -> result.append(component.getValue()));
        return result.toString();
    }
}
