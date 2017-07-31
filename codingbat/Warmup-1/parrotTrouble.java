public boolean parrotTrouble(boolean talking, int hour) {
 if(talking&&(hour<7) || talking&&(hour>20))
 {
   return true;
 }
 else
 return false;
}
