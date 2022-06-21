package ch07.pr19;

import java.util.Arrays;

public class Exercise7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}

class Buyer {
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0; // product배열 cart에 사용될 idx

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 " + p + "을/를 살수 없습니다.");
            return;
        }
        money -= p.price;
        add(p);
    }

    void add(Product p) {
        if (cart.length <= i) {
            Product[] newCart = Arrays.copyOfRange(cart, 0, 6);
            cart = newCart;
        }
        cart[i] = p;
        i++;
    }

    void summary() {
        int usedMoney = 0;
        System.out.print("구입한 물건:");
        for (Product p : cart) {
            System.out.print(p+",");
            usedMoney += p.price;
        }
        System.out.println();
        System.out.println("사용한 금액:" + usedMoney);
        System.out.println("남은 금액:" + money);
    }



}

class Product {
    int price;

    Product(int price) { this.price = price; }
}

class Tv extends Product {
    Tv() { super(100); }

    @Override
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() { super(200); }

    @Override
    public String toString() { return "Computer"; }
}

class Audio extends Product {
    Audio() { super(50); }

    @Override
    public String toString() { return "Audio"; }
}




