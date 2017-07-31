(ns lein-cljs-npm-deps-example.core
  (:require ))

(enable-console-print!)

(println "This text is printed from src/lein-cljs-npm-deps-example/core.cljs. Go ahead and edit it and see reloading in action.")

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
