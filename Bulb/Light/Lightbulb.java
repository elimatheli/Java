 /**
 * a class for Lightbulb
 * 
 * @author VISEUX et HWANG 
 * @version 1.0
 */
public class Lightbulb
{
    private boolean on ;
    private double power ;
    private String color ;
    
    /**
     * Builds a Lightbulb
     * @param power
     *      the power of this lightbulb (Watt)
     * @param color
     *      the color of this lightbulb
     */
    public Lightbulb(double power, String color) {
        this.on = false ;
        this.power = power ;
        this.color = color ;
    }
    
    /**
     * switches on this lightbulb
     */
    public void lightOn(){
        this.on = true ;
    }
    
    /**
     * switches off this lightbulb
     */
    public void lightOff(){
        this.on = false ;
    }
    
    /**
     * returns true if this lightbulb is on, false otherwise
     * @return true if this lightbulb is on, false otherwise
     */
    public boolean isOn(){
        return this.on ;
    }
    
    /**
     * returns true if this lightbulb is off, false otherwise
     * @return true if this lightbulb is off, false otherwise
     */
    public boolean isOff(){
        return !this.on ;
    }
    
    /**
     * returns the power of this lightbulb
     * @return the power of this lightbulb
     */
    public double getPower(){
        return this.power ;
    }
    
    /**
     * returns the color of this lightbulb
     * @return the color of this lightbulb
     */
    public String getColor(){
        return this.color ;
    }
    
    /**
     * returns the description of this lightbulb
     * @return the description of this lightbulb
     */
    public String toString(){
        return "On: "+this.on+" , Color: "+this.color+" , Power: "+this.power+"Watt" ;
    }
}