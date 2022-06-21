package ch07.pr2;


import java.util.Arrays;

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        int[] kwang = { 1, 3, 8 };
        for (int i = 1; i <= CARD_NUM; i++) {
            // set 카드 숫자
            int cNum = i%10;
            if (cNum == 0) cNum = 10;
            boolean isKwang = false;

            // 꽝인지 확인
            Arrays.sort(kwang);
            int idx = Arrays.binarySearch(kwang, cNum);

            // 일회성 꽝
            if (idx >= 0) {
                isKwang = true;
                kwang[idx] = -1;
            }

            // 카드 초기화
            cards[i-1] = new SutdaCard(cNum, isKwang);
        }
    }

    void shuffle() {
        for (int i = 0; i < CARD_NUM; i++) {
            SutdaCard tmp;
            int idx = (int) (Math.random() * 20);

            tmp = cards[i];
            cards[i] = cards[idx];
            cards[idx] = tmp;
        }
    }

    SutdaCard pick(int index) {
        return cards[index];
    }

    SutdaCard pick() {
        return cards[(int) (Math.random() * 20)];
    }

}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "k" : "");
    }
}

public class Exercise7_2 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ", ");
        }
        System.out.println();
        System.out.println(deck.pick(0));
    }
}
