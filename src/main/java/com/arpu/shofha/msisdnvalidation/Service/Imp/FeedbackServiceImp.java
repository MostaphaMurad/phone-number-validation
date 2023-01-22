package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Service.FeedbackService;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionRequestV2;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionResponseV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

/**
 * @author: Mostafa Murad
 * @created: 1/12/2023 on 10:32 AM
 **/
@Service
@RequiredArgsConstructor
public class FeedbackServiceImp implements FeedbackService {
    public static final String baseUrl="http://localhost:9090/api/v2/valid-msisdn";
    private WebClient webClient=WebClient.create(baseUrl);
    @Override
    public String sendFeedback(String msisdn, String message) {
        MsisdnRegionRequestV2 regionRequestV2=new MsisdnRegionRequestV2();
        regionRequestV2.setMsisdn(msisdn);
        MsisdnRegionResponseV2 response= webClient.method(HttpMethod.GET)
                .uri(baseUrl)
                .body(Mono.just(regionRequestV2),MsisdnRegionRequestV2.class)
                .retrieve()
                .bodyToMono(MsisdnRegionResponseV2.class).block();
        if(response.getStatus()==1){
            System.out.println("Your Mobile is "+msisdn+" and your message is  "+message);
            return message;
        }else{
            return "No Message Added";
        }
   /*   if(msisdn!=null&&Message!=null){
          System.out.println("Your Mobile is "+msisdn+" and your message is  "+Message);
          return Message;
      }else{
          return "No Message Added";
      }*/
    }
}
