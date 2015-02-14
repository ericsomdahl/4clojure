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
(=  [:a :b :c]  (list :a :b :c)  (vec '(:a :b :c))  (vector :a :b :c))

;;; 7
;;; Vectors: conj
(= [1 2 3 4] (conj  [1 2 3] 4))
;;; in contrast to lists where the element is added to the front

;;; 8
;;; Intro to Sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
;;; or
(set '(:a :b :c :d))






