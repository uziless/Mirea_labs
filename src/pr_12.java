//pr_12-complete(50%)
//4

import java.util.Scanner;
class Number
{
    Number(String str)
    {

        if((str.substring(1,2))==("7"))
        {
            //+79852870755
            String country = str.substring(0, 2);
            String first_3 = str.substring(2, 5);
            String second_3 = str.substring(5, 8);
            String third_4 = str.substring(8, 12);
            System.out.print(country + " " + first_3 + " " + second_3 + " " + third_4);
        }
        else
        {
            //89852870755
            String country = "+7";
            String first_3 = str.substring(1, 4);
            String second_3 = str.substring(4, 7);
            String third_4 = str.substring(7, 11);
            System.out.print(country + " " + first_3 + " " + second_3 + " " + third_4);
        }
    }
}

public class pr_12
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        var numb=new Number(str);
    }
}
//2
/*
import java.util.Scanner;
class Address
{
    private String word;

    Address() {}

    public void setWord(String word)
    {
        this.word = word;
    }

    public String getWord()
    {
        return word;
    }

}

public class pr_12
{
    //var add=new Address(word,word,word,word,word,word,word);
    //System.out.println(word.trim());
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] words = str.split(",");
        //Россия, Москва, Москва, Ленина, 25, 13, 6
        for(String word : words)
        {
            var add=new Address();
            add.setWord(word.trim());
            System.out.println(add.getWord());
        }
    }
}
 */