package com.mehmettayar;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// This is the main function

        Scanner scanner = new Scanner(System.in);
        String word,word2,islem;
        DortIslem dortIslem = new DortIslem();


        while(true){

            System.out.print("Bir romen rakami giriniz (1-3999):");
            word = scanner.nextLine();

            if(word.equals("-")){
                break;
            }
            System.out.print("Yapilmasi istenilen islemi giriniz :");
            islem = scanner.nextLine();

            System.out.print("Bir romen rakami giriniz (1-3999):");
            word2 = scanner.nextLine();

            System.out.println(dortIslem.dortIslemSecilecek(word,word2,islem));

        }


    }






}
