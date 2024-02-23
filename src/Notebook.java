import java.util.Objects;

public class Notebook {
    private String model;
    private int RAM;
    private int ValueHD;
    private String OS;
    private String color;
    public Notebook(String model, int RAM,int ValueHD, String OS, String color){
        this.model = model;
        this.RAM = RAM;
        this.ValueHD = ValueHD;
        this.OS = OS;
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setValueHD(int valueHD) {
        ValueHD = valueHD;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getRAM() {
        return RAM;
    }

    public int getValueHD() {
        return ValueHD;
    }

    public String getColor() {
        return color;
    }

    public String getOS() {
        return OS;
    }


    @Override
    public String toString() {
        return String.format("\nМодель %s: ОЗУ - %s Гб, объем ЖД - %s Гб, операционная система - %s, цвет - %s", model, RAM, ValueHD, OS,color);
    }
}
