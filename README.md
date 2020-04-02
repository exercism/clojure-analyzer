# Exercism Clojure analyzer

Exercism's Automated Analysis a long-term endeavour to provide rapid feedback to students through the use of automated code analysis. The Clojure analyzer is based on [clojure/tools.analyzer](https://github.com/clojure/tools.analyzer).

## Installation

Download from https://github.com/exercism/clojure-analyzer.

## Usage

Calling `analyze` on a Clojure form is all it takes to get its AST:

```clojure
user> (ana.jvm/analyze 1)
{:op        :const,
 :env       {:context :ctx/expr, :locals {}, :ns user},
 :form      1,
 :top-level true,
 :val       1,
 :type      :number,
 :literal?  true,
 :id        0,
 :tag       long,
 :o-tag     long}
```

Run the project directly:

    $ clojure -m exercism.clojure-analyzer

Run the project's tests (they'll fail until you edit them):

    $ clojure -A:test:runner

Build an uberjar:

    $ clojure -A:uberjar

Run that uberjar:

    $ java -jar clojure-analyzer.jar

## Copyright

All content in this repository is Copyright to Exercism and licenced under MIT.

