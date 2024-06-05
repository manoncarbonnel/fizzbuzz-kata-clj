(ns fizzbuzz.core-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [fizzbuzz.core :as sut]
   [fizzbuzz.constant :as c]))

(deftest fizzbuzz-test
  (testing "Default behaviour with numbers"
    (doseq [n [1 2 4]]
      (is (= (str n) (sut/fizzbuzz n)))))
  (testing "Fizz"
    (doseq [n [3 6 9]]
      (is (= c/fizz (sut/fizzbuzz n)))))
  (testing "Buzz"
    (doseq [n [5 10 20]]
      (is (= c/buzz (sut/fizzbuzz n)))))
  (testing "Fizzbuzz"
    (doseq [n [15 30 45]]
      (is (= c/fizzbuzz (sut/fizzbuzz n))))))
