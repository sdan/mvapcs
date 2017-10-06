/*
* numSyllables -> no args, counts and returns
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
*/
