package ai.yunxi.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 
 * @author 小五老师-云析学院
 * @createTime 2018年10月26日 下午4:36:38
 * 
 */
@Component
public class MQBusiness {
	
	@RabbitListener(queues=MQProperties.DEAD_QUEUE_NAME)
	public void process(String message) throws IOException{
		System.out.println(CalendarUtils.getCurrentTimeByStr(0)+" 消费了一个超时订单，订单ID："+message);
	}
}
