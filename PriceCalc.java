import java.util.Scanner;

public class PriceCalc {
    public double cutPrice;
    public double metalPrice;
    public String materialName;
    public double totalCost;
    public double coefficient;

    public String setMaterialName() {
        MetalCalc material = new MetalCalc();
        double density = material.getDensity();

        if (density == 8) {
            this.materialName = " нержавейки ";
        } else if (density == 7.85) {
            this.materialName = " черной стали ";
        } else if (density == 2.7) {
            this.materialName = " алюминия ";
        }
        return this.materialName;
    }

    public double priceCalculation(String materialName) {
        GasCalc timeCalc = new GasCalc();
        double time = timeCalc.timeReturn();

        MetalCalc metal = new MetalCalc();
        double weight = metal.returnWeight();

        this.cutPrice = (time / 0.75) * 130;

        Scanner metalCostInput = new Scanner(System.in);
        System.out.print("Введите стоимость материала за 1 кг: ");
        double metalCost = metalCostInput.nextDouble();
        this.metalPrice = metalCost * weight;
        this.totalCost = cutPrice + metalPrice;
        System.out.println("\nСтоимость листа " + this.materialName +
                " составляет :" + metalPrice + "руб");
        System.out.println("Стоимость резки: " + cutPrice + "руб.");
        System.out.println("Итоговая стоимость заказа" +
                " составляет: " + totalCost + " руб.");
        return this.totalCost;
    }

    public void coefficientCalc() {
        double totalCost = this.totalCost;
        System.out.println("\nРассчитать коэффициент?" +
            "1. Да" +
            "2. Выйти");
        Scanner c = new Scanner (System.in);
        int selection = c.nextInt();

        if (selection == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Какой коэффициент расчитать? " +
                    "Введите число или десятичную дробь: ");
            this.coefficient = scanner.nextDouble();
        } else if (selection == 2) {
            System.exit(0);
        }
    }
}
