(ns exercism.clojure-analyzer
  (:require
   [clojure.tools.analyzer.jvm :as ana.jvm]
   [clj-kondo.core :as clj-kondo]
   [cheshire.core :as json]
   [clojure.edn :as edn]
   [rewrite-clj.zip :as z])
  (:gen-class))

;; Get clj-kondo static analysis:

(defn ana [file]
  (-> (clj-kondo/run! {:lint [file]
                       :config {:output {:analysis true :format :edn}}}) :analysis))

;; Check if user has defined the correct namespace and var:
(defn ns-defined? [s file]
  (some #(= (symbol s) %)
        (map :name (:namespace-definitions (ana file)))))

(defn var-defined? [s file]
  (some #(= (symbol s) %)
        (map :name (:var-definitions (ana file)))))
 
(comment
  (ns-defined? "two-fer" "resources/example.clj")
  (var-defined? "two-fer" "resources/example.clj")
  )

; to use rewrite-clj:

;; load example two-fer solution, parse code to nodes, 
;; create a zipper, and navigate to the first non-whitespace node
(def zloc (z/of-file "resources/example.clj"))

;; explore what we've parsed

zloc

(z/sexpr zloc)

(-> zloc z/right)

(z/find-value zloc z/next 'defn)
;; more info: https://github.com/clj-commons/rewrite-clj/blob/main/doc/01-user-guide.adoc


(defn -main
  [slug in out]
  (println (str "Analyzing: " slug))
  (spit (str out "analysis.json")
        (json/encode (ana.jvm/analyze (edn/read-string (slurp in)))))
  (println (str "Saved to: " out "analysis.json")))

(comment
  
  (load-file "resources/example.clj")

(keys (ana.jvm/analyze
        (edn/read-string
         (slurp "resources/example.clj")))
     )

  

  (json/generate-string {:foo "bar" :baz 5})
  (json/encode
   (ana.jvm/analyze '(let [a 1] a))))