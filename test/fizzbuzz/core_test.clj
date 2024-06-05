(ns fizzbuzz.core-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [fizzbuzz.constant :as c]))

(defn divisible-by
  "Checks if `n` is divisible by `x`."
  [n x]
  (zero? (mod n x)))

(defn fizzbuzz
  [n]
  (cond
    (divisible-by n 15) c/fizzbuzz
    (divisible-by n 3) c/fizz
    (divisible-by n 5) c/buzz
    :else (str n)))

(deftest fizzbuzz-test
  (testing "Default behaviour with numbers"
    (doseq [n [1 2 4]]
      (is (= (str n) (fizzbuzz n)))))
  (testing "Fizz"
    (doseq [n [3 6 9]]
      (is (= c/fizz (fizzbuzz n)))))
  (testing "Buzz"
    (doseq [n [5 10 20]]
      (is (= c/buzz (fizzbuzz n)))))
  (testing "Fizzbuzz"
    (doseq [n [15 30 45]]
      (is (= c/fizzbuzz (fizzbuzz n))))))
