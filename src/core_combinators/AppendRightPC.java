package core_combinators;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserCombinator;

import java.util.List;
import java.util.Map;

public class AppendRightPC<O, PA extends Parser<List<O>>, PB extends Parser<O>> extends ParserCombinator<List<O>, O, PA, PB, List<O>> {
    public AppendRightPC(Parser<List<O>> parserA, Parser<O> parserB) {
        super(parserA, parserB);
    }

    @Override
    public ParseResult<List<O>> parse(String input) throws ParseException {
        PairPC<List<O>, O, PA, PB> pairPc = new PairPC<>(parserA, parserB);
        ParseResult<Map.Entry<List<O>, O>> prNotJoined = pairPc.parse(input);
        List<O> poA = prNotJoined.output.getKey();
        O poB = prNotJoined.output.getValue();
        poA.add(poB);
        return new ParseResult<>(prNotJoined.rem, poA);
    }
}
