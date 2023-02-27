public class Main {

    public static void main(String[] args) {

        String r1 = "7 2 1 0 4 0 2 3 2 3 7 0 1 2 4 0 7 0 4 2 3 1 0 1 3 2 0 4 2 7 1 2 7 0 4 3";
        String r2 = "9 4 3 2 7 1 4 5 0 4 5 1 0 6 1 2 9 5 9 0 4 3 7 9 0 2 0 3 1 6 9 2 8 3 2 4 6 0 6 2 7 0 8 6 9 1 5 2 4 8";
        String r3 = "4 5 0 5 4 9 3 8 4 2 4 3 2 0 2 1 3 6 8 9 0 5 9 6 0 1 4 0 9 8 7 0 9 1 4 1 0 9 2 3 4 7 2 6 3 9 0 7 1 4 2 9 4 3 8 4 5 4 2 0 6 3 0 9 7 5 1 7 9 4 2 7 3 5 4 0 7 6 9 1 4 1 5 9 6 1 5 2 7 5 1 3 4 8 6 2 7 9";
        String[] ref = r1.split(" ");

        System.out.println("============== FIFO ==============");
        FIFO fifo = new FIFO(1);
        for(int i=1; i<16; i++) {
            fifo.setFrame_size(i);
            fifo.printInfo(ref);
        }

        System.out.println("============== Optimal ==============");
        Optimal optimal = new Optimal(1);
        for(int i=1; i<16; i++) {
            optimal.setFrame_size(i);
            optimal.printInfo(ref);
        }

        System.out.println("============== LRU ==============");
        LRU lru = new LRU(1);
        for(int i=1; i<16; i++) {
            lru.setFrame_size(i);
            lru.printInfo(ref);
        }


    }


}
