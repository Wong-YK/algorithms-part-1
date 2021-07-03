public class HelloGoodbye {
    public static void main(String[] args) {
        String n1 = args[0];
        String n2 = args[1];
        String hello = String.format("Hello %s and %s.", n1, n2);
        String goodbye = String.format("Goodbye %s and %s.", n2, n1);
        System.out.println(hello);
        System.out.println(goodbye);
    }
}
