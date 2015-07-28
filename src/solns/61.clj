(ns solns.61
  (:gen-class))

(def answer
 (fn [k v]
   (into {} (map vector k v))))

