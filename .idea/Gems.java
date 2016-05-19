
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Gwindblaid on 16.05.2016.
 */

public class Gems {
    protected int id;
    protected double weight;
    protected String name;
    protected double refraction;
    protected BigDecimal price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getRefraction() {
        return refraction;
    }
}

class Diamond extends Gems {
    final  int moosHardness = 10;
    final double diamondRefraction = 2.418;

    public Diamond(double weight) {
        this.weight = weight;

    }

    public int getMoosHardness() {
        return moosHardness;
    }

    public double getRefraction() {
        return refraction = diamondRefraction;
    }
//Используем BigDecimal для точного вычисления цены драгоценного камня
    public final BigDecimal getPrice() {
        BigDecimal a = new BigDecimal(this.weight);
        BigDecimal b = new BigDecimal(1200);
        price  = a.multiply(b).setScale(1, RoundingMode.CEILING);
        return price;
    }

    public String toString() {
        return "Id "+id+"\n"+
                name+"\n"+
                "Weight "+weight+" carat"+"\n"+
                "Moos Hardness "+moosHardness+"\n"+
                "Refraction "+refraction+"\n"+
                "Price "+getPrice()+" $"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diamond diamond = (Diamond) o;

        if (moosHardness != diamond.moosHardness) return false;
        return Double.compare(diamond.diamondRefraction, diamondRefraction) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = moosHardness;
        temp = Double.doubleToLongBits(diamondRefraction);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Corund extends Gems {
    private final  int moosHardness = 9;
    final double corundRefraction = 1.778;

    public Corund(double weight) {
        this.weight = weight;
    }

    public int getMoosHardness() {
        return moosHardness;
    }

    public double getRefraction() {
        return refraction = corundRefraction;
    }

    final public BigDecimal getPrice() {
        BigDecimal a = new BigDecimal(this.weight);
        BigDecimal b = new BigDecimal(800);
        price  = a.multiply(b).setScale(1,RoundingMode.CEILING);
        return price;
    }

    public String toString() {
        return "Id "+id+"\n"+
                name+"\n"+
                "Weight "+weight+" carat"+"\n"+
                "Moos Hardness "+moosHardness+"\n"+
                "Refraction "+refraction+"\n"+
                "Price "+getPrice()+" $"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corund)) return false;

        Corund corund = (Corund) o;

        if (moosHardness != corund.moosHardness) return false;
        return Double.compare(corund.corundRefraction, corundRefraction) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = moosHardness;
        temp = Double.doubleToLongBits(corundRefraction);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Aquamarin extends Gems {
    private final  int moosHardness = 8;
    private final double aquamarinRefraction = 1.596;

    public Aquamarin(double weight) {
        this.weight = weight;
    }

    public int getMoosHardness() {
        return moosHardness;
    }

    public double getRefraction() {
        return refraction = aquamarinRefraction;
    }

    final public BigDecimal getPrice() {
        BigDecimal a = new BigDecimal(this.weight);
        BigDecimal b = new BigDecimal(50);
        price  = a.multiply(b).setScale(1,RoundingMode.CEILING);
        return price;
    }

    public String toString() {
        return "Id "+id+"\n"+
                name+"\n"+
                "Weight "+weight+" carat"+"\n"+
                "Moos Hardness "+moosHardness+"\n"+
                "Refraction "+refraction+"\n"+
                "Price "+getPrice()+" $"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aquamarin aquamarin = (Aquamarin) o;

        if (getMoosHardness() != aquamarin.getMoosHardness()) return false;
        return Double.compare(aquamarin.aquamarinRefraction, aquamarinRefraction) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMoosHardness();
        temp = Double.doubleToLongBits(aquamarinRefraction);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Beril extends Gems {

    private final  int moosHardness = 8;
    final double berilRefraction = 1.763;

    public Beril (double weight) {
        this.weight = weight;

    }

    public int getMoosHardness() {
        return moosHardness;
    }

    public double getRefraction() {
        return refraction = berilRefraction;
    }

    final public BigDecimal getPrice() {
        BigDecimal a = new BigDecimal(this.weight);
        BigDecimal b = new BigDecimal(50);
        price  = a.multiply(b).setScale(1,RoundingMode.CEILING);
        return price;
    }

    public String toString() {
        return "Id "+id+"\n"+
                name+"\n"+
                "Weight "+weight+" carat"+"\n"+
                "Moos Hardness "+moosHardness+"\n"+
                "Refraction "+refraction+"\n"+
                "Price "+getPrice()+" $"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beril beril = (Beril) o;

        if (moosHardness != beril.moosHardness) return false;
        return Double.compare(beril.berilRefraction, berilRefraction) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = moosHardness;
        temp = Double.doubleToLongBits(berilRefraction);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
