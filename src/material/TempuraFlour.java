package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
        String result = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar exp = Calendar.getInstance();
        exp.setTime(dateFormat.parse(getMfd()));
        exp.add(Calendar.YEAR,1);
        result = dateFormat.format(exp.getTime());
        return result;
    }
    @Override
    public double discount() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = dateFormat.parse(abstrc());
        Calendar today = Calendar.getInstance();
        Calendar exp = Calendar.getInstance();
        exp.setTime(date2);
        boolean LESS_THAN_FOUR_MONTHS = exp.get(Calendar.MONTH) - today.get(Calendar.MONTH) <= 4;
        boolean LESS_THAN_TWO_MONTHS = exp.get(Calendar.MONTH) - today.get(Calendar.MONTH) <= 2;
        boolean IS_SAME_YEAR = today.get(Calendar.YEAR) == exp.get(Calendar.YEAR);
        boolean IS_SAME_DATE = today.get(Calendar.DATE) == exp.get(Calendar.DATE);

        if (LESS_THAN_FOUR_MONTHS && IS_SAME_YEAR){
            if (LESS_THAN_TWO_MONTHS && IS_SAME_YEAR && IS_SAME_DATE) {
                return abs()*0.8;
            }
            return abs()*0.6;
        }else
            return abs()*0.95;
    }
}
