package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Material implements Discount{
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    protected int id;
    protected String name;
    protected String mfd;
    protected int quantity;
    protected int cost;

    public Material(){

    }

    public Material(int id, String name, String mfd, int cost){
        this.id = id;
        this.name = name;
        this.mfd = mfd;
        this.cost = cost;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMfd() {
        return mfd;
    }

    public void setMfd(String mfd) {
        this.mfd = mfd;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double abs();

    public abstract String abstrc() throws ParseException;

//    @Override
    public double discount(double percent) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = dateFormat.parse(abstrc());
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d2.setTime(date2);
        return abs()*(1-percent/100);
    }
}
