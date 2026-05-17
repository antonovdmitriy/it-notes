#!/bin/bash

if [ -z "$1" ]; then
    echo "Enter folder for git repos search in"
    exit 9
fi

dirs=()
while IFS= read -r -d $'\0' dir; do
    dirs+=("${dir%/.git}")
done < <(find "$1" -name ".git" -type d -print0 2>/dev/null)

if [ ${#dirs[@]} -ne 0 ]; then
    eval "$(ssh-agent -s)"
    ssh-add ~/.ssh/id_ed25519 2>/dev/null || ssh-add ~/.ssh/id_rsa 2>/dev/null
    trap "kill $SSH_AGENT_PID" EXIT
fi

for i in "${dirs[@]}"; do
    cd "$i" || { echo "cannot cd into $i, skipping"; continue; }
    echo "processing $i"

    status=$(git status)
    if [[ $status != *"nothing to commit, working tree clean"* ]]; then
        git add -A
        git commit -m "Auto commit from script"
    fi

    git pull || echo "pull failed for $i"
    git push
done
