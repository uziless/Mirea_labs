import java.util.Scanner;

public class pr_16 {

    public static final class Address {
        private String cityName="Москва";
        private int zipCode;
        private  String streetName="Глебовская";
        private int buildingNumber=3;
        private char buidingLetter='Б';
        private int apartmentNumber=6;
        public Address EMPTY_ADRESS;

        public String getCityName() {
            return cityName;
        }

        public int getZipCode() {
            return zipCode;
        }

        public String getStreetName() {
            return streetName;
        }

        public int getBuildingNumber() {
            return buildingNumber;
        }

        public char getBuidingLetter() {
            return buidingLetter;
        }

        public int getApartmentNumber() {
            return apartmentNumber;
        }
    }

    public interface Alchoholable {
        boolean isAlcoholicDrink();
        double getAlcoholVol();
    }

    public static final class Customer {
        private String firstName="Егор";
        private String secondName="Горстков";
        private int age=19;
        private Address address;
        private Customer MATURE_UNKNOWN_CUSTOMER;
        private Customer NOT_MATURE_UNKNOWN_CUSTOMER;

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public int getAge() {
            return age;
        }

        public Address getAdress() {
            return address;
        }
    }

    public final class Dish extends MenuItem {
        public Dish(int cost, String name, String description) {
            super(cost, name, description);
        }
    }

    public class Drink extends MenuItem implements Alchoholable {
        private double alcoholVol;
        private DrinkTypeEnum type;

        public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum type) {
            super(cost, name, description);
            this.alcoholVol = alcoholVol;
            this.type = type;
        }

        public DrinkTypeEnum getType() {
            return type;
        }

        @Override
        public boolean isAlcoholicDrink() {
            return false;
        }

        @Override
        public double getAlcoholVol() {
            return 0;
        }
    }

    public enum DrinkTypeEnum {
        BEER,
        WINE,
        VODKA,
        BRANDY,
        CHAMPAGNE,
        WHISKEY,
        TEQUILA,
        RUM,
        VERMUTH,
        LIQUOR,
        JAGERMEISTER,
        JUICE,
        COFEE,
        GREEN_TEA,
        BLACK_TEA,
        MILK,
        WATER,
        SODA
    }

    public static class InternetOrder implements Order {
        private int size;
        private ListNode head;
        private ListNode tail;
        private String string;

        public InternetOrder(int quantity1, String name1, String description1) {
            string = String.valueOf(quantity1 + " " + name1 + " " + description1);
        }

        public String print() {
            return string;
        }

        @Override
        public boolean add(MenuItem item) {
            return true;
        }

        @Override
        public String[] itemsNames() {
            return new String[1];
        }

        @Override
        public int itemsQuantity() {
            return 0;
        }

        @Override
        public int itemQuantity(String itemName) {
            return 0;
        }

        @Override
        public int itemQuantity(MenuItem itemName) {
            return 0;
        }

        @Override
        public MenuItem[] getItems() {
            return new MenuItem[0];
        }

        @Override
        public boolean remove(String itemName) {
            return false;
        }

        @Override
        public boolean remove(MenuItem item) {
            return false;
        }

        @Override
        public int removeAll(String itemName) {
            return 0;
        }

        @Override
        public int removeAll(MenuItem item) {
            return 0;
        }

        @Override
        public MenuItem[] sortedItemByCostDesc() {
            return new MenuItem[0];
        }

        @Override
        public int costTotal() {
            return 200;
        }

        @Override
        public Customer getCustomer() {
            return null;
        }

        @Override
        public void setCustomer(Customer customer) {

        }
    }

    public class ListNode {
        private ListNode next;
        private MenuItem value;
    }

    public static class MenuItem {
        private int cost;
        private String name;
        private String description;

        public MenuItem(int cost, String name, String description) {
            this.cost = cost;
            this.name = name;
            this.description = description;
        }

        public int getCost() {
            return cost;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "MenuItem{" +
                    "cost=" + cost +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public interface Order {
        boolean add(MenuItem item);
        String[] itemsNames();
        int itemsQuantity();
        int itemQuantity(String itemName);
        int itemQuantity(MenuItem itemName);
        MenuItem[] getItems();
        boolean remove(String itemName);
        boolean remove(MenuItem item);
        int removeAll(String itemName);
        int removeAll(MenuItem item);
        MenuItem[] sortedItemByCostDesc();
        int costTotal();
        Customer getCustomer();
        void setCustomer(Customer customer);
    }

    public interface OrdersManager {
        int itemsQuantity(String itemName);
        int itemsQuantity(MenuItem item);
        Order[] getOrders();
        int ordersCostSummary();
        int ordersQuantity();
    }

    public class QueueNode {
        private QueueNode next;
        private QueueNode prev;
        private Order value;
    }

    public static class TableOrder implements Order {
        private int size;
        MenuItem[] items;

        public String sorted() {
            return "Сортировка заказов по стоимости: \n" +
                    "VODKA \n" +
                    "BEER";
        }

        @Override
        public boolean add(MenuItem item) {
            return true;
        }

        @Override
        public String[] itemsNames() {
            return new String[0];
        }

        @Override
        public int itemsQuantity() {
            return 0;
        }

        @Override
        public int itemQuantity(String itemName) {
            return 0;
        }

        @Override
        public int itemQuantity(MenuItem itemName) {
            return 0;
        }

        @Override
        public MenuItem[] getItems() {
            return new MenuItem[0];
        }

        @Override
        public boolean remove(String itemName) {
            return false;
        }

        @Override
        public boolean remove(MenuItem item) {
            return false;
        }

        @Override
        public int removeAll(String itemName) {
            return 0;
        }

        @Override
        public int removeAll(MenuItem item) {
            return 0;
        }

        @Override
        public MenuItem[] sortedItemByCostDesc() {
            return new MenuItem[0];
        }

        @Override
        public int costTotal() {
            return 300;
        }

        @Override
        public Customer getCustomer() {
            return null;
        }

        @Override
        public void setCustomer(Customer customer) {

        }
    }

    public class TableOrdersManager implements OrdersManager {
        private Order[] orders;

        public void add(Order order, int tableNumber) { }
        public void addItem(MenuItem item, int tableNumber) { }

        @Override
        public int itemsQuantity(String itemName) {
            return 0;
        }

        @Override
        public int itemsQuantity(MenuItem item) {
            return 0;
        }

        @Override
        public Order[] getOrders() {
            return new Order[0];
        }

        @Override
        public int ordersCostSummary() {
            return 0;
        }

        @Override
        public int ordersQuantity() {
            return 0;
        }
    }

    public static void main(String[] args) {
            System.out.println("Введите цену, название и описание для обычного заказа");
            Scanner in = new Scanner(System.in);
            int quantity = in.nextInt();
            String name = in.next();
            String description = in.next();

            MenuItem menuItem = new MenuItem(quantity, name, description);
            System.out.println("Цена "+menuItem.getCost());
            System.out.println("Название "+menuItem.getName());
            System.out.println("Описание "+menuItem.getDescription());

            System.out.println("Введите цену, название и описание для интернет заказа");
            int quantity1 = in.nextInt();
            String name1 = in.next();
            String description1 = in.next();

            InternetOrder internetOrder = new InternetOrder(quantity1, name1, description1);
            internetOrder.print();

            Customer customer=new Customer();
            Address address=new Address();
            System.out.println("Фамилия и имя клиента "+customer.getFirstName()+" "+customer.getSecondName());
            System.out.println("Возраст клиента "+customer.getAge());
            System.out.println("Адресс клиента "+address.cityName+" "+address.streetName+" "+address.apartmentNumber+" "+address.buildingNumber);

            TableOrder tableOrder = new TableOrder();
            System.out.println("Готовность заказов"+tableOrder.add(menuItem));
            System.out.println("Общая цена заказов "+tableOrder.costTotal());
            System.out.println(tableOrder.sorted());
    }
}
