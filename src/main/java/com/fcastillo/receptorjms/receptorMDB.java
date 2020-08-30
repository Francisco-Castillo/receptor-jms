/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.receptorjms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Queue"
    )
}, mappedName = "jms/NewDemo")
public class receptorMDB implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        TextMessage textMessage = (TextMessage) msg;
        try {
            System.out.println("Recibi un mensaje: " + textMessage.getText());
        } catch (JMSException ex) {
            Logger.getLogger(receptorMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
