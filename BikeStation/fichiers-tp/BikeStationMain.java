public class BikeStationMain{
  public static void main(String[] args){
    if (args.length<1){
      System.out.println("usage: java BikeStationMain <int>");
      System.exit(0);
    }

    BikeStation station = new BikeStation("Timoleon",10);
    station.dropBike(new Bike("b001", BikeModel.CLASSICAL));
    station.dropBike(new Bike("b002", BikeModel.ELECTRIC));

    Bike taken = station.takeBike(Integer.parseInt(args[0]));

    if (taken!=null) {
      System.out.println(taken.toString());
      System.out.println("Its rental price is "+Bike.price);
    }else{
      System.out.println("There isn't any bike at that position of the station, we are so sorry. Please try another position");
    }
  }  
}
