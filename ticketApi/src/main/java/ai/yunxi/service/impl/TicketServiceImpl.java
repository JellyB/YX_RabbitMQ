package ai.yunxi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.yunxi.entity.Ticket;
import ai.yunxi.mapper.ITicketMapper;
import ai.yunxi.service.ITicketService;
import ai.yunxi.utils.JsonUtil;
import ai.yunxi.utils.SnowflakeOrderServiceImpl;

/**
 * 
 * @author 小五老师-云析学院
 * @createTime 2018年10月24日 下午9:36:17
 * 
 */
@Service
public class TicketServiceImpl implements ITicketService {
	
	@Autowired
	private ITicketMapper ticketMapper;
	@Autowired
	private SnowflakeOrderServiceImpl idGeneration;
	@Override
	public String createTicket(String userId) {
		try {
			Ticket ticket = new Ticket(String.valueOf(idGeneration.nextId()), userId);
			System.out.println("insert into ticket:ticketId="+ticket.getTicketId());
			int row = ticketMapper.createTicket(ticket);
			if(row>0){
				return JsonUtil.fromBean(ticket);
			}
			System.out.println("--------------------null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
