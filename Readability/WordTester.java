
/**
 *  Word.java
 *  A class that models an English word.  This class
 *  has a single field variable, a String that holds
 *  the word.  This word should be stored as all
 *  lower case.  If the word initially has some upper
 *  case letters, they should be changed to lower case.
 *  This class has a constructor that takes a single
 *  String argument, assigning that String to the
 *  field variable.  There are three methods for
 *  this class:
 *  (a) getWord -> no args, returns the word that is
 *      the field variable for this class.
 *  (b) numSyllables -> no args, counts and returns
 *      the number of syllables in the word (field
 *      variable), according to the following rules:
 *      (i) Each group of adjacent vowels ("a","e","i","o","u","y")
 *          is counted as one syllable, for example:
 *          "simplicity" contains 4 syllables ("i" + "i" + "i" + "y")
 *          "soup" contains 1 syllable because the vowels "ou" are adjacent
 *          "sleeping" contains 2 syllables ("ee" and "i")
 *          "aye" contains one syllable because the vowels "aye" are adjacent
 *      (ii) There is one exception to the above rule.  A single "e"
 *          appearing at the end of a word does not count as a separate
 *          syllable, so:
 *          "syllable" contains 2 syllables ("y" and "a")
 *          "stable" contains 1 syllable ("a")
 *          "state" contains 1 syllable ("a")
 *          "tie" contains 1 syllable because the vowels "ie" are adjacent
 *      (iii) All non-letters such as digits and punctuation should be
 *          treated as non-vowels, so that:
 *          "testing123" contains 2 syllables ("e" and "i")
 *          "what!!??" contains 1 syllable ("a")
 *      (iv) All words must have at least one syllable.  So, if by the
 *          rules above a word would have 0 syllables, 1 should be
 *          returned , such that:
 *          "xyz408" counts as 1 syllable
 *  (c) isVowel -> takes in a single character, and returns true if this
 *      char is a vowel ("a","e","i","o","u",or "y"), false otherwise.
 *      This method must be used as a helper method, called in the 2nd
 *      method above (numSyllables).
 *  @author Your Name Here
 *  @version 1.0
 *  @since 9/12/2017
 */

public class Word
{

}
