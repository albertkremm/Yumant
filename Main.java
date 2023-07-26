public class Main {
    public static void main(String[] args) {
        MetalCalc metalCalc = new MetalCalc();
        GasCalc gasCalc = new GasCalc();
        double density = metalCalc.getDensity();
        metalCalc.sheetForm(density);
        double thick = metalCalc.returnThick();
        gasCalc.timeInput();

        if (density == 8) {
            gasCalc.stainlessConsumptionCalc(thick);
        } else if (density == 7.85) {
            gasCalc.mildPlasmaConsumption(thick);
            gasCalc.mildGasConsumption(thick);
        } else if (density == 2.7) {
            System.out.println("Таблица расходов газа" +
                    " при резке алюминия еще в разработке");
        }

        PriceCalc priceCalc = new PriceCalc();
        String materialName = priceCalc.setMaterialName();
        priceCalc.priceCalculation(materialName);
    }
}
