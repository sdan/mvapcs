public int diff21(int n) {
  if(n>21)
  {
    return 2*(Math.abs(21-n));
  }
  else if(n<21 || n==21)
  {
     return 21-n;
  }
  return 0;
}
