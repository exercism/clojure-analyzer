(ns exercism.clojure-analyzer
  (:require
   [clojure.tools.analyzer.jvm :as ana.jvm]
   [cheshire.core :as json]
   [clojure.edn :as edn]
   [rewrite-clj.zip :as z])
  (:gen-class))

;; load example two-fer solution, parse code to nodes, 
;; create a zipper, and navigate to the first non-whitespace node
(def zloc (z/of-file "resources/example.clj"))

zloc

;; explore what we've parsed
(z/sexpr zloc)

;; more info: https://github.com/clj-commons/rewrite-clj/blob/main/doc/01-user-guide.adoc


(defn -main
  [slug in out]
  (println (str "Analyzing: " slug))
  (spit (str out "analysis.json")
        (json/encode (ana.jvm/analyze (edn/read-string (slurp in)))))
  (println (str "Saved to: " out "analysis.json")))

(comment

  (json/generate-string {:foo "bar" :baz 5})
  (json/encode
   (ana.jvm/analyze '(let [a 1] a))))