package collection;

public class Building {
    // static member inner class
    public static class Block {
    }

    public static void main(String[] args) {
        // instance of static member inner class
        Building.Block block = new Building.Block();
    }
}