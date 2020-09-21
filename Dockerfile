FROM clojure:tools-deps-alpine
LABEL Name=clojure-analyzer Version=0.0.1
COPY . /opt/analyzer
WORKDIR /opt/analyzer
ENTRYPOINT ["/opt/analyzer/bin/run.sh"]
