/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.kotlin;

import net.sourceforge.pmd.lang.BaseLanguageModule;

public class KotlinLanguageModule extends BaseLanguageModule {

    public static final String NAME = "Kotlin";
    public static final String TERSE_NAME = "kotlin";

    public KotlinLanguageModule() {
        super(NAME, null, TERSE_NAME, null, "kt");
        addVersion("1.2", new KotlinLanguageHandler(), true);
    }

}
