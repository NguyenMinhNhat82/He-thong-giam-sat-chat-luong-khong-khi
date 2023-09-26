package com.spring.iot.configuration;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.spring.iot.dto.Status;
import com.spring.iot.entities.Component;
import com.spring.iot.entities.Main;
import com.spring.iot.entities.Station;
import com.spring.iot.services.StationService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.spring.iot.util.Utils.historyStation1;
import static com.spring.iot.util.Utils.historyValue;


@Configuration
public class MqttBeans {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private StationService stationService;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{"tcp://broker.ou-cs.tech:1883"});
        options.setCleanSession(true);
        options.setUserName("nhom1");
        options.setPassword("nhom1IoT".toCharArray());
        options.setAutomaticReconnect(true);
        options.setKeepAliveInterval(10);
        factory.setConnectionOptions(options);
        for(Station s: stationService.getAllStation()){
            historyValue.put(s.getId(),s);
        }
        historyStation1.add(stationService.findStattionByID("station1"));
        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn",
                mqttClientFactory(), "nhom2/stations");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }



    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                JSONObject myjson = null;
                try {
                    myjson = new JSONObject("{"+message.getPayload().toString() + "}");
                    for(long i =1;i <=5 ;i++){
                        JSONArray jsonArray = myjson.getJSONArray("station"+i);
                        Station t = new Gson().fromJson(jsonArray.get(0).toString(),Station.class);
                        Component component = t.getComponent();
                        component.setId(i);
                        Main main = t.getMain();
                        main.setId(i);
                        if(stationService.findStattionByID("station"+i).getDt() != null) {
                            String time = stationService.findStattionByID("station"+i).getDt();
                            if (!time.equals(t.getDt())) {
                                t.setId("station" + i);
                                stationService.addOrUpdate(t);
                                historyValue.put("station"+i,t);
                                if(historyStation1.size() < 4 && t.getId().equals("station1"))
                                {
                                    historyStation1.add(t);
                                }
                                else
                                if(historyStation1.size() == 4 && t.getId().equals("station1"))
                                {
                                    historyStation1.add(t);
                                    historyStation1.remove(0);
                                }

                            }
                        }
                    }
                    com.spring.iot.dto.Message m = new com.spring.iot.dto.Message("server", "client", message.getPayload().toString(), dateFormat.format(cal.getTime()), Status.MESSAGE);
                    simpMessagingTemplate.convertAndSendToUser(m.getReceiverName(), "/private", m);
                    System.out.println(message.getPayload());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }

        };
    }


    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        //clientId is generated using a random number
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("nhom2/stations");
        messageHandler.setDefaultRetained(false);
        return messageHandler;
    }

}
