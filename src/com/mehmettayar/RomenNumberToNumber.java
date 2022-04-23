package com.mehmettayar;

import java.util.*;

public class RomenNumberToNumber {

    private Map<Integer,String> romenNumbers = new HashMap<>();
    private final int MAX_SIZE = 1000;

    RomenNumberToNumber(){

        final List<Integer> romenNumberKeys = new ArrayList<>(Arrays.asList(1,5,10,50,100,500,MAX_SIZE));

        final List<String> romenNumberValues = new ArrayList<>(Arrays.asList("I","V","X","L","C","D","M"));

        for (int i = 0;i<romenNumberKeys.size();i++){
            romenNumbers.put(romenNumberKeys.get(i),romenNumberValues.get(i));
        }


    }


    public String getToTheRomenNumber(int sayi){
        int bolunecekSayi = MAX_SIZE;
        int sayac = 0;
        int tempSayi = sayi;
        StringBuilder romenRakami = new StringBuilder();
        boolean itIsGoingOn = true;

        while (bolunecekSayi >= 1) {

            if (tempSayi / bolunecekSayi != 0) {
                sayac = tempSayi / bolunecekSayi;
                tempSayi -= sayac * bolunecekSayi;
            }
            else if(tempSayi / (bolunecekSayi-bolunecekSayi/10) == 1){
                romenRakami.append(romenNumbers.get(bolunecekSayi/10)+romenNumbers.get(bolunecekSayi));
                tempSayi -= (bolunecekSayi-bolunecekSayi/10);
            }

            for (int i = 0; i < sayac; i++) {
                if(sayac == 4){
                   romenRakami.append(romenNumbers.get(bolunecekSayi)+romenNumbers.get(bolunecekSayi*5));
                   break;
                }
                else{
                    romenRakami.append(romenNumbers.get(bolunecekSayi));
                }


            }
            if (itIsGoingOn) {
                bolunecekSayi = bolunecekSayi / 2;
                itIsGoingOn = false;
            } else {
                bolunecekSayi = bolunecekSayi / 5;
                itIsGoingOn = true;
            }
            sayac = 0;
        }


        return romenRakami.toString();
    }



}
