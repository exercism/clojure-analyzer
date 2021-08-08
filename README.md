# Exercism Clojure analyzer

Exercism's Automated Analysis a long-term endeavour to provide rapid feedback to students through the use of automated code analysis. The Clojure analyzer is based on [rewrite-clj](https://github.com/clj-commons/rewrite-clj) and [clojure/tools.analyzer](https://github.com/clojure/tools.analyzer).

## Usage

To run the analyzer, pass it an exercise `<slug>`, an input solution file and an output directory for the AST:

    $ clojure -m exercism.clojure-analyzer two-fer resources/example.clj resources/output/
    Analyzing: two-fer
    Saved to: resources/output/analysis.json

Run the project's tests:

    $ clojure -A:test:runner

Build an uberjar:

    $ clojure -A:uberjar

Run that uberjar:

    $ java -jar clojure-analyzer.jar

## Documentation

The specification of the analyzer interface is found in the [track-tooling](https://github.com/exercism/v3-docs/tree/master/anatomy/track-tooling) section of the v3-docs repo.

## Copyright

All content in this repository is Copyright to Exercism and licensed under AGPL.

