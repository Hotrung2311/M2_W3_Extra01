package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Meat extends Material {
    private String unit;
    private double weight;
    public Meat(int id, String name, String mdf, int cost, String unit, double weight){
        super(id, name, mdf, cost);
        this.unit = unit;
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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
        return getCost()*getWeight();
    }

    @Override
    public String abstrc() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar exp = Calendar.getInstance();
        exp.setTime(dateFormat.parse(getMfd()));
        exp.add(Calendar.DATE,15);

        return dateFormat.format(exp.getTime());
    }
    @Override
    public double discount() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = dateFormat.parse(abstrc());
        Calendar today = Calendar.getInstance();
        Calendar exp = Calendar.getInstance();
        exp.setTime(date2);
        boolean LESS_THAN_THREE_DAYS = exp.get(Calendar.DATE) - today.get(Calendar.DATE) <= 3;
        boolean LESS_THAN_FIVE_DAYS = exp.get(Calendar.DATE) - today.get(Calendar.DATE) <= 5;
        boolean IS_SAME_MONTH = today.get(Calendar.MONTH) == exp.get(Calendar.MONTH);
        boolean IS_SAME_YEAR = today.get(Calendar.YEAR) == exp.get(Calendar.YEAR);
        if (LESS_THAN_FIVE_DAYS && IS_SAME_MONTH && IS_SAME_YEAR){
            if(LESS_THAN_THREE_DAYS && IS_SAME_MONTH && IS_SAME_YEAR) {
                return abs()*0.5;
            }
            return abs()*0.3;
        } else
            return abs()*0.1;
    }
}

