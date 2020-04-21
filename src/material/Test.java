package material;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Material[] materials = init();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Material material:materials){
            Date date = dateFormat.parse(material.abstrc());

            Calendar today = Calendar.getInstance();

            Calendar exp = Calendar.getInstance();
            exp.setTime(date);

            double sale = material.abs() - material.discount();;
            String amount = "";

            if (material instanceof Meat){
                amount = "Khối lượng: " + ((Meat) material).getWeight()+ ((Meat) material).getUnit();
            }else if (material instanceof TempuraFlour){
                amount = "Số lượng: " + material.quantity;
            }

            System.out.println("Tên sản phẩm: " + material.getName());
            System.out.println(amount);
            System.out.println("Giá tiền: " + material.getCost());
            System.out.println("Tổng tiền: " + material.abs() + " đồng");
            System.out.println("Chiết khấu: " + material.discount() + " đồng");
            System.out.println("Thành tiền: " + sale + " đồng");
            System.out.println("NSX: " + material.getMfd());
            System.out.println("HSD: " + material.abstrc());
            System.out.println("");
        }
    }

    public static Material[] init(){
        Material m1 = new Meat(1, "m1","3/4/2020", 20000, " (100g)", 5);
        Material m2 = new Meat(2, "m2","20/5/2020", 25000, " (100g)", 3);
        Material m3 = new Meat(3, "m3","20/6/2020", 30000, " (100g)", 7);
        Material m4 = new Meat(4, "m4","20/7/2020", 16000, " (100g)", 20);
        Material m5 = new Meat(5, "m5","20/8/2020", 22000, " (100g)", 10);

        Material t1 = new TempuraFlour(6, "t1", "23/4/2020", 50000, 3);
        Material t2 = new TempuraFlour(7, "t2", "17/7/2019", 58000, 2);
        Material t3 = new TempuraFlour(8, "t3", "22/5/2020", 55000, 1);
        Material t4 = new TempuraFlour(9, "t4", "20/4/2020", 54000, 5);
        Material t5 = new TempuraFlour(10, "t5", "5/4/2019", 60000, 6);

        Material[] materials = new Material[10];
        materials[0] = m1;
        materials[1] = m2;
        materials[2] = m3;
        materials[3] = m4;
        materials[4] = m5;
        materials[5] = t1;
        materials[6] = t2;
        materials[7] = t3;
        materials[8] = t4;
        materials[9] = t5;
        return materials;
    }
}
