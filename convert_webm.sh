#!/bin/bash

# Check if ffmpeg is installed
if ! command -v ffmpeg &> /dev/null
then
    echo "ffmpeg could not be found, please install it first."
    exit 1
fi

# Check if a webm file path is provided
if [ -z "$1" ]; then
    echo "Usage: $0 <path-to-webm-file>"
    exit 1
fi

# Input file
input_file=$1

# Output file
output_file="${input_file%.*}.gif"

# Conversion command
ffmpeg -i "$input_file" -vf "fps=10,scale=640:-1:flags=lanczos" -c:v gif -f gif "$output_file"

echo "Conversion completed: $output_file"
