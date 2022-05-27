import services.MainService;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.writeToFile();
    }
}
