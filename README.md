# lein-cljs-npm-deps-example

Example project, showcasing npm integration using clojurescript `:npm-deps` and `:install-deps`

## Setup

This project depends on yet unreleased feature in lein-figwheel (https://github.com/bhauman/lein-figwheel/commit/35b92b740cbb92c434914c4d0c3e8cc6daf3f17d), but introduced already in clojurescript 1.9.518 (see: https://anmonteiro.com/2017/03/requiring-node-js-modules-from-clojurescript-namespaces/). 

If you get:
```
...
:install-deps true
                                ^---  The key :install-deps is unrecognized
...
```

Then you need to:
```
git clone git@github.com:bhauman/lein-figwheel.git
cd lein-figwheel/plugin
lein install
cd ../sidecar
lein install
```
That should install both figwheel plugin and sidecar to your local maven repository and supply `[lein-figwheel "0.5.12-SNAPSHOT"]`.

Next, to get an interactive development environment run:
```
lein figwheel
(require 'left-pad)
(left-pad "123" 6)
```
It will download (due to `:install-deps true`) npm dependency (in this case left-pad) and generate required `:foreign-libs` for you!
How cool is that?!

Big thanks to ClojureScript guys for introducing this!

## License

Copyright © 2017 kapware

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
