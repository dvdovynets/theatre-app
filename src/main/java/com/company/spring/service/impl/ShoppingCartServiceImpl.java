package com.company.spring.service.impl;

import com.company.spring.dao.ShoppingCartDao;
import com.company.spring.dao.TicketDao;
import com.company.spring.model.PerformanceSession;
import com.company.spring.model.ShoppingCart;
import com.company.spring.model.Ticket;
import com.company.spring.model.User;
import com.company.spring.service.ShoppingCartService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket newTicket = new Ticket();
        newTicket.setUser(user);
        newTicket.setCinemaHall(performanceSession.getTheatreStage());
        newTicket.setShowTime(performanceSession.getShowTime());
        newTicket.setMovie(performanceSession.getPerformance());

        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTickets().add(ticketDao.add(newTicket));
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clearShoppingCart(ShoppingCart cart) {
        cart.setTickets(new ArrayList<>());
        shoppingCartDao.update(cart);
    }
}
