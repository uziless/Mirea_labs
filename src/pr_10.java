//pr_10
//1
/*
public class pr_10
{
    public interface ComplexAbstractFactory
    {
        ComplexAbstractFactory createComplex();
        ComplexAbstractFactory CreateComplex(int real, int image);
    }

    public static class ConcreteFactory implements ComplexAbstractFactory
    {
        private int real,image;
        public ComplexAbstractFactory createComplex()
        {
            return null;
        }

        public ComplexAbstractFactory CreateComplex(int real, int image)
        {
            this.image=image;
            this.real=real;
            return null;
        }

        public void output()
        {
            System.out.print("Действительная часть числа="+real+", мниная часть числа="+image);
        }
    }

    public static void main(String[] args)
    {
        var a = new ConcreteFactory();
        a.CreateComplex(1,2);
        a.output();
    }
}
 */

//2
public class pr_10
{
    public interface AbstractChairFactory {
        VictorianChair createVictorianChair();
        MagicChair createMagicChair();
        FunctionalChair createFunctionalChair();
    }

    public interface Chair {
    }

    public static class ChairFactory implements AbstractChairFactory{
        @Override
        public FunctionalChair createFunctionalChair() {
            return (new FunctionalChair());
        }

        @Override
        public MagicChair createMagicChair() {
            return (new MagicChair());
        }

        @Override
        public VictorianChair createVictorianChair() {
            return (new VictorianChair(1));
        }
    }

    public static class Client {
        public Chair chair;
        public void sit() {};
        public void setChair(Chair chair) {
            this.chair = chair;
        }
    }

    public static class FunctionalChair implements Chair {
        public int sum (int a, int b){
            return a+b;
        }
    }

    public static class MagicChair implements Chair{
        public void doMagic(){
            //do something
        }
    }

    public static class VictorianChair implements Chair{
        private int age;
        public int getAge(){
            return this.age;
        }
        VictorianChair(int age){
            this.age = age;
        }
    }

    public static void main(String[] args)
    {
        var ob=new ChairFactory();
        var cl=new Client();
        ob.createFunctionalChair();
        ob.createMagicChair();
        ob.createVictorianChair();
        cl.setChair(new FunctionalChair());
        cl.sit();
    }
}
