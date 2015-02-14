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
