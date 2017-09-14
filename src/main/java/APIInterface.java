import model.Document;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIInterface {
    @GET("/hello")
    Call<Document> getHello();

    @GET("/posts/{id}")
    Call<Document> getDocument(@Path("id") String id);

    @POST("/posts")
    @Headers("Content-Type: application/json")
    Call<Document> saveDocument(@Body Document document);
}
