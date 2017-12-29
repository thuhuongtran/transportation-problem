import com.vimensa.trans_ords.data_config.OrdersConfig;
import com.vimensa.trans_ords.model.Distance;
import com.vimensa.trans_ords.model.DistanceManager;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class ServiceTest {
    @Test
    public void testGetDistance(){
        OrdersConfig.getOrders();
        List<Distance> disLi=DistanceManager.getAllDistanceOrder(OrdersConfig.orders);
        for(Distance dis: disLi){
            System.out.println(dis.getTrack()+" "+dis.getValueDis());
        }
        assertEquals(26, disLi.size());
    }
}
