package rip_string;


public class Main {
    public static void main(String[] args) {
        Character[] lsit = {'a', 'b', 'c', 'd', 'e', 'f'};
        Sequence sequence = new Sequence(lsit);
        System.out.println(sequence);
        Character[] lsit2 = {'x', 'y'};
        Sequence sequence2 = new Sequence(lsit2);

        sequence.concatenate(sequence2);
        System.out.println(sequence);
        System.out.println(sequence.indexOf('r'));
        System.out.println(sequence.indexOf('j'));

        Character[] lsit3 = {'q', 'y', 'z'};
        Sequence sequence3 = new Sequence(lsit3);
        System.out.println(sequence);

        Character[] lsit4 = {'0'};
        Sequence sequence4 = new Sequence(lsit4);
        sequence.replace(sequence4, sequence3);
        System.out.println(sequence);


        Character[] lsit5 = {'f'};
        Sequence sequence5 = new Sequence(lsit5);
        sequence.replace(sequence5, sequence3);
        System.out.println(sequence);


    }
}
