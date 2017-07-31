public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
  if(aSmile&&bSmile)
  {
    return true;
  }
  if(!aSmile&&!bSmile)
  {
    return true;
  }
  if(!aSmile&&bSmile)
  {
    return false;
  }
  if(aSmile&&!bSmile)
  {
    return false;
  }
  return true;
}
