public class BikeMain{
  public static void main(String[] args){
    Bike b1 = new Bike("b001", BikeModel.CLASSICAL);
    Bike b2 = new Bike("b002", BikeModel.ELECTRIC);
    System.out.println("Those bikes are equal : "+ b1.equals(b2));
    System.out.println(b1.toString());
    System.out.println("Its rental price is "+Bike.price);
  }
}
