package ch07.pr17;

class Unit {
    int x, y; // 현재위치
    void move(int x, int y) {}
    void stop() {}
}

class Marine extends Unit {
    void stimPack() {}
}

class Tank extends Unit {
    void changeMod() {}
}

class Dropship extends Unit {
    void unload() {}
}

public class Exercise7_17 {
}
