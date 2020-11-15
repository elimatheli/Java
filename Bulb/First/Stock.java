/**
 * a class for Stocks
 *
 * @author VISEUX et HWANG
 * @version 1.0
 */
public class Stock
{
    private int quantity;

    /**
     * Builds a Stock, initially its quantity worths zero.
     */
    public Stock () {
        this.quantity = 0 ;
    }

    /**
      * returns the current quantity of the stock.
      *
      *
      * @return the current quantity
      */
    public int getQuantity () {
        return this.quantity ;
    }

    /**
     * get the current quantity of the stock.
     *
     *
     * @param n
     *         an interger representing the number of elements to add to the stock.
     */
    public void add (int n) {
        this.quantity += n ;
    }

    /**
     * removes elements from the current quantity of the stock
     * and returns the number of elements it removed
     *
     * @param destock
     *         an interger representing the number of elements to remove from the stock.
     * @return the number of elements it removed
     */
    public int remove (int destock) {
        if (destock<=this.quantity){
            this.quantity -= destock ;
            return destock ;
        }else{
            int temp = this.quantity ;
            this.quantity = 0 ;
            return temp ;
        }
    }

    /**
     * returns the String representation of the stock
     *
     * @return the String representation of the stock
     */
    public String toString () {
        return "the stock’s quantity is "+this.quantity ;
    }

    /**
     * Builds a Stock, initially its quantity worths the value of the paramater.
     *
     * @param nb
     *      the initial quantity of the stock
     */
    public Stock (int nb) {
        this.quantity = nb ;
    }

    public static void main(String[] args){
      if (args.length<1){
        System.out.println("usage: java Stock <unEntier>");
        System.exit(0);
      }

      Stock someStock = new Stock();
      someStock.add(Integer.parseInt(args[0]));
      System.out.println(someStock.getQuantity());
    }
}
