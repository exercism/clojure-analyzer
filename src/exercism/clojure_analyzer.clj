(ns exercism.clojure-analyzer
  (:require [clojure.tools.analyzer.jvm :as ana.jvm])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(comment
  (ana.jvm/analyze 1))