(ns solns.156-test
  (:require [clojure.test :refer :all]
            [solns.156 :refer :all]))

(deftest the-solution
  (testing "case one"
    (is (=  (answer 0  [:a :b :c])  {:a 0 :b 0 :c 0})))
  (testing "case two"
    (is (=  (answer "x"  [1 2 3])  {1 "x" 2 "x" 3 "x"})))
  (testing "case three" 
    (is (=  (answer  [:a :b]  [:foo :bar])  {:foo  [:a :b] :bar  [:a :b]}))))
