public class Obama extends President {
    public static void testClassMethod() {
        System.out.println("The class method in Obama.");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Obama.");
    }

    public static void main(String[] args) {

	System.out.println ( "\n\n\n" );
        Obama curr = new Obama();
        curr.testClassMethod();
        curr.testInstanceMethod();

	System.out.println ( "\n\n\n" );
        President headhoncho = pres;
        headhoncho.testClassMethod();
        headhoncho.testInstanceMethod();

	System.out.println ( "\n\n\n" );
	President apres = new President();
        apres.testClassMethod();
        apres.testInstanceMethod();
	System.out.println ( "\n\n\n" );
    }
}

class President {
    public static void testClassMethod() {
        System.out.println("The class method in President.");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in President.");
    }
}