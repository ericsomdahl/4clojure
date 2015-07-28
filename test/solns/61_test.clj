(ns solns.61-test
  (:require [clojure.test :refer :all]
            [solns.61 :refer :all]))

(deftest the-solution
  (testing "case one"
    (is (= (answer  [:a :b :c]  [1 2 3])  {:a 1, :b 2, :c 3} )))
  (testing "case two"
    (is (=  (answer  [1 2 3 4]  ["one" "two" "three"])  {1 "one", 2 "two", 3 "three"})))
  (testing "case three" 
    (is (= (answer  [:foo :bar]  ["foo" "bar" "baz"])  {:foo "foo", :bar "bar"}))))
