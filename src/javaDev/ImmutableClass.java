package javaDev;

import java.util.Objects;

public final class ImmutableClass {
    private final String data;

    public ImmutableClass(String data) {
        this.data = data;
    }

    private String getData() {
        return this.data;
    }

    private ImmutableClass Modify(String data) {
        if(Objects.equals(this.data, data))
            return this;
        else
            return new ImmutableClass(data);
    }
}
