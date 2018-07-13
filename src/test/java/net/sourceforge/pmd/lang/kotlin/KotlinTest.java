/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.kotlin;

import java.io.StringReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.kotlin.ast.ASTFunction;
import net.sourceforge.pmd.lang.kotlin.ast.ASTKotlinFile;
import net.sourceforge.pmd.lang.kotlin.ast.ASTStatement;

public class KotlinTest {

    @Test
    public void testParsing() {
        LanguageVersion language = LanguageRegistry.getLanguage(KotlinLanguageModule.NAME).getDefaultVersion();
        StringReader source = new StringReader("fun main(args: Array<String>) {\n" +
                "    println(\"Hello, world!\")\n" +
                "}");
        Node node = language.getLanguageVersionHandler().getParser(null).parse("foo", source);
        Assert.assertTrue(node instanceof ASTKotlinFile);
        ASTKotlinFile kotlinFile = (ASTKotlinFile) node;
        List<ASTFunction> functions = kotlinFile.findDescendantsOfType(ASTFunction.class);
        Assert.assertEquals(1, functions.size());
        Assert.assertEquals(1, functions.get(0).getBeginLine());

        ASTStatement statement = kotlinFile.getFirstDescendantOfType(ASTStatement.class);
        Assert.assertEquals(2, statement.getBeginLine());
    }
}
