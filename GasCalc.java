import java.util.Scanner;

public class GasCalc {
    double h, min, sec, time;
    double thick;
    String mode;
    double hydroGen;
    double nitroGen;
    double oxygen;
    double propane;

    double oxygenCan = 78750; //большая кислородная бочка

    Stainless[] h35n2 = {
            new Stainless("80A", 4, 2300, 8.4, 103),
            new Stainless("80A", 5, 17.500, 10, 103),
            new Stainless("80A", 6, 1500, 16, 103),
            new Stainless("80A", 8, 1000, 25, 55),

            new Stainless("130A", 8, 1300, 21.5, 68),
            new Stainless("130A", 10, 1000, 30, 48.5),
            new Stainless("130A", 12, 850, 30, 48.5),
            new Stainless("130A", 15, 600, 30, 48.5),
            new Stainless("130A", 20, 400, 30, 48.5),
            new Stainless("130A", 25, 30, 30, 48.5),

            new Stainless("260A", 10, 17.500, 40, 123),
            new Stainless("260A", 12, 1700, 40, 123),
            new Stainless("260A", 15, 1450, 40, 123),
            new Stainless("260A", 20, 1100, 40, 123),
            new Stainless("260A", 25, 750, 40, 123),
            new Stainless("260A", 30, 650, 40, 123),
            new Stainless("260A", 34, 550, 40, 123),
            new Stainless("260A", 40, 510, 40, 123),
            new Stainless("260A", 45, 390, 40, 123),
            new Stainless("260A", 50, 270, 40, 123),
            new Stainless("260A", 60, 200, 40, 123),
            new Stainless("260A", 100, 100, 40, 123),
    };

    Mild[] plasma = {
            new Mild("30A", 0.5, 17.5, 0),
            new Mild("30A", 0.8, 17.5, 0),
            new Mild("30A", 1, 17.5, 0),
            new Mild("30A", 1.2, 17.5, 0),
            new Mild("30A", 1.5, 17.5, 0),
            new Mild("30A", 2, 17.5, 0),
            new Mild("30A", 2.5, 17.5, 0),
            new Mild("30A", 3, 17.5, 0),
            new Mild("30A", 4, 17.5, 0),
            new Mild("30A", 5, 17.5, 0),
            new Mild("30A", 6, 17.5, 0), //готово

            new Mild("40A", 1.5, 4.5, 0),
            new Mild("40A", 2, 4.5, 0),
            new Mild("40A", 2.5, 4.5, 0),
            new Mild("40A", 3, 4.5, 0),
            new Mild("40A", 4, 4.5, 0),
            new Mild("40A", 5, 4.5, 0),
            new Mild("40A", 6, 4.5, 0), //готово

            new Mild("80A", 2, 10, 0),
            new Mild("80A", 2.5, 10, 0),
            new Mild("80A", 3, 10, 0),
            new Mild("80A", 4, 10, 0),
            new Mild("80A", 5, 10, 0),
            new Mild("80A", 6, 10, 0),
            new Mild("80A", 8, 10, 0),
            new Mild("80A", 10, 10, 0),
            new Mild("80A", 12, 10, 0),
            new Mild("80A", 15, 10, 0),
            new Mild("80A", 20, 10, 0), //готово

            new Mild("130A", 3, 16, 0),
            new Mild("130A", 4, 16, 0),
            new Mild("130A", 5, 16, 0),
            new Mild("130A", 6, 16, 0),
            new Mild("130A", 8, 16, 0),
            new Mild("130A", 10, 16, 0),
            new Mild("130A", 12, 16, 0),
            new Mild("130A", 15, 16, 0),
            new Mild("130A", 20, 16, 0),
            new Mild("130A", 25, 16, 0),
            new Mild("130A", 30, 16, 0), //готово

            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 6, 19, 0),
            new Mild("200A", 45, 27, 0),
            new Mild("200A", 50, 27, 0),

            new Mild("260A", 10, oxygen, propane)

    };

    Mild[] gas = {
            new Mild("GRICUT 10-25", 10, 0, 0),
    };

    public double timeInput() {
        Scanner timeInput = new Scanner(System.in);
        System.out.println("\nВведите время резки: ");

        System.out.print("Часы: ");
        this.h = timeInput.nextDouble();
        System.out.print("Минуты: ");
        this.min = timeInput.nextDouble();
        System.out.print("Секунды: ");
        this.sec = timeInput.nextDouble();

        this.time = (h * 60) + (sec / 60) + min;
        return this.time;
    }

    public double timeReturn() {
        return this.time;
    }

    public void stainlessConsumptionCalc(double thick) {
        for (Stainless stainless : h35n2) {
            this.thick = thick;
            if (stainless.thick == this.thick) {
                this.mode = stainless.mode;
                this.thick = stainless.thick;
                this.hydroGen = stainless.hydroGen;
                this.nitroGen = stainless.nitroGen;

                System.out.println("\nТолщина: " + this.thick);
                System.out.println("Режим резки: " + this.mode);
                System.out.println("Расход водорода (H35) - " + (int) ((hydroGen / 6300) * time) + " баллонов");
                System.out.println("Расход азота (N2) - " + (int) ((nitroGen / 5700) * time) + " баллонов\n");
            }
        }
    }

    public void mildGasConsumption(double thick) {
        for (Mild mild : gas) {
            this.thick = thick;
            if (mild.thick == this.thick) {
                this.mode = mild.mode;
                this.thick = mild.thick;
                this.oxygen = mild.oxygen;
                this.propane = mild.propane;

                System.out.println("\n Толщина: " + this.thick);
                System.out.println("Режим резки: " + this.mode);
                System.out.println("Расход кислорода - " + (int) ((oxygen / oxygenCan) * time) +
                        "% большой кислородной бочки");
                System.out.println("Расход пропана - " + (int) ((propane / 9500) * time) + " баллонов");

                if (this.thick > 40) {
                    System.out.println("Рекомендуется производить газокислородную резку!");
                }
            }
        }
    }

    public void mildPlasmaConsumption(double thick) {
        for (Mild mild : plasma) {
            this.thick = thick;
            if (mild.thick == this.thick) {
                this.mode = mild.mode;
                this.thick = mild.thick;
                this.oxygen = mild.oxygen;

                System.out.println("\nТолщина: " + this.thick);
                System.out.println("Режим резки: " + this.mode);
                System.out.println("Расход кислорода - " + (int) ((oxygen / oxygenCan) * time) + "% кислородной бочки");

                if (this.thick > 40) {
                    System.out.println("Рекомендуется производить газокислородную резку!");
                }
            }
        }
    }
}

class Stainless {
    public String mode;
    public double thick;
    public double speed;
    public double nitroGen;
    public double hydroGen;

    public Stainless(String mode, double thick, double speed, double hydroGen, double nitroGen) {
        this.mode = mode;
        this.thick = thick;
        this.speed = speed;
        this.hydroGen = hydroGen;
        this.nitroGen = nitroGen;
    }
}

class Mild {
    public String mode;
    public double thick;
    public double oxygen;
    public double propane;

    public Mild(String mode, double thick, double oxygen, double propane) {
        this.mode = mode;
        this.thick = thick;
        this.oxygen = oxygen;
        this.propane = propane;
    }
}