#!/bin/bash

if [ -z $1 ]
then
    echo "Enter folder for git repos search in"
    exit 9
fi

dirs=($(find $1 -name ".git" -type d 2>/dev/null | sed 's/.git//g'))

if [ ${#dirs[@]} -ne 0 ]
then
    eval "$(ssh-agent -s)"
    ssh-add ~/.ssh/id_rsa
fi

for i in "${dirs[@]}"
do
   :
   cd $i
   echo "processing $i"
   status=$(git status)
   if [[ $status != *"nothing to commit, working tree clean"* ]]; then
        git add -A
        git commit -m "Auto commit from script"
        git push
   fi
   
   if [[ $status == *"Your branch is ahead"* ]]; then
       git push
   fi
done
