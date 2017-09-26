Oce.charAt(i+1)<33))
      {
        counter++;
      }
    }
    if(modifiedSentence.charAt(modifiedSentence.length()-1)<33&&!(modifiedSentence.charAt(0)<33))
    counter++;
    return counter;
  }

  public int getNumSyllables()
  {
    wordList = new Word[getNumWords()];
    int modindexof = 0;
    int count = 0;
    for(int i=0;i<wordList.length;i++)
    {
      while(modifiedSentence.substring(modindexof,modindexof+1).trim().isEmpty())
      {
        modindexof++;
      }
      wordList[i] = new Word(modifiedSentence.substring(modindexof,modifiedSentence.indexOf(' ',modindexof+1)));
      count+=wordList[i].numSyllables();
      modindexof = modifiedSentence.indexOf(' ',modindexof);
    }
    return count;
  }

  public String stripAllPunctuation(String temp)
  {
    for(int i = 0; i < temp.length(); i++)
    {
      switch(temp.charAt(i))
      {
        case '.': case ':': case ';': case '?': case '!': case ',': case '\"': case '-':
        temp = temp.substring(0,i) + " " + temp.substring(i+1);
        break;
        case '\'':
        temp = temp.substring(0,i) + temp.substring(i+1);
        i--;
        break;
      }
    }
    return temp;
  }
}
