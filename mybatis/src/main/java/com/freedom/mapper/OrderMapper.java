package com.freedom.mapper;


import com.freedom.po.OrderCustom;

import java.util.List;

public interface OrderMapper {

    public List<OrderCustom> findOrdersUser() throws Exception;
}
