package com.org;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.json.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String broker = "tcp://10.43.101.239:1883"; // Dirección del broker
        String clientId = "JavaReceiver"; // ID único para el cliente suscriptor
        String topic = "pokemon/pelea";

        try {
            MqttClient client = new MqttClient(broker, clientId);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexión perdida: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String payload = new String(message.getPayload());
                    System.out.println("Mensaje recibido del tema " + topic + ": " + payload);
                    procesarMensaje(payload); // Procesar el JSON recibido
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // No se utiliza en un cliente suscriptor
                }
            });

            client.connect();
            client.subscribe(topic);
            System.out.println("Suscrito al tema " + topic);

            // Mantener el cliente en ejecución
            synchronized (Main.class) {
                Main.class.wait();
            }

        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void procesarMensaje(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Pelea pelea = objectMapper.readValue(jsonString, Pelea.class); // Deserializa el JSON a un objeto Pelea

            // Imprime detalles de la pelea para verificar la deserialización
            System.out.println("Pelea recibida:");
            System.out.println("Pokemon 1: " + pelea.getPokemon1().getNombre());
            System.out.println("Pokemon 2: " + pelea.getPokemon2().getNombre());
            // Agrega más detalles si es necesario
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
