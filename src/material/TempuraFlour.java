package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TempuraFlour extends Material {
    private int quantity;
    public TempuraFlour(int id, String name, String mdf, int cost, int quantity){
        super(id, name, mdf, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double abs() {
        return getQuantity()*getCost();
    }
    @Override
    public String abstrc() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar exp = Calendar.getInstance();
        exp.setTime(dateFormat.parse(getMfd()));
        exp.add(Calendar.YEAR,1);

//        setMfd(dateFormat.format(exp.getTime()));
        return dateFormat.format(exp.getTime());
    }

    @Override
    public void discount(double a) {
        Calendar currentDate = Calendar.getInstance();

    }
//    @Override
//    public double discount(double a){
//        double result = 0;
//        if ()
//        return result;
//    }
}
class testTempura{
    public static void main(String[] args) throws ParseException {
        TempuraFlour a = new TempuraFlour(123, "Bột chiên giòn", "23/11/2020", 3, 50000);

        System.out.println(a.getMfd());
        System.out.println(a.abs());
        System.out.println(a.getName());
        System.out.println(a.abstrc());
    }
}
