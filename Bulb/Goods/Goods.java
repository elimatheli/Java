/**
 * a class for Goods
 * 
 * @author VISEUX et HWANG
 * @version 1.0
 */
public class Goods
{
    private double value ;
    private String name ;
    /**
     * Builds a Goods, initially its value worths zero 
     * and it's named by the parameter name
     * 
     * @param name
     *      the name of the good
     */
    public Goods (String name) {
        this(name,0) ;
    }
    
    /**
     * Builds a Goods, its value is the parameter value 
     * and its name is the parameter name
     * 
     * @param name
     *      the name of the good
     * @param value
     *      the value of the good
     */
    public Goods (String name, int value) {
        this.name = name ;
        this.value = value ;
    }
    
    /**
     * returns the value of the good
     * 
     * @return the value of the good
     */
    public double getValue () {
        return this.value ;
    }
    
    /**
     * changes the value of the good
     * 
     * @param newValue
     *      the new value of the good to set
     */
    public void setValue (int newValue) {
        this.value = newValue ;
    }
    
    /**
     * returns the name of the good
     * 
     * @return the name of the good
     */
    public String getName (){
        return this.name ;
    }
    
    /**
     * returns the String representation of the good
     * 
     * @return the String representation of the good
     */
    public String toString (){
        return "the goods "+this.name+" costs "+this.value ;
    }
    
    /**
     * returns TTC value of the good
     * 
     * @return TTC value of the good
     */
    public double getTtc (){
        double ttc = this.value*1.2;
        return ttc ;
    }
}