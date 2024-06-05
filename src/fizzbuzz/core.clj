(ns fizzbuzz.core
  (:require
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
