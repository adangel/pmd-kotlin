/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.kotlin.ast;

import net.sourceforge.pmd.lang.ast.Node;

public interface KotlinNode extends Node {
    /**
     * Accept the visitor. *
     */
    Object jjtAccept(KotlinParserVisitor visitor, Object data);

    /**
     * Accept the visitor. *
     */
    Object childrenAccept(KotlinParserVisitor visitor, Object data);

}
