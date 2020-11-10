//pr_9-complete

import java.util.*;

class Client
{
    private String surname,name,INN;

    Client(String surname,String name,String INN) {
        this.surname=surname;
        this.name=name;
        this.INN=INN;
    }

    public String getInn() { return INN; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
}

public class pr_9
{
    static boolean input(String const_surname1,String const_surname2,String const_surname3,String const_name1,String const_name2,String const_name3,String const_INN1,String const_INN2,String const_INN3)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Фамилию, Имя и ИНН первого клиента");
        String surname1=in.nextLine();
        String name1=in.nextLine();
        String INN1=in.nextLine();
        System.out.println("Введите Фамилию, Имя и ИНН второго клиента");
        String surname2=in.nextLine();
        String name2=in.nextLine();
        String INN2=in.nextLine();
        System.out.println("Введите Фамилию, Имя и ИНН третьего клиента");
        String surname3=in.nextLine();
        String name3=in.nextLine();
        String INN3=in.nextLine();
        if ((surname1.equals(const_surname1))&&(surname2.equals(const_surname2))&&(surname3.equals(const_surname3))&&(name1.equals(const_name1))&&(name2.equals(const_name2))&&(name3.equals(const_name3))&&(INN1.equals(const_INN1))&&(INN2.equals(const_INN2))&&(INN3.equals(const_INN3)))
        {
            return true;
        }
        else
        {
            System.out.println("Один из параметров введен неверно, пожалуйста, повторите ввод заново!");
            return false;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String const_name1="A";
        String const_surname1="A";
        String const_INN1="1111";
        String const_name2="B";
        String const_surname2="B";
        String const_INN2="2222";
        String const_name3="C";
        String const_surname3="C";
        String const_INN3="3333";

        var cl_1=new Client(const_surname1,const_name1,const_INN1);
        var cl_2=new Client(const_surname2,const_name2,const_INN2);
        var cl_3=new Client(const_surname3,const_name3,const_INN3);

        System.out.println("Введите Фамилию, Имя и ИНН первого клиента");
        String surname1=in.nextLine();
        String name1=in.nextLine();
        String INN1=in.nextLine();
        System.out.println("Введите Фамилию, Имя и ИНН второго клиента");
        String surname2=in.nextLine();
        String name2=in.nextLine();
        String INN2=in.nextLine();
        System.out.println("Введите Фамилию, Имя и ИНН третьего клиента");
        String surname3=in.nextLine();
        String name3=in.nextLine();
        String INN3=in.nextLine();

        try
        {
            if ((!cl_1.getSurname().equals(surname1))||(!cl_2.getSurname().equals(surname2))||(!cl_3.getSurname().equals(surname3))||(!cl_1.getName().equals(name1))||(!cl_2.getName().equals(name2))||(!cl_3.getName().equals(name3))||(!cl_1.getInn().equals(INN1))||(!cl_2.getInn().equals(INN2))||(!cl_3.getInn().equals(INN3)))
            {
                throw new Exception("Фамилия введена неверно");
            }
        }
        catch (Exception e)
        {
            System.out.println("Один из параметров введен неверно, пожалуйста, повторите ввод заново!");
            while (!input(const_surname1, const_surname2, const_surname3,const_name1,const_name2,const_name3,const_INN1,const_INN2,const_INN3)) {}
        }
        finally
        {
            System.out.println("Все данные введены верно, все заказы зарезервированны!");
        }
    }
}
