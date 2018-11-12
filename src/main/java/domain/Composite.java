package domain;

import java.util.ArrayList;

public abstract class Composite implements Component {

    private ArrayList<Component> components;

    abstract void addComponent(Component component);

    abstract Component removeComponent(int index);
}
