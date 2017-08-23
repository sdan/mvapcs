#!/bin/bash
files=($(find -E . -type f -regex "^.*$"))
for item in ${files[*]}
do
  printf "   %s\n" $item
  if [ -e Stones.java ]
  then
    echo "Hey that\'s a large number."
  else
    echo "Nope."
  fi
done
