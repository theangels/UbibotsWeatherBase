package ubibots.weatherbase.control;

import java.util.Calendar;

import ubibots.weatherbase.model.BeanTabMessage;
import ubibots.weatherbase.util.RequestUtil;

public class RequestHour {

    public void hourHistory(BeanTabMessage hour, Calendar calendar, int id) {
        String strUrl = RequestUtil.combineUrl((Calendar) calendar.clone());
        RequestHourHistory request = new RequestHourHistory(hour, id, 0);
        request.execute(strUrl);
    }

    public void hourStep(BeanTabMessage hour, Calendar calendar) {
        String strUrl = RequestUtil.combineUrl((Calendar) calendar.clone());
        RequestHourStep request = new RequestHourStep(hour, 0);
        request.execute(strUrl);
    }
}
