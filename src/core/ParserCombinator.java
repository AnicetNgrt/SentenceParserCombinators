package core;

public abstract class ParserCombinator<OA, OB, R> implements Parser<R> {

    public final Parser<OA> parserA;
    public final Parser<OB> parserB;

    public ParserCombinator(Parser<OA> parserA, Parser<OB> parserB) {
        this.parserA = parserA;
        this.parserB = parserB;
    }

    @Override
    public abstract ParseResult<R> parse(String input) throws ParseException;
}
