public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));

        cache.put(3, 30);
        System.out.println(cache.get(2));

        cache.put(4, 40);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        cache.printStats();
    }
}
