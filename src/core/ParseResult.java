package core;

public class ParseResult<Output> {
    public final Output output;
    public final String rem;

    public ParseResult(String rem, Output output) {
        this.rem = rem;
        this.output = output;
    }
}
