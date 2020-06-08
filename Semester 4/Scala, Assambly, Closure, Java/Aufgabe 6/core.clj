(ns Übung-6.core)

;;Aufgabe 1 a)
(def getLenghOfList #(count '(1 2 3 4)))
;;count ist die API die für das zählen von Listeneinträge zuständig ist

;;Aufgabe 1 b)
(defn by100
  [numberToMultiply]
  (* numberToMultiply 100))

;;Aufgabe 1 c)
(defn power
  [base exponent]
  (Math/pow base exponent))
;;(reduce * (repeat base exponent))

;;Aufgabe 1 d)
(defn sumdif
  [digitOne digitTwo]
  [(+ digitOne digitTwo) (- digitOne digitTwo)])

;;Aufgabe 1 e)
(defn solve
  [var1 var2]
  (let [minusPHalb (* -1 (/ var1 2))
        pHalbQuadrat(Math/pow (/ var1 2) 2)
        radikand (Math/sqrt (- pHalbQuadrat var2))]
    [(+ minusPHalb radikand)
     (- minusPHalb radikand)]))

;;Aufgabe 2
(defn most-frequent
  [text]
  (let [count_map (frequencies(clojure.string/split text #" "))
        max_value (apply max (vals count_map))]
    (filter (comp #{max_value} count_map) (keys count_map))
    ))

;;Aufgabe 3
(import '(java.util Calendar))

(defn friday-the-13th
  [year]
    (let [cal (Calendar/getInstance)]
      (do
        (.set cal Calendar/YEAR year)
        (.set cal Calendar/DAY_OF_MONTH 13)
        (.set cal Calendar/MONTH 0))

      (dotimes [n 12]
        (if (= (.get cal Calendar/DAY_OF_WEEK) (Calendar/FRIDAY))
           (print (+ (.get cal Calendar/MONTH) 1) " "))
        (.add cal Calendar/MONTH 1))))

;;Aufgebe 4
  (defn divisors
    [numberToCheck]
    (if (< numberToCheck 5)
      [1]
      (->> (range 2 (inc (quot numberToCheck 2)))
           (filter #(zero? (rem numberToCheck %)))
           (cons 1))))

  (defn perfect?
    [numberToCheck]
    (= (reduce + (divisors numberToCheck)) numberToCheck))
