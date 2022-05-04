import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataIn = new Scanner(System.in);
        String reservationData;
        HotelReservation challenge = new HotelReservation();

        System.out.println("=================================================================================");
        System.out.println("Favor inserir os dados no formato <tipo_do_cliente>: <data1>, <data2>, <data3>, …");
        reservationData = dataIn.nextLine();
        System.out.println("=================================================================================");
        System.out.println("O nome do hotel mais barato é: " + challenge.getCheapestHotel(reservationData));
        System.out.println("Pressione ENTER para finalizar");
        dataIn.next();

    }

}
