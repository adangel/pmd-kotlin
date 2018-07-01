# PMD Kotlin

PoC for parsing [Kotlin](https://kotlinlang.org) sources with javacc.

Grammar: https://kotlinlang.org/docs/reference/grammar.html

## Using

Build it, e.g. `mvn clean package`

Then put `target/pmd-kotlin-6.6.0-SNAPSHOT.jar` onto the classpath of PMD (e.g. place it into the `lib/` folder
of the binary distribution).

Start the designer.
