(ns rorschach.core)

(defmacro derive-atom [atm new-atm key f & [inital-value]]
  `(do
     (def ~new-atm (atom (or ~inital-value (~f (deref ~atm)))))
     (add-watch ~atm ~key (fn [r# k# old# n#]
                            (reset! ~new-atm (~f n#))))))

