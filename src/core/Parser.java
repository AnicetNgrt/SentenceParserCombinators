package core;

public interface Parser<Output> {
    ParseResult<Output> parse(String input) throws ParseException;
}
