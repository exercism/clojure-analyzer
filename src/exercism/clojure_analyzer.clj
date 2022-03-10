(ns exercism.clojure-analyzer
  (:require  [clj-kondo.core :as clj-kondo]
             [cheshire.core :as json])
  (:gen-class))

(defn ana [file]
  (clj-kondo/run! {:lint   [file]
                   :config {:output {:analysis true
                                     :format   :edn}}}))

(defn -main [slug in out]
  (let [comments (:findings (ana in))]
    (println (str "Analyzing: " slug))
    (spit (str out "analysis.json")
          (json/encode
           {:summary "Findings from clj-kondo"
            :comments  (vec (for [{:keys [message level row col]} comments]
                              {:comment (str message " at " [row col])
                               :type (case level
                                       :error "essential"
                                       :warning "actionable"
                                       "informative")}))}
           {:pretty true}))
    (println (str "Saved to: " out "analysis.json"))))

(comment
  (-main "two-fer" "resources/example.clj" "resources/output/")
  )
 (case level
   :error "essential"
   :warning "actionable")