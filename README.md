# PancakeWords
A Java program for finding pancake words--words with unique stackable properties

PancakeWords.java takes as input an integer and outputs "pancake words" that are the same length as that integer. Pancake words have the following qualities:

1. They are words that can be found in a dictionary (e.g., a text file, such as the one provided, which contain a list of words). 
2. If you remove the last letter of a pancake word, the resulting word will also be a pancake word. 

## Usage

PancakeWords.java requires a dictionary of words that is read and added to a dictionary object during the execution of the program. The dictionary object is an ArrayList of ArrayLists. There are 26 "inner" ArrayLists, each corresponding to a letter of the English alphabet and containing an alphabetical list of words from the dictionary text file. 

PancakeWords.java looks for a text file on your desktop called "words_alpha.txt". The program uses the words in this text file to populate the dictionary object. 

## IP Note

I do not own the dictionary text file "words_alpha.txt". I found this text file on GitHub. You can find out more by following the link below. 

<https://github.com/dwyl/english-words.git>
