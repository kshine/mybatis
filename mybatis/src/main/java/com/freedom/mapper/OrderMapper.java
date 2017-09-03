package com.freedom.mapper;


import com.freedom.po.Order;
import com.freedom.po.OrderCustom;
import com.freedom.po.User;

import java.util.List;

public interface OrderMapper {

    public List<OrderCustom> findOrdersUser() throws Exception;

    public List<Order> findOrdersUserResultMap() throws Exception;

    public List<Order> findOrderDetailResultMap() throws Exception;

    public List<User> findUserItemsResultMap() throws Exception;
}
