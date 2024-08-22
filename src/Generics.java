public class Generics {

    public static void main(String[] ar) {
        FriendGeneric<String, Integer> fr1 = new FriendGeneric<>("xyz", "abc", 10);

        FriendGeneric.test("test");
        FriendGeneric.test(137283);

        FriendGeneric.test1("dshjdsd", 38293);
        FriendGeneric.test1("hkjede", "dhsakdjwl");

        FriendGeneric.test2("djwsdlwe");
        FriendGeneric.test2(7309.328932);
    }

}

class FriendGeneric<T, U> {
    T p1;
    T p2;
    U relation;

    FriendGeneric(T p1, T p2, U relation) {
        this.p1 = p1;
        this.p2 = p2;
        this.relation = relation;
    }

    public static <E> void test(E e) {
        System.out.println("e = "+e);
    }

    public static <E> void test1(E e1, E e2) {
        System.out.println("e1 = "+e1+"  e2 = "+e2);
    }

    public static <E, V> V test2(E e) {
        System.out.println("e with return type = "+e);
        return null;
    }
}
