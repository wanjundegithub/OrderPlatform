package com.company;

import com.company.model.Order;
import com.company.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    private static final Logger logger= LoggerFactory.getLogger(OrderServiceTest.class);

    @Test
    @Rollback(value = false)
    public void testAddOrder(){
        Order order=new Order();
        order.setOrderId(null);
        order.setPriceNumber(new BigDecimal("13.99"));
        order.setUserName("Jk");
        order.setOrderDescription("多线程的艺术");
        if(!orderService.addOrder(order)){
            logger.error("增加失败，order为:"+order.toString());
            return;
        }
        logger.info("增加成功，order为:"+order.toString());
    }

    @Test
    @Rollback(value = false)
    public void testDeleteOrder(){
        if(!orderService.deleteOrder(9)){
            logger.error("删除失败，order为:");
            return;
        }
        logger.info("删除成功，order为:");
    }

    @Test
    @Rollback(value = false)
    public void testUpdateOrder(){
        Order order=new Order();
        order.setOrderId(8);
        order.setPriceNumber(new BigDecimal("100.99"));
        order.setUserName("Jk");
        order.setOrderDescription("多线程的艺术");
        if(!orderService.updateOrder(order)){
            logger.error("更新失败，order为:");
            return;
        }
        logger.info("更新成功，order为:");
    }

    @Test
    @Rollback(value = false)
    public void testSelectOrders(){
        List<Order> orders= orderService.getAllOrders();
        if(orders==null||orders.size()==0){
            logger.error("查询失败");
            return;
        }
        for(Order item:orders){
            logger.info(item.toString());
        }
    }

    @Test
    @Rollback(value = false)
    public void testSelectOrder(){
        Order order= orderService.getOrderById(8);
        if(order==null){
            return;
        }
        logger.info(order.toString());
    }
}
