package util;

import domain.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private final Pattern PATTERN_FOR_SENTENCE=Pattern.compile
            ("[^.!?]+?[.!?]",Pattern.UNICODE_CHARACTER_CLASS);

    private final Pattern PATTERN_FOR_WORD_AND_SEPARATORS=Pattern.compile
            ("[«<\"\' {4}]?\\w+[»>\"\']?[^\\w]?\\s*",Pattern.UNICODE_CHARACTER_CLASS);

    public Text parseToText(String text){
        String[] splittedText= text.split("\n {4}");
        ArrayList<Component> paragraphs=new ArrayList<>();
        for (String par:splittedText) {
            Paragraph paragraph= parseToParagraph(par);
            paragraphs.add(paragraph);
        }
        return new Text(paragraphs);
    }

    public Paragraph parseToParagraph(String paragraph){
        Matcher matcher=PATTERN_FOR_SENTENCE.matcher(paragraph);
        ArrayList<Component> sentences= new ArrayList<>();
        while (matcher.find()) {
            Sentence sentence= parseToSentence(matcher.group());
            sentences.add(sentence);
        }
        return new Paragraph(sentences);
    }

    public Sentence parseToSentence(String sentence){
        Matcher matcher=PATTERN_FOR_WORD_AND_SEPARATORS.matcher(sentence);
        ArrayList<Component> wordsAndSeparators = new ArrayList<>();
        while (matcher.find()){
            String match = matcher.group();
            Pattern wordPattern = Pattern.compile("\\w+",Pattern.UNICODE_CHARACTER_CLASS);
            Matcher wordMatcher =wordPattern.matcher(match);
            if (!Character.isLetterOrDigit(match.charAt(0))){
                Separator separator = new Separator(match.substring(0,1));
                wordsAndSeparators.add(separator);
            }
            while (wordMatcher.find()){
                Word word = new Word(wordMatcher.group());
                wordsAndSeparators.add(word);
                Separator separator = new Separator(match.substring(wordMatcher.end()));
                wordsAndSeparators.add(separator);
            }
        }
        return new Sentence(wordsAndSeparators);
    }

    public String parseText(Text text){
        ArrayList<Component> paragraphs= text.getValues();
        StringBuilder result = new StringBuilder();
        paragraphs.forEach(component -> result.append(component.getValue()).append("\n    "));
        return result.toString();
    }
}
