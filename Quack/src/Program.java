package src;

public class Program {
    public static void main(String[] args) {
        Quack<Integer> q = new Quack<>();
        for (int i = 1; i <= 10; ++i) {
            q.push(i);
        }

        Quack<Integer> r = new Quack<>();

        Quack<Integer> s = new Quack<>();
        s.push(1);

        Quack<String> t = new Quack<>();
        t.push("Hello, ");
        t.push("world!");

        System.out.print(q);
        System.out.print(r);
        System.out.print(s);
        System.out.print(t);
    }
}
