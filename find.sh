files=($(find -E . -type f -regex "^.java$"))
for item in ${files[java]}
do
  printf "   %s\n" $item
done
