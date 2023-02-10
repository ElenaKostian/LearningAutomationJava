package jsonplaceholder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ApiTest {
	private String endpoint = "https://jsonplaceholder.typicode.com/users";

	@Test
	public void status200Test() { 
		given().when().get(endpoint).then().assertThat().statusCode(200);
	}
	
	@Test
	public void headerContentTypeTest() {
		given().when().get(endpoint).then().log().headers().assertThat().contentType("application/json; charset=utf-8");
	}
	
	@Test
	public void bodyCountOfUsersTest() {
		given().when().get(endpoint).then().log().body().assertThat().body("user.size()", equalTo(10));
	}
	
}
