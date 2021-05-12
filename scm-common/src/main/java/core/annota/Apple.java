package core.annota;

public class Apple {

    @FruitProvider(id = 100000, name = "红富士", address = "陕西西安大雁塔")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
