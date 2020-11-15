 /**
 * a class for LightString
 * 
 * @author VISEUX et HWANG
 * @version 1.0
 */
public class LightString
{
    private Lightbulb[] lights ;

    /**
     * Builds a LightString
     * @param nb
     *      the number of lightbulbs one the lightsrting
     */
    public LightString(int nb)
    {
        lights = new Lightbulb[nb] ;
        for (int i=0;i<nb;i++){
            lights[i] = new Lightbulb(1,"white");
        }
    }

    /**
     * lights on all the lightbulbs on this lightstring
     */
    public void allOn()
    {
        for (int i=0;i<this.lights.length;i++){
            lights[i].lightOn() ;
        }
    }
    
    /**
     * lights off all the lightbulbs on this lightstring
     */
    public void allOff()
    {
        for (int i=0;i<this.lights.length;i++){
            lights[i].lightOff() ;
        }
    }
    
    /**
     * returns the lightbulb at the index given
     * @param index
     *      the number of the lightbulb we want to get (first has number 1)
     * @return the lightbulb at the index given
     */
    public Lightbulb getByIndex(int index){
        index-- ;
        if (index<0 || index>=this.lights.length){
            return null ;            
        }
        return this.lights[index] ;
    }
    
    /** replace the n-th lightbulb of the light string by the given lightbulb.
    * Nothing happens if i is not a valid index.
    * @param i the number of the lightbulb to be changed (first has number 1)
    * @param theBulb the new lightbulb
    */
    public void changeLightbulb(int i, Lightbulb theBulb){
        i-- ;
        if (i>=0 && i<this.lights.length){
             this.lights[i] = theBulb;
        }
    }
    
    /**
     * returns the total amount of power consumed by lightbulbs on
     * @return the total amount of power consumed by lightbulbs on
     */
    public double getConsumedPower()
    {
        double total = 0 ;
        for (int i=0;i<this.lights.length;i++){
            if (lights[i].isOn()){
                total += lights[i].getPower() ;
            }
        }
        return total ;
    }
}
