package satellite;


public class Satellite {

    private String name;

    public Satellite(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }
}
