(defproject lein-cljs-npm-deps-example "0.1.0-SNAPSHOT"
  :description "Example project, showcasing npm integration using clojurescript :npm-deps and :install-deps"
  :url "https://github.com/kapware/lein-cljs-npm-deps-example"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.7.1"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.854"]
                 [org.clojure/core.async  "0.3.442"
                  :exclusions [org.clojure/tools.reader]]]
  :plugins [[lein-figwheel "0.5.12-SNAPSHOT"]
            [lein-cljsbuild "1.1.5" :exclusions [[org.clojure/clojure]]]]
  :source-paths ["src"]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]

                :figwheel {:on-jsload "lein-cljs-npm-deps-example.core/on-js-reload"
                           :open-urls ["http://localhost:3449/index.html"]}

                :compiler {:main lein-cljs-npm-deps-example.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/lein_cljs_npm_deps_example.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           :npm-deps {:left-pad "1.1.3"}
                           :install-deps true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/lein_cljs_npm_deps_example.js"
                           :main lein-cljs-npm-deps-example.core
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {:css-dirs ["resources/public/css"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.2"]
                                  [figwheel-sidecar "0.5.12-SNAPSHOT"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :source-paths ["src" "dev"]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}})
