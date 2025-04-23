#!/bin/bash

# Check if a markdown file path or directory is provided
if [ -z "$1" ]; then
    echo "Usage: $0 <path-to-markdown-file-or-directory>"
    exit 1
fi

# Function to extract TOC items from a markdown file and add them to the array
extract_toc_items() {
    local md_file="$1"
    local lines=()

    # Read lines into array manually, stripping carriage returns
    while IFS= read -r line || [ -n "$line" ]; do
        lines+=("${line//$'\r'/}")
    done <"$md_file"

    # Loop through lines to find the table of contents items
    for ((i = 0; i < ${#lines[@]}; i++)); do
        local line="${lines[$i]}"
        local next_line="${lines[$i + 1]}"

        if [[ "$line" =~ ^[[:blank:]]*[-\*] ]]; then
            toc_items+=("$md_file|$line")
            if [[ -z "$next_line" ]]; then
                break
            fi
        fi
    done
}

# Function to process a file or directory
process_path() {
    local path="$1"

    if [ -f "$path" ]; then
        # It's a file, extract TOC items from it
        extract_toc_items "$path"
    elif [ -d "$path" ]; then
        # It's a directory, find all markdown files and extract TOC items from them
        while IFS= read -r -d '' md_file; do
            extract_toc_items "$md_file"
        done < <(find "$path" -type f -name '*.md' -print0)
    else
        echo "The provided path is not valid."
        exit 1
    fi
}

# Global array to hold all TOC items
toc_items=()

# Run the function with the provided path
process_path "$1"

# Diagnostic: Print all collected TOC items
echo "Collected TOC items:"
for item in "${toc_items[@]}"; do
    echo "$item"
done

# Select a random TOC item if there are any found
if [ ${#toc_items[@]} -ne 0 ]; then
    random_toc_item="${toc_items[$RANDOM % ${#toc_items[@]}]}"
    file_name=$(echo "$random_toc_item" | cut -d '|' -f 1)
    toc_item=$(echo "$random_toc_item" | cut -d '|' -f 2)

    echo "--------------------------"
    echo "Random Chapter: $toc_item"
    echo "File: $file_name"
else
    echo "No table of contents items found in the provided path."
fi
