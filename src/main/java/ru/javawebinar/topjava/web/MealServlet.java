package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private static MealDao mealsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");
        mealsDao = new MealDaoImpl();

        log.debug("fake meals size: " + mealsDao.getMeals().size());

        List<MealWithExceed> meals = MealsUtil.getFilteredWithExceededInOnePass(mealsDao.getMeals(), LocalTime.MIN, LocalTime.MAX, 2000);
        req.setAttribute("meals", meals);
        req.setAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
