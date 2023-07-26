import java.util.Scanner;

public class MetalCalc {
    public double weight;
    public double thick;
    public double length;
    public double wide;
    public double density;
    public double diameter;

    public double getDensity() {
        title();
        System.out.println("Выберите тип металла: ");
        System.out.println("1. Черная сталь");
        System.out.println("2. Нержавеющая сталь");
        System.out.println("3. Алюминий");
        System.out.print("Ваш выбор: ");

        Scanner dens = new Scanner(System.in);
        int densitySelect = dens.nextInt();

        switch (densitySelect) {
            case 1:
                this.density = 7.85;
                break;

            case 2:
                this.density = 8;
                break;

            case 3:
                this.density = 2.7;
                break;

            default:
                System.out.println("Ошибка!");
        }

        return this.density;
    }

    public void sheetForm(double density) {
        title();
        System.out.println("Выберите форму: ");
        System.out.println("1. Прямоугольная");
        System.out.println("2. Круглая");
        System.out.print("Ваш выбор: ");

        Scanner form = new Scanner(System.in);
        int formSelection = form.nextInt();

        switch (formSelection) {
            case 1:
                rectangleCalc(this.density);
                break;

            case 2:
                circleCalc(this.density);
                break;

            default:
                System.out.println("Ошибка!");
        }
    }

    public void rectangleCalc(double density) {
        title();
        Scanner rect = new Scanner(System.in);
        System.out.println("Введите размеры листа в мм: ");
        System.out.print("Толщина: ");
        this.thick = rect.nextDouble();
        System.out.print("Длина: ");
        this.length = rect.nextDouble();
        System.out.print("Ширина: ");
        this.wide = rect.nextDouble();

        this.weight = this.thick * this.length * this.wide * this.density / 1000000;
        System.out.println("Лист весит " + weight + " кг");
    }

    public void circleCalc(double density) {
        title();
        Scanner circ = new Scanner(System.in);
        System.out.print("Толщина: ");
        this.thick = circ.nextDouble();
        System.out.print("Диаметр: ");
        this.diameter = circ.nextDouble();

        double radius = this.diameter / 2;
        double circleSquare = Math.PI * (Math.pow(radius, 2));

        this.weight = this.thick * circleSquare * this.density / 1000000;
        System.out.println("Лист весит " + weight + " кг");
    }

    public double returnWeight() {
        return this.weight;
    }

    public double returnThick() {
        return this.thick;
    }

    public void title() {
        System.out.println("\033\143");
        System.out.println("Калькулятор Металла\n");
    }
}