package be.helb.arami.Configuration;

import be.helb.arami.Client.FighterApiClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class FeignConfiguration {

    @Bean
    @Qualifier("dataAccessTracingClient")
    public FighterApiClient fighterApiClient(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FighterApiClient.class, "http://localhost:8080/");
    }
}