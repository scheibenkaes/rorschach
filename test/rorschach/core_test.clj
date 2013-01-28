(ns rorschach.core-test
  (:use clojure.test
        rorschach.core))

(def a (atom 1))

(testing "definition of the new atm"
  (derive-atom a b :test inc)
  (is (= 2 @b)))

(testing "updating the source changes the new-atm"
  (derive-atom a b' :test inc)
  (reset! a 2)
  (is (= 3 @b')))