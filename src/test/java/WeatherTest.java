import com.wzy.entity.Weather;
import com.wzy.servie.WeatherService;
import com.wzy.servie.WeatherServiceImpl;
import com.wzy.servie.WeatherServiceProxy;

public class WeatherTest {
    public static void main(String[] args){
        //获取目标对象
        WeatherService weatherService = new WeatherServiceImpl();
        //获取代理对象
        WeatherServiceProxy weatherServiceProxy = new WeatherServiceProxy();
        WeatherService weatherService1 = (WeatherService) weatherServiceProxy.getProxy(weatherService);
        Weather weather = weatherService1.queryWeather("101280101");//这里会进到代理类的invoke方法，在实际的target执行queryWeather前执行一些操作
        System.out.println("天气预报：" + weather.toString());
    }
}
