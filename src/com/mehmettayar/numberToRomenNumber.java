package com.mehmettayar;

import java.util.*;

public class numberToRomenNumber {

    private Map<String,Integer> romenNumbers = new HashMap<>();

    numberToRomenNumber(){

        final List<Integer> romenNumberValues = new ArrayList<>(Arrays.asList(1,5,10,50,100,500,1000));

        final List<String> romenNumberKeys = new ArrayList<>(Arrays.asList("I","V","X","L","C","D","M"));


        for (int i = 0;i<romenNumberKeys.size();i++){
            romenNumbers.put(romenNumberKeys.get(i),romenNumberValues.get(i));
        }

    }

    //2744  // MMDCCXLIV
    public int getToTheNumber(String word) throws  Exception{
        List<String> bolunenVeri = new ArrayList<>();
        List<String> islenecekVeriler = new ArrayList<>();
        int toplam = 0;

        islenecekVeriler = List.of(word.split(""));

        islenecekVeriler = duzenGetir(islenecekVeriler);

        for(var eleman : islenecekVeriler){
            if(eleman.length() == 2){
                bolunenVeri = List.of(eleman.split(""));
                toplam += romenNumbers.get(bolunenVeri.get(1)) - romenNumbers.get(bolunenVeri.get(0));
            }
            else{
                toplam += romenNumbers.get(eleman);
            }
        }

        return toplam;
    }

    private List<String> duzenGetir(List<String> veriler) throws Exception {

        String onceki;
        List<String> yeniVeri = new ArrayList<>();
        veriler = checkTheLetters(veriler);

        onceki = veriler.get(0);
        String yeniEleman;
        boolean isItDone = false;

        if(veriler.size() == 1){
            return veriler;
        }

        for (int i = 1;i<veriler.size();i++){
            yeniEleman = veriler.get(i);

            if(romenNumbers.get(onceki) >= romenNumbers.get(yeniEleman)){
                if (!isItDone){
                    yeniVeri.add(onceki);
                }
                isItDone= false;

            }
            else{
                yeniVeri.add(onceki+yeniEleman);
                isItDone = true;

            }
            if(i == veriler.size()-1 && yeniVeri.get(yeniVeri.size()-1).length() !=2){
                yeniVeri.add(yeniEleman);
            }

            onceki = yeniEleman;
        }

        return checkItIsRomenNumber(yeniVeri);
    }

    private List<String> checkItIsRomenNumber(List<String> theRomenNumbers) throws Exception {
        List<String> tempList = new ArrayList<>();
        String oncekiEleman = "";
        String sonrakiEleman = "";
        String birOncekiEleman = "";

        int sayac,oncekiSayac = 0;
        for (var eleman : theRomenNumbers){

            //Yanlıs ikili durumları kontrol eder.
            if(eleman.length() == 2){
                tempList = List.of(eleman.split(""));

                if(romenNumbers.get(tempList.get(1)) != romenNumbers.get(tempList.get(0)) * 5 &&
                        !(romenNumbers.get(tempList.get(1)) == romenNumbers.get(tempList.get(0)) * 10)){

                    throw new Exception("Girilen sayi Romen rakamlari kurallarina uymuyor.");
                }
                else if (romenNumbers.get(tempList.get(1)) != romenNumbers.get(tempList.get(0)) * 10 &&
                        !(romenNumbers.get(tempList.get(1)) == romenNumbers.get(tempList.get(0)) * 5)){
                    throw new Exception("Girilen sayi Romen rakamlari kurallarina uymuyor.");
                }
            }
            sayac = 0;
            //Aynı Romen rakamının 3 ten fazla olup olmama durumu kontrol edilir.
           for(int i = 0;i<theRomenNumbers.size();i++){
               if (eleman.equals(theRomenNumbers.get(i))){
                   sayac++;
               }
               //Bu ve asagidaki ifadeler yukardaki if ifadesi içine alınabilirler gibi duruyor.
               if (eleman.length() == 2){
                   oncekiEleman = eleman.split("")[0];
                   if (oncekiEleman.equals(sonrakiEleman)){
                       throw new Exception("Girilen sayi iki kez yanındaki karakter ile girilemez : "+oncekiEleman);
                   }
                   sonrakiEleman = oncekiEleman;
                   break;
               }
               if (oncekiEleman.equals(eleman)){
                   throw new Exception("Girilen rakamlarin sirasi dogru degil.");
               }
           }
           if (sayac > 3){
               throw new Exception("Girilen rakamlar 3 ten fazla yan yana gelemez.");
           }
           else if (oncekiSayac >= 1 && sayac >1 && romenNumbers.get(eleman) * 2 == romenNumbers.get(birOncekiEleman)){
                throw new Exception("Kendinden 2 kat buyuk rakamdan sonra 2 kez kullanılamaz.");
           }
           oncekiSayac = sayac;
           birOncekiEleman = eleman;

        }

        return theRomenNumbers;
    }

    private List<String> checkTheLetters(List<String> theRomenNumbers) throws Exception{

        for (var eleman : theRomenNumbers){
            if(!(romenNumbers.containsKey(eleman))){
                throw new Exception("Girilen sayi herhangi bir romen rakami ile uyusmuyor.");
            }
        }

        return theRomenNumbers;
    }

}

