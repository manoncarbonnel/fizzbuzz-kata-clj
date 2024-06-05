(ns fizzbuzz.core-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [clojure.test.check.clojure-test :refer [defspec]]
   [clojure.test.check.generators :as gen]
   [clojure.test.check.properties :as prop]
   [fizzbuzz.core :as sut]
   [fizzbuzz.constant :as c]))

(defspec fizzbuzz-spec
  (prop/for-all [n gen/nat] 
   (or (= 0 n)
       (let [r (sut/fizzbuzz n)]
         (and (string? r)
              (cond
                (= 0 (mod n 15)) (= c/fizzbuzz r)
                (= 0 (mod n 3)) (= c/fizz r)
                (= 0 (mod n 5)) (= c/buzz r)
                :else (= (str n) r)))))))

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
