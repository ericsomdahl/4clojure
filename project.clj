(defproject solns "0.1.0-SNAPSHOT"
  :description "4clojure solutions"
  :url "https://github.com/ericsomdahl/4clojure"
  :license {:name "The MIT License (MIT)" }
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot solns.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
