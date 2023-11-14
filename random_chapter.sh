#!/bin/bash

# Check if a markdown file path is provided
if [ -z "$1" ]; then
    echo "Usage: $0 <path-to-markdown-file-or-directory>"
    exit 1
fi

# Function to select a random leaf from the table of contents
select_random_leaf() {
    local md_file=$1
    local in_toc=false
    local leaves=()
    local prev_line=""
    local line=""
    local next_line=""
    local current_indent=0
    local next_indent=0

    # Read file into an array
    mapfile -t lines < "$md_file"

    # Loop through lines to find the table of contents and leaf nodes
    for (( i=0; i<${#lines[@]}; i++ )); do
        line=${lines[$i]}
        next_line=${lines[$i + 1]}

        # Check for start of the table of contents
        if [[ "$line" =~ ^[-\*]\ \[.*\]\(#.*\) ]]; then
            in_toc=true
        fi

        # If in table of contents
        if [ "$in_toc" = true ]; then
            # Determine indentation level by counting leading spaces
            current_indent=$(echo "$line" | sed -e 's/[^ -].*//g' | wc -c)
            next_indent=$(echo "$next_line" | sed -e 's/[^ -].*//g' | wc -c)

            # Check if it is a leaf node
            if [ "$current_indent" -ge "$next_indent" ]; then
                leaves+=("$line")
            fi

            # Update previous line
            prev_line=$line

            # Check for the end of the table of contents
            if [[ ! "$next_line" =~ ^[-\*]\ \[.*\]\(#.*\) ]]; then
                break
            fi
        fi
    done

    # Print all leaves
    echo "All leaves in the table of contents of $md_file:"
    for leaf in "${leaves[@]}"; do
        echo "$leaf"
    done

    # Select a random leaf from the table of contents
    if [ ${#leaves[@]} -ne 0 ]; then
        echo "--------------------------"
        echo "File: $md_file"
        echo "Random Chapter: ${leaves[$RANDOM % ${#leaves[@]}]}"
    else
        echo "No leaf chapters found in the table of contents of $md_file."
    fi
}


# Check if a path (file or directory) is provided
if [ -z "$1" ]; then
    echo "Usage: $0 <path-to-markdown-file-or-directory>"
    exit 1
fi

# Check if the path is a file or a directory
if [ -f "$1" ]; then
    # It's a file, apply the logic directly
    select_random_leaf "$1"
elif [ -d "$1" ]; then
    # It's a directory, find a random markdown file
    md_files=($(find "$1" -name '*.md'))
    num_files=${#md_files[@]}

    if [ "$num_files" -gt 0 ]; then
        # Select a random markdown file
        random_file=${md_files[$RANDOM % $num_files]}
        select_random_leaf "$random_file"
    else
        echo "No markdown files found in the directory."
    fi
else
    echo "The provided path is not valid."
    exit 1
fi
