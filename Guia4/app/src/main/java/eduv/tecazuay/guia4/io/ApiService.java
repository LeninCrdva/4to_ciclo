package eduv.tecazuay.guia4.io;

import eduv.tecazuay.guia4.model.Analyze;
import eduv.tecazuay.guia4.model.Extract;
import eduv.tecazuay.guia4.model.Languaje;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("detect")
    Call<Languaje> DETECT_CALL(
            @Field("textToDetect") String textToDetect
    );

    @FormUrlEncoded
    @POST("extract-entities")
    Call<Extract> EXTRACT_CALL(
            @Field("InputString") String inputString
    );

    @FormUrlEncoded
    @POST("sentiment")
    Call<Analyze> ANALYZE_CALL(
            @Field("TextToAnalyze") String TextToAnalyze
    );
}
