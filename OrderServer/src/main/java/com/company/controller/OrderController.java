package com.company.controller;

import com.company.model.Order;
import com.company.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/addOrder")
    @ResponseBody
    public String addOrder(@RequestBody Order order){
        if(orderService.addOrder(order)){
            return "成功增加订单";
        }
        return "增加订单失败";
    }

    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public  String deleteOrder(@PathVariable Integer id){
        if(orderService.deleteOrder(id)){
            return "删除订单成功";
        }
        return "删除订单失败";
    }

    @GetMapping("/getAllOrders")
    @ResponseBody
    public  List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrderById/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @RequestMapping("/updateOrderById/{id}")
    @ResponseBody
    public String  updateOrder(@RequestBody Order order){
        if(orderService.updateOrder(order)){
            return "更新订单成功";
        }
        return "更新订单失败";
    }

}
