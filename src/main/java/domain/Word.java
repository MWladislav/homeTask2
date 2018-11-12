package domain;

public class Word implements Component {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
