import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

// Comandos de execução via terminal
// Executa todas as classes = "mvn test"
// Executa todos os testes da classe  "mvn-Dtest=BookingTest test"
// Executa teste especifico na classe "mvn -Dtest=BookingTest#cadastrarReserva test"
// Executar testes agrupados por tag (com JUnit5) @Tag("NomeTag") "mvn test -Dgooup=NomeDoGrupo"
// Comandos para Gerar report no terminal = "mvn allure:repot" depois "mvn allure:serve"
// Usar depois de gerar relatorio ou executar teste "mvn clean test"



public class BookingTest {

    public String lerJson(String caminhoArquivo) throws IOException {
        return  new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
    }

    // Define um método de teste
    @Test
    public void testGetBooking() {
        // Configura a URL base para as requisições da API
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Configura e executa a requisição GET para o endpoint "/booking/"
        given() // Define as configurações da requisição (headers, parâmetros, etc.)
                .header("Accept", "*/*") //adiciona o header accept

        .when() // Indica o início da execução da requisição
                .get("/booking/") // Especifica o endpoint a ser chamado

        .then() // Define as validações da resposta
                .statusCode(200) // Verifica se o status code da resposta é 200 (OK)
                .log().all();    // Loga no console todos os detalhes da resposta (body, headers, etc.)
    }

    @Test
    public void testComId(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        given()
                .header("Accept", "application/json")
        .when()
                .get("/booking/134")
        .then()
                .statusCode(200)
                .body("firstname", equalTo("Ederson"))
                .body("lastname", equalTo("Mota"))
                .body("totalprice", equalTo(2500))
                .body("depositpaid", is(true))
                .body("bookingdates.checkin", equalTo("2025-11-01"))
                .body("bookingdates.checkout", equalTo("2025-12-25"))
                .body("additionalneeds", equalTo("Breakfast and Dinner"));
    }

    @Tag("Reserva")
    @Test
    public void cadastrarReserva() throws IOException {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String jsonBody = lerJson("src/test/resources/payloads/reserva.json");

        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .log().all()
        .when()
                .post("/booking")
        .then()
                .log().all()
                .statusCode(200)
                .body("booking.firstname", equalTo("Edinho"))
                .body("booking.lastname", equalTo("Mota"))
                .body("booking.totalprice", equalTo(2500))
                .body("booking.depositpaid", is(true))
                .body("booking.bookingdates.checkin", equalTo("2025-11-01"))
                .body("booking.bookingdates.checkout", equalTo("2025-12-25"))
                .body("booking.additionalneeds", equalTo("Breakfast and Dinner"));
        }




    }



