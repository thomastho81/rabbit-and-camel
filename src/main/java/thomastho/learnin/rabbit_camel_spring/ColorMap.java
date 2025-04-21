package thomastho.learnin.rabbit_camel_spring;

import java.util.List;
import java.util.Random;

public class ColorMap {

    private static final Random RANDOM = new Random();
    private static final List<String> colors = List.of("Azul", "Preto", "Caramelo");

    public static String getColor() {
        return colors.get(RANDOM.nextInt(colors.size()));

    }
}
