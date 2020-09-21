#!/bin/bash

if [ $# -lt 3 ]
then
    echo "Usage:"
    echo "./bin/run.sh two_fer ~/input/ ~/output/"
    exit 1
fi

problem_slug="$1"
input_folder="$2"
output_folder="$3"

echo "Analyzing "$problem_slug"..."
clojure -m exercism.clojure-analyzer $problem_slug $input_folder $output_folder
echo "Results written to "$output_folder"analysis.json"
