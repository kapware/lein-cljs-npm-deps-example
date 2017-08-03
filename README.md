# lein-cljs-npm-deps-example

Example project, showcasing npm integration using clojurescript `:npm-deps` and `:install-deps`

## Setup

To get an interactive development environment run:
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
