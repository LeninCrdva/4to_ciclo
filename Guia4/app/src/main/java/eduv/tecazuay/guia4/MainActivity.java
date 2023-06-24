package eduv.tecazuay.guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import eduv.tecazuay.guia4.io.AnalyzeApiAdapter;
import eduv.tecazuay.guia4.io.ApiService;
import eduv.tecazuay.guia4.io.ExtractApiAdapter;
import eduv.tecazuay.guia4.io.LanguajeApiAdapter;
import eduv.tecazuay.guia4.model.Analyze;
import eduv.tecazuay.guia4.model.Entity;
import eduv.tecazuay.guia4.model.Extract;
import eduv.tecazuay.guia4.model.Languaje;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btn_detect;
    Button btn_extract;
    Button btn_analyze;
    EditText txt_to_analyze;
    EditText txt_to_detect;
    EditText txt_to_extract;
    TextView show_detect;
    TextView show_analyze;
    TextView show_type;
    TextView show_entity;
    HttpLoggingInterceptor loggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_analyze = findViewById(R.id.btnAnalyze);
        btn_detect = findViewById(R.id.buttonToDetect);
        btn_extract = findViewById(R.id.btnExtract);
        txt_to_analyze = findViewById(R.id.txtAnalyze);
        txt_to_detect = findViewById(R.id.detectInputText);
        txt_to_extract = findViewById(R.id.txtExtract);
        show_detect = findViewById(R.id.viewDetect);
        show_analyze = findViewById(R.id.showAnalyze);
        show_type = findViewById(R.id.showType);
        show_entity = findViewById(R.id.showEntity);
        loggin = new HttpLoggingInterceptor();

        btn_analyze.setOnClickListener(l -> analyzeFeels());
        btn_detect.setOnClickListener(l -> detectText());
        btn_extract.setOnClickListener(l -> extractEntities());
    }

    public void analyzeFeels() {
        String textToDetect = txt_to_analyze.getText().toString().trim();

        Call<Analyze> call = AnalyzeApiAdapter.getApiService().ANALYZE_CALL(textToDetect);

        call.enqueue(new Callback<Analyze>() {
            @Override
            public void onResponse(Call<Analyze> call, Response<Analyze> response) {
                if(response.isSuccessful() && response.body() != null){
                    txt_to_detect.getText().clear();
                    String tokenInter = response.body().getSentimentClassificationResult();

                    show_analyze.setText(tokenInter);

                    Toast.makeText(MainActivity.this, "Se ha realizado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error, escriba el texto en inglés para su análisis", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Analyze> call, Throwable t) {
                Toast.makeText(MainActivity.this, "LO SENTIMOS HUBO UN ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void detectText(){
        String textToDetect = txt_to_detect.getText().toString().trim();

        Call<Languaje> call = LanguajeApiAdapter.getApiService().DETECT_CALL(textToDetect);

        call.enqueue(new Callback<Languaje>() {
            @Override
            public void onResponse(Call<Languaje> call, Response<Languaje> response) {
                if(response.isSuccessful() && response.body() != null){
                    txt_to_detect.getText().clear();
                    String tokenInter = response.body().getDetectedLanguage_FullName();

                    show_detect.setText(tokenInter);

                    Toast.makeText(MainActivity.this, "Se ha realizado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Languaje> call, Throwable t) {
                Toast.makeText(MainActivity.this, "LO SENTIMOS HUBO UN ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void extractEntities(){
        String textToDetect = txt_to_extract.getText().toString().trim();

        Call<Extract> call = ExtractApiAdapter.getApiService().EXTRACT_CALL(textToDetect);

        call.enqueue(new Callback<Extract>() {
            @Override
            public void onResponse(Call<Extract> call, Response<Extract> response) {
                if(response.isSuccessful() && response.body() != null){
                    txt_to_detect.getText().clear();
                    Entity[] tokenInter = response.body().getEntities();

                    String joinedText = joinEntityTexts(tokenInter);
                    String joinedType = joinTypeTexts(tokenInter);
                    show_entity.setText(joinedText);
                    show_type.setText(joinedType);

                    Toast.makeText(MainActivity.this, "Se ha realizado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Extract> call, Throwable t) {
                Toast.makeText(MainActivity.this, "LO SENTIMOS HUBO UN ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String joinEntityTexts(Entity[] entities) {
        return Arrays.stream(entities)
                .map(Entity::getEntityText)
                .collect(Collectors.joining(", "));
    }

    private String joinTypeTexts(Entity[] entities) {
        return Arrays.stream(entities)
                .map(Entity::getEntityType)
                .collect(Collectors.joining(", "));
    }
}