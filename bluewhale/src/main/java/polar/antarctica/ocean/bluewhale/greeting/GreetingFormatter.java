package polar.antarctica.ocean.bluewhale.greeting;

public class GreetingFormatter {
    public static String format(String name) {
        name = name == null ? "world" : name;
        return String.format("Hello, %s! - from blue whale", name);
    }
}
