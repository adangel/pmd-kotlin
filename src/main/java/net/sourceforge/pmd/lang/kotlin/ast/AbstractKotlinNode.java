/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.kotlin.ast;

import net.sourceforge.pmd.lang.ast.AbstractNode;

public abstract class AbstractKotlinNode extends AbstractNode implements KotlinNode {
    protected KotlinParser parser;

    public AbstractKotlinNode(int id) {
        super(id);
    }

    public AbstractKotlinNode(KotlinParser parser, int id) {
        this(id);
        this.parser = parser;
    }

    @Override
    public Object childrenAccept(KotlinParserVisitor visitor, Object data) {
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                ((KotlinNode) children[i]).jjtAccept(visitor, data);
            }
        }
        return data;
    }

    @Override
    public String getXPathNodeName() {
        String nodeName = this.getClass().getSimpleName();
        if (nodeName.startsWith("AST")) {
            nodeName = nodeName.substring(3);
        }
        return nodeName;
    }
}
