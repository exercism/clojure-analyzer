# Exercism Clojure analyzer

Exercism's Automated Analysis a long-term endeavour to provide rapid feedback to students through the use of automated code analysis. The Clojure analyzer is based on [clojure/tools.analyzer](https://github.com/clojure/tools.analyzer) and [clj-kondo](https://github.com/borkdude/clj-kondo).

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

Generate JSON static analysis report for a solution file:

```
$ clj-kondo --lint resources/example.clj --config '{:output {:analysis true :format :json}}'                                 
{"findings":[],"summary":{"error":0,"warning":0,"info":0,"type":"summary","duration":53},"analysis":{"namespace-definitions":[{"filename":"resources/example.clj","row":1,"col":1,"name":"two-fer"}],"namespace-usages":[],"var-definitions":[{"filename":"resources/example.clj","row":3,"col":1,"ns":"two-fer","name":"two-fer","fixed-arities":[0,1]}],"var-usages":[{"fixed-arities":[0,1],"name":"str","filename":"resources/example.clj","from":"two-fer","col":8,"from-var":"two-fer","arity":1,"varargs-min-arity":1,"row":4,"to":"clojure.core"},{"fixed-arities":[0,1],"name":"str","filename":"resources/example.clj","from":"two-fer","col":12,"from-var":"two-fer","arity":3,"varargs-min-arity":1,"row":5,"to":"clojure.core"},{"name":"defn","filename":"resources/example.clj","from":"two-fer","macro":true,"col":2,"arity":3,"varargs-min-arity":2,"row":3,"to":"clojure.core"}]}}
```

Run the project directly:

    $ clojure -m exercism.clojure-analyzer "two-fer" "resources/example.clj" "resources/output/"
    Analyzing: two-fer
    Saved to: resources/output/representaion.txt

Run the project's tests:

    $ clojure -A:test:runner

Build an uberjar:

    $ clojure -A:uberjar

Run that uberjar:

    $ java -jar clojure-analyzer.jar

## Copyright

All content in this repository is Copyright to Exercism and licensed under MIT.

