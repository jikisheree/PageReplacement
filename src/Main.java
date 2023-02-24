public class Main {

    public static void main(String[] args) {

        String r = "1,2,3,4,1,2,5,1,2,3,4,5,5,7,0,4,1,9,0,1,5,6,3,4,9,9,9,7,5,2,5,1,2,3,4,5,5,2";
        String s = "T 5 X W V Z Y 6 7 T I C 7 8 3 Q R B C 2 I 9 3 1 O Q D H D Q B 2 Z N 2 X I Q B C C Z 4 5 K 1 H Q S D 2 M W 8 9 6 Z X 7 D";
        String[] ref = s.split(" ");

        System.out.println("============== FIFO ==============");
        FIFO fifo = new FIFO(1);
        for(int i=1; i<21; i++) {
            fifo.setFrame_size(i);
            fifo.printInfo(ref);
        }

        System.out.println("============== Optimal ==============");
        Optimal optimal = new Optimal(1);
        for(int i=1; i<21; i++) {
            optimal.setFrame_size(i);
            optimal.printInfo(ref);
        }

        System.out.println("============== LRU ==============");
        LRU lru = new LRU(1);
        for(int i=1; i<21; i++) {
            lru.setFrame_size(i);
            lru.printInfo(ref);
        }


    }


}
