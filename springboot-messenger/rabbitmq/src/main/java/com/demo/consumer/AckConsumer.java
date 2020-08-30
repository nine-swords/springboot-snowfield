//package com.demo.consumer;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AckConsumer implements ChannelAwareMessageListener {
//
//    @Override
//    public void onMessage(Message message, Channel channel) throws Exception {
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        String[] content = message.toString().split("'");
//        System.out.println("message:"+content[1]);
//        System.out.println("消费的消息来自："+message.getMessageProperties().getConsumerQueue());
//        channel.basicAck(deliveryTag, true);
////		channel.basicReject(deliveryTag, true);//为true会重新放回队列
//
//    }
//
//}
