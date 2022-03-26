FROM cljkondo/clj-kondo:2022.03.09-alpine
LABEL Name=clojure-analyzer Version=0.0.1
COPY . /opt/analyzer
WORKDIR /opt/analyzer
ENTRYPOINT ["/opt/analyzer/bin/run.sh"]
