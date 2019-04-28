package com.coen92.projects.letters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main implements Runnable {

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("lit.in"));

            int numOfDigits = Integer.parseInt(bufferedReader.readLine());
            String johnSurname = bufferedReader.readLine();
            String margaretSurname = bufferedReader.readLine();

            List<Character> firstSurnameCharacters = turnStringToListOfCharacters(johnSurname);
            List<Character> secondSurnameCharacters = turnStringToListOfCharacters(margaretSurname);

            System.out.println("Minimal moves required: " + minimalMoves(firstSurnameCharacters, secondSurnameCharacters, numOfDigits));

            bufferedReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //PODWÓJNA PETLA:
    //Dla pierwszej litery imienia Jasia sprawdz gdzie znajduje sie najblizej ta sama litera w imieniu Malgosi
    //Sprawdz roznice indeksów pomiedzy tymi literami (to minimalna liczba przesunieć dla pierwszej litery)
    //Ustaw ta litere w nazwisku Malgosi na pierwszym miejscu a pozostale pozostaw bez zmian
    //powtarzamy ten krok dla sprawdzajac tym razem dla drugiej litery nazwiska Jasia i sumujemy liczbe przesuniec
    //--------------------------------------------------
    //UWAZAJ NA INDEKSY
    public static int minimalMoves(List<Character> first, List<Character> second, int numOfDigits) {
        int movesCount = 0;
        int sameCharIndex;
        Iterator firstIterator = first.iterator();
        Iterator secondIterator = second.iterator();
        List<Character> temporaryList = new ArrayList<>();

        if(first.size() != numOfDigits || second.size() != numOfDigits) {
            System.out.println("Invalid input values. Check the length of both surnames");

        } else {
            for(int i=0; i<numOfDigits; i++) {
                if(first.get(i).equals(second.get(i))) {
                    continue;

                } else {
                    while(secondIterator.hasNext()) {
                        Character checkedChar = (char) secondIterator.next();
                        StringBuilder tempListBuilder = new StringBuilder();

                        if(second.indexOf(checkedChar) >= i && checkedChar.equals(first.get(i))) {
                            sameCharIndex = second.indexOf(checkedChar);
                            movesCount += (sameCharIndex - i);

                            for(int j=0; j<i; j++) {
                                tempListBuilder.append(first.get(j));
                            }
                            tempListBuilder.append(second.get(sameCharIndex));
                            for(int k=i; k<sameCharIndex; k++) {
                                tempListBuilder.append(second.get(k));
                            }
                            for(int m=sameCharIndex+1; m<numOfDigits; m++) {
                                tempListBuilder.append(second.get(m));
                            }

                            temporaryList = turnStringToListOfCharacters(tempListBuilder.toString());
                            second = temporaryList;
                            System.out.println(Collections.singletonList(second));
                            break;
                        }
                    }
                }
            }
        }
        return movesCount;
    }

    private static List<Character> turnStringToListOfCharacters(String input) {
        String toLowerCase = input.toLowerCase();
        List<Character> characters = toLowerCase.chars().mapToObj(
                e -> (char) e).collect(
                        Collectors.toCollection(ArrayList::new)
        );
        return characters;
    }
}