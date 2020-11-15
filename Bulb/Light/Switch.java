 /**
 * a class for Switch
 * 
 * @author VISEUX et HWANG
 * @version 1.0
 */
public class Switch
{
    private Lightbulb bulb ;

    /**
     * Builds a Switch connected to one lightbulb
     * @param bulb
     *      the lightbulb this switch is connected to
     */
    public Switch(Lightbulb bulb)
    {
        this.bulb = bulb ;
    }

    /**
     * lights on the lightbulb if it is off,
     * lights it off otherwise
     */
    public void buttonPush()
    {
        if (this.bulb.isOn()){
            this.bulb.lightOff() ; 
        }else{
            this.bulb.lightOn() ;
        }
    }
}
