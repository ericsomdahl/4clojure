(ns solns.core
  (:gen-class))

;;; 1
;;; Nothing but the Truth
(= true true)

;;; 2
;;; Simple Math
(=  (- 10  (* 2 3)) 4)

;;; 3
;;; Intro to Strings
(= "HELLO WORLD" (.toUpperCase "hello world"))

;;; 4
;;; Intro to Lists
(=  (list :a :b :c) '(:a :b :c))

;;; 5
;;; Lists: conj
(= (list 1 2 3 4) (conj '(2 3 4) 1))
;;; or
'(1 2 3 4)

;;; 6
;;; Intro to Vectors
(=  [:a :b :c] (list :a :b :c)  (vec '(:a :b :c))  (vector :a :b :c))

;;; 7
;;; Vectors: conj
(= [1 2 3 4] (conj  [1 2 3] 4))
;;; in contrast to lists where the element is added to the front

;;; 8
;;; Intro to Sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
;;; or
(set '(:a :b :c :d))

;;; 9
;;; sets: conj
(= #{1 2 3 4}  (conj #{1 4 3} 2))

;;; 10
;;; Intro to Maps
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))

;;; 11
;;; Maps: conj
(=  {:a 1, :b 2, :c 3}  (conj  {:a 1} [:b 2]  [:c 3]))
;;; or
{:b 2}

;;; 12
;;; Intro to Sequences
(= 3  (first '(3 2 1)))

;;; 13
;;; Sequences: rest
(= [20 30 40] (rest  [10 20 30 40]))

;;; 14
;;; Intro to Functions
(= 8  ((fn add-five  [x]  (+ x 5)) 3))

;;; 15
;;; Double down
(=  (#(* 2 %) 2) 4)

;;; 16
;;; Hello World
(=  (#(str "Hello, " % "!") "Dave") "Hello, Dave!")

;;; 17
;;; Sequences: map
(= [6 7 8]  (map #(+ % 5) '(1 2 3)))`

;;; 18
;;; Sequences: filter
(= [6 7] (filter #(> % 5) '(3 4 5 6 7)))








