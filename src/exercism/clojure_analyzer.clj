(ns exercism.clojure-analyzer
  (:require
   [clojure.tools.analyzer.jvm :as ana.jvm]
   [cheshire.core :as json])
  (:gen-class))

(def solution
  (slurp "resources/example.clj"))

(defn -main
  [slug in out]
  (println (str "Analyzing: " slug))
  (spit (str out "representation.txt") (ana.jvm/analyze (slurp in)))
  (println (str "Saved to: " out "representaion.txt")))

(comment
  
  (json/generate-string {:foo "bar" :baz 5})
  (json/encode
    (ana.jvm/analyze '(let [a 1] a))))