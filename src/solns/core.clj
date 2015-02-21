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

;;; 19
;;; Last Element
(=  (#(first (reverse %))  [1 2 3 4 5]) 5)

;;; 20
;;; Penultimate Element
(=  (#(first (rest (reverse %)))  (list 1 2 3 4 5)) 4)
;;; or
(=  (#(second (reverse %))  (list 1 2 3 4 5)) 4)

;;; 21
;;; n-th element

;;; the first solution I came up with
#(cond
   (= 0 %2) (first %1)
   (not= 0 %2) (recur  (rest %1)  (dec %2)))

;;; after I learned some destructuring
(def x (fn get-nth
         [[h & r] n]
         (if (= n 0)
           h
           (get-nth r (dec n)))))

;;; but destructuring must use nth under the hood because this tripped
;;; the nth restriction on the problem.
(fn twenty-one
   [[h & r] n]
     (if (= n 0)
        h
        (twenty-one r (dec n))))

(=  ( x '(4 5 6 7) 2) 6)

;;; 22
;;; Count a sequence

;;; third solution I came up with, after having not looked at it for a while

(def twenty-two
  (fn [t]  (reduce + (map (fn [&t] 1) t))))

;;; second solution, derived from looking at other solutions
(def twenty-two
  '(reduce  (fn  [c _]  (inc c)) 0))

(= ( twenty-two '(1 2 3 3 1)) 5)

;;; 23
;;; Reverse a Sequence
(def twenty-three (fn [x y]
          (conj (if (list? x)
                  x
                  (list x)) y)))

(reduce twenty-three [1 2 3] )
(= (reduce twenty-three [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])

;;; 24
;;; Sum It All Up
(def twenty-four #(reduce + %))
(= (twenty-four [1 2 3]) 6)

;;; 25
;;; Filter the Odds
(def twenty-five #(filter odd? %))

(= (twenty-five  #{1 2 3 4 5}) '(1 3 5))

;;; 26
;;; Fibonacci Sequence

;;; this has O(n!) performance -- ugh
(def twenty-six
  (fn [n]
    (map (fn inner [x]
           (if (<= x 2)
            1
            (+ (inner (- x 1)) (inner (- x 2))))) (range 1 (inc n)))))

(twenty-six 9)

(= (twenty-six 3) '(1 1 2))

;;; 27
;;; Palindrome detector

;;; my first solution
(def twenty-seven (fn [x] (= (partition 1 x) (reverse (partition 1 x)))))

;;; looked at other solutions, apparently seq is more idiomatic
(def twenty-seven (fn [x] (= (seq x) (reverse (seq x)))))
(twenty-seven "racecar")

;;; 28
;;; Flatten a Sequence

;;; I actually started playing with mapcat for this but I eventually
;;; looked at the source of core.flatten on this one

(def twenty-eight #(filter (complement sequential?) (tree-seq sequential? identity %)))

((filter (complement sequential?)
          (rest (tree-seq sequential? seq x))))

(= (twenty-eight '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(twenty-eight '(:a 1 3 (2 4)))

;;; 29
;;; Get the caps

;;; my first solution
(def upper? (fn [c] (java.lang.Character/isUpperCase c)))
(def twenty-nine (fn [x]  (apply str (filter (fn [c] (java.lang.Character/isUpperCase c)) x))))

(twenty-nine "HeLlO, WoRlD!")
(= (twenty-nine "HeLlO, WoRlD!") "HLOWRD")

;;; apparently regexes are more idiomatic?
(apply str (re-seq #"[A-Z]" "HeLLo"))

;;; 30
;;; Compress a sequence

;;; here was my first solution.  My eyes!
(def thirty (fn cmpr [s]
  (when-let [[h & t] (seq s)]
    (if (= h (first t))
      (cmpr t)
      (cons h (cmpr t))))))

;;; after grokking some other ways...
(def thirty (fn [l] (map first (partition-by identity l))))

(thirty "Heelloo")
(=  (apply str (thirty "Leeeeeerrroyyy")) "Leroy")

(= (thirty [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))

;;; 31
;;; Pack a sequence

;;; It would make more sense for 31 to come before 30 if this were a straight-up
;;; tutorial
(def thirty-one (fn [s] (partition-by identity s)))
(= (thirty-one [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))

;;; 32
;;; Duplicate a sequence
(def thirty-two (fn [x]
                  (mapcat (fn [i]
                            (vector i i)) x)))

(thirty-two [1 2 3])

(= (thirty-two [1 2 3]) '(1 1 2 2 3 3))


;;; 33
;;; Replicate a sequence

(def thirty-three
  (fn [x n] (mapcat #(repeat n %) x)))

(thirty-three [1 2 4 3 1] 3)

(= (thirty-three [1 2 3] 2) '(1 1 2 2 3 3))

;;; 34
;;; Implement Range
(def thirty-four
  (fn [x y]
    (if (< x (dec y))
      (cons x (lazy-seq (thirty-four (inc x) y)))
      (list (dec y)))))

(= (thirty-four 1 4) '(1 2 3))

;;; as a second take
(def thirty-four (fn [x y] (take (- y x) (iterate inc x))))

;;; 35
;;; Local Bindings

(= 7 (let [x 5] (+ 2 x)))

;;; 36
;;; Let It Be
(= 10 (let [z 1 y 3 x 7] (+ x y)))

;;; 37
;;; Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;;; 38
;;; Maximum Value
(def thirty-eight (fn [& l] (last (sort l))))

(thirty-eight 1 2 3 4)

(=  ( thirty-eight  1 8 3 4) 8)

;;; 39
;;; Interleave Two Sequences

(def thirty-nine
  (fn
    [x y] (let [a (seq x) b (seq y)]
            (if-not (or (empty? a) (empty? b))
              (conj (conj (lazy-seq (thirty-nine (rest a) (rest b))) (first b) ) (first a))
              '()))))

(thirty-nine [1 3 :a] [2 4 :b])
(thirty-nine [1 2 3 4] [:a :b :c])

(= (thirty-nine [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))


;;; I was thinking about mapcat but couldn't get anything.  Simple solutions are simple
(def thirty-nine #(mapcat list %1 %2))

;;; 40
;;; Interpose a Seq

(def forty
  (fn [x y] (reverse (rest (reverse (mapcat #(list % x) y))))))

(= (forty 0 [1 2 3]) [1 0 2 0 3])

(forty 0 [1 2 3])

;;;second take, mostly the same but there is a butlast function!

(def forty
  (fn [x y] (butlast (mapcat #(list % x) y))))

;;; 41
;;; Drop every nth item

(def forty-one
  (fn [x y]
    (mapcat #(if (= y (count %))
                (butlast %)
                %)
            (partition-all y x))))

(= (forty-one [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])









