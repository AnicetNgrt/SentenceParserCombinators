package core;

public abstract class ParserWrapper<O, R> implements Parser<R> {
    public final Parser<O> parser;

    public ParserWrapper(Parser<O> parser) {
        this.parser = parser;
    }

    @Override
    public abstract ParseResult<R> parse(String input) throws ParseException;
}
