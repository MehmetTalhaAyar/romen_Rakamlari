package com.mehmettayar;

public class DortIslem {
    private numberToRomenNumber romenNumber = new numberToRomenNumber();
    private RomenNumberToNumber number = new RomenNumberToNumber();


    public String dortIslemSecilecek(String sayi,String sayi2,String islem) throws  Exception{
        int birSayi;

        switch (islem){
            case "+":
                birSayi = romenNumber.getToTheNumber(sayi) + romenNumber.getToTheNumber(sayi2);
                break;
            case "-":
                birSayi = romenNumber.getToTheNumber(sayi) - romenNumber.getToTheNumber(sayi2);
                break;
            case "/":
                birSayi = romenNumber.getToTheNumber(sayi) / romenNumber.getToTheNumber(sayi2);
                break;
            case "*":
                birSayi =romenNumber.getToTheNumber(sayi) * romenNumber.getToTheNumber(sayi2);
                break;
            default:
                throw new Exception("Girilen islem sonucu 1-3999 arasinda olmali.");
        }

        if (birSayi <= 3999 && birSayi > 0){
            return number.getToTheRomenNumber(birSayi);
        }
        else {
            throw new Exception("Girilen islem sonucu 1-3999 arasinda olmali.");
        }
    }
}
