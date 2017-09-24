public class WordTester
{
	public static void main(String [] args)
	{
		String [] w = {"java", "rate", "ROTATE", "hierarchy", "juxtaposition", "great",
						"syllable", "able", "are", "phylae", "simplicity", "GRouP",
						"keeping", "AYE", "testing123", "pqr132", "unique", "quixotic",
						"rambunctious", "pleurodynia", "presenteeism", "umbriferous",
						"wayzgoose", "Sequoia", "SIMple"};
		Word [] list = new Word[w.length];
		System.out.println("\n\n\n");
		for(int i = 0; i < list.length; i++)
		{
			list[i] = new Word(w[i]);
			System.out.println(list[i].getWord() + "  " + list[i].numSyllables());
		}
		System.out.println("\n\n\n");
	}
}

/*


java  2
rate  1
rotate  2
hierarchy  3
juxtaposition  5
great  1
syllable  2
able  1
are  1
phylae  2
simplicity  4
group  1
keeping  2
aye  1
testing123  2
pqr132  1
unique  3
quixotic  3
rambunctious  3
pleurodynia  4
presenteeism  3
umbriferous  4
wayzgoose  2
sequoia  2
simple  1


*/
