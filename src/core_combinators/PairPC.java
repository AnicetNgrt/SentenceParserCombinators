package core_combinators;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserCombinator;

import java.util.AbstractMap;
import java.util.Map;

public class PairPC<OA, OB, PA extends Parser<OA>, PB extends Parser<OB>> extends ParserCombinator<OA, OB, PA, PB, Map.Entry<OA, OB>> {
    public PairPC(Parser<OA> parserA, Parser<OB> parserB) {
        super(parserA, parserB);
    }

    @Override
    public ParseResult<Map.Entry<OA, OB>> parse(String input) throws ParseException {
        ParseResult<OA> prA = parserA.parse(input);
        ParseResult<OB> prB = null;
        prB = parserB.parse(prA.rem);
        return new ParseResult<Map.Entry<OA, OB>>(
                prB.rem,
                new AbstractMap.SimpleEntry<OA, OB>(prA.output, prB.output)
        );
    }
}
