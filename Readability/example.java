public static int syllables() throws IOException
{
	File file = new File("/home/joe/Documents/F.txt");
	Scanner infile = new Scanner(file);
	int vowelCounter = 0;
	int syllableCounter = 0;

	while((infile.hasNext()))
	{
		String eachLetter = infile.next();

		for (int i=0;i<=eachLetter.length()-1;i++)
		{
			char vowel = eachLetter.charAt(i);

			if(vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel =='o' || vowel == 'u')

			{
				vowelCounter++;



					if(vowelCounter == 2)
					{
						syllableCounter++;
						vowelCounter = 0;

					}
					else
					{
						syllableCounter++;
					}



		    }

		}




	}

	return syllableCounter;
}
