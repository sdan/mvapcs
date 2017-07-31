public boolean sleepIn(boolean weekday, boolean vacation) {
  if(!weekday&&!vacation)
  {
    return true;
  }
  if(weekday&&!vacation)
  {
    return false;
  }
  if(!weekday&&vacation)
  {
    return true;
  }
  else if(weekday&&vacation)
  {
    return true;
  }
  return false;
}
