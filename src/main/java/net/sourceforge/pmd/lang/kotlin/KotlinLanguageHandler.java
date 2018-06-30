/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.kotlin;

import java.io.Reader;
import java.util.Map;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.AbstractLanguageVersionHandler;
import net.sourceforge.pmd.lang.AbstractParser;
import net.sourceforge.pmd.lang.Parser;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.lang.TokenManager;
import net.sourceforge.pmd.lang.ast.JavaCharStream;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.ast.ParseException;
import net.sourceforge.pmd.lang.kotlin.ast.KotlinParser;
import net.sourceforge.pmd.lang.kotlin.ast.KotlinParserTokenManager;
import net.sourceforge.pmd.lang.rule.RuleViolationFactory;

public class KotlinLanguageHandler extends AbstractLanguageVersionHandler {

    @Override
    public RuleViolationFactory getRuleViolationFactory() {
        return new RuleViolationFactory() {

            @Override
            public void addViolation(RuleContext ruleContext, Rule rule, Node node, String message, int beginLine, int endLine,
                    Object[] args) {
                // TODO Auto-generated method stub

            }

            @Override
            public void addViolation(RuleContext ruleContext, Rule rule, Node node, String message, Object[] args) {
                // TODO Auto-generated method stub

            }
        };
    }

    @Override
    public Parser getParser(ParserOptions parserOptions) {
        return new AbstractParser(parserOptions) {

            @Override
            public Node parse(String fileName, Reader source) throws ParseException {
                KotlinParser parser = new KotlinParser(new JavaCharStream(source));
                return parser.KotlinFile();
            }

            @Override
            public Map<Integer, String> getSuppressMap() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public boolean canParse() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            protected TokenManager createTokenManager(final Reader source) {
                return new TokenManager() {
                    private KotlinParserTokenManager tokenManager = new KotlinParserTokenManager(new JavaCharStream(source));
                    @Override
                    public void setFileName(String fileName) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public Object getNextToken() {
                        return tokenManager.getNextToken();
                    }
                };
            }
        };
    }

}
