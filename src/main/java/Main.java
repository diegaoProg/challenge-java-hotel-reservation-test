import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataIn = new Scanner(System.in);
        String reservationData, newData = "s";
        HotelReservation challenge = new HotelReservation();

        while (!newData.equalsIgnoreCase("n")) {
            System.out.println("==========================================================");
            System.out.println("Favor inserir os dados de entrada do programa no formato");
            System.out.println("<tipo_do_cliente>: <DTMonYEAR(d_o_w)>, <data2>, <data3>, …");
            reservationData = dataIn.nextLine();
            System.out.println("==========================================================");
            System.out.println("O nome do hotel mais barato é: " + challenge.getCheapestHotel(reservationData));
            System.out.println("Deseja inserir novos dados? (s/n)");
            newData = dataIn.nextLine();
        }
        dataIn.close();

    }

}
