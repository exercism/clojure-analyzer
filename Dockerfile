FROM java:8-alpine
RUN mkdir -p /resources /app/resources/output
WORKDIR /
COPY clojure-analyzer.jar .
CMD java -jar clojure-analyzer.jar