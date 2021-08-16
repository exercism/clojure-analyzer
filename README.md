# Exercism Clojure analyzer

Exercism's Automated Analysis a long-term endeavour to provide rapid feedback to students through the use of automated code analysis. The Clojure analyzer is based on [rewrite-clj](https://github.com/clj-commons/rewrite-clj) and [clojure/tools.analyzer](https://github.com/clojure/tools.analyzer).

## Usage

To run the analyzer, pass it an exercise `<slug>`, an input solution file and an output directory for the AST:

    $ clojure -m exercism.clojure-analyzer two-fer resources/example.clj resources/output/
    Analyzing: two-fer
    Saved to: resources/output/analysis.json

To generate a JSON static analysis report for a solution file using [clj-kondo](https://github.com/clj-kondo/clj-kondo):

``` bash
$ clj-kondo --lint resources/example.clj --config '{:output {:analysis true :format :json}}'
{"findings":[],"summary":{"error":0,"warning":0,"info":0,"type":"summary","duration":53},"analysis":{"namespace-definitions":[{"filename":"resources/example.clj","row":1,"col":1,"name":"two-fer"}],"namespace-usages":[],"var-definitions":[{"filename":"resources/example.clj","row":3,"col":1,"ns":"two-fer","name":"two-fer","fixed-arities":[0,1]}],"var-usages":[{"fixed-arities":[0,1],"name":"str","filename":"resources/example.clj","from":"two-fer","col":8,"from-var":"two-fer","arity":1,"varargs-min-arity":1,"row":4,"to":"clojure.core"},{"fixed-arities":[0,1],"name":"str","filename":"resources/example.clj","from":"two-fer","col":12,"from-var":"two-fer","arity":3,"varargs-min-arity":1,"row":5,"to":"clojure.core"},{"name":"defn","filename":"resources/example.clj","from":"two-fer","macro":true,"col":2,"arity":3,"varargs-min-arity":2,"row":3,"to":"clojure.core"}]}}
```

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

