import model.HotelModel;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    private String errorMessage;
    private String[] params;
    private String clientType;
    private List<HotelModel> hotels;

    public HotelReservation() {
        getHotels();
    }

    public String getCheapestHotel(String input) {
        double cheapestPrice = 0;
        HotelModel cheapestHotel = null;

        if (validateInput(input)) {
            clientType = params[0];
            String[] reservationDates = params[1].split(", ");

            for (HotelModel hotel: hotels) {
                double price = hotel.getTotalPrice(clientType, reservationDates);

                //Compara o preço do hotel atual com o último preço mais barato. Em caso negativo, faz uma segunda
                //validação para ver se os preços são iguais.
                if (cheapestPrice == 0 || cheapestPrice > price){
                    cheapestPrice = price;
                    cheapestHotel = hotel;
                } else if (cheapestPrice == price && cheapestHotel.rating < hotel.rating){
                    cheapestHotel = hotel;
                }
            }

            String hotelName = "";

            if (cheapestHotel != null){
                hotelName = cheapestHotel.name;
            }

            return hotelName;
        }

        return errorMessage;
    }

    private Boolean validateInput(String input) {
        params = input.split(":");
        clientType = params[0];

        if (params.length < 2) {
            errorMessage = "Parâmetros incorretos! Por favor, informe todos os parâmetros no formato: '<tipo_do_cliente>: <data1>, <data2>, <data3>, ...'";
            return false;
        }

        if (!clientType.equalsIgnoreCase("Regular") && !clientType.equalsIgnoreCase("Rewards")) {
            errorMessage = "Tipo de cliente inválido.";
            return false;
        }

        return true;
    }

    private void getHotels(){
        hotels = new ArrayList<>();

        hotels.add(new HotelModel("Lakewood", 3, 110, 90, 80, 80));
        hotels.add(new HotelModel("Bridgewood", 4, 160, 60, 110, 50));
        hotels.add(new HotelModel("Ridgewood", 5, 220, 150, 100, 40));
    }
}

//Separação de string (separar os 4 parametros da string recebida pela função getCheapestHotel)
//1º Split por ":" (dois pontos)
//2º Split por "," (datas)

//Validações de entrada:
//Verificar se foram inseridos 4 parametros
//Validar se param1 é "Regular" ou "Reward"
//Validar se param2, param3 e param4 são datas válidas
//Validar se o formato de data é válido
//Validar se a data é > hoje

//Manipulação de DateTime:
//Verificar se a data é dia útil ou fim de semana

//Calcular preço do período para os 3 hotéis
//Selecionar o hotel mais barato naquele período, para o tipo de cliente informado.
//Se der empate no preço, o critério de desempate é a classificação do hotel

//Criar testes unitários
