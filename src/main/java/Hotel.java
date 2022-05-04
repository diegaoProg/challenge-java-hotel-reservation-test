public class Hotel {
    private int hotelRating;
    double totalValue = 0.0;

    public double lakewoodPrice(String clientType, String period){
        if (clientType.equalsIgnoreCase("Regular")){
            for (String date: period.split(", ")){
                if (date.charAt(10) == 's'){
                    totalValue += 90.0;
                } else {
                    totalValue += 110.0;
                }
            }
        } else {
            for (String date: period.split(", ")){
                totalValue += 80.0;
            }
        }
        return totalValue;
    }
    public double bridgewoodPrice(String clientType, String period){
        if (clientType.equalsIgnoreCase("Regular")){
            for (String date: period.split(", ")){
                if (date.charAt(10) == 's'){
                    totalValue += 60.0;
                } else {
                    totalValue += 160.0;
                }
            }
        } else {
            for (String date: period.split(", ")){
                if (date.charAt(10) == 's'){
                    totalValue += 50.0;
                } else {
                    totalValue += 110.0;
                }
            }
        }
        return totalValue;
    }

    public double ridgewoodPrice(String clientType, String period){
        if (clientType.equalsIgnoreCase("Regular")){
            for (String date: period.split(", ")){
                if (date.charAt(10) == 's'){
                    totalValue += 150.0;
                } else {
                    totalValue += 220.0;
                }
            }
        } else {
            for (String date: period.split(", ")){
                if (date.charAt(10) == 's'){
                    totalValue += 40.0;
                } else {
                    totalValue += 100.0;
                }
            }
        }
        return totalValue;
    }

}