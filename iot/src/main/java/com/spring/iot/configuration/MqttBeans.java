package com.spring.iot.configuration;



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


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;


import static com.spring.iot.util.Utils.*;


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
        options.setUserName("nhom2");
        options.setPassword("nhom2IoT".toCharArray());
        options.setAutomaticReconnect(true);
        options.setKeepAliveInterval(100);
        factory.setConnectionOptions(options);
        for(Station s: stationService.getAllStation()){
            historyValue.put(s.getId(),s);
            if (s.getId().equals("station1")) {
                MinCO1 = s.getComponent().getCo();
                MaxCO1 = s.getComponent().getCo();
            }
            if (s.getId().equals("station2")) {
                MinCO2 = s.getComponent().getCo();
                MaxCO2 = s.getComponent().getCo();
            }
            if (s.getId().equals("station3")) {
                MinCO3 = s.getComponent().getCo();
                MaxCO3 = s.getComponent().getCo();
            }
            if (s.getId().equals("station4")) {
                MinCO4 = s.getComponent().getCo();
                MaxCO4 = s.getComponent().getCo();
            }
            if (s.getId().equals("station5")) {
                MinCO5 = s.getComponent().getCo();
                MaxCO5 = s.getComponent().getCo();
            }

        }
        historyStation1.add(stationService.findStattionByID("station1"));
        historyStation2.add(stationService.findStattionByID("station2"));
        historyStation3.add(stationService.findStattionByID("station3"));
        historyStation4.add(stationService.findStattionByID("station4"));
        historyStation5.add(stationService.findStattionByID("station5"));
        Station1.add(stationService.findStattionByID("station1"));
        Station2.add(stationService.findStattionByID("station2"));
        Station3.add(stationService.findStattionByID("station3"));
        Station4.add(stationService.findStattionByID("station4"));
        Station5.add(stationService.findStattionByID("station5"));
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

    public void updateData (String id, Station t)
    {
        switch (id)
        {
            case "station1":
                if(historyStation1.size() < 4 && t.getId().equals(id))
                {
                    historyStation1.add(t);
                }
                else
                if(historyStation1.size() == 4 && t.getId().equals(id))
                {
                    historyStation1.add(t);
                    historyStation1.remove(0);
                }
                break;
            case "station2":
                if(historyStation2.size() < 4 && t.getId().equals(id))
                {
                    historyStation2.add(t);
                }
                else
                if(historyStation2.size() == 4 && t.getId().equals(id))
                {
                    historyStation2.add(t);
                    historyStation2.remove(0);
                }
                break;
            case "station3":
                if(historyStation3.size() < 4 && t.getId().equals(id))
                {
                    historyStation3.add(t);
                }
                else
                if(historyStation3.size() == 4 && t.getId().equals(id))
                {
                    historyStation3.add(t);
                    historyStation3.remove(0);
                }
                break;
            case "station4":
                if(historyStation4.size() < 4 && t.getId().equals(id))
                {
                    historyStation4.add(t);
                }
                else
                if(historyStation4.size() == 4 && t.getId().equals(id))
                {
                    historyStation4.add(t);
                    historyStation4.remove(0);
                }
                break;
            default:
                if(historyStation5.size() < 4 && t.getId().equals(id))
                {
                    historyStation5.add(t);
                }
                else
                if(historyStation5.size() == 4 && t.getId().equals(id))
                {
                    historyStation5.add(t);
                    historyStation5.remove(0);
                }
        }
    }
    public void DataStation (String id, Station t)
    {
        switch (id)
        {
            case "station1":
                if(Station1.size() < 96 && t.getId().equals(id))
                {
                    Station1.add(t);
                }
                else
                if(Station1.size() == 96 && t.getId().equals(id))
                {
                    Station1.add(t);
                    Station1.remove(0);
                }
                break;
            case "station2":
                if(Station2.size() < 96 && t.getId().equals(id))
                {
                    Station2.add(t);
                }
                else
                if(Station2.size() == 96 && t.getId().equals(id))
                {
                    Station2.add(t);
                    Station2.remove(0);
                }
                break;
            case "station3":
                if(Station3.size() < 96 && t.getId().equals(id))
                {
                    Station3.add(t);
                }
                else
                if(Station3.size() == 96 && t.getId().equals(id))
                {
                    Station3.add(t);
                    Station3.remove(0);
                }
                break;
            case "station4":
                if(Station4.size() < 96 && t.getId().equals(id))
                {
                    Station4.add(t);
                }
                else
                if(Station4.size() == 96 && t.getId().equals(id))
                {
                    Station4.add(t);
                    Station4.remove(0);
                }
                break;
            default:
                if(Station5.size() < 96 && t.getId().equals(id))
                {
                    Station5.add(t);
                }
                else
                if(Station5.size() == 96 && t.getId().equals(id))
                {
                    Station5.add(t);
                    Station5.remove(0);
                }
        }
    }
    public void getminmaxCO(String id, Station t)
    {
        switch (id)
        {
            case "station1":
                if(t.getId().equals(id) && t.getComponent().getCo() >= MaxCO1)
                    MaxCO1 = t.getComponent().getCo();
                if(t.getId().equals(id) && t.getComponent().getCo() <= MinCO1)
                    MinCO1 = t.getComponent().getCo();
                break;
            case "station2":
                if(t.getId().equals(id) && t.getComponent().getCo() >= MaxCO2)
                    MaxCO2 = t.getComponent().getCo();
                if(t.getId().equals(id) && t.getComponent().getCo() <= MinCO2)
                    MinCO2 = t.getComponent().getCo();
                break;
            case "station3":
                if(t.getId().equals(id) && t.getComponent().getCo() >= MaxCO3)
                    MaxCO3 = t.getComponent().getCo();
                if(t.getId().equals(id) && t.getComponent().getCo() <= MinCO3)
                    MinCO3 = t.getComponent().getCo();
                break;
            case "station4":
                if(t.getId().equals(id) && t.getComponent().getCo() >= MaxCO4)
                    MaxCO4 = t.getComponent().getCo();
                if(t.getId().equals(id) && t.getComponent().getCo() <= MinCO4)
                    MinCO4 = t.getComponent().getCo();
                break;
            default:
                if(t.getId().equals(id) && t.getComponent().getCo() >= MaxCO5)
                    MaxCO5 = t.getComponent().getCo();
                if(t.getId().equals(id) && t.getComponent().getCo() <= MinCO5)
                    MinCO5 = t.getComponent().getCo();
        }
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
                                getminmaxCO(t.getId(),t);
                                updateData(t.getId(),t);
                                DataStation(t.getId(),t);
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
