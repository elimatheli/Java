


public class BikeStation {

  private String name;
	private Bike[] station;

    /** create a BikeStation with given name and capacity
     * @param name this BikeStation's name
		 * @param capacity this BikeStation's capacity
     */
	public BikeStation(String name, int capacity) {
	    this.name = name ;
			this.station = new Bike[capacity] ;
			for (int i=0 ; i<capacity ; i++ ) {
				this.station[i] = null ;
			}
	}

    /** returns the name of this BikeStation
     * @return the name of this BikeStation
     */
	public String getName() {
		return this.name ;
	}

    /** returns the capacity of this BikeStation
     * @return the capacity of this BikeStation
     */
	public int getCapacity() {
		return this.station.length ;
	}

    /** returns the number of Bikes in this BikeStation
     * @return the number of Bikes in this BikeStation
     */
	public int getNumberOfBikes() {
		int cpt = 0 ;
		for (int i=0 ; i<this.getCapacity() ; i++ ) {
			if (this.station[i] instanceof Bike) cpt++ ;
		}
		return cpt ;
	}


    /** returns the index of the first free slot of this BikeStation
		 * -1 is returned if any slot is free
     * @return the index of the first free slot of this BikeStation, -1 is returned if any slot is free
     */
	public int firstFreeSlot() {
		for (int i=0 ; i<this.getCapacity() ; i++ ) {
			if (this.station[i]==null) return i ;
		}
		return -1 ;
	}

    /** drops a Bike at the first free slot of this BikeStation if possible
     * @param bike the bike we want to drop in this BikeStation
		 * @return <code>true</code> iff there was a free slot where we dropped the bike
     */
	public boolean dropBike(Bike bike) {
	    int index = this.firstFreeSlot();
			if (index!=-1){
				this.station[index] = bike ;
				return true ;
			}
	    return false ;
	}



    /** takes a Bike in this BikeStation
     * @param i the index of this station where we try to take a Bike
		 * @return if a Bike exists at i position the Bike is returned else null is returned
     */
	public Bike takeBike(int i) {
	    if (i>=0 && i<=this.getCapacity()) {
				Bike res = this.station[i] ;
				this.station[i] = null ;
				return res ;
			}
	    return null;
	}


}
