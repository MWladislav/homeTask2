package service;

import domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class TextService {

    public ArrayList<String> printWordsSortedByFirstLetter(Text text){

        ArrayList<Word> wordsList=new ArrayList<>();

        ArrayList<Component> paragraphs= text.getValues();

        for (Component p :paragraphs) {
            Paragraph paragraph=(Paragraph) p;
            ArrayList<Component> sentences= paragraph.getValues();
            for (Component s:sentences) {
                Sentence sentence=(Sentence)s;
                wordsList.add((Word) sentence.getValues().stream().
                        filter(component -> component instanceof Word).collect(Collectors.toList()));
            }
        }
        ArrayList<String> words= new ArrayList<>();
        wordsList.forEach(word -> words.add(word.getValue().toLowerCase()));
        Collections.sort(words);
        ArrayList<String> sortedWords = new ArrayList<>();
        char currentLetter = 'a';
        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.charAt(0) == currentLetter) {
                    System.out.print(word + " ");
                    sortedWords.add(word);
                } else {
                    sortedWords.add("\n");
                    sortedWords.add(word);
                    System.out.println();
                    System.out.print(word + " ");
                    currentLetter = word.charAt(0);
                }
            } else {
                System.out.println("Detected empty word");
            }
        }
        return sortedWords;
    }
}
