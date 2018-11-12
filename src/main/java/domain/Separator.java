package domain;

public class Separator implements Component {

    private String value;

    public Separator(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
