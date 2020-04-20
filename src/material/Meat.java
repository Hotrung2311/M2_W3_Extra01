package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Meat extends Material {
    private int unit;
    private double weight;
    public Meat(int id, String name, String mdf, int cost, int unit, double weight){
        super(id, name, mdf, cost);
        this.unit = unit;
        this.weight = weight;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double abs() {
        return getCost()*getUnit()*getWeight();
    }

    @Override
    public String abstrc() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar exp = Calendar.getInstance();
        exp.setTime(dateFormat.parse(getMfd()));
        exp.add(Calendar.DATE,15);

        setMfd(dateFormat.format(exp.getTime()));
        return this.getMfd();
    }

    @Override
    public void discount(double a) {

    }
}

class TestMeat{
    public static void main(String[] args) throws ParseException {
        Meat m1 = new Meat(1, "m1","20/4/2020", 20000, 5, 5);
        Meat m2 = new Meat(2, "m2","20/4/2020", 25000, 3, 3);
        Meat m3 = new Meat(3, "m3","20/4/2020", 30000, 6, 7);
        Meat m4 = new Meat(4, "m4","20/4/2020", 16000, 4, 20);
        Meat m5 = new Meat(5, "m5","20/4/2020", 22000, 8, 10);

        System.out.println(m1.getMfd());
        System.out.println(m1.abstrc());
    }
}