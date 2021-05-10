package core_combinators;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserCombinator;

import java.util.Map;

public class LeftPC<OA, OB, PA extends Parser<OA>, PB extends Parser<OB>> extends ParserCombinator<OA, OB, PA, PB, OA> {
    public LeftPC(Parser<OA> parserA, Parser<OB> parserB) {
        super(parserA, parserB);
    }

    @Override
    public ParseResult<OA> parse(String input) throws ParseException {
        PairPC<OA, OB, PA, PB> ppc = new PairPC<>(parserA, parserB);
        ParseResult<Map.Entry<OA, OB>> prPair = ppc.parse(input);
        return new ParseResult<>(prPair.rem, prPair.output.getKey());
    }
}
