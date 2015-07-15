(ns solns.156
  (:gen-class))

(def answer
  (fn [d vals]
    (let [bfn (fn [v m k] (assoc m k v))
          bfnp (partial bfn d) ]
      (reduce bfnp {} vals))))

(def x (fn [v m k] (assoc m k v)))
(def xp (partial x 1))
