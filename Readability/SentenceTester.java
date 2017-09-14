public class SentenceTester
{
    public static void main(String [] args)
    {
        String [] s = {
            "When human beings acquired language, we learned not just how to listen but how to speak.",
            "When we gained literacy, we learned not just how to read but how to write.",
            "And as we move into an increasingly digital reality, we must learn not just how to use programs " +
            "but how to make them.",
            "In the emerging highly programmed landscape ahead, you will either create the software or you " +
            "will be the software.",
            "It's really that simple:",
            "Program, or be programmed.",
            "If you aren't, at any given time, scandalized by code you wrote five or even three years ago, " +
            "you're not learning anywhere near enough.",
            "Hmmmmm.",
            "?"};
        Sentence [] phrase = new Sentence[s.length];
        System.out.println("\n\n\n");
        for(int i = 0; i < phrase.length; i++)
        {
            phrase[i] = new Sentence(s[i]);
            System.out.println(phrase[i].getSentence());
            System.out.print("The sentence above has " + phrase[i].getNumWords() + " word(s), and ");
            System.out.println(phrase[i].getNumSyllables() + " syllable(s).\n");
        }
        System.out.println("\n\n\n");
    }
}
/*

When human beings acquired language, we learned not just how to listen but how to speak.
The sentence above has 16 word(s), and 22 syllable(s).
When we gained literacy, we learned not just how to read but how to write.
The sentence above has 15 word(s), and 20 syllable(s).
And as we move into an increasingly digital reality, we must learn not just how to use programs but how to make them.
The sentence above has 23 word(s), and 32 syllable(s).
In the emerging highly programmed landscape ahead, you will either create the software or you will be the software.
The sentence above has 19 word(s), and 29 syllable(s).
It's really that simple:
The sentence above has 4 word(s), and 5 syllable(s).
Program, or be programmed.
The sentence above has 4 word(s), and 7 syllable(s).
If you aren't, at any given time, scandalized by code you wrote five or even three years ago, you're not learning anywhere near enough.
The sentence above has 24 word(s), and 36 syllable(s).
Hmmmmm.
The sentence above has 1 word(s), and 1 syllable(s).
?
The sentence above has 0 word(s), and 0 syllable(s).

*/
